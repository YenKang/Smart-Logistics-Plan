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

public class MainCopy {

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
			
			ArrayList<Integer> timeSchedule = new ArrayList<Integer>();
			Map<Integer,ArrayList> timeMapToSender = new HashMap<Integer,ArrayList>();
			HashMap timeMap = new HashMap();
			int timeArray[]= {};
			

			SumoStopFlags sf_send = new SumoStopFlags(false, false, false, false, false);
			SumoStopFlags sf_rec = new SumoStopFlags(false, false, false, false, false);
			
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
				
				// request3 from sender3 11:00
				if(timeSeconds==40.0) {
					System.out.println("------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					ArrayList sender3Array = new ArrayList();
					
			
					sender3Array.add("24452776");
					sender3Array.add(2513.37);
					sender3Array.add(1747.28);
					
					int insertTime = 660;
					timeSchedule.add(insertTime); // request3, sender3, 11:00->660
					timeMapToSender.put(insertTime, sender3Array);
					
					System.out.println("timeSchedule:"+timeSchedule);
					System.out.println("timeMapToSender:"+timeMapToSender);
				
					
					Collections.sort(timeSchedule);  // Sort timeSchedule
					
					int indexValue = timeSchedule.indexOf(insertTime);
				
					System.out.println("indexValue of 660:"+indexValue);
					
					if(indexValue==0) {
						//
					}
					
					else if(indexValue==(timeSchedule.size()-1)) {
			
						System.out.println("indexValue of "+ (timeSchedule.size()-1));
						
						// get the sender's position of this index and the previous element
						int Key_indexValue =  timeSchedule.get(indexValue);
						double sender_x_indexValue = (double)timeMapToSender.get(Key_indexValue).get(1);
						double sender_y_indexValue = (double)timeMapToSender.get(Key_indexValue).get(2);
						
						int Key_beforeIndex =  timeSchedule.get(indexValue-1);
						double sender_x_beforeIndex = (double)timeMapToSender.get(Key_beforeIndex).get(1);
						double sender_y_beforeIndex = (double)timeMapToSender.get(Key_beforeIndex).get(2);
						
						double Distance_preIndexToIndex= (double)(conn.do_job_get(Simulation.getDistance2D(sender_x_indexValue, sender_y_indexValue,
								sender_x_beforeIndex, sender_y_beforeIndex, false, true)));
						double travelTime_preIndexToIndex = Distance_preIndexToIndex/5.0; // V=5.0m/s
						System.out.println("travelTime_preIndexToIndex:"+travelTime_preIndexToIndex);
						
						double diffDuration_preIndexToIndex = (timeSchedule.get(indexValue)-timeSchedule.get(indexValue-1))*60; //  gap between this element and next element 
						System.out.println("duration:"+ diffDuration_preIndexToIndex + " seconds"); // 600min-570min
						
						if(travelTime_preIndexToIndex < diffDuration_preIndexToIndex) {
							System.out.println("request3 was inserted into the scedule successfully");		
						}
						
						else {
							// remove the request3
							// timeSchedule.remove(indexValue);
							// timeMap.remove(timeSchedule.get(indexValue));
						}
						
						
						
					}
					
					else {
						// 	System.out.println("index has two adjacent elements");
					}
					
					System.out.println("After arranging the schedule:");
					System.out.println("timeSchedule:"+timeSchedule);
					System.out.println("timeMapToSender:"+timeMapToSender);
					
				}
				
				if(timeSeconds==50.0) {
					
					System.out.println("------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					// the request4[10:30, sender4]->10:30=630 min
					ArrayList sender4Array = new ArrayList();
					sender4Array.add("496493919#2");
					sender4Array.add(1517.62);
					sender4Array.add(1207.92);
					
					int insertTime = 630;
					timeSchedule.add(insertTime); // request4, sender4, 10:30->630
					timeMapToSender.put(insertTime, sender4Array);
					
	
					Collections.sort(timeSchedule);  // Sort timeSchedule
					
					int indexValue = timeSchedule.indexOf(insertTime);
					System.out.println("indexValue:"+indexValue);
					
					if(indexValue==0) {
						//
					}
					
					else if(indexValue==(timeSchedule.size()-1)) {
			
						
					}
					
					else {
						
						int Key_indexValue =  timeSchedule.get(indexValue);
						double sender_x_indexValue = (double)timeMapToSender.get(Key_indexValue).get(1);
						double sender_y_indexValue = (double)timeMapToSender.get(Key_indexValue).get(2);
						
						int Key_afterIndex =  timeSchedule.get(indexValue+1);
						double sender_x_afterIndex = (double)timeMapToSender.get(Key_afterIndex).get(1);
						double sender_y_afterIndex = (double)timeMapToSender.get(Key_afterIndex).get(2);
						
						int Key_beforeIndex =  timeSchedule.get(indexValue-1);
						double sender_x_beforeIndex = (double)timeMapToSender.get(Key_beforeIndex).get(1);
						double sender_y_beforeIndex = (double)timeMapToSender.get(Key_beforeIndex).get(2);
						
						double Distance_preIndexToIndex= (double)(conn.do_job_get(Simulation.getDistance2D(sender_x_indexValue, sender_y_indexValue,
								sender_x_beforeIndex, sender_y_beforeIndex, false, true)));
						System.out.println("Distance_preIndexToIndex:"+ Distance_preIndexToIndex);
						
						double travelTime_preIndexToIndex = Distance_preIndexToIndex/5.0; // V=5.0m/s
						System.out.println("travelTime_preIndexToIndex:" + travelTime_preIndexToIndex);
						
						double diffDuration_preIndexToIndex = (timeSchedule.get(indexValue)-timeSchedule.get(indexValue-1))*60; //  gap between this element and previous element 
						System.out.println("diffDuration_preIndexToIndex:"+ diffDuration_preIndexToIndex + " seconds");
						
						double Distance_afterIndexToIndex = (double)(conn.do_job_get(Simulation.getDistance2D(sender_x_indexValue, sender_y_indexValue,
								sender_x_afterIndex, sender_y_afterIndex, false, true)));
						double travelTime_afterIndexToIndex = Distance_afterIndexToIndex/5.0; // V=5.0m/s
						double diffDuration_afterIndexToIndex = (timeSchedule.get(indexValue+1)-timeSchedule.get(indexValue))*60; // gap between this element and next element 
						System.out.println("Distance_afterIndexToIndex:"+ Distance_afterIndexToIndex);
						System.out.println("travelTime_afterIndexToIndex:"+travelTime_afterIndexToIndex);
						System.out.println("diffDuration_afterIndexToIndex:"+ diffDuration_afterIndexToIndex + " seconds");
						
					
						
						if(travelTime_preIndexToIndex<diffDuration_preIndexToIndex 
								&& travelTime_afterIndexToIndex< diffDuration_afterIndexToIndex ) {
							// 
							System.out.println("timeSchedule:"+timeSchedule);
							System.out.println("timeMapToSender:"+timeMapToSender);
					
		
						}
						
						// remove the request4
						else {
							System.out.println("after removing this request in timeSchedule");
							timeSchedule.remove(indexValue);
							timeMap.remove(timeSchedule.get(indexValue));
							
							System.out.println("timeSchedule:"+timeSchedule);
							System.out.println("timeMap:"+timeMap);
						}
						
						
						
					}
					

					System.out.println("After arranging the schedule:");
					System.out.println("timeSchedule:"+timeSchedule);
					System.out.println("timeMapToSender:"+timeMapToSender);
					
				}
				
	
				
				
				if (timeSeconds % 10 == 0) {
					
					
					 /*
					 String vType ="routeByDistance"; 
					 double depart = 0.0; 
					 int routingMode = 0;
					 SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute(Edge1, Edge3, vType, depart,routingMode)); 
					 
					 double TravelTimeToSender = stage.travelTime;
					  
					 System.out.println("We need "+ TravelTimeToSender+" s from Edge1 to Edge3");
					 */
					
					 //String curEdge = (String)conn.do_job_get(Vehicle.getRoadID("8")); // 
					 
				
					 //SumoPosition2D v8Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition("8")); 
					 //SumoPosition2D v9Position =(SumoPosition2D) conn.do_job_get(Vehicle.getPosition("9"));
					  
					 //System.out.println("v8 current edgeID is:" + curEdge + " in " + timeSeconds +" seconds"); 
				
					 
					 //double v8toSenderDistance= (double)(conn.do_job_get(Simulation.getDistance2D(sender_x, sender_y,v8Position.x, v8Position.y, false, false)));
					 //System.out.println("current distance between v8 to sender is:" +v8toSenderDistance);
					
					 //double v9toSenderDistance  =(double)(conn.do_job_get(Simulation.getDistance2D(sender_x, sender_y, v9Position.x, v9Position.y, false, false)));
					 
					 //System.out.println("current distance between v9 to sender is:" +v9toSenderDistance);
					
					 double speed = (double)conn.do_job_get(Vehicle.getSpeed("8"));
					 // System.out.println("speed:"+ speed);

				}
				
				/*
				if(timeSeconds==40.0) {
					conn.do_job_set(Vehicle.changeTarget("8", Edge3));
					double distance= (double)(conn.do_job_get(Simulation.getDistanceRoad(Edge1, 0.0, Edge3, 90.0, true)));
					System.out.println("getDistanceRoad:"+ distance);
					 
					double getDistance2D= (double)(conn.do_job_get(Simulation.getDistance2D(3546.69, 2156.75, 2334.39, 1819.02, false, true)));
					System.out.println("getDistance2D:"+ getDistance2D);
					
					 String vType ="routeByDistance"; 
					 double depart = 0.0; 
					 int routingMode = 1;
					 SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute(Edge1, Edge3, vType, depart,routingMode)); 
					 
					 double TravelTimeToSender = stage.travelTime;
					  
					 System.out.println("We need "+ TravelTimeToSender+" s from Edge1 to Edge3");
					 
					 //double speed = (double)conn.do_job_get(Vehicle.getSpeed("8"));
				}
				*/

	

				// System.out.println("timeSeconds:"+ timeSeconds);

		

			
			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
