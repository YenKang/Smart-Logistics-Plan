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

import it.polito.appeal.traci.SumoTraciConnection;
import de.tudresden.sumo.cmd.Gui;
import de.tudresden.sumo.cmd.Simulation;
import de.tudresden.sumo.cmd.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;

import de.tudresden.ws.container.*;

public class MainCopy {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	// static String config_file = "simulation4/map.sumo.cfg";
	static String config_file = "simulation4/map.sumo.cfg";
	// static double step_length = 0.01; // version1

	static double step_length = 0.01;

	public static void main(String[] args) {

		try {
			
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			conn.addOption("step-length", step_length + "");
			conn.addOption("start", "true"); // start sumo immediately

			// start Traci Server
			conn.runServer(8080);
			conn.setOrder(1);
			
			ArrayList<Integer> timeSchedule = new ArrayList<Integer>();
			Map<Integer,ArrayList> timeMapToSender = new HashMap<Integer,ArrayList>();
			HashMap timeMap = new HashMap();
			int timeArray[]= {};
			

			SumoStopFlags sf_send = new SumoStopFlags(false, false, false, false, false);
			SumoStopFlags sf_rec = new SumoStopFlags(false, false, false, false, false);
			
			String Edge1 = "405115648#1"; 
			String Edge2 = "-228022792#2";  // entrance of ncku
			String Edge3 = "228022808#0";

			conn.do_job_set(Gui.setSchema("View #0", "real world"));
			//conn.do_job_set(Gui.setSchema(viewID, schemeName));

			for (int i = 0; i < 360000; i++) {
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());

				double sender_x = 3003.22;
				double sender_y = 6763.46;
				String senderEdge = "-537706053#2";
				
				double sender1_x = 2818.27;
				double sender1_y = 1718.78;
				String sender1_edgeID = "-537706053#0";
				double sender1_expected_arrival_duration = 1800;
				
				double sender2_x = 3180.99;
				double sender2_y = 614.76;
				String sender2_edgeID = "279049709#0";
				double sender2_expected_arrival_duration = 3600; //60min=3600s
				
				double sender3_x = 2513.37;
				double sender3_y = 1747.28;
				String sender3_edgeID = "24452776";
				double sender3_expected_arrival_duration = 7050; //2h, 7200-150=7050
				
				
				double sender4_x = 1517.62;
				double sender4_y = 1207.92;
				String sender4_edgeID = "496493919#2";
				
				if(timeSeconds==10.0) {
					ArrayList testlist = new ArrayList();
					ArrayList insertlist = new ArrayList();
					ArrayList count_of_BoxType = new ArrayList();
					
					insertlist.add(400);
					insertlist.add(500);
					
					testlist.add("edgeID");
					testlist.add(3.0);
					testlist.add(5.0);
					testlist.add(insertlist);
					
					int[] BoxIndex= {1, 0, 0, 0,
							0,0,0,
							0,0,0 };
				
					count_of_BoxType.add(BoxIndex);
				
					System.out.println("count_of_BoxType:"+ count_of_BoxType);
					System.out.println("count_of_BoxType.get(0):"+  (int[])count_of_BoxType.get(0));
		
					System.out.println("testlist:"+testlist);
					System.out.println("testlist:"+testlist.get(0));
					System.out.println("testlist.get(3):"+testlist.get(3));
					
					String a = (String)testlist.get(0);
					double s = (double)testlist.get(1);
					
					System.out.println("timeSeconds:"+ timeSeconds);
					System.out.println("timeSchedule:"+timeSchedule);
					System.out.println("timeMap:"+timeMap);
					
				}
				
				// the request1[10:00, sender1]
				if(timeSeconds==20.0) {
					System.out.println("------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					/*
					double sender1_x = 2818.27;
					double sender1_y = 1718.78;
					String sneder1_edgeID = "-537706053#0";
					double sender1_expected_arrival_duration = 1800;*/
					
					ArrayList sender1Array = new ArrayList();
					
					
					sender1Array.add("-537706053#0");
					sender1Array.add(2818.27);
					sender1Array.add(1718.78);
					
					int insertTime = 600;
					timeSchedule.add(insertTime);
					timeMapToSender.put(insertTime, sender1Array);
					int indexValue = timeSchedule.indexOf(insertTime);
					
					System.out.println("timeSchedule:"+timeSchedule);
					System.out.println("timeMapToSender:"+timeMapToSender);
					
					
					SumoPosition2D v8Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition("2")); 
					double Distancev8toSender1= (double)(conn.do_job_get(Simulation.getDistance2D((double)sender1Array.get(1), (double)sender1Array.get(2),
							v8Position.x, v8Position.y, false, true)));
					double travelTimeToSender1 = Distancev8toSender1/5.0; // V=5.0m/s
					
					System.out.println("v8toSender1Distance:" + Distancev8toSender1);
					System.out.println("travelTimeToSender1:" + travelTimeToSender1);
					
					// current time is 09:00
					// the request1[10:00, sender1]
					// 10:00-09:00 = 60min=3600s
					
					double duration_curPos_to_Index = (insertTime-540)*60;
					
					if(travelTimeToSender1 < duration_curPos_to_Index) { // the car can arrive to sender1 before 10:00
						// 10:00 =10hr = 600min
						// [10:00=sender1]
						int Key_indexValue =  timeSchedule.get(indexValue);
						String senderEdge_indexValue = (String)timeMapToSender.get(Key_indexValue).get(0);
						System.out.println("senderEdge_indexValue:"+senderEdge_indexValue);
						
						conn.do_job_set(Vehicle.changeTarget("2", senderEdge_indexValue));		
					
					}
					
					System.out.println("After arranging the schedule:");
					System.out.println("timeSchedule:"+timeSchedule);
					System.out.println("timeMapToSender:"+timeMapToSender);
					
				}
				/*
				 * double sender4_x = 1517.62;
				double sender4_y = 1207.92;
				String sender4_edgeID = "496493919#2";
				 * */

				if(timeSeconds==30.0){
					conn.do_job_set(Vehicle.changeTarget("2", "279049706#7")); //
					conn.do_job_set(Gui.trackVehicle("View #0", "2"));
					
					SumoPosition2D v2_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition("2")); 
					double Distancev_v2_to_Sender= (double)(conn.do_job_get(Simulation.getDistance2D(9166.64, 6317.01,
							v2_Position.x, v2_Position.y, false, true)));
					System.out.println("Distancev_v2_to_Sender:"+ Distancev_v2_to_Sender);
					conn.do_job_set(Gui.setOffset("View #0", v2_Position.x, v2_Position.y));
					String edge ="279049706#7"; // 570
					double pos =  68.83; // 
					double until = 0;
					SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop("2", edge, pos, (byte)0,  300.0,  sf, pos, until));
					
					String vType ="truck"; 
					String fromEdge = (String) conn.do_job_get(Vehicle.getRoadID("2"));
					String endEdge = "279049706#7"; //
					double depart = 0.0; 
					int routingMode = 0;
					SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute(fromEdge, endEdge, vType, depart,routingMode));

					System.out.println("travelTime_v2_to_Sender:"+ stage.travelTime);
					System.out.println("stage_v2_to_Sender:"+ stage.length);
					System.out.println("e_spped_v2_to_Sender:"+ (stage.length/stage.travelTime));
				}
				
			
			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
