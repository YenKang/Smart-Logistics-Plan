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
import sun.print.PSPrinterJob.PluginPrinter;
import de.tudresden.sumo.cmd.Simulation;
import de.tudresden.sumo.cmd.Vehicle;

import java.util.ArrayList;
import java.util.LinkedList;


import de.tudresden.sumo.cmd.Person;

import de.tudresden.ws.container.*;



public class Main0506 {


	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	// static String config_file = "simulation_Tainan/map_from_flow.sumo.cfg";

	

	static String config_file = "simulation4/map.sumo.cfg";
	static double step_length = 0.01; // version1
	//static double step_length = 0.001;
	

	static ArrayList<ClientInfo> clientInfos = new ArrayList<ClientInfo>();
	static int assignSuccess = 0;

	public static void main(String[] args) {
		
		Thread server = new Server(clientInfos, assignSuccess);
		server.start();


		try {
			

			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			
			conn.addOption("step-length", step_length + "");

			conn.addOption("start", "true"); // start sumo immediately

			// start Traci Server
			conn.runServer(7789);
			conn.setOrder(1);
			/////////////////////
			
			double minDistance=0;
			double min=0;
			double timeStep;
			ArrayList<Double> myList = new ArrayList();


			for (int i = 0; i < 360000; i++) {
				timeStep = (double) conn.do_job_get(Simulation.getTime());
				//System.out.println(timeStep);
				conn.do_timestep();
				
				if (i == 1000) {
					JDBC_AVD init_truck = new JDBC_AVD();
					/*
					for (int j = 1; j<31; j++) {
						SumoPosition2D vPosition = (SumoPosition2D) conn.do_job_get(Vehicle.getPosition(Integer.toString( j )));
						SumoPosition2D v_geo_position = (SumoPosition2D)conn.do_job_get(Simulation.convertGeo(vPosition.x, vPosition.y,false ));
						double x = v_geo_position.x;
						double y = v_geo_position.y;
						double speed = (double)conn.do_job_get(Vehicle.getSpeed(Integer.toString(j)));
						init_truck.insertVehicle(Integer.toString(j), y, x, speed);
						System.out.println(x+y);
					}
					
					//init_truck.insertVehicle(truck_No, lat_now, lng_now, speed);
					for (int j = 1; j<31; j++ ) {
						for (int k = 1; k<4; k++) {
							init_truck.insertContainer("c"+j+"-"+k, 0, "0", j);
						}
						for (int k = 4 ; k<7; k++) {
							init_truck.insertContainer("c"+j+"-"+k, 1, "0", j);
						}
						for (int k = 7 ; k<10; k++) {
							init_truck.insertContainer("c"+j+"-"+k, 2, "0", j);
						}
					}*/
					init_truck.Close();
				}
				
				if (i%100==0) {

					if (clientInfos.size() >0) {
						//System.out.println(clientInfos.size());
						for (int j  = 0; j < clientInfos.size(); j++) {
							ClientInfo clientInfo = clientInfos.get(j);
							if (clientInfo.getRequestNo() == 0) {
								double[] lnglat = new double[4];
								lnglat = clientInfo.getLatLng();
								double sender_lng = lnglat[0];
								double sender_lat = lnglat[1];
								SumoPositionRoadMap sender_roadmap = (SumoPositionRoadMap) conn.do_job_get(Simulation.convertRoad(sender_lng, sender_lat, true, "ignoring"));
								String sender_edge = sender_roadmap.edgeID;
								int sender_lane = sender_roadmap.laneIndex;
								double sender_pos = sender_roadmap.pos;
								conn.do_job_set(Vehicle.changeTarget("17", sender_edge));
								SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
								//conn.do_job_set(Vehicle.setStop("17", sender_edge, 1.0, (byte)0, 20.0, sf));
								
								//int timeArrived = clientInfo.getTimeArrived();
								//clientInfo.assignTest = 5;
								//System.out.println(assignSuccess);
								//clientInfos.
							}
							else if (clientInfo.getRequestNo() == 1) {
								String vid = clientInfo.getTruckNo();
								double[] lnglat = new double[4];
								lnglat = clientInfo.getLatLng();
								double receiver_lng = lnglat[2];
								double receiver_lat = lnglat[3];
								SumoPositionRoadMap receiver_roadmap = (SumoPositionRoadMap) conn.do_job_get(Simulation.convertRoad(receiver_lng, receiver_lat, true, "ignoring"));
								String receiver_edge = receiver_roadmap.edgeID;
								int receiver_lane = receiver_roadmap.laneIndex;
								double receiver_pos = receiver_roadmap.pos;
								conn.do_job_set(Vehicle.changeTarget(vid, receiver_edge));
								conn.do_job_set(Vehicle.resume(vid));
							}
						}
						//System.out.println(conn.do_job_get(Simulation.convertRoad(lng, lat, true, "ignoring")));
						//SumoPositionRoadMap a =(SumoPositionRoadMap) conn.do_job_get(Simulation.convertRoad(lng, lat, true, "ignoring"));
						//System.out.println(a.edgeID);
						//System.out.println(a.laneIndex);
						//System.out.println(a.pos);
						//conn.do_job_set(Vehicle.addFull("v"+i, "r1", "car", "now", "0", "0", "max", "current", "max", "current", "", "", "", 0, 0));
						clientInfos.clear();
					}
					
				}			
			}		
			conn.close(); 
		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}
	
}
