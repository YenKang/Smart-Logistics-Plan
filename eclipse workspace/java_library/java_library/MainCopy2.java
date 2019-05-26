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

import de.tudresden.sumo.cmd.Simulation;
import de.tudresden.sumo.cmd.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;

import de.tudresden.ws.container.*;

public class MainCopy2 {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	// static String config_file = "simulation4/map.sumo.cfg";
	static String config_file = "simulation3/map.sumo.cfg";
	// static double step_length = 0.01; // version1

	static double step_length = 0.1;
	//double vehicle_speed = 5.0; //5 [m/s]

	public static void main(String[] args) {

		try {
			
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			conn.addOption("step-length", step_length + "");
			conn.addOption("start", "true"); // start sumo immediately
			

			// start Traci Server
			conn.runServer(8080);
			conn.setOrder(1);
			
			double vehicle_speed = 5.0; //5 [m/s]
			
			// vehicle1
			Map  CarsMapWithSchedule = new HashMap();
			ArrayList v1_sender_TimeSchedule = new ArrayList();
			
			
			CarsMapWithSchedule.put("1",v1_sender_TimeSchedule);
			v1_sender_TimeSchedule.add(600);
			
			System.out.println("v1_sender_TimeSchedule:"+ v1_sender_TimeSchedule);
			System.out.println("CarsMapWithSchedule:" + CarsMapWithSchedule);
			
			
			Map v1_TimeToSenderInfo = new HashMap();
			
			ArrayList sender1_Array = new ArrayList();
			sender1_Array.add("-537706053#0");
			sender1_Array.add(2818.27);
			sender1_Array.add(1718.78);
			
			v1_TimeToSenderInfo.put(600, sender1_Array);
			
			int[] v1_BoxIndex= {1, 0, 0, 0,
					0,0,0,
					0,0,0 };
			
			System.out.println("v1_BoxIndex[1]:" + v1_BoxIndex[1]);
			
			
			System.out.println("v1_TimeToSenderInfo:"+ v1_TimeToSenderInfo);
			System.out.println("sender1_Array:"+ sender1_Array);
		
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			
			System.out.println("-----------------------------------------------");
			
			// vehicle2
			ArrayList v2_sender_TimeSchedule = new ArrayList();
			
			v2_sender_TimeSchedule.add(600);
			CarsMapWithSchedule.put("2",v2_sender_TimeSchedule);
			
			Map v2_TimeToSenderInfo = new HashMap();
			
			ArrayList sender2_Array = new ArrayList();
			sender2_Array.add("279049709#0");
			sender2_Array.add(3180.99);
			sender2_Array.add(614.76);
			
			v2_TimeToSenderInfo.put(600, sender2_Array);
			int[] v2_BoxIndex= {0, 0, 0, 0,
					0,0,1,
					0,0,1 };
			
			System.out.println("v2_TimeToSenderInfo:"+ v2_TimeToSenderInfo);
			System.out.println("sender2_Array:"+ sender2_Array);
			
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			
			v2_sender_TimeSchedule.add(660);
			CarsMapWithSchedule.put("2",v2_sender_TimeSchedule);
			
			ArrayList sender3_Array = new ArrayList();
			sender3_Array.add("24452776");
			sender3_Array.add(2513.37);
			sender3_Array.add(1747.28);
			v2_TimeToSenderInfo.put(660, sender3_Array);
			
			System.out.println("v2_TimeToSenderInfo:"+ v2_TimeToSenderInfo);
			System.out.println("sender3_Array:"+ sender3_Array);
			
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			System.out.println("-----------------------------------------------");
			
			// vehicle3
			ArrayList v3_sender_TimeSchedule = new ArrayList();
			v3_sender_TimeSchedule.add(630); // add sendRequest4 of 10:30 
			CarsMapWithSchedule.put("3",v3_sender_TimeSchedule);
			
			Map v3_TimeToSenderInfo = new HashMap();
	
			ArrayList sender4_Array = new ArrayList();
			
			sender4_Array.add("279049709#0");
			sender4_Array.add(3451.37);
			sender4_Array.add(1096.83);
			v3_TimeToSenderInfo.put(630, sender4_Array);
			
			System.out.println("v3_TimeToSenderInfo:"+ v3_TimeToSenderInfo);
			System.out.println("v3_sender_TimeSchedule:" + v3_sender_TimeSchedule);

			System.out.println("sender4_Array:"+ sender4_Array);
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);

			
			v3_sender_TimeSchedule.add(690); // add sendRequest5 of 11:30 
			CarsMapWithSchedule.put("3",v3_sender_TimeSchedule);
	
		
			ArrayList sender5_Array = new ArrayList();
			sender5_Array.add("-496249903#0");
			sender5_Array.add(2264.53);
			sender5_Array.add(1568.14);
			v3_TimeToSenderInfo.put(690, sender5_Array);
			
			System.out.println("v3_TimeToSenderInfo:"+ v3_TimeToSenderInfo);
			System.out.println("sender5_Array:"+ sender5_Array);
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			
			// vehicle4
			ArrayList v4_sender_TimeSchedule = new ArrayList();
			v4_sender_TimeSchedule.add(570); // add sendRequest6 of 09:30 
			CarsMapWithSchedule.put("4",v4_sender_TimeSchedule);
			
			Map v4_TimeToSenderInfo = new HashMap();
	
			ArrayList sender6_Array = new ArrayList();
			
			sender6_Array.add("307097147#0");
			sender6_Array.add(1677.67);
			sender6_Array.add(1516.97);
			v4_TimeToSenderInfo.put(570, sender6_Array);
			
			System.out.println("v4_TimeToSenderInfo:"+ v4_TimeToSenderInfo);
			System.out.println("sender6_Array:"+ sender6_Array);
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			
			v4_sender_TimeSchedule.add(630); // add sendRequest7 of 10:30 
			CarsMapWithSchedule.put("4", v4_sender_TimeSchedule);
			
			ArrayList sender7_Array = new ArrayList();
			sender7_Array.add("228022808#2");
			sender7_Array.add(2218.53);
			sender7_Array.add(1841.17);
			v4_TimeToSenderInfo.put(630, sender7_Array);
			
			System.out.println("v4_TimeToSenderInfo:"+ v4_TimeToSenderInfo);
			System.out.println("sender7_Array:"+ sender7_Array);
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			
			// vehicle5
			ArrayList v5_sender_TimeSchedule = new ArrayList();
			Map v5_TimeToSenderInfo = new HashMap();
			v5_sender_TimeSchedule.add(600); // add sendRequest8 of 10:00 
			CarsMapWithSchedule.put("5",v5_sender_TimeSchedule);
			
		
	
			ArrayList sender8_Array = new ArrayList();
			
			sender8_Array.add("228022809#9");
			sender8_Array.add(1530.12);
			sender8_Array.add(2028.92);
			v5_TimeToSenderInfo.put(600, sender8_Array);
			
			System.out.println("v5_TimeToSenderInfo:"+ v5_TimeToSenderInfo);
			System.out.println("sender8_Array:"+ sender8_Array);
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			
			v5_sender_TimeSchedule.add(720); // add sendRequest9 of 12:00 
			CarsMapWithSchedule.put("5",v5_sender_TimeSchedule);
			
	
			ArrayList sender9_Array = new ArrayList();
			
			sender9_Array.add("306997497#0");
			sender9_Array.add(1738.11);
			sender9_Array.add(1029.69);
			v5_TimeToSenderInfo.put(720, sender9_Array);
			
			System.out.println("v5_TimeToSenderInfo:"+ v5_TimeToSenderInfo);
			System.out.println("sender9_Array:"+ sender9_Array);
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			
		
			for (int i = 0; i < 360000; i++) {
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());
				
				// vehicle1 route
				/*
				ArrayList v1_send_Schedule = new ArrayList();
				v1_send_Schedule = (ArrayList) CarsMapWithSchedule.get(1);
				int firstTime = (int) v1_send_Schedule.get(0);
				ArrayList first_SendInfo = new ArrayList();
				first_SendInfo=(ArrayList) v1_TimeToSenderInfo.get(firstTime);
				conn.do_job_set(Vehicle.changeTarget("1", (String)first_SendInfo.get(0)));
				*/
				
				// got send_Request10 of 10:00->10hr->600min
				if(timeSeconds==30.0) {
				
					System.out.println("------------------------");
					System.out.println("got send_Request10 of 10:00->10hr->600min");
					System.out.println("timeSeconds:"+ timeSeconds);
					
					ArrayList sender10_Array = new ArrayList();
					
					sender10_Array.add("496493919#2");
					sender10_Array.add(1506.52);
					sender10_Array.add(1210.75);
					
					System.out.println("-----------------------------------------------");
					System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
					int insertTime = 600;
					
					Map  CarsMap_Specific_Schedule = new HashMap();
					Map  mapResult = new HashMap();
					CarsMap_Specific_Schedule = CarsMapWithSchedule;
					Set keyset=CarsMap_Specific_Schedule.keySet();
					
					for (Object key : keyset) {
						ArrayList vehicle_schedule_array = new ArrayList();
				        vehicle_schedule_array = (ArrayList) CarsMap_Specific_Schedule.get(key);
				        
				        if(vehicle_schedule_array.contains(600)) {
				        	//CarsMap_Specific_Schedule.remove(key);
				        	//System.out.println("CarsMap_Specific_Schedule:"+ CarsMap_Specific_Schedule);
				        }
				        else {
				        	mapResult.put(key, CarsMap_Specific_Schedule.get(key));
				        	
				        }
				        
						
					}
					System.out.println("mapResult:"+ mapResult);
					
					SumoPosition2D v3_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition("3"));
					
					System.out.println("v3_Position:"+ v3_Position);
					
					ArrayList vehicle_array = new ArrayList();
					vehicle_array = (ArrayList) v3_TimeToSenderInfo.get(630); // s4 in 10:30
					System.out.println("vehicle_array:"+ vehicle_array);
					
					double Distance_v3toSender10= (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender10_Array.get(1), 
							(double)sender10_Array.get(2), 
							v3_Position.x, v3_Position.y, false, true)));
					System.out.println("Distance_v3toSender10:" + Distance_v3toSender10);
					
					double Distance_Sender10ToSender4 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender10_Array.get(1), 
							(double)sender10_Array.get(2), 
							(double)vehicle_array.get(1), 
							(double)vehicle_array.get(2), false, true)));
					System.out.println("Distance_Sender10ToSender4:" + Distance_Sender10ToSender4);
					
					if((Distance_v3toSender10/vehicle_speed) < (3600-timeSeconds) && 
							(Distance_Sender10ToSender4/vehicle_speed) <1800) {
						System.out.println("v3 is the candidate!");
					}
					
					double Distance_Sender6ToSender10 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender10_Array.get(1), 
							(double)sender10_Array.get(2), 
							(double)sender6_Array.get(1), 
							(double)sender6_Array.get(2), false, true)));
					
					double Distance_Sender10ToSender7 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender10_Array.get(1), 
							(double)sender10_Array.get(2), 
							(double)sender7_Array.get(1), 
							(double)sender7_Array.get(2), false, true)));
					
					System.out.println("Distance_Sender6ToSender10:"+ Distance_Sender6ToSender10);
					
					System.out.println("Distance_Sender10ToSender7:"+ Distance_Sender10ToSender7);
					if((Distance_Sender6ToSender10/vehicle_speed) <1800 && 
							(Distance_Sender6ToSender10/vehicle_speed) <1800){
						System.out.println("v4 is the candidate!");
					}
					
					// v3 has higher priority than v4 due to the smaller index
					v3_sender_TimeSchedule.add(insertTime);
					Collections.sort(v3_sender_TimeSchedule);
					
					v3_TimeToSenderInfo.put(600, sender10_Array);
					CarsMapWithSchedule.put(3, v3_sender_TimeSchedule);
					
					System.out.println("v3_TimeToSenderInfo:"+ v3_TimeToSenderInfo);
					System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
					
					
				}
				
				if(timeSeconds ==40.0) {
					
				
					ArrayList V1_first_SendInfo = new ArrayList();
					
					V1_first_SendInfo = (ArrayList)v1_TimeToSenderInfo.get(
							(int)((ArrayList) CarsMapWithSchedule.get("1")).get(0)); // 0 means first-time
					
					conn.do_job_set(Vehicle.changeTarget("1", (String)V1_first_SendInfo.get(0)));
						
				}
				
				// arrange the new route of vehicle2
				if(timeSeconds ==41.0) {
					
					
					ArrayList v2_first_SendInfo = new ArrayList();
					
					v2_first_SendInfo = (ArrayList)v2_TimeToSenderInfo.get(
							(int)((ArrayList) CarsMapWithSchedule.get("2")).get(0)); // 0 means first-time
					
					conn.do_job_set(Vehicle.changeTarget("2", (String)v2_first_SendInfo.get(0)));
					
					SumoStopFlags sf_send2 = new SumoStopFlags(false, false, false, false, false);
					
					//conn.do_job_set(Vehicle.setStop("2", (String)v2_first_SendInfo.get(0), 600.0, (byte)0, 2880.0, sf_send2));
					
				
				
				}
				
				/*
				if() {
					ArrayList V2_second_SendInfo = new ArrayList();
					
					V2_second_SendInfo = (ArrayList)v2_TimeToSenderInfo.get(
							(int)((ArrayList) CarsMapWithSchedule.get("2")).get(0)); // 0 means first-time
					
					conn.do_job_set(Vehicle.changeTarget("2", (String)V2_second_SendInfo.get(0)));
					
					//SumoStopFlags sf_send2 = new SumoStopFlags(false, false, false, false, false);
					SumoStopFlags sf_send2 = new SumoStopFlags(false, false, false, false, false);
					
					conn.do_job_set(Vehicle.setStop("2", (String)V2_second_SendInfo.get(0), 600.0, (byte)0, 600.0, sf_send2));
				}*/
				
				
				if(timeSeconds ==42.0) {
					
				
					ArrayList V3_first_SendInfo = new ArrayList();
					
					V3_first_SendInfo = (ArrayList)v3_TimeToSenderInfo.get(
							(int)((ArrayList) CarsMapWithSchedule.get("3")).get(0)); // 0 means first-time
					
					conn.do_job_set(Vehicle.changeTarget("3", (String)V3_first_SendInfo.get(0)));
					
				}
				
				if(timeSeconds ==3000.0) { // 09:50 [9h50min]
					ArrayList sender11_Array = new ArrayList(); // tainan art museum
					
					sender11_Array.add("286847289#1");
					sender11_Array.add(1181.84);
					sender11_Array.add(1025.39);
					
					System.out.println("-----------------------------------------------");
					System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
					int insertTime = 630;
					
					Map  CarsMap_Specific_Schedule = new HashMap();
					Map  mapResult = new HashMap();
					CarsMap_Specific_Schedule = CarsMapWithSchedule;
					Set keyset=CarsMap_Specific_Schedule.keySet();
					
					double Distance_Sender2ToSender11 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender11_Array.get(1), 
							(double)sender11_Array.get(2), 
							(double)sender2_Array.get(1), 
							(double)sender2_Array.get(2), false, true)));
					
					double Distance_Sender11ToSender3 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender11_Array.get(1), 
							(double)sender11_Array.get(2), 
							(double)sender3_Array.get(1), 
							(double)sender3_Array.get(2), false, true)));
					
					if((Distance_Sender2ToSender11/vehicle_speed) <1800 && 
							(Distance_Sender11ToSender3/vehicle_speed) <1800){
						
						System.out.println("Distance_Sender2ToSender11:" + Distance_Sender2ToSender11);
						System.out.println("Distance_Sender11ToSender3:" + Distance_Sender11ToSender3);
						
						System.out.println("timeSeconds:"+ timeSeconds);
						System.out.println("send11 request is inserted  between sender2 and sender3!");
					}
					

				
					v2_sender_TimeSchedule.add(insertTime);
					Collections.sort(v2_sender_TimeSchedule);
					
					v2_TimeToSenderInfo.put(630, sender11_Array);
					
					CarsMapWithSchedule.put(2, v3_sender_TimeSchedule);
					
					System.out.println("v2_sender_TimeSchedule:"+ v2_sender_TimeSchedule);
					System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
					System.out.println("v2_TimeToSenderInfo:"+ v2_TimeToSenderInfo);
					
					
					
					
					
				}
				
				if(timeSeconds ==3500.0) {
					System.out.println("timeSeconds:"+ timeSeconds);
					conn.do_job_set(Vehicle.resume("2"));
					
					ArrayList v2_second_SendInfo = new ArrayList();
					
					v2_second_SendInfo = (ArrayList)v2_TimeToSenderInfo.get(
							(int)((ArrayList) CarsMapWithSchedule.get("2")).get(1)); // 0 means first-time
					
					System.out.println("v2_second_SendInfo:"+ v2_second_SendInfo);
					
					conn.do_job_set(Vehicle.changeTarget("2", (String)v2_second_SendInfo.get(0)));
					
					SumoStopFlags sf_send2 = new SumoStopFlags(false, false, false, false, false);
					
					//conn.do_job_set(Vehicle.setStop("2", (String)v2_second_SendInfo.get(0), 10.0, (byte)0, 1200.0, sf_send2));
				}
				
				
		
				
				/*
				// the request1[10:00, sender1]
				if(timeSeconds==30.0) {
					
					System.out.println("------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					
				}
				*/
			
		
				
				
				
	
				
			
				
			
		

			
			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
