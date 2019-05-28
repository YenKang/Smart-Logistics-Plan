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

public class MainCopy4_MultipleCars {

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
			
			CarsMap_time_to_requestInfo.put("1", v1_time_to_requestInfo);
			CarsMap_time_to_requestInfo.put("2", v2_time_to_requestInfo);
			
			System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
			
			// start Traci Server
			conn.runServer(8080);
			conn.setOrder(1);
			
			Map  CarsMapWithSchedule = new HashMap();
			//ArrayList v1_sender_TimeSchedule = new ArrayList();
			
			double vehicle_speed = 4.0; //4 [m/s]
			
		
			
			
			
		
			for (int i = 0; i < 360000000; i++) {
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());
				//System.out.println("timeSeconds:"+ timeSeconds);
				
				if(timeSeconds==40.0) {
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					//conn.do_job_set(Vehicle.changeTarget("1", "496257308#5"));
					
					//SumoStopFlags sf_v1 = new SumoStopFlags(false, false, false, false, false);
					
					/**
					 * public static SumoCommand setStop(String vehID, String edgeID, 
					double pos, byte laneIndex, double duration, SumoStopFlags sf, double startPos, double until)
					 */
					 
	
					//conn.do_job_set(Vehicle.setStop("1","496257308#5", 50.0, (byte)0,  0.0, sf_v1, 30.0, 1500.0));
					
					
					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
					
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(vehID);
						
						ArrayList edges_list = new ArrayList();
						ArrayList stages_list = new ArrayList();
						
						String curEdge = (String)conn.do_job_get(Vehicle.getRoadID(vehID));
						edges_list.add(curEdge);
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							System.out.println("edge:"+ edge);
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
						
						System.out.println("stages_list:"+ stages_list);
						
						
						
						
						
						
						System.out.println("veh:"+ veh);
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						
						
						System.out.println("Map_requestInfo.get(veh_array.get(0))"+ Map_requestInfo.get(veh_array.get(0)));
						
						System.out.println("edges_list:"+ edges_list);
						
					}

					
					String curEdge = (String)conn.do_job_get(Vehicle.getRoadID("1"));
					String fromEdge = curEdge;
					String Edge1 = "496257308#5";
					String Edge2 = "273445903#7";
					String vType ="truck"; 
					double depart = 100.0; 
					int routingMode = 0;
					
					
					SumoStage stage1 = (SumoStage)conn.do_job_get(Simulation.findRoute(curEdge, Edge1, vType, depart,routingMode));
					
					SumoStage stage2 = (SumoStage)conn.do_job_get(Simulation.findRoute(Edge1, Edge2, vType, depart,routingMode));
					
					LinkedList<String> newRoute = new LinkedList<String>(); 
					LinkedList<String> a_route = new LinkedList<String>(); 
					LinkedList<String> newRoute1_addOne = new LinkedList<String>(); 
					SumoStringList a = new SumoStringList();
					
					//a= stage1.edges;

					//conn.do_job_set(Vehicle.setRoute("1", stage1.edges));
					
				
					
					
					a = stage1.edges;
				
					
					for (int j=1;j<stage2.edges.size();j++){ 
						String edge = stage2.edges.get(j);
				
						stage1.edges.add(edge); 
					}
					
			
				
					
					conn.do_job_set(Vehicle.setRoute("1", stage1.edges));
					
					
					
					SumoStopFlags sf_v1 = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop("1", Edge1, 50.0, (byte)0,  0.0, sf_v1, 30.0, 2400.0));
					conn.do_job_set(Vehicle.setStop("1", Edge2, 50.0, (byte)0,  0.0, sf_v1, 30.0, 7800.0));
					
					
					/*
					conn.do_job_set(Vehicle.setRoute("1", stage2.edges));
					conn.do_job_set(Vehicle.setStop("1", Edge2, 60.0, (byte)0,  0.0, sf_v1, 30.0, 7800.0));
					*/
					
					
				}
				
				// receive the request of sender4 with 10:30
				if(timeSeconds==600.0) {
					int insertTime=630;
					System.out.println("timeSeconds:"+ timeSeconds);
					// receive the request
					
					ArrayList request3_array = new ArrayList();
					request3_array.add("496493919#2");
					request3_array.add(7147.59);
					request3_array.add(5832.08);
					request3_array.add(150.0);
					
					for(Object key: CarsMap_with_Schedule.keySet()) {
						
						System.out.println("-------------------------");
						System.out.println("key:"+ key);
						ArrayList veh_array = new ArrayList();
						veh_array = (ArrayList)CarsMap_with_Schedule.get(key);
						Map  Map_requestInfo = new HashMap();
						
						System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(key);
						System.out.println("Map_requestInfo111:"+ Map_requestInfo);
						
						if((veh_array.contains(insertTime))!=true) {
							
							
							veh_array.add(insertTime);
							System.out.println("veh_array:"+ veh_array);
							Collections.sort(veh_array);
							System.out.println("veh_array_88:"+ veh_array);
							
							int indexValue = veh_array.indexOf(insertTime);
							
							if(indexValue==0) {
								SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) key));
								
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
								System.out.println("insertTime-key_afterIndex:"+ (key_afterIndex-insertTime));
								
								if((travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) &&
										(timeSeconds+travelTime_curr_To_Index) <(key_afterIndex-insertTime)*60) {
									
									
									Map_requestInfo.put(insertTime, request3_array ); // request3_array should be dynamic
									CarsMap_time_to_requestInfo.put(key, Map_requestInfo);
									System.out.println("-----------after inserting------------");
									System.out.println("Map_requestInfo:"+ Map_requestInfo);
									System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
									
									conn.do_job_set(Vehicle.changeTarget((String) key, 
											(String)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(0)));
									
									SumoStopFlags sf_v2 = new SumoStopFlags(false, false, false, false, false);
									
									/*
									conn.do_job_set(Vehicle.setStop((String) key,
											(String)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(0), 
											(double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(3), 
											(byte)0, 1200.0, sf_v2));
									*/
								
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
								
								
								
							}
							
							else {
								/*
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
								*/
							}
						}
					}
					
				}
				
			
				
				
				
				
			
			
	
		
			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
