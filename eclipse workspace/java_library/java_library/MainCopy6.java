
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
import de.tudresden.sumo.cmd.Junction;
import de.tudresden.sumo.cmd.Simulation;
import de.tudresden.sumo.cmd.Vehicle;
import de.tudresden.sumo.util.SumoCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;

import de.tudresden.ws.container.*;

public class MainCopy6 {

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
			Map  cars_Box = new HashMap();
			ArrayList v1_small_Box = new ArrayList();
			v1_small_Box.add(111);
			v1_small_Box.add(112);

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
			v1_570_to_requestInfo.add(0);
			v1_570_to_requestInfo.add(111);
			
			
			ArrayList v1_660_to_requestInfo = new ArrayList();
			v1_660_to_requestInfo.add("273445903#7");
			v1_660_to_requestInfo.add(2966.38);
			v1_660_to_requestInfo.add(6993.0);
			v1_660_to_requestInfo.add(60.0);
			v1_660_to_requestInfo.add(0);
			v1_660_to_requestInfo.add(112);
			
			v1_time_to_requestInfo.put(570, v1_570_to_requestInfo );
			v1_time_to_requestInfo.put(660, v1_660_to_requestInfo );
			
			System.out.println("v1_time_to_requestInfo:"+ v1_time_to_requestInfo);
		
			Map  v2_time_to_requestInfo = new HashMap();

			ArrayList v2_660_to_requestInfo = new ArrayList();
			v2_660_to_requestInfo.add("297579234");
			v2_660_to_requestInfo.add(8973.76);
			v2_660_to_requestInfo.add(3772.53);
			v2_660_to_requestInfo.add(200.0);
			v2_660_to_requestInfo.add(0);
			v2_660_to_requestInfo.add(221);
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
		
			//BoxIndex initialization
			for(int veh=1;veh<4;veh++) {
				for(int boxSizeIndex=1;boxSizeIndex<4;boxSizeIndex++) {
					for(int boxOrder=1;boxOrder<4;boxOrder++) {
						int int_boxIndex = veh*100+boxSizeIndex*10+boxOrder;
						String veh_ID = Integer.toString(veh);
						String boxIndex = Integer.toString(int_boxIndex);
						conn.do_job_set(Vehicle.setParameter(veh_ID, boxIndex, "0"));
					}
				}	
			}
			/////////////////////////////////////////////////////////////////
			
			
			///////////////////////////////////////////////////////////////////
			double vehicle_speed = 4.0; //4 [m/s]
			//SumoColor veh1_color = new SumoColor(255 ,105, 180, 8);
			//conn.do_job_set(Vehicle.setColor("1", veh1_color));
			
			for (int i = 0; i < 360000000; i++) {
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());
				//System.out.println("timeSeconds:"+ timeSeconds);

				if(timeSeconds==10.0){
					System.out.println("---------------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) 
					{
						System.out.println("---------------------------------");

						String vehID = Integer.toString(veh); 
						System.out.println("vehID:"+ vehID);
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);

						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("sort(veh_array):"+ veh_array);
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
							SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute((String)edges_list.get(edge_index), 
									(String)edges_list.get(edge_index+1), vType, depart,routingMode));
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

						if(stages_list.size()>0){
							routes = ((SumoStage)stages_list.get(0)).edges;
						}

						LinkedList<String> newRoute = new LinkedList<String>(); 

						for (String edge :routes){ 
							newRoute.add(edge); 
						}

						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						System.out.println("curEdge:"+ curEdge);
						System.out.println("Arrival edges_list:"+ edges_list);	
						System.out.println("newRoute_before:"+ newRoute);

						if(stages_list.size()>0){
							conn.do_job_set(Vehicle.setRoute(vehID, routes));
						}
						// setStop stage
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);		
							// SumoStopFlags sf3 = new SumoStopFlags(false, false, false, false, false);
							double until = 60.0*((Integer) veh_array.get(veh_array_index)-530);
							System.out.println("edge:"+ edge);
							System.out.println("pos:"+ pos);
							System.out.println("until"+ until);
							SumoStopFlags sf_0 = new SumoStopFlags(false, false, false, false, false);
							conn.do_job_set(Vehicle.setStop(vehID, edge, pos, (byte)0,  0.0,  
									sf_0, pos, until));

						}
				  	}
				}

				// 
				if(timeSeconds==50.0 ) {


					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);			
					int insert_BoxSize=1; // small box insertion
					int insertTime=570; // 570 means 09:30
					int insertCar = 0;
					ArrayList request_array = new ArrayList();
					request_array.add("496493919#2");
					request_array.add(7147.59);
					request_array.add(5832.08);
					request_array.add(150.0);
					request_array.add(0);
					
					System.out.println("insert_BoxSize:"+ insert_BoxSize);
					System.out.println("insertTime:"+ insertTime);
					System.out.println("request_array:"+ request_array);
					
					SumoStringList junctions = new SumoStringList();
					junctions = (SumoStringList) conn.do_job_get(Junction.getIDList());
					System.out.println("junctions:"+ junctions);
					LinkedList<String> junction_list = new LinkedList<String>(); 
					
					for (String each_junction :junctions){ 
						junction_list.add(each_junction); 
					}
					
					//System.out.println("junction_list:"+ junction_list);
					
					HashMap  CarsMapSchedule_afterBoxFilter = new HashMap();
					Iterator iter = CarsMap_with_Schedule.entrySet().iterator(); 
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMapSchedule_afterBoxFilter.put(key, value);
					}
					
					HashMap  CarsMap_timeToRequestInfo_afterBoxFilter = new HashMap();
					Iterator iterInfo = CarsMap_time_to_requestInfo.entrySet().iterator(); 
					while (iterInfo.hasNext()) {
						Map.Entry entry = (Map.Entry) iterInfo.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMap_timeToRequestInfo_afterBoxFilter.put(key, value);
					}
					
					// Box filtering stage
					for(int veh=1;veh<cars_Box.size()+1;veh++) {
						String vehID = Integer.toString(veh); 			
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();		
						veh_box =(Map) cars_Box.get(veh);
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size();
						
						//System.out.println("veh:"+ veh + ",insert_capacity:"+ insert_capacity);
						if(insert_capacity==3) {
							CarsMapSchedule_afterBoxFilter.remove(vehID);
							CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
						}
					}
					
					// Time schedule filtering
					for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) {
						System.out.println("---------------------------------");
						System.out.println("veh:"+ vehID);
						int int_vehID = Integer.valueOf((String) vehID);
						//String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
			
						veh_array = (ArrayList)CarsMap_with_Schedule.get((String) vehID);
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) vehID);
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();
						
						veh_box =(Map) cars_Box.get(int_vehID); // eg. veh_Box=v3_Box:{1=[], 2=[], 3=[]}
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size(); // if insert_BoxSize=1, arrayList(v3_small_Box[])
						//System.out.println("insert_capacity:"+ insert_capacity);

						// there is no schedule in this car
						if(veh_array.size()==0) {
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
							double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
									(double)request_array.get(1), (double)request_array.get(2), veh_Position.x, veh_Position.y, false, true));
							System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
							double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
							double diffDuration_curAddrTo_Des = 60*(insertTime-540)-timeSeconds;
							System.out.println("diffDuration_curAddrTo_Des:"+ diffDuration_curAddrTo_Des);
							
							if(travelTime_curr_To_Index<diffDuration_curAddrTo_Des) {
								veh_array.add(insertTime); // v3_timeSchedule [570]
								int insert_BoxIndex = 1+ 10*insert_BoxSize+ 100*int_vehID;
								insertCar = int_vehID;
								String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
								((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
								System.out.println("veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
								
								//setParameter
								conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
								//
								
								cars_Box.put(int_vehID, veh_box);
								System.out.println("inserted successfully");
								System.out.println("Map_requestInfo before putting:"+ Map_requestInfo);
								Map_requestInfo.put(insertTime, request_array ); 
								System.out.println("Map_requestInfo after putting:"+ Map_requestInfo);
								
								CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
								CarsMap_with_Schedule.put((String) vehID, veh_array);
								System.out.println("-----------after inserting------------");
								System.out.println("Map_requestInfo:"+ Map_requestInfo);
								System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
								System.out.println("cars_Box:"+ cars_Box);
							}
						}
						
						else {
							if((veh_array.contains(insertTime))!=true) {

								veh_array.add(insertTime);
								System.out.println("veh_array:"+ veh_array);
								Collections.sort(veh_array);
								System.out.println("veh_array after sorting:"+ veh_array);
								int indexValue = veh_array.indexOf(insertTime);
								Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
								
								if(indexValue==0) {
									SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
									
									double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
											(double)request_array.get(1), (double)request_array.get(2), 
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
											(double)request_array.get(1), (double)request_array.get(2), false, true)));
									
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											//
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}

										
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										
										System.out.println("-----------after inserting------------");
										System.out.println("This request is inserted into "+ "veh"+ vehID);
										System.out.println("boxSize:"+ insert_BoxSize);
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										System.out.println("cars_Box:"+ cars_Box);				
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
					
					System.out.println("-------------route arrangement----------------------------------------------------------");
					// set routes

					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						
						String vehID = Integer.toString(veh); 
						System.out.println("vehID:"+ vehID);
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("sort(veh_array):"+ veh_array);
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
							SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute((String)edges_list.get(edge_index), 
									(String)edges_list.get(edge_index+1), vType, depart,routingMode));
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

						if(stages_list.size()>0){
							routes = ((SumoStage)stages_list.get(0)).edges;
						}
		
						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						System.out.println("curEdge:"+ curEdge);
						System.out.println("Arrival edges_list:"+ edges_list);	
						System.out.println("newRoute_before:"+ newRoute);
	
						if(stages_list.size()>0){
							conn.do_job_set(Vehicle.setRoute(vehID, routes));
						}
						// setStop stage
						/*
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);		
							// SumoStopFlags sf3 = new SumoStopFlags(false, false, false, false, false);
							double until = 60.0*((Integer) veh_array.get(veh_array_index)-530);
							System.out.println("edge:"+ edge);
							System.out.println("pos:"+ pos);
							System.out.println("until"+ until);
							SumoStopFlags sf_50 = new SumoStopFlags(false, false, false, false, false);
							conn.do_job_set(Vehicle.setStop(vehID, edge, pos, (byte)0,  0.0,  
									sf_50, pos, until));
						}
						*/	
					}
					ArrayList veh_array_for_setStop = new ArrayList();
					Map  Map_requestInfo_for_setStop = new HashMap();
					String insertCar_ID = Integer.toString(insertCar);
					veh_array_for_setStop = (ArrayList)CarsMap_with_Schedule.get(insertCar_ID);
					Map_requestInfo_for_setStop =(Map) CarsMap_time_to_requestInfo.get(insertCar_ID);
					
					System.out.println("insertCar_ID:"+insertCar_ID);
					System.out.println("insertTime:"+insertTime);
					System.out.println("veh_array_for_setStop:"+ veh_array_for_setStop);
					System.out.println("Map_requestInfo_for_setStop:"+ Map_requestInfo_for_setStop);
					String edge = (String) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(0); // 570
					double pos =  (double) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(3);
					double until = 60.0*(insertTime-530);
					SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop(insertCar_ID, edge, pos, (byte)0,  0.0,  sf, pos, until));
				}

				if(timeSeconds==100.0 ) {
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
					int insertCar=0;
					int insert_BoxSize=3; // small box insertion
					int insertTime=600; // 600 means 10:00
					ArrayList request_array = new ArrayList();
					request_array.add("287304445#7"); // costco
					request_array.add(6308.47);
					request_array.add(8134.17);
					request_array.add(200.0);
					request_array.add(0); // int isReceiver=1

					System.out.println("insert_BoxSize:"+ insert_BoxSize);
					System.out.println("insertTime:"+ insertTime);
					System.out.println("request_array:"+ request_array);

					SumoStringList junctions = new SumoStringList();
					junctions = (SumoStringList) conn.do_job_get(Junction.getIDList());
					System.out.println("junctions:"+ junctions);
					LinkedList<String> junction_list = new LinkedList<String>(); 

					for (String each_junction :junctions){ 
						junction_list.add(each_junction); 
					}

					//System.out.println("junction_list:"+ junction_list);

					HashMap  CarsMapSchedule_afterBoxFilter = new HashMap();
					Iterator iter = CarsMap_with_Schedule.entrySet().iterator(); 
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMapSchedule_afterBoxFilter.put(key, value);
					}

					HashMap  CarsMap_timeToRequestInfo_afterBoxFilter = new HashMap();
					Iterator iterInfo = CarsMap_time_to_requestInfo.entrySet().iterator(); 
					while (iterInfo.hasNext()) {
						Map.Entry entry = (Map.Entry) iterInfo.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMap_timeToRequestInfo_afterBoxFilter.put(key, value);
					}
					
					// Box filtering stage
					for(int veh=1;veh<cars_Box.size()+1;veh++) {
						String vehID = Integer.toString(veh); 			
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();		
						veh_box =(Map) cars_Box.get(veh);
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size();
						
						//System.out.println("veh:"+ veh + ",insert_capacity:"+ insert_capacity);
						if(insert_capacity==3) {
							CarsMapSchedule_afterBoxFilter.remove(vehID);
							CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
						}
					}
	
					// Time schedule filtering
					for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) {
						System.out.println("---------------------------------");
						System.out.println("veh:"+ vehID);
						int int_vehID = Integer.valueOf((String) vehID);
						//String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]

						veh_array = (ArrayList)CarsMap_with_Schedule.get((String) vehID);
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) vehID);
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();
						
						veh_box =(Map) cars_Box.get(int_vehID); // eg. veh_Box=v3_Box:{1=[], 2=[], 3=[]}
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size(); // if insert_BoxSize=1, arrayList(v3_small_Box[])
						//System.out.println("insert_capacity:"+ insert_capacity);

						// there is no schedule in this car
						if(veh_array.size()==0) {
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
							double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
									(double)request_array.get(1), (double)request_array.get(2), veh_Position.x, veh_Position.y, false, true));
							System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
							double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
							double diffDuration_curAddrTo_Des = 60*(insertTime-540)-timeSeconds;
							System.out.println("diffDuration_curAddrTo_Des:"+ diffDuration_curAddrTo_Des);
							
							if(travelTime_curr_To_Index<diffDuration_curAddrTo_Des) {
								veh_array.add(insertTime); // v3_timeSchedule [570]
								int insert_BoxIndex = 1+ 10*insert_BoxSize+ 100*int_vehID;
								insertCar = int_vehID;
								String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
								((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
								System.out.println("veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
								
								//setParameter
								conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
								//
								
								cars_Box.put(int_vehID, veh_box);
								System.out.println("inserted successfully");
								System.out.println("Map_requestInfo before putting:"+ Map_requestInfo);
								Map_requestInfo.put(insertTime, request_array ); 
								System.out.println("Map_requestInfo after putting:"+ Map_requestInfo);
								
								CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
								CarsMap_with_Schedule.put((String) vehID, veh_array);
								System.out.println("-----------after inserting------------");
								System.out.println("Map_requestInfo:"+ Map_requestInfo);
								System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
								System.out.println("cars_Box:"+ cars_Box);
							}
						}
						
						else {
							if((veh_array.contains(insertTime))!=true) {

								veh_array.add(insertTime);
								System.out.println("veh_array:"+ veh_array);
								Collections.sort(veh_array);
								System.out.println("veh_array after sorting:"+ veh_array);
								int indexValue = veh_array.indexOf(insertTime);
								Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
								
								if(indexValue==0) {
									SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
									
									double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
											(double)request_array.get(1), (double)request_array.get(2), 
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
											(double)request_array.get(1), (double)request_array.get(2), false, true)));
									
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											//
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}

										
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										
										System.out.println("-----------after inserting------------");
										System.out.println("This request is inserted into "+ "veh"+ vehID);
										System.out.println("boxSize:"+ insert_BoxSize);
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										System.out.println("cars_Box:"+ cars_Box);				
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
	
					System.out.println("-------------route arrangement----------------------------------------------------------");
					// set routes

					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						
						String vehID = Integer.toString(veh); 
						System.out.println("vehID:"+ vehID);
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("sort(veh_array):"+ veh_array);
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
							SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute((String)edges_list.get(edge_index), 
									(String)edges_list.get(edge_index+1), vType, depart,routingMode));
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

						if(stages_list.size()>0){
							routes = ((SumoStage)stages_list.get(0)).edges;
						}

						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						System.out.println("curEdge:"+ curEdge);
						System.out.println("Arrival edges_list:"+ edges_list);	
						System.out.println("newRoute_before:"+ newRoute);

						if(stages_list.size()>0){
							conn.do_job_set(Vehicle.setRoute(vehID, routes));
						}
						// setStop stage
						/*
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);		
							// SumoStopFlags sf3 = new SumoStopFlags(false, false, false, false, false);
							double until = 60.0*((Integer) veh_array.get(veh_array_index)-530);
							System.out.println("edge:"+ edge);
							System.out.println("pos:"+ pos);
							System.out.println("until"+ until);
							SumoStopFlags sf_50 = new SumoStopFlags(false, false, false, false, false);
							conn.do_job_set(Vehicle.setStop(vehID, edge, pos, (byte)0,  0.0,  
									sf_50, pos, until));
						}
						*/	
					}
					ArrayList veh_array_for_setStop = new ArrayList();
					Map  Map_requestInfo_for_setStop = new HashMap();
					String insertCar_ID = Integer.toString(insertCar);
					veh_array_for_setStop = (ArrayList)CarsMap_with_Schedule.get(insertCar_ID);
					Map_requestInfo_for_setStop =(Map) CarsMap_time_to_requestInfo.get(insertCar_ID);
					
					System.out.println("insertCar_ID:"+insertCar_ID);
					System.out.println("insertTime:"+insertTime);
					System.out.println("veh_array_for_setStop:"+ veh_array_for_setStop);
					System.out.println("Map_requestInfo_for_setStop:"+ Map_requestInfo_for_setStop);
					String edge = (String) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(0); // 570
					double pos =  (double) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(3);
					double until = 60.0*(insertTime-530);
					SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop(insertCar_ID, edge, pos, (byte)0,  0.0,  sf, pos, until));
				}
				
				if(timeSeconds==150.0 ) {
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
					int insertCar = 0;			
					int insert_BoxSize=1; // small box insertion
					int insertTime=720; // 720 means 10:00
					ArrayList request_array = new ArrayList();
					request_array.add("-111343192#8"); // 
					request_array.add(8975.38);
					request_array.add(6261.05);
					request_array.add(68.0);
					request_array.add(0); // int isReceiver=1

					System.out.println("insert_BoxSize:"+ insert_BoxSize);
					System.out.println("insertTime:"+ insertTime);
					System.out.println("request_array:"+ request_array);


					HashMap  CarsMapSchedule_afterBoxFilter = new HashMap();
					Iterator iter = CarsMap_with_Schedule.entrySet().iterator(); 
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMapSchedule_afterBoxFilter.put(key, value);
					}

					HashMap  CarsMap_timeToRequestInfo_afterBoxFilter = new HashMap();
					Iterator iterInfo = CarsMap_time_to_requestInfo.entrySet().iterator(); 
					while (iterInfo.hasNext()) {
						Map.Entry entry = (Map.Entry) iterInfo.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMap_timeToRequestInfo_afterBoxFilter.put(key, value);
					}
					
					// Box filtering stage
					for(int veh=1;veh<cars_Box.size()+1;veh++) {
						String vehID = Integer.toString(veh); 			
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();		
						veh_box =(Map) cars_Box.get(veh);
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size();
						
						//System.out.println("veh:"+ veh + ",insert_capacity:"+ insert_capacity);
						if(insert_capacity==3) {
							CarsMapSchedule_afterBoxFilter.remove(vehID);
							CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
						}
					}
	
					// Time schedule filtering
					for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) {
						System.out.println("---------------------------------");
						System.out.println("veh:"+ vehID);
						int int_vehID = Integer.valueOf((String) vehID);
						//String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]

						veh_array = (ArrayList)CarsMap_with_Schedule.get((String) vehID);
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) vehID);
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();
						
						veh_box =(Map) cars_Box.get(int_vehID); // eg. veh_Box=v3_Box:{1=[], 2=[], 3=[]}
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size(); // if insert_BoxSize=1, arrayList(v3_small_Box[])
						//System.out.println("insert_capacity:"+ insert_capacity);

						// there is no schedule in this car
						if(veh_array.size()==0) {
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
							double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
									(double)request_array.get(1), (double)request_array.get(2), veh_Position.x, veh_Position.y, false, true));
							System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
							double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
							double diffDuration_curAddrTo_Des = 60*(insertTime-540)-timeSeconds;
							System.out.println("diffDuration_curAddrTo_Des:"+ diffDuration_curAddrTo_Des);
							
							if(travelTime_curr_To_Index<diffDuration_curAddrTo_Des) {
								veh_array.add(insertTime); // v3_timeSchedule [570]
								int insert_BoxIndex = 1+ 10*insert_BoxSize+ 100*int_vehID;
								insertCar = int_vehID;
								String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
								((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
								System.out.println("veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
								
								//setParameter
								conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
								//
								
								cars_Box.put(int_vehID, veh_box);
								System.out.println("inserted successfully");
								System.out.println("Map_requestInfo before putting:"+ Map_requestInfo);
								Map_requestInfo.put(insertTime, request_array ); 
								System.out.println("Map_requestInfo after putting:"+ Map_requestInfo);
								
								CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
								CarsMap_with_Schedule.put((String) vehID, veh_array);
								System.out.println("-----------after inserting------------");
								System.out.println("Map_requestInfo:"+ Map_requestInfo);
								System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
								System.out.println("cars_Box:"+ cars_Box);
							}
						}
						
						else {
							if((veh_array.contains(insertTime))!=true) {

								veh_array.add(insertTime);
								System.out.println("veh_array:"+ veh_array);
								Collections.sort(veh_array);
								System.out.println("veh_array after sorting:"+ veh_array);
								int indexValue = veh_array.indexOf(insertTime);
								Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
								
								if(indexValue==0) {
									SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
									
									double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
											(double)request_array.get(1), (double)request_array.get(2), 
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
											(double)request_array.get(1), (double)request_array.get(2), false, true)));
									
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											//
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}

										
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										
										System.out.println("-----------after inserting------------");
										System.out.println("This request is inserted into "+ "veh"+ vehID);
										System.out.println("boxSize:"+ insert_BoxSize);
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										System.out.println("cars_Box:"+ cars_Box);				
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
	
					System.out.println("-------------route arrangement-------------------");
					// set routes

					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						
						String vehID = Integer.toString(veh); 
						System.out.println("vehID:"+ vehID);
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("sort(veh_array):"+ veh_array);
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
							SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute((String)edges_list.get(edge_index), 
									(String)edges_list.get(edge_index+1), vType, depart,routingMode));
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

						if(stages_list.size()>0){
							routes = ((SumoStage)stages_list.get(0)).edges;
						}

						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						System.out.println("curEdge:"+ curEdge);
						System.out.println("Arrival edges_list:"+ edges_list);	
						System.out.println("newRoute_before:"+ newRoute);

						if(stages_list.size()>0){
							conn.do_job_set(Vehicle.setRoute(vehID, routes));
						}

					}
					ArrayList veh_array_for_setStop = new ArrayList();
					Map  Map_requestInfo_for_setStop = new HashMap();
					String insertCar_ID = Integer.toString(insertCar);
					veh_array_for_setStop = (ArrayList)CarsMap_with_Schedule.get(insertCar_ID);
					Map_requestInfo_for_setStop =(Map) CarsMap_time_to_requestInfo.get(insertCar_ID);
					
					System.out.println("insertCar_ID:"+insertCar_ID);
					System.out.println("insertTime:"+insertTime);
					System.out.println("veh_array_for_setStop:"+ veh_array_for_setStop);
					System.out.println("Map_requestInfo_for_setStop:"+ Map_requestInfo_for_setStop);
					String edge = (String) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(0); // 570
					double pos =  (double) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(3);
					double until = 60.0*(insertTime-530);
					SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop(insertCar_ID, edge, pos, (byte)0,  0.0,  sf, pos, until));
				}

				if(timeSeconds==250.0 ) {
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
					int insertCar =0;			
					int insert_BoxSize=2; // medium box insertion
					int insertTime=690; // 690 means 11:30
					ArrayList request_array = new ArrayList();
					request_array.add("72871329#0"); // 
					request_array.add(8160.64);
					request_array.add(6391.12);
					request_array.add(4.1);
					request_array.add(0); // int isReceiver=0

					System.out.println("insert_BoxSize:"+ insert_BoxSize);
					System.out.println("insertTime:"+ insertTime);
					System.out.println("request_array:"+ request_array);
					
					HashMap  CarsMapSchedule_afterBoxFilter = new HashMap();
					Iterator iter = CarsMap_with_Schedule.entrySet().iterator(); 
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMapSchedule_afterBoxFilter.put(key, value);
					}

					HashMap  CarsMap_timeToRequestInfo_afterBoxFilter = new HashMap();
					Iterator iterInfo = CarsMap_time_to_requestInfo.entrySet().iterator(); 
					while (iterInfo.hasNext()) {
						Map.Entry entry = (Map.Entry) iterInfo.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMap_timeToRequestInfo_afterBoxFilter.put(key, value);
					}
					
					// Box filtering stage
					for(int veh=1;veh<cars_Box.size()+1;veh++) {
						String vehID = Integer.toString(veh); 			
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();		
						veh_box =(Map) cars_Box.get(veh);
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size();
						
						//System.out.println("veh:"+ veh + ",insert_capacity:"+ insert_capacity);
						if(insert_capacity==3) {
							CarsMapSchedule_afterBoxFilter.remove(vehID);
							CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
						}
					}
	
					// Time schedule filtering
					for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) {
						System.out.println("---------------------------------");
						System.out.println("veh:"+ vehID);
						int int_vehID = Integer.valueOf((String) vehID);
						//String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]

						veh_array = (ArrayList)CarsMap_with_Schedule.get((String) vehID);
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) vehID);
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();
						
						veh_box =(Map) cars_Box.get(int_vehID); // eg. veh_Box=v3_Box:{1=[], 2=[], 3=[]}
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size(); // if insert_BoxSize=1, arrayList(v3_small_Box[])
						//System.out.println("insert_capacity:"+ insert_capacity);

						// there is no schedule in this car
						if(veh_array.size()==0) {
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
							double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
									(double)request_array.get(1), (double)request_array.get(2), veh_Position.x, veh_Position.y, false, true));
							System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
							double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
							double diffDuration_curAddrTo_Des = 60*(insertTime-540)-timeSeconds;
							System.out.println("diffDuration_curAddrTo_Des:"+ diffDuration_curAddrTo_Des);
							
							if(travelTime_curr_To_Index<diffDuration_curAddrTo_Des) {
								veh_array.add(insertTime); // v3_timeSchedule [570]
								int insert_BoxIndex = 1+ 10*insert_BoxSize+ 100*int_vehID;
								insertCar = int_vehID;
								String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
								((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
								System.out.println("veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
								
								//setParameter
								conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
								//
								
								cars_Box.put(int_vehID, veh_box);
								System.out.println("inserted successfully");
								System.out.println("Map_requestInfo before putting:"+ Map_requestInfo);
								Map_requestInfo.put(insertTime, request_array ); 
								System.out.println("Map_requestInfo after putting:"+ Map_requestInfo);
								
								CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
								CarsMap_with_Schedule.put((String) vehID, veh_array);
								System.out.println("-----------after inserting------------");
								System.out.println("Map_requestInfo:"+ Map_requestInfo);
								System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
								System.out.println("cars_Box:"+ cars_Box);
							}
						}
						
						else {
							if((veh_array.contains(insertTime))!=true) {

								veh_array.add(insertTime);
								System.out.println("veh_array:"+ veh_array);
								Collections.sort(veh_array);
								System.out.println("veh_array after sorting:"+ veh_array);
								int indexValue = veh_array.indexOf(insertTime);
								Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
								
								if(indexValue==0) {
									SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
									
									double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
											(double)request_array.get(1), (double)request_array.get(2), 
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
											(double)request_array.get(1), (double)request_array.get(2), false, true)));
									
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											//
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}

										
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										
										System.out.println("-----------after inserting------------");
										System.out.println("This request is inserted into "+ "veh"+ vehID);
										System.out.println("boxSize:"+ insert_BoxSize);
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										System.out.println("cars_Box:"+ cars_Box);				
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
	
					System.out.println("-------------route arrangement-------------------");
					// set routes

					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						
						String vehID = Integer.toString(veh); 
						System.out.println("vehID:"+ vehID);
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("sort(veh_array):"+ veh_array);
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
							SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute((String)edges_list.get(edge_index), 
									(String)edges_list.get(edge_index+1), vType, depart,routingMode));
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

						if(stages_list.size()>0){
							routes = ((SumoStage)stages_list.get(0)).edges;
						}

						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						System.out.println("curEdge:"+ curEdge);
						System.out.println("Arrival edges_list:"+ edges_list);	
						System.out.println("newRoute_before:"+ newRoute);

						if(stages_list.size()>0){
							conn.do_job_set(Vehicle.setRoute(vehID, routes));
						}

					}
					ArrayList veh_array_for_setStop = new ArrayList();
					Map  Map_requestInfo_for_setStop = new HashMap();
					String insertCar_ID = Integer.toString(insertCar);
					veh_array_for_setStop = (ArrayList)CarsMap_with_Schedule.get(insertCar_ID);
					Map_requestInfo_for_setStop =(Map) CarsMap_time_to_requestInfo.get(insertCar_ID);
					
					System.out.println("insertCar_ID:"+insertCar_ID);
					System.out.println("insertTime:"+insertTime);
					System.out.println("veh_array_for_setStop:"+ veh_array_for_setStop);
					System.out.println("Map_requestInfo_for_setStop:"+ Map_requestInfo_for_setStop);
					String edge = (String) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(0); // 570
					double pos =  (double) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(3);
					double until = 60.0*(insertTime-530);
					SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop(insertCar_ID, edge, pos, (byte)0,  0.0,  sf, pos, until));
				}

				if(timeSeconds==300.0 ) {
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
					int insertCar =0;			
					int insert_BoxSize=2; // medium box insertion
					int insertTime=660; // 690 means 11:30
					ArrayList request_array = new ArrayList();
					request_array.add("228022808#0"); // gateway
					request_array.add(8038.25);
					request_array.add(6425.07);
					request_array.add(25.0);
					request_array.add(0); // int isReceiver=0

					System.out.println("insert_BoxSize:"+ insert_BoxSize);
					System.out.println("insertTime:"+ insertTime);
					System.out.println("request_array:"+ request_array);
					
					HashMap  CarsMapSchedule_afterBoxFilter = new HashMap();
					Iterator iter = CarsMap_with_Schedule.entrySet().iterator(); 
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMapSchedule_afterBoxFilter.put(key, value);
					}

					HashMap  CarsMap_timeToRequestInfo_afterBoxFilter = new HashMap();
					Iterator iterInfo = CarsMap_time_to_requestInfo.entrySet().iterator(); 
					while (iterInfo.hasNext()) {
						Map.Entry entry = (Map.Entry) iterInfo.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMap_timeToRequestInfo_afterBoxFilter.put(key, value);
					}
					
					// Box filtering stage
					for(int veh=1;veh<cars_Box.size()+1;veh++) {
						String vehID = Integer.toString(veh); 			
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();		
						veh_box =(Map) cars_Box.get(veh);
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size();
						
						//System.out.println("veh:"+ veh + ",insert_capacity:"+ insert_capacity);
						if(insert_capacity==3) {
							CarsMapSchedule_afterBoxFilter.remove(vehID);
							CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
						}
					}
	
					// Time schedule filtering
					for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) {
						System.out.println("---------------------------------");
						System.out.println("veh:"+ vehID);
						int int_vehID = Integer.valueOf((String) vehID);
						//String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]

						veh_array = (ArrayList)CarsMap_with_Schedule.get((String) vehID);
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) vehID);
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();
						
						veh_box =(Map) cars_Box.get(int_vehID); // eg. veh_Box=v3_Box:{1=[], 2=[], 3=[]}
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size(); // if insert_BoxSize=1, arrayList(v3_small_Box[])
						//System.out.println("insert_capacity:"+ insert_capacity);

						// there is no schedule in this car
						if(veh_array.size()==0) {
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
							double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
									(double)request_array.get(1), (double)request_array.get(2), veh_Position.x, veh_Position.y, false, true));
							System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
							double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
							double diffDuration_curAddrTo_Des = 60*(insertTime-540)-timeSeconds;
							System.out.println("diffDuration_curAddrTo_Des:"+ diffDuration_curAddrTo_Des);
							
							if(travelTime_curr_To_Index<diffDuration_curAddrTo_Des) {
								veh_array.add(insertTime); // v3_timeSchedule [570]
								int insert_BoxIndex = 1+ 10*insert_BoxSize+ 100*int_vehID;
								insertCar = int_vehID;
								String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
								((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
								System.out.println("veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
								
								//setParameter
								conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
								//
								
								cars_Box.put(int_vehID, veh_box);
								System.out.println("inserted successfully");
								System.out.println("Map_requestInfo before putting:"+ Map_requestInfo);
								Map_requestInfo.put(insertTime, request_array ); 
								System.out.println("Map_requestInfo after putting:"+ Map_requestInfo);
								
								CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
								CarsMap_with_Schedule.put((String) vehID, veh_array);
								System.out.println("-----------after inserting------------");
								System.out.println("Map_requestInfo:"+ Map_requestInfo);
								System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
								System.out.println("cars_Box:"+ cars_Box);
							}
						}
						
						else {
							if((veh_array.contains(insertTime))!=true) {

								veh_array.add(insertTime);
								System.out.println("veh_array:"+ veh_array);
								Collections.sort(veh_array);
								System.out.println("veh_array after sorting:"+ veh_array);
								int indexValue = veh_array.indexOf(insertTime);
								Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
								
								if(indexValue==0) {
									SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
									
									double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
											(double)request_array.get(1), (double)request_array.get(2), 
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
											(double)request_array.get(1), (double)request_array.get(2), false, true)));
									
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											//
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}

										
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										
										System.out.println("-----------after inserting------------");
										System.out.println("This request is inserted into "+ "veh"+ vehID);
										System.out.println("boxSize:"+ insert_BoxSize);
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											insertCar = int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										System.out.println("cars_Box:"+ cars_Box);				
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
	
					System.out.println("-------------route arrangement-------------------");
					// set routes

					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						
						String vehID = Integer.toString(veh); 
						System.out.println("vehID:"+ vehID);
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("sort(veh_array):"+ veh_array);
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
							SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute((String)edges_list.get(edge_index), 
									(String)edges_list.get(edge_index+1), vType, depart,routingMode));
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

						if(stages_list.size()>0){
							routes = ((SumoStage)stages_list.get(0)).edges;
						}

						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						System.out.println("curEdge:"+ curEdge);
						System.out.println("Arrival edges_list:"+ edges_list);	
						System.out.println("newRoute_before:"+ newRoute);

						if(stages_list.size()>0){
							conn.do_job_set(Vehicle.setRoute(vehID, routes));
						}

					}
					ArrayList veh_array_for_setStop = new ArrayList();
					Map  Map_requestInfo_for_setStop = new HashMap();
					String insertCar_ID = Integer.toString(insertCar);
					veh_array_for_setStop = (ArrayList)CarsMap_with_Schedule.get(insertCar_ID);
					Map_requestInfo_for_setStop =(Map) CarsMap_time_to_requestInfo.get(insertCar_ID);
					
					System.out.println("insertCar_ID:"+insertCar_ID);
					System.out.println("insertTime:"+insertTime);
					System.out.println("veh_array_for_setStop:"+ veh_array_for_setStop);
					System.out.println("Map_requestInfo_for_setStop:"+ Map_requestInfo_for_setStop);
					String edge = (String) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(0); // 570
					double pos =  (double) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(3);
					double until = 60.0*(insertTime-530);
					SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop(insertCar_ID, edge, pos, (byte)0,  0.0,  sf, pos, until));
				}

				if(timeSeconds==1920.0 ) {
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);			
					int insert_BoxSize=2; // medium box insertion
					int insertTime=750; // 750 means 12:30
					ArrayList request_array = new ArrayList();
					request_array.add("-316267745#0"); // 東門圓環
					request_array.add(8794.97);
					request_array.add(5228.52);
					request_array.add(19.0);
					request_array.add(0); // int isReceiver=1

					System.out.println("insert_BoxSize:"+ insert_BoxSize);
					System.out.println("insertTime:"+ insertTime);
					System.out.println("request_array:"+ request_array);
					
					HashMap  CarsMapSchedule_afterBoxFilter = new HashMap();
					Iterator iter = CarsMap_with_Schedule.entrySet().iterator(); 
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMapSchedule_afterBoxFilter.put(key, value);
					}
					
					HashMap  CarsMap_timeToRequestInfo_afterBoxFilter = new HashMap();
					Iterator iterInfo = CarsMap_time_to_requestInfo.entrySet().iterator(); 
					while (iterInfo.hasNext()) {
						Map.Entry entry = (Map.Entry) iterInfo.next(); 
						 Object key = entry.getKey(); 
						 Object value = entry.getValue(); 
						 CarsMap_timeToRequestInfo_afterBoxFilter.put(key, value);
					}
					
					// Box filtering stage
					for(int veh=1;veh<cars_Box.size()+1;veh++) {
						String vehID = Integer.toString(veh); 			
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();		
						veh_box =(Map) cars_Box.get(veh);
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size();
						
						//System.out.println("veh:"+ veh + ",insert_capacity:"+ insert_capacity);
						if(insert_capacity==3) {
							CarsMapSchedule_afterBoxFilter.remove(vehID);
							CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
						}
					}
					
					// Time schedule filtering
					for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) {
						System.out.println("---------------------------------");
						System.out.println("veh:"+ vehID);
						int int_vehID = Integer.valueOf((String) vehID);
						//String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
			
						veh_array = (ArrayList)CarsMap_with_Schedule.get((String) vehID);
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) vehID);
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();
						
						veh_box =(Map) cars_Box.get(int_vehID); // eg. veh_Box=v3_Box:{1=[], 2=[], 3=[]}
						int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size(); // if insert_BoxSize=1, arrayList(v3_small_Box[])
						//System.out.println("insert_capacity:"+ insert_capacity);

						// there is no schedule in this car
						if(veh_array.size()==0) {
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
							double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
									(double)request_array.get(1), (double)request_array.get(2), veh_Position.x, veh_Position.y, false, true));
							System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
							double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
							double diffDuration_curAddrTo_Des = 60*(insertTime-540)-timeSeconds;
							System.out.println("diffDuration_curAddrTo_Des:"+ diffDuration_curAddrTo_Des);
							
							if(travelTime_curr_To_Index<diffDuration_curAddrTo_Des) {
								veh_array.add(insertTime); // v3_timeSchedule [570]
								int insert_BoxIndex = 1+ 10*insert_BoxSize+ 100*int_vehID;
								String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
								((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
								System.out.println("veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
								
								//setParameter
								conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
								//
								
								cars_Box.put(int_vehID, veh_box);
								System.out.println("inserted successfully");
								System.out.println("Map_requestInfo before putting:"+ Map_requestInfo);
								Map_requestInfo.put(insertTime, request_array ); 
								System.out.println("Map_requestInfo after putting:"+ Map_requestInfo);
								
								CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
								CarsMap_with_Schedule.put((String) vehID, veh_array);
								System.out.println("-----------after inserting------------");
								System.out.println("Map_requestInfo:"+ Map_requestInfo);
								System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
								System.out.println("cars_Box:"+ cars_Box);
							}
						}
						
						else {
							if((veh_array.contains(insertTime))!=true) {

								veh_array.add(insertTime);
								System.out.println("veh_array:"+ veh_array);
								Collections.sort(veh_array);
								System.out.println("veh_array after sorting:"+ veh_array);
								int indexValue = veh_array.indexOf(insertTime);
								Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
								
								if(indexValue==0) {
									SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
									
									double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
											(double)request_array.get(1), (double)request_array.get(2), 
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
											(double)request_array.get(1), (double)request_array.get(2), false, true)));
									
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
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											//
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}

										
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										
										System.out.println("-----------after inserting------------");
										System.out.println("This request is inserted into "+ "veh"+ vehID);
										System.out.println("boxSize:"+ insert_BoxSize);
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										break;
									}
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("this request can not be inserted into the schedule, please pick other time!");
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
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										else if(insert_capacity==1){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										
										else if(insert_capacity==2){
											int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
											String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

											System.out.println("insert_BoxIndex:"+insert_BoxIndex);
											((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
											System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
											// setParameter
											conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
											cars_Box.put(int_vehID, veh_box);
											System.out.println("cars_Box:"+ cars_Box);
										}
										CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										System.out.println("cars_Box:"+ cars_Box);				
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
					
					System.out.println("-------------route arrangement----------------------------------------------------------");
					// set routes

					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						
						String vehID = Integer.toString(veh); 
						System.out.println("vehID:"+ vehID);
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("sort(veh_array):"+ veh_array);
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
							SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute((String)edges_list.get(edge_index), 
									(String)edges_list.get(edge_index+1), vType, depart,routingMode));
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

						if(stages_list.size()>0){
							routes = ((SumoStage)stages_list.get(0)).edges;
						}
		
						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						System.out.println("curEdge:"+ curEdge);
						System.out.println("Arrival edges_list:"+ edges_list);	
						System.out.println("newRoute_before:"+ newRoute);
	
						if(stages_list.size()>0){
							conn.do_job_set(Vehicle.setRoute(vehID, routes));
						}
						// setStop stage
						
						System.out.println("veh_array:"+ veh_array);
						
						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) { //[570,660]
							System.out.println("veh_array_index:"+ veh_array_index);
							
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);		
							double until = 60.0*((Integer) veh_array.get(veh_array_index)-530);
							System.out.println("edge:"+ edge);
							System.out.println("pos:"+ pos);
							System.out.println("until:"+ until);
							SumoStopFlags sf_250 = new SumoStopFlags(false, false, false, false, false);
							conn.do_job_set(Vehicle.setStop(vehID, edge, pos, (byte)0,  0.0, 
									sf_250, pos, until));
						}
					}
				}
			

				/*
				// Got the receiver-request
				if(timeSeconds==1920.0) { //09:32, got the receiver-request 
					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
					System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
					System.out.println("cars_Box:"+ cars_Box);
					
					double currentMin = (540+ timeSeconds/60.0);
					
					
					int insertTime=600; // 600 means 09:30
					ArrayList request_array = new ArrayList();
					
					request_array.add("287304445#7"); // costco
					request_array.add(6308.47);
					request_array.add(8134.17);
					request_array.add(200.0);
					request_array.add(1); // int isReceiver=1
					request_array.add(211); // int boxIndex created by sender4
					request_array.add("kk22yy"); // String userDeviceKeyId
					
					int boxIndex = (int) request_array.get(5);
					int specific_veh = boxIndex /100;
					String specific_vehID = Integer.toString(specific_veh);
					
					System.out.print("request_array from receiver4:"+ request_array);
					
					HashMap  CarsMapSchedule_fromReceiverRequest = new HashMap();
					
					Iterator iter = CarsMap_with_Schedule.entrySet().iterator(); 
					while (iter.hasNext()) {
						Map.Entry entry = (Map.Entry) iter.next(); 
						//System.out.println("entry:"+ entry);
						String key = (String) entry.getKey(); 
						Object value = entry.getValue();
						
						if(key.equals(specific_vehID)) {
							CarsMapSchedule_fromReceiverRequest.put(key, value);
						}	
					}
					
					for(Object vehID:CarsMapSchedule_fromReceiverRequest.keySet()) {
						System.out.println("---------------------------------");
						//System.out.println("veh:"+ vehID);
						int int_vehID = Integer.valueOf((String) vehID);
						//String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
						veh_array = (ArrayList)CarsMap_with_Schedule.get((String) vehID);
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) vehID);
						
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();
						
						veh_box =(Map) cars_Box.get(int_vehID); // eg. veh_Box=v3_Box:{1=[], 2=[], 3=[]}
						
					
						// there is no schedule in this car
						if(veh_array.size()==0) {
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
							double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
									(double)request_array.get(1), (double)request_array.get(2), veh_Position.x, veh_Position.y, false, true));
							System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
							double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
							System.out.println("travelTime_curr_To_Index:"+ travelTime_curr_To_Index);
							double diffDuration_curAddrTo_Des = 60*(insertTime-540)-timeSeconds;
							System.out.println("diffDuration_curAddrTo_Des:"+ diffDuration_curAddrTo_Des);
							
							if(travelTime_curr_To_Index<diffDuration_curAddrTo_Des) {
								veh_array.add(insertTime); // v3_timeSchedule [570]
								cars_Box.put(int_vehID, veh_box);							
								Map_requestInfo.put(insertTime, request_array ); 
								CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
								CarsMap_with_Schedule.put((String) vehID, veh_array);
								System.out.println("-----------after inserting------------");
								System.out.println("Map_requestInfo:"+ Map_requestInfo);
								System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
								System.out.println("cars_Box:"+ cars_Box);
							}
							
							
						}
						
						else {
							if((veh_array.contains(insertTime))!=true) {

								veh_array.add(insertTime);
								//System.out.println("veh_array:"+ veh_array);
								Collections.sort(veh_array);
								//System.out.println("veh_array after sorting:"+ veh_array);
								int indexValue = veh_array.indexOf(insertTime);
								Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
								
								if(indexValue==0) {
									SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
									
									double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
											(double)request_array.get(1), (double)request_array.get(2), 
											veh_Position.x, veh_Position.y, false, true));
									
									System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
									double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
									//System.out.println("Map_requestInfo:"+ Map_requestInfo);
									
									int key_afterIndex = (int) veh_array.get(indexValue+1);
									double request_x_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(1);
									double request_y_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(2);
									double distance_afterIndexToIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
											request_x_afterIndex, request_y_afterIndex,
											(double)request_array.get(1), (double)request_array.get(2), false, true)));
									
									double travelTime_afterIndexToIndex = distance_afterIndexToIndex/vehicle_speed;			
									double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60;
								

									if((travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) &&
											(timeSeconds+travelTime_curr_To_Index) <(key_afterIndex-insertTime)*60) {
					
										CarsMap_with_Schedule.put((String) vehID, veh_array);
										Map_requestInfo.put(insertTime, request_array ); 
										CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
										System.out.println("cars_Box:"+ cars_Box);
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
									
									if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex) {
										
										CarsMap_with_Schedule.put((String) vehID, veh_array);
										Map_requestInfo.put(insertTime, request_array ); 
										CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
										System.out.println("cars_Box:"+ cars_Box);
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
									
									if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex && 
											travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) {											
										
										CarsMap_with_Schedule.put((String) vehID, veh_array);
										Map_requestInfo.put(insertTime, request_array ); 
										CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
										System.out.println("-----------after inserting------------");
										System.out.println("Map_requestInfo:"+ Map_requestInfo);
										System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
										System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
										System.out.println("cars_Box:"+ cars_Box);																			
										break;
									}
									
									else {
										Map_requestInfo.remove(insertTime);
										System.out.print("No avaliable car in this request!");
										break;
										
									}
								}
							}
						}
					}

					System.out.println("-------------route arrangement----------------------------------------------------------");
					// set routes

					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) {
						System.out.println("---------------------------------");
						
						String vehID = Integer.toString(veh); 
						System.out.println("vehID:"+ vehID);
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						veh_array.add((int)currentMin);
						Collections.sort(veh_array);
						System.out.println("sort(veh_array):"+ veh_array);
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
							SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute((String)edges_list.get(edge_index), 
									(String)edges_list.get(edge_index+1), vType, depart,routingMode));
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

						if(stages_list.size()>0){
							routes = ((SumoStage)stages_list.get(0)).edges;
						}
		
						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String edge :routes){ 
							newRoute.add(edge); 
						}
						
						System.out.println("veh_array:"+veh_array);
						System.out.println("Map_requestInfo:"+ Map_requestInfo);
						System.out.println("curEdge:"+ curEdge);
						System.out.println("Arrival edges_list:"+ edges_list);	
						System.out.println("newRoute_before:"+ newRoute);
	
						if(stages_list.size()>0){
							conn.do_job_set(Vehicle.setRoute(vehID, routes));
						}

						for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
							String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
							double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);		
							//System.out.println("edge:"+ edge);
							//System.out.println("pos:"+ pos);
							SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
							double until = 60.0*((Integer) veh_array.get(veh_array_index)-530);
							conn.do_job_set(Vehicle.setStop(vehID, edge, pos+10, (byte)0,  0.0, sf, pos, until));
						}
					}
				}
				*/

				// notification stage
				// CarsMap_with_Schedule:{1=[570, 660], 2=[660]}
				// CarsMap_time_to_requestInfo:{1={660=[273445903#7, 2966.38, 6993.0, 60.0], 570=[496257308#5, 3937.13, 5039.67, 50.0]}, 
				// 2={660=[297579234, 8973.76, 3772.53, 200.0]}, 3={}}
			
				
			

				
				
				// when the vehicle arrive to the destination (sender address & receiver address)
				
				
				

				

			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

