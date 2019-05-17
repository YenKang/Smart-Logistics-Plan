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
import java.util.Arrays;
import java.util.Collections;

import de.tudresden.ws.container.*;

public class MainCopy2 {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	// static String config_file = "simulation4/map.sumo.cfg";
	static String config_file = "simulation3/map.sumo.cfg";
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
			
			
			ArrayList<Integer> timeSchedule = new ArrayList<Integer>();
			Map<Integer,ArrayList> timeMapToSender = new HashMap<Integer,ArrayList>();
			HashMap timeMap = new HashMap();
			int timeArray[]= {};
			

	
			
			String Edge1 = "405115648#1"; 
			String Edge2 = "-228022792#2";  // entrance of ncku
			String Edge3 = "228022808#0";

			for (int i = 0; i < 360000; i++) {
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());

				double sender_x = 3003.22;
				double sender_y = 6763.46;
				String senderEdge = "-537706053#2";
				
				double sender1_x = 2818.27;
				double sender1_y = 1718.78;
				String sender1_edgeID = "-537706053#0";
			
				
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
					
					ArrayList insertlist = new ArrayList();
			
					
					insertlist.add(400);
					insertlist.add(500);
					
			
					System.out.println("-----------------------------------------------");
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
					
					
					SumoPosition2D v8Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition("8")); 
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
						
						conn.do_job_set(Vehicle.changeTarget("8", senderEdge_indexValue));		
					
					}
					
					System.out.println("After arranging the schedule:");
					System.out.println("timeSchedule:"+timeSchedule);
					System.out.println("timeMapToSender:"+timeMapToSender);
					
				}
				
				// request3 from sender3
				if(timeSeconds==30.0) {
					System.out.println("------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					// the request2[09:30, sender2]->09:30=570 min
					
					ArrayList sender2Array = new ArrayList();
					
					
					sender2Array.add("279049709#0");
					sender2Array.add(3180.99);
					sender2Array.add(614.76);
					
					int insertTime = 570;
					timeSchedule.add(insertTime);
					timeMapToSender.put(insertTime, sender2Array);
					
					System.out.println("timeSchedule:"+timeSchedule);
					System.out.println("timeMapToSender:"+timeMapToSender);
					
					
					Collections.sort(timeSchedule);  // Sort timeSchedule
					
					int indexValue = timeSchedule.indexOf(insertTime);
			
					
					
					if(indexValue==0) {
						System.out.println("indexValue of 0");
						
						SumoPosition2D v8Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition("8")); 
						
						System.out.println((double)sender2Array.get(1));
						
						double Distance_v8toSender2 = (double)(conn.do_job_get(Simulation.getDistance2D((double)sender2Array.get(1), (double)sender2Array.get(2),
								v8Position.x, v8Position.y, false, true)));
						double travelTimeToSender2 = Distance_v8toSender2/5.0; // V=5.0m/s
						System.out.println("Distance_v8toSender2:"+ Distance_v8toSender2);
						System.out.println("travelTimeToSender2:"+ travelTimeToSender2);
						
						int Key_indexValue =  timeSchedule.get(indexValue);
						double sender_x_indexValue = (double)timeMapToSender.get(Key_indexValue).get(1);
						double sender_y_indexValue = (double)timeMapToSender.get(Key_indexValue).get(2);
						
						int Key_afterIndex =  timeSchedule.get(indexValue+1);
						double sender_x_afterIndex = (double)timeMapToSender.get(Key_afterIndex).get(1);
						double sender_y_afterIndex = (double)timeMapToSender.get(Key_afterIndex).get(2);
						
						double afterIndexToIndex = (double)(conn.do_job_get(Simulation.getDistance2D(sender_x_indexValue, sender_y_indexValue,
								sender_x_afterIndex, sender_y_afterIndex, false, true)));
						
						double travelTime_afterIndexToIndex = afterIndexToIndex/5.0; // V=5.0m/s
						
						double diffDuration_afterIndexToIndex = (timeSchedule.get(indexValue+1)-timeSchedule.get(indexValue))*60; //  gap between this element and next element 
						System.out.println("diffDuration_afterIndexToIndex:"+ diffDuration_afterIndexToIndex + " seconds"); // 600min-570min
						
						// 09:00 starts, 30 mins
						if(timeSeconds+travelTimeToSender2 <((insertTime-540)*60) 
								&& travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) { // 30min*60=1800s
							// change the original route to the new route
							
					
							
							String senderEdge_indexValue = (String)timeMapToSender.get(Key_indexValue).get(0);
							conn.do_job_set(Vehicle.changeTarget("8", senderEdge_indexValue));	
							
							// need arrange the route after executing the current route
						}
						
					}
					
					else if(indexValue==(timeSchedule.size()-1)) {
						System.out.println("indexValue of "+ (timeSchedule.size()-1));
					}
					
					else {
						int beforeIndex = indexValue-1;
						int afterIndex = indexValue+1;
						
						System.out.println(timeSchedule.get(beforeIndex));
						System.out.println(timeSchedule.get(afterIndex));
					}

					System.out.println("After arranging the schedule:");
					System.out.println("timeSchedule:"+timeSchedule);
					System.out.println("timeMapToSender:"+timeMapToSender);
													
				}
				
		
				
				
				
	
				
			
				
			
		

			
			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
