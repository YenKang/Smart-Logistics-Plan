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
import de.tudresden.sumo.util.SumoCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;

import de.tudresden.ws.container.*;

public class MainCopy5_receiver_request {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	  static String config_file = "simulation4/map.sumo.cfg";

	// static double step_length = 0.01; // version1

	static double step_length = 0.01;
	//double vehicle_speed = 5.0; //5 [m/s]
	

	public static void main(String[] args) {

		try {
			
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			conn.addOption("step-length", step_length + "");
			conn.addOption("start", "true"); // start sumo immediately
			
			Map  CarsMapSchedule_afterBoxFilter = new HashMap();
			Map  CarsMap_timeToRequestInfo_afterBoxFilter = new HashMap();
			
			Map  cars_Box = new HashMap();
			ArrayList v1_small_Box = new ArrayList();
			v1_small_Box.add(111);
			v1_small_Box.add(112);
			//v1_small_Box.add(113);
			ArrayList v1_medium_Box = new ArrayList();
			ArrayList v1_large_Box = new ArrayList();
			Map  v1_Box = new HashMap();
			v1_Box.put(1, v1_small_Box); // "1" means for small box
			v1_Box.put(2, v1_medium_Box); // "2" means for medium box
			v1_Box.put(3, v1_large_Box); // "3" means for large box
			System.out.println("v1_Box:"+ v1_Box);
			
			ArrayList v2_small_Box = new ArrayList();
			ArrayList v2_medium_Box = new ArrayList();
			v2_medium_Box.add(221);
			ArrayList v2_large_Box = new ArrayList();
			Map  v2_Box = new HashMap();
			v2_Box.put(1, v2_small_Box); // "1" means for small box
			v2_Box.put(2, v2_medium_Box); // "2" means for medium box
			v2_Box.put(3, v2_large_Box); // "3" means for large box
			System.out.println("v2_Box:"+ v2_Box);
			
			ArrayList v3_small_Box = new ArrayList();
			ArrayList v3_medium_Box = new ArrayList();
			ArrayList v3_large_Box = new ArrayList();
			Map  v3_Box = new HashMap();
			v3_Box.put(1, v3_small_Box); // "1" means for small box
			v3_Box.put(2, v3_medium_Box); // "2" means for medium box
			v3_Box.put(3, v3_large_Box); // "3" means for large box
			System.out.println("v3_Box:"+ v3_Box);
			
			cars_Box.put(1, v1_Box);
			cars_Box.put(2, v2_Box);
			cars_Box.put(3, v3_Box);
			
			System.out.println("cars_Box:"+ cars_Box);
			
			

			Map  CarsMap_with_Schedule = new HashMap();
			//CarsMap_with_Schedule = {"1"=[570, 660], "2"=[660]};
			
			
			ArrayList v1_TimeSchedule = new ArrayList();
			v1_TimeSchedule.add(570);
			v1_TimeSchedule.add(660);
			CarsMap_with_Schedule.put("1", v1_TimeSchedule);
			
			
			ArrayList v2_TimeSchedule = new ArrayList();
			v2_TimeSchedule.add(660);
			CarsMap_with_Schedule.put("2", v2_TimeSchedule);
			
			System.out.println("CarsMap_with_Schedule:"+CarsMap_with_Schedule);

			/*CarsMap_time_to_requestInfo = {"1"={570=["33#1",5570.2, 4404.2, 10.0], 660=["115#1", 8880.0, 1112.0, 10.0]},
			 * "2"={660=["22#0", 4456.1, 4412.3, 20.0]}}
			 */
			Map  CarsMap_time_to_requestInfo = new HashMap();
			
			Map  v1_time_to_requestInfo = new HashMap();
			ArrayList v1_570_to_requestInfo = new ArrayList();
			v1_570_to_requestInfo.add("496257308#5");
			v1_570_to_requestInfo.add(3937.13);
			v1_570_to_requestInfo.add(5039.67);
			v1_570_to_requestInfo.add(50.0);
		
			
			ArrayList v1_660_to_requestInfo = new ArrayList();
			v1_660_to_requestInfo.add("273445903#7");
			v1_660_to_requestInfo.add(2966.38);
			v1_660_to_requestInfo.add(6993.0);
			v1_660_to_requestInfo.add(60.0);
			
			v1_time_to_requestInfo.put(570, v1_570_to_requestInfo );
			v1_time_to_requestInfo.put(660, v1_660_to_requestInfo );
			
			System.out.println("v1_time_to_requestInfo:"+ v1_time_to_requestInfo);
			
			Map  v2_time_to_requestInfo = new HashMap();

			ArrayList v2_660_to_requestInfo = new ArrayList();
			v2_660_to_requestInfo.add("297579234");
			v2_660_to_requestInfo.add(8973.76);
			v2_660_to_requestInfo.add(3772.53);
			v2_660_to_requestInfo.add(200.0);
			
			v2_time_to_requestInfo.put(660, v2_660_to_requestInfo);
			
			System.out.println("v2_time_to_requestInfo:"+ v2_time_to_requestInfo);
			
			ArrayList v3_TimeSchedule = new ArrayList();
			CarsMap_with_Schedule.put("3", v3_TimeSchedule);
			Map  v3_time_to_requestInfo = new HashMap();
			
			CarsMap_time_to_requestInfo.put("1", v1_time_to_requestInfo);
			CarsMap_time_to_requestInfo.put("2", v2_time_to_requestInfo);
			CarsMap_time_to_requestInfo.put("3", v3_time_to_requestInfo);
			
			System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
			
			// start Traci Server
			conn.runServer(8080);
			conn.setOrder(1);
			
			Map  CarsMapWithSchedule = new HashMap();
			//ArrayList v1_sender_TimeSchedule = new ArrayList();
			
			double vehicle_speed = 4.0; //4 [m/s]
			
			SumoColor veh1_color = new SumoColor(255 ,105, 180,0);
			conn.do_job_set(Vehicle.setColor("1", veh1_color));
			
			
			
		
			for (int i = 0; i < 360000000; i++) {
				
				
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());
				//System.out.println("timeSeconds:"+ timeSeconds);
				
				/*
				if(timeSeconds==30.0) {
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					
					int insert_BoxSize=1; // small box insertion
					CarsMapSchedule_afterBoxFilter = CarsMap_with_Schedule;
					CarsMap_timeToRequestInfo_afterBoxFilter= CarsMap_time_to_requestInfo;
					
					System.out.println("CarsMapSchedule_afterBoxFilter"+ CarsMapSchedule_afterBoxFilter);
					System.out.println("CarsMap_timeToRequestInfo_afterBoxFilter:"+ CarsMap_timeToRequestInfo_afterBoxFilter);
					
					for(int veh=1;veh<cars_Box.size()+1;veh++) {
						String vehID = Integer.toString(veh); 
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();
						veh_box =(Map) cars_Box.get(veh);
						
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size();
						//insert_Size_Box.size();
						System.out.println("veh:"+ veh + "insert_capacity:"+ insert_capacity);
						if(insert_capacity==3) {
							CarsMapSchedule_afterBoxFilter.remove(vehID);
							CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
						}
					}
					
					System.out.println("CarsMapSchedule_afterBoxFilter"+ CarsMapSchedule_afterBoxFilter);
					System.out.println("CarsMap_timeToRequestInfo_afterBoxFilter:"+ CarsMap_timeToRequestInfo_afterBoxFilter);
					
				}
				*/
				
				if(timeSeconds==50.0 ) {

					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
					
					
					for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) {
						
						System.out.println("---------------------------------");
						System.out.println("veh:"+ vehID);
						//String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
						
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("Collections.sort(veh_array):"+ veh_array);
						int remove_time =0;
						while(remove_time<(int)veh_array.indexOf((int)currentMin)+1) {
							veh_array.remove(0);
							remove_time++;
						}
						
						System.out.println("veh_array after removing:"+ veh_array);
						
				
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(vehID);
						
						ArrayList edges_list = new ArrayList();
						ArrayList stages_list = new ArrayList();
						SumoStringList routes = new SumoStringList();
						
						String curEdge = (String)conn.do_job_get(Vehicle.getRoadID((String) vehID));
						System.out.println("curEdge:"+ curEdge);
						edges_list.add(curEdge);
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
						
							//System.out.println("edge:"+ edge);
							edges_list.add(edge);
						}
						
						for(int edge_index=0;edge_index<edges_list.size()-1;edge_index++) {
							String vType ="truck"; 
							double depart = 0.0; 
							int routingMode = 0;
							SumoStage stage = (SumoStage)conn.do_job_get(
									Simulation.findRoute((String)edges_list.get(edge_index), (String)edges_list.get(edge_index+1), vType, depart,routingMode));
							stages_list.add(stage);
						}
						
				
						
						
						for(int stageIndex=1; stageIndex<stages_list.size();stageIndex++) {
							//(((SumoStage) stages_list.get(stageIndex)).edges).size();
							SumoStage each_stage= (SumoStage) stages_list.get(stageIndex);
							for(int edgeIndex=1; edgeIndex< each_stage.edges.size(); edgeIndex++) {
								
								String edge= each_stage.edges.get(edgeIndex);
								
								((SumoStage)stages_list.get(0)).edges.add(edge);
							}
							
						}
						
						if(stages_list.size()>0) {
							routes = ((SumoStage)stages_list.get(0)).edges;
						}
						
						
						
						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("newRoute_before:"+ newRoute);
						
						
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						
						System.out.println("edges_list:"+ edges_list);
						
						if(stages_list.size()>0) {
							conn.do_job_set(Vehicle.setRoute((String) vehID, routes));
						}
						
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);
						
							conn.do_job_set(Vehicle.setStop((String) vehID, edge, pos, (byte)0,  0.0, 
									new SumoStopFlags(false, false, false, false, false), 
									pos, 60.0*((Integer) veh_array.get(veh_array_index)-530)));
							
						
							
						}
						//conn.do_job_set(Vehicle.setStop("1", Edge1, 50.0, (byte)0,  0.0, sf_v1, 30.0, 2400.0));
					}

					
					
			
					
				}
				
				// At 09:05, we receive the request of sender4 with 10:30
				if(timeSeconds==100.0) {
					System.out.println("timeSeconds:"+ timeSeconds);
					int insertTime=570;
					int insert_BoxSize=1; // small box insertion
					
					Map  veh_box = new HashMap();
					ArrayList insert_Size_Box = new ArrayList(); 
					ArrayList request3_array = new ArrayList();
					
					
					
					request3_array.add("496493919#2");
					request3_array.add(7147.59);
					request3_array.add(5832.08);
					request3_array.add(150.0);
					
					CarsMapSchedule_afterBoxFilter = CarsMap_with_Schedule;
					CarsMap_timeToRequestInfo_afterBoxFilter= CarsMap_time_to_requestInfo;
					
					// box filtering stage
					for(int veh=1;veh<cars_Box.size()+1;veh++) {
						String vehID = Integer.toString(veh); 
						
						veh_box =(Map) cars_Box.get(veh);
						
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size();
						//insert_Size_Box.size();
						System.out.println("veh:"+ veh + " insert_capacity:"+ insert_capacity);
						if(insert_capacity==3) {
							CarsMapSchedule_afterBoxFilter.remove(vehID);
							CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
						}
					}
					
					// time-interval insertion filtering
					for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) {
						//String vehID = Integer.toString(veh); 
						int int_vehID = Integer.valueOf((String) vehID);
						System.out.println("-------------------------");
						System.out.println("key:"+ vehID);
						
						veh_box =(Map) cars_Box.get(int_vehID);
						System.out.println("cars_Box:"+ cars_Box);
						System.out.println("vehID:"+ vehID + " veh_box:"+ veh_box);
						System.out.println(((ArrayList) veh_box.get(insert_BoxSize)).size());
						
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size();
						
						ArrayList veh_array = new ArrayList();
						veh_array = (ArrayList)CarsMap_with_Schedule.get((String) vehID);
						Map  Map_requestInfo = new HashMap();
						
						System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(vehID);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						
						if((veh_array.contains(insertTime))!=true) {
							
							
							veh_array.add(insertTime);
							System.out.println("veh_array:"+ veh_array);
							Collections.sort(veh_array);
							System.out.println("veh_array after sorting:"+ veh_array);
							
							int indexValue = veh_array.indexOf(insertTime);
							Map_requestInfo.put(insertTime, request3_array ); // request3_array should be dynamic
							
							if(indexValue==0) {
								SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
								
								double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
										(double)request3_array.get(1), (double)request3_array.get(2), 
										veh_Position.x, veh_Position.y, false, true));
								
								System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
								double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
								
								System.out.println("Map_requestInfo22:"+ Map_requestInfo);
								
								int key_afterIndex = (int) veh_array.get(indexValue+1);
								System.out.println("key_afterIndex:"+ key_afterIndex);
								double request_x_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(1);
								double request_y_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(2);
								
								
								double distance_afterIndexToIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
										request_x_afterIndex, request_y_afterIndex,
										(double)request3_array.get(1), (double)request3_array.get(2), false, true)));
								
								double travelTime_afterIndexToIndex = distance_afterIndexToIndex/vehicle_speed;
								System.out.println("distance_afterIndexToIndex:"+ distance_afterIndexToIndex);
								System.out.println("travelTime_afterIndexToIndex:"+ travelTime_afterIndexToIndex);
								
								double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60;
							
								System.out.println("diffDuration_afterIndexToIndex:"+ diffDuration_afterIndexToIndex);
								
								System.out.println("timeSeconds+travelTime_curr_To_Index:"+ (timeSeconds+travelTime_curr_To_Index));
								System.out.println("insertTime key_afterIndex:"+ (key_afterIndex-insertTime));
								
								if((travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) &&
										(timeSeconds+travelTime_curr_To_Index) <(key_afterIndex-insertTime)*60) {
									
									// BoxIndex insertion
									if(insert_capacity==0) {
										int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
										System.out.println("insert_BoxIndex:"+insert_BoxIndex);
										((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
										System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
										// setParameter
										cars_Box.put(int_vehID, veh_box);
										System.out.println("cars_Box:"+ cars_Box);
									}
									else if(insert_capacity==1){
										int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
										System.out.println("insert_BoxIndex:"+insert_BoxIndex);
										((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
										System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
										// setParameter
										cars_Box.put(int_vehID, veh_box);
										System.out.println("cars_Box:"+ cars_Box);
									}
									
									else if(insert_capacity==2){
										int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
										System.out.println("insert_BoxIndex:"+insert_BoxIndex);
										((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
										System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
										// setParameter
										cars_Box.put(int_vehID, veh_box);
										System.out.println("cars_Box:"+ cars_Box);
									}
									
									
									
									
								
									//Map_requestInfo.put(insertTime, request3_array ); // request3_array should be dynamic
									CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
									
									System.out.println("-----------after inserting------------");
									System.out.println("This request is inserted!"+ "veh"+ vehID+ "boxSize:"+ insert_BoxSize );
									System.out.println("Map_requestInfo:"+ Map_requestInfo);
									System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
									
									
									System.out.println("CarsMap_time_to_requestInfo in 900s:"+ CarsMap_time_to_requestInfo);
									
									
									
									
									break;
								}
								
								else {
									Map_requestInfo.remove(insertTime);
									break;
								}
							}
							
							else if(indexValue==(veh_array.size()-1)) {
								int key_IndexValue = (int) veh_array.get(indexValue);
								double request_x_IndexValue = (double)((ArrayList) Map_requestInfo.get(key_IndexValue)).get(1);
								double request_y_IndexValue = (double)((ArrayList) Map_requestInfo.get(key_IndexValue)).get(2);
								
								int key_beforeIndex = (int) veh_array.get(indexValue-1);
								double request_x_beforeIndex = (double)((ArrayList) Map_requestInfo.get(key_beforeIndex)).get(1);
								double request_y_beforeIndex = (double)((ArrayList) Map_requestInfo.get(key_beforeIndex)).get(2);
								
								double distance_IndexToBeforeIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
										request_x_IndexValue, request_y_IndexValue,
										request_x_beforeIndex, request_y_beforeIndex, false, true)));
								double travelTime_IndexToBeforeIndex = distance_IndexToBeforeIndex/vehicle_speed;
								
								double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60;
								
								System.out.println("travelTime_IndexToBeforeIndex:"+travelTime_IndexToBeforeIndex);
								System.out.println("diffDuration_IndexToBeforeIndex:"+ diffDuration_IndexToBeforeIndex);
								
								System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex) {
									// BoxIndex insertion
									if(insert_capacity==0) {
										int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
										System.out.println("insert_BoxIndex:"+insert_BoxIndex);
										((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
										System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
										// setParameter
										cars_Box.put(int_vehID, veh_box);
										System.out.println("cars_Box:"+ cars_Box);
									}
									else if(insert_capacity==1){
										int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
										System.out.println("insert_BoxIndex:"+insert_BoxIndex);
										((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
										System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
										// setParameter
										cars_Box.put(int_vehID, veh_box);
										System.out.println("cars_Box:"+ cars_Box);
									}
									
									else if(insert_capacity==2){
										int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
										System.out.println("insert_BoxIndex:"+insert_BoxIndex);
										((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
										System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
										// setParameter
										cars_Box.put(int_vehID, veh_box);
										System.out.println("cars_Box:"+ cars_Box);
									}
									
									Map_requestInfo.put(insertTime, request3_array ); // request3_array should be dynamic
									CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
									System.out.println("-----------after inserting------------");
									System.out.println("Map_requestInfo:"+ Map_requestInfo);
									System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
									break;
								}
								else {
									Map_requestInfo.remove(insertTime);
									break;
								}
								
							}
							
							else {
								
								int key_IndexValue = (int) veh_array.get(indexValue);
								double request_x_IndexValue = (double)((ArrayList) Map_requestInfo.get(key_IndexValue)).get(1);
								double request_y_IndexValue = (double)((ArrayList) Map_requestInfo.get(key_IndexValue)).get(2);
								
								int key_beforeIndex = (int) veh_array.get(indexValue-1);
								double request_x_beforeIndex = (double)((ArrayList) Map_requestInfo.get(key_beforeIndex)).get(1);
								double request_y_beforeIndex = (double)((ArrayList) Map_requestInfo.get(key_beforeIndex)).get(2);
								
								int key_afterIndex = (int) veh_array.get(indexValue+1);
						
								double request_x_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(1);
								double request_y_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(2);
								
								double distance_IndexToBeforeIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
										request_x_IndexValue, request_y_IndexValue,
										request_x_beforeIndex, request_y_beforeIndex, false, true)));
								double travelTime_IndexToBeforeIndex = distance_IndexToBeforeIndex/vehicle_speed;
								double distance_afterIndexToIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
										request_x_afterIndex, request_y_afterIndex,
										request_x_IndexValue, request_y_IndexValue, false, true)));
								double travelTime_afterIndexToIndex = distance_afterIndexToIndex/vehicle_speed;
								
								double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60;
								double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60;
								
								System.out.println("travelTime_IndexToBeforeIndex:"+travelTime_IndexToBeforeIndex);
								System.out.println("travelTime_afterIndexToIndex:"+ travelTime_afterIndexToIndex);
								
								System.out.println("diffDuration_IndexToBeforeIndex:"+diffDuration_IndexToBeforeIndex);
								System.out.println("diffDuration_afterIndexToIndex:"+ diffDuration_afterIndexToIndex);
								
								if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex && 
										travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) {
									// BoxIndex insertion
									if(insert_capacity==0) {
										int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
										System.out.println("insert_BoxIndex:"+insert_BoxIndex);
										((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
										System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
										// setParameter
										cars_Box.put(int_vehID, veh_box);
										System.out.println("cars_Box:"+ cars_Box);
									}
									else if(insert_capacity==1){
										int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
										System.out.println("insert_BoxIndex:"+insert_BoxIndex);
										((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
										System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
										// setParameter
										cars_Box.put(int_vehID, veh_box);
										System.out.println("cars_Box:"+ cars_Box);
									}
									
									else if(insert_capacity==2){
										int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
										System.out.println("insert_BoxIndex:"+insert_BoxIndex);
										((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
										System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
										// setParameter
										cars_Box.put(int_vehID, veh_box);
										System.out.println("cars_Box:"+ cars_Box);
									}
									
									//Map_requestInfo.put(insertTime, request3_array ); // request3_array should be dynamic
									CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
									
									System.out.println("-----------after inserting------------");
									System.out.println("Map_requestInfo:"+ Map_requestInfo);
									System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								
									
									break;
								}
								
								else {
									Map_requestInfo.remove(insertTime);
									break;
								}
							}
						}
					}
					
				}
				
				if(timeSeconds==360.0 ) {

					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
			
					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
						
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						
						veh_array.add((int)currentMin);
						
						Collections.sort(veh_array);
						System.out.println("Collections.sort(veh_array):"+ veh_array);
						int remove_time =0;
						while(remove_time<(int)veh_array.indexOf((int)currentMin)+1) {
							veh_array.remove(0);
							remove_time++;
						}
						
						System.out.println("veh_array after removing:"+ veh_array);
						
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(vehID);
						
						ArrayList edges_list = new ArrayList();
						ArrayList stages_list = new ArrayList();
						SumoStringList routes = new SumoStringList();
						
						String curEdge = (String)conn.do_job_get(Vehicle.getRoadID(vehID));
						System.out.println("curEdge:"+ curEdge);
						edges_list.add(curEdge);
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
						
							//System.out.println("edge:"+ edge);
							edges_list.add(edge);
						}
						
						for(int edge_index=0;edge_index<edges_list.size()-1;edge_index++) {
							String vType ="truck"; 
							double depart = 0.0; 
							int routingMode = 0;
							
							SumoStage stage = (SumoStage)conn.do_job_get(
									Simulation.findRoute((String)edges_list.get(edge_index), (String)edges_list.get(edge_index+1), vType, depart,routingMode));
							stages_list.add(stage);
						}
						
				
						
						
						for(int stageIndex=1; stageIndex<stages_list.size();stageIndex++) {
							//(((SumoStage) stages_list.get(stageIndex)).edges).size();
							SumoStage each_stage= (SumoStage) stages_list.get(stageIndex);
							for(int edgeIndex=1; edgeIndex< each_stage.edges.size(); edgeIndex++) {
								
								String edge= each_stage.edges.get(edgeIndex);
								
								((SumoStage)stages_list.get(0)).edges.add(edge);
							}
							
						}
						
						
						routes = ((SumoStage)stages_list.get(0)).edges;
						
						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("newRoute_before:"+ newRoute);
						
						System.out.println("veh:"+ veh);
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						
						System.out.println("edges_list:"+ edges_list);
						conn.do_job_set(Vehicle.setRoute(vehID, routes));
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);
							
							System.out.println("edge:"+ edge);
							System.out.println("pos:"+ pos);
							SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
							
							conn.do_job_set(Vehicle.setStop(vehID, edge, pos+10, (byte)0,  0.0, 
									sf, pos, 60.0*((Integer) veh_array.get(veh_array_index)-530)));
						
						}
						//conn.do_job_set(Vehicle.setStop("1", Edge1, 50.0, (byte)0,  0.0, sf_v1, 30.0, 2400.0));
					}

					
					
			
					
				}
				
				// receive the request5 if 10:00
				if(timeSeconds==480.0) {
					int insertTime=600; // dream mall
					System.out.println("timeSeconds:"+ timeSeconds);
					// receive the request
					
					ArrayList request4_array = new ArrayList();
					request4_array.add("405115649");
					request4_array.add(10353.5);
					request4_array.add(5583.48);
					request4_array.add(260.0);
					
					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						String vehID = Integer.toString(veh); 
						System.out.println("-------------------------");
						System.out.println("key:"+ vehID);
						ArrayList veh_array = new ArrayList();
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						Map  Map_requestInfo = new HashMap();
						
						System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(vehID);
						System.out.println("Map_requestInfo111:"+ Map_requestInfo);
						
						if((veh_array.contains(insertTime))!=true) {
							
							
							veh_array.add(insertTime);
							System.out.println("veh_array:"+ veh_array);
							Collections.sort(veh_array);
							System.out.println("veh_array after sorting:"+ veh_array);
							
							int indexValue = veh_array.indexOf(insertTime);
							Map_requestInfo.put(insertTime, request4_array ); // request3_array should be dynamic
							
							if(indexValue==0) {
								SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition(vehID));
								
								double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
										(double)request4_array.get(1), (double)request4_array.get(2), 
										veh_Position.x, veh_Position.y, false, true));
								
								System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
								double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
								
								System.out.println("Map_requestInfo22:"+ Map_requestInfo);
								
								int key_afterIndex = (int) veh_array.get(indexValue+1);
								System.out.println("key_afterIndex:"+ key_afterIndex);
								double request_x_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(1);
								double request_y_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(2);
								
								
								double distance_afterIndexToIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
										request_x_afterIndex, request_y_afterIndex,
										(double)request4_array.get(1), (double)request4_array.get(2), false, true)));
								
								double travelTime_afterIndexToIndex = distance_afterIndexToIndex/vehicle_speed;
								System.out.println("distance_afterIndexToIndex:"+ distance_afterIndexToIndex);
								System.out.println("travelTime_afterIndexToIndex:"+ travelTime_afterIndexToIndex);
								
								double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60;
							
								System.out.println("diffDuration_afterIndexToIndex:"+ diffDuration_afterIndexToIndex);
								
								System.out.println("timeSeconds+travelTime_curr_To_Index:"+ (timeSeconds+travelTime_curr_To_Index));
								System.out.println("insertTime key_afterIndex:"+ (key_afterIndex-insertTime));
								
								if((travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) &&
										(timeSeconds+travelTime_curr_To_Index) <(key_afterIndex-insertTime)*60) {
									
									
									//Map_requestInfo.put(insertTime, request3_array ); // request3_array should be dynamic
									CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
									
									System.out.println("-----------after inserting------------");
									System.out.println("Map_requestInfo:"+ Map_requestInfo);
									System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
									
									
									System.out.println("CarsMap_time_to_requestInfo in 900s:"+ CarsMap_time_to_requestInfo);
									break;
								}
								
								else {
									Map_requestInfo.remove(insertTime);
									break;
								}
							}
							
							else if(indexValue==(veh_array.size()-1)) {
								int key_IndexValue = (int) veh_array.get(indexValue);
								double request_x_IndexValue = (double)((ArrayList) Map_requestInfo.get(key_IndexValue)).get(1);
								double request_y_IndexValue = (double)((ArrayList) Map_requestInfo.get(key_IndexValue)).get(2);
								
								int key_beforeIndex = (int) veh_array.get(indexValue-1);
								double request_x_beforeIndex = (double)((ArrayList) Map_requestInfo.get(key_beforeIndex)).get(1);
								double request_y_beforeIndex = (double)((ArrayList) Map_requestInfo.get(key_beforeIndex)).get(2);
								
								double distance_IndexToBeforeIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
										request_x_IndexValue, request_y_IndexValue,
										request_x_beforeIndex, request_y_beforeIndex, false, true)));
								double travelTime_IndexToBeforeIndex = distance_IndexToBeforeIndex/vehicle_speed;
								
								double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60;
								
								System.out.println("travelTime_IndexToBeforeIndex:"+travelTime_IndexToBeforeIndex);
								System.out.println("diffDuration_IndexToBeforeIndex:"+ diffDuration_IndexToBeforeIndex);
								
								System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex) {
									Map_requestInfo.put(insertTime, request4_array ); // request3_array should be dynamic
									CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
									System.out.println("-----------after inserting------------");
									System.out.println("Map_requestInfo:"+ Map_requestInfo);
									System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
									break;
								}
								else {
									Map_requestInfo.remove(insertTime);
									break;
								}
								
							}
							
							else {
								
								int key_IndexValue = (int) veh_array.get(indexValue);
								double request_x_IndexValue = (double)((ArrayList) Map_requestInfo.get(key_IndexValue)).get(1);
								double request_y_IndexValue = (double)((ArrayList) Map_requestInfo.get(key_IndexValue)).get(2);
								
								int key_beforeIndex = (int) veh_array.get(indexValue-1);
								double request_x_beforeIndex = (double)((ArrayList) Map_requestInfo.get(key_beforeIndex)).get(1);
								double request_y_beforeIndex = (double)((ArrayList) Map_requestInfo.get(key_beforeIndex)).get(2);
								
								int key_afterIndex = (int) veh_array.get(indexValue+1);
						
								double request_x_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(1);
								double request_y_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(2);
								
								double distance_IndexToBeforeIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
										request_x_IndexValue, request_y_IndexValue,
										request_x_beforeIndex, request_y_beforeIndex, false, true)));
								double travelTime_IndexToBeforeIndex = distance_IndexToBeforeIndex/vehicle_speed;
								double distance_afterIndexToIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
										request_x_afterIndex, request_y_afterIndex,
										request_x_IndexValue, request_y_IndexValue, false, true)));
								double travelTime_afterIndexToIndex = distance_afterIndexToIndex/vehicle_speed;
								
								double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60;
								double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60;
								
								System.out.println("travelTime_IndexToBeforeIndex:"+travelTime_IndexToBeforeIndex);
								System.out.println("travelTime_afterIndexToIndex:"+ travelTime_afterIndexToIndex);
								
								System.out.println("diffDuration_IndexToBeforeIndex:"+diffDuration_IndexToBeforeIndex);
								System.out.println("diffDuration_afterIndexToIndex:"+ diffDuration_afterIndexToIndex);
								
								if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex && 
										travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) {
									//Map_requestInfo.put(insertTime, request3_array ); // request3_array should be dynamic
									CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
									
									System.out.println("-----------after inserting------------");
									System.out.println("Map_requestInfo:"+ Map_requestInfo);
									System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								
									
									break;
								}
								
								else {
									Map_requestInfo.remove(insertTime);
									break;
								}
							}
						}
					}
					
				}
			
				
				if(timeSeconds==500.0 ) {
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
					
		
					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
						
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("Collections.sort(veh_array):"+ veh_array);
						int remove_time =0;
						while(remove_time<(int)veh_array.indexOf((int)currentMin)+1) {
							veh_array.remove(0);
							remove_time++;
						}
						
						System.out.println("veh_array after removing:"+ veh_array);
						
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(vehID);
						
						ArrayList edges_list = new ArrayList();
						ArrayList stages_list = new ArrayList();
						SumoStringList routes = new SumoStringList();
						
						String curEdge = (String)conn.do_job_get(Vehicle.getRoadID(vehID));
						System.out.println("curEdge:"+ curEdge);
						edges_list.add(curEdge);
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
						
							//System.out.println("edge:"+ edge);
							edges_list.add(edge);
						}
						
						for(int edge_index=0;edge_index<edges_list.size()-1;edge_index++) {
							String vType ="truck"; 
							double depart = 0.0; 
							int routingMode = 0;
							SumoStage stage = (SumoStage)conn.do_job_get(
									Simulation.findRoute((String)edges_list.get(edge_index), (String)edges_list.get(edge_index+1), vType, depart,routingMode));
							stages_list.add(stage);
						}
						
				
						
						
						for(int stageIndex=1; stageIndex<stages_list.size();stageIndex++) {
							//(((SumoStage) stages_list.get(stageIndex)).edges).size();
							SumoStage each_stage= (SumoStage) stages_list.get(stageIndex);
							for(int edgeIndex=1; edgeIndex< each_stage.edges.size(); edgeIndex++) {
								
								String edge= each_stage.edges.get(edgeIndex);
								
								((SumoStage)stages_list.get(0)).edges.add(edge);
							}
							
						}
						
						
						routes = ((SumoStage)stages_list.get(0)).edges;
						
						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("newRoute_before:"+ newRoute);
						
						System.out.println("veh:"+ veh);
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						
						System.out.println("edges_list:"+ edges_list);
						conn.do_job_set(Vehicle.setRoute(vehID, routes));
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);
							
							System.out.println("edge:"+ edge);
							System.out.println("pos:"+ pos);
							SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
							
							conn.do_job_set(Vehicle.setStop(vehID, edge, pos+10, (byte)0,  0.0, 
									sf, pos, 60.0*((Integer) veh_array.get(veh_array_index)-530)));
						
						}
						//conn.do_job_set(Vehicle.setStop("1", Edge1, 50.0, (byte)0,  0.0, sf_v1, 30.0, 2400.0));
					}

					
					
			
					
				}
				
				
					if(timeSeconds==2000.0 ) {
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
					
		
					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						String vehID = Integer.toString(veh); 
						ArrayList veh_array_0 = new ArrayList();//veh_array:[570, 660]
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
						veh_array_0 = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array_0.add((int)currentMin);
						Collections.sort(veh_array_0);
						System.out.println("Collections.sort(veh_array):"+ veh_array_0);
						
						int currTime_index = (int)veh_array_0.indexOf((int)currentMin);
						for(int p=currTime_index+1; p<veh_array_0.size();p++) {
							veh_array.add(veh_array_0.get(p));
						}
						/*
						int remove_time =0;
						while(remove_time<(int)veh_array.indexOf((int)currentMin)+1) {
							veh_array.remove(0);
							remove_time++;
						}
						*/
						System.out.println("veh_array after removing:"+ veh_array);
						
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(vehID);
						
						ArrayList edges_list = new ArrayList();
						ArrayList stages_list = new ArrayList();
						SumoStringList routes = new SumoStringList();
						
						String curEdge = (String)conn.do_job_get(Vehicle.getRoadID(vehID));
						System.out.println("curEdge:"+ curEdge);
						edges_list.add(curEdge);
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
						
							//System.out.println("edge:"+ edge);
							edges_list.add(edge);
						}
						
						for(int edge_index=0;edge_index<edges_list.size()-1;edge_index++) {
							String vType ="truck"; 
							double depart = 0.0; 
							int routingMode = 0;
							SumoStage stage = (SumoStage)conn.do_job_get(
									Simulation.findRoute((String)edges_list.get(edge_index), (String)edges_list.get(edge_index+1), vType, depart,routingMode));
							stages_list.add(stage);
						}
						
				
						
						
						for(int stageIndex=1; stageIndex<stages_list.size();stageIndex++) {
							//(((SumoStage) stages_list.get(stageIndex)).edges).size();
							SumoStage each_stage= (SumoStage) stages_list.get(stageIndex);
							for(int edgeIndex=1; edgeIndex< each_stage.edges.size(); edgeIndex++) {
								
								String edge= each_stage.edges.get(edgeIndex);
								
								((SumoStage)stages_list.get(0)).edges.add(edge);
							}
							
						}
						
						
						routes = ((SumoStage)stages_list.get(0)).edges;
						
						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("newRoute_before:"+ newRoute);
						
						System.out.println("veh:"+ veh);
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						
						System.out.println("edges_list:"+ edges_list);
						conn.do_job_set(Vehicle.setRoute(vehID, routes));
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);
							
							System.out.println("edge:"+ edge);
							System.out.println("pos:"+ pos);
							SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
							
							conn.do_job_set(Vehicle.setStop(vehID, edge, pos+10, (byte)0,  0.0, 
									sf, pos, 60.0*((Integer) veh_array.get(veh_array_index)-530)));
						
						}
						//conn.do_job_set(Vehicle.setStop("1", Edge1, 50.0, (byte)0,  0.0, sf_v1, 30.0, 2400.0));
					}

					
					
			
					
				}
				
			
			
	
		
			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}