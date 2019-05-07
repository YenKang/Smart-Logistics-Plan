/****************************************************************************/
// Eclipse SUMO, Simulation of Urban MObility; see https://eclipse.org/sumo
// Copyright (C) 2017-2018 German Aerospace Center (DLR) and others.
// TraaS module
// Copyright (C) 2013-2017 Dresden University of Technology
// This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v2.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v20.html
// SPDX-License-Identifier: EPL-2.0
/****************************************************************************/
/// @file    Main.java
/// @author  Mario Krumnow
/// @date    2013
/// @version $Id$
///
//
/****************************************************************************/

import java.util.Calendar;
import java.text.SimpleDateFormat;

import it.polito.appeal.traci.SumoTraciConnection;
import de.tudresden.sumo.cmd.Simulation;
import de.tudresden.sumo.cmd.Vehicle;

import java.util.LinkedList;


import de.tudresden.sumo.cmd.Person;

import de.tudresden.ws.container.*;



public class Main {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	// static String config_file = "simulation_Tainan/map_from_flow.sumo.cfg";
	   static String config_file = "simulation3/map_edited.sumo.cfg";
	//   static double step_length = 0.001; // version1

	   static double step_length = 0.01;

	public static void main(String[] args) {
	
		try {
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			
			conn.addOption("step-length", step_length + "");

			conn.addOption("start", "true"); // start sumo immediately

			// start Traci Server
			conn.runServer(8080);
			conn.setOrder(1);
			
			for (int i = 0; i < 360000; i++) 
			{
				
				conn.do_timestep();
				
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());

				
				double sender_x = 3003.22;
				double sender_y = 6763.46;
				String senderEdge = "-537706053#2";
						
				if(timeSeconds % 1==0) 
				{
					
					String curEdge = (String)conn.do_job_get(Vehicle.getRoadID("8")); // String vehID
					SumoPosition2D v8Position = (SumoPosition2D) conn.do_job_get(Vehicle.getPosition("8"));
					SumoPosition2D v9Position = (SumoPosition2D) conn.do_job_get(Vehicle.getPosition("9"));
					
					System.out.println("current edgeID is:" + curEdge + " in " + timeSeconds + " seconds");
					System.out.println("current position is:" + v8Position);
					System.out.println("current position x:" + v8Position.x + " y:" + v8Position.y + " in " + timeSeconds + " seconds");
		
					double v8toSenderDistance = (double)(conn.do_job_get(Simulation.getDistance2D(sender_x, sender_y, v8Position.x, v8Position.y, false, false)));
					System.out.println("current distance between v8 to sender is:" + v8toSenderDistance);
					
					double v9toSenderDistance = (double)(conn.do_job_get(Simulation.getDistance2D(sender_x, sender_y, v9Position.x, v9Position.y, false, false)));
					System.out.println("current distance between v9 to sender is:" + v9toSenderDistance);
					
					if(timeSeconds==50.0 ) {
						conn.do_job_set(Vehicle.setParameter("8", "containerNumber", "0"));
						String j = (String) conn.do_job_get(Vehicle.getParameter("8", "containerNumber"));
						System.out.println("getParameter:" + j);
						
						
						
					}
					
					if(timeSeconds==53.0 ) {
						String v8_containerNumber = (String) conn.do_job_get(Vehicle.getParameter("8", "containerNumber"));
						int v8_int_containerNumber = Integer.valueOf(v8_containerNumber);
						v8_int_containerNumber = v8_int_containerNumber+1;
						String stringValue = Integer.toString(v8_int_containerNumber);
						conn.do_job_set(Vehicle.setParameter("8", "containerNumber", stringValue));
						
						String j = (String) conn.do_job_get(Vehicle.getParameter("8", "containerNumber"));
						System.out.println("getParameter:" + j);
						
		
					}
					
					if((v9toSenderDistance< v8toSenderDistance) && timeSeconds==60.0 ) {
						System.out.println("we dispath v9 to the sender address!");
					}
					
					else if(v9toSenderDistance > v8toSenderDistance && (timeSeconds==60.0)) 
					{
						System.out.println("we dispath v8 to the sender address!");

						System.out.println("Default Route:");
						SumoStringList edgeList = (SumoStringList)conn.do_job_get(Vehicle.getRoute("8"));
						LinkedList<String> defaultRouteList = new LinkedList<String>(); 
						
						for(i=0; i<edgeList.size(); i++) {
							defaultRouteList.add(edgeList.get(i));
						}
						System.out.println("defaultRouteList:"+ defaultRouteList);


						
						conn.do_job_set(Vehicle.changeTarget("8", senderEdge));
						
						System.out.println("changing Route:");

						SumoStringList new_edgeList = (SumoStringList)conn.do_job_get(Vehicle.getRoute("8"));
						LinkedList<String> changedRouteList = new LinkedList<String>(); 
						
						for(i=0; i<new_edgeList.size(); i++) {
							changedRouteList.add(new_edgeList.get(i));
						}
						System.out.println("changedRouteList:"+ changedRouteList);
						

						String fromEdge = curEdge;
						String toEdge = senderEdge;
						String vType ="routeByDistance"; 
						double depart = 60.0; 
						int routingMode = 0;
						
						SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute(fromEdge, toEdge, vType, depart,routingMode));
						double TravelTimeToSender = stage.travelTime;
						
						System.out.println("We need "+ TravelTimeToSender +" s from current edge to sender address");
						
						SumoStopFlags sf_send = new SumoStopFlags(false, false, false, false, false);
					
						
						//conn.do_job_set(Vehicle.setContainerStop("8", "senderAddr_stop", 20.0, 100));
						
						conn.do_job_set(Vehicle.setStop("8", senderEdge, 1.0, (byte)0, 20.0, sf_send ));
				
				
				    }
					
					int a = (Integer)conn.do_job_get(Vehicle.isStopped("8"));
					
					// car stop at the sender's address
					if(a==1) {
						System.out.println("timeSeconds:" + timeSeconds);
						
					}
					
					if(timeSeconds ==195.0) {
						conn.do_job_set(Vehicle.resume("8"));
						int b = (Integer)conn.do_job_get(Vehicle.isStopped("8"));
						
						System.out.println("isStopped:" + b );
						
					}
				   
		
		
	             }
			 

		      }
			  conn.close();
			  
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
