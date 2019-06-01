
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

public class MainCopy3 {

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

			//
			v1_small_Box.add(113);
			//
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
			//
			v2_small_Box.add(211);
			v2_small_Box.add(212);
			v2_small_Box.add(213);
			//
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
				
			
				
				if(timeSeconds==50.0 ) {

					System.out.println("-------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					double currentMin = (540+ timeSeconds/60.0);
					
					int insert_BoxSize=1; // small box insertion
					int insertTime=570;
					ArrayList request_array = new ArrayList();
					
					request_array.add("496493919#2");
					request_array.add(7147.59);
					request_array.add(5832.08);
					request_array.add(150.0);
					
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
						
						System.out.println("veh:"+ veh + ",insert_capacity:"+ insert_capacity);
						if(insert_capacity==3) {
							CarsMapSchedule_afterBoxFilter.remove(vehID);
							CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
						}
					}
					
					for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) {
						
						System.out.println("---------------------------------");
						System.out.println("veh:"+ vehID);
						int int_vehID = Integer.valueOf((String) vehID);
						//String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
						
						veh_array = (ArrayList)CarsMap_with_Schedule.get((String) vehID);
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
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) vehID);
						////////////////////////////////////////////////////////////////////
						Map  veh_box = new HashMap();
						ArrayList insert_Size_Box = new ArrayList();
						veh_box =(Map) cars_Box.get((String) vehID); // eg. veh_Box=v3_Box:{1=[], 2=[], 3=[]}
						//int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size(); // if insert_BoxSize=1, arrayList(v3_small_Box[])
						System.out.println("veh_box:"+veh_box);
						
						if(veh_array.size()==0) {
							
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
							
							double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
									(double)request_array.get(1), (double)request_array.get(2), 
									veh_Position.x, veh_Position.y, false, true));
							System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
							double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
							
							
							double diffDuration_curAddrTo_Des = 60*(insertTime-540)-timeSeconds;
							System.out.println("diffDuration_curAddrTo_Des:"+ diffDuration_curAddrTo_Des);
							
							if(travelTime_curr_To_Index<diffDuration_curAddrTo_Des) {
								int insert_BoxIndex = 1+ 10*insert_BoxSize+100*int_vehID;
								System.out.println("insert_BoxIndex:"+insert_BoxIndex);
								System.out.println("veh_box:"+veh_box);
								System.out.println("veh_box.get(insert_BoxSize):"+ veh_box.get(insert_BoxSize));
								
								((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
								System.out.println("(ArrayList) veh_box.get(insert_BoxSize):"+ (ArrayList) veh_box.get(insert_BoxSize));
								// setParameter
								cars_Box.put(int_vehID, veh_box);
								System.out.println("cars_Box:"+ cars_Box);
							}
						}
					
						
				
		
						//conn.do_job_set(Vehicle.setStop("1", Edge1, 50.0, (byte)0,  0.0, sf_v1, 30.0, 2400.0));
					}

					
					
				}

				// notification stage
				// CarsMap_with_Schedule:{1=[570, 660], 2=[660]}
				// CarsMap_time_to_requestInfo:{1={660=[273445903#7, 2966.38, 6993.0, 60.0], 570=[496257308#5, 3937.13, 5039.67, 50.0]}, 
				// 2={660=[297579234, 8973.76, 3772.53, 200.0]}, 3={}}
		
				if(timeSeconds%600==0) {
					for(int veh=1;veh<CarsMap_with_Schedule.size()+1;veh++) {
						String vehID = Integer.toString(veh); 
						
						ArrayList veh_array = new ArrayList();
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						Map eachVeh_requestInfo = new HashMap();
						eachVeh_requestInfo = (Map) CarsMap_time_to_requestInfo.get(vehID);
						
						for(int veh_array_Index=0; veh_array_Index<veh_array.size();veh_array_Index++) {
							int arrival_time =(int) veh_array.get(veh_array_Index);
						
							ArrayList requestInfo = new ArrayList();
							requestInfo = (ArrayList) eachVeh_requestInfo.get(arrival_time);
							int upperBound_time = (arrival_time-540)*60;
							int lowerBound_time = (arrival_time-540-10)*60; //1200s
							
							/*
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition(vehID));
							double distance_curAdd_To_Des = (double)conn.do_job_get(Simulation.getDistance2D(
									(double)requestInfo.get(1), (double)requestInfo.get(2), 
									veh_Position.x, veh_Position.y, false, true));
							*/
				
							/*
							System.out.println("arrival_time:"+ arrival_time);
							System.out.println("requestInfo:"+ requestInfo);
							System.out.println("distance_curAdd_To_Des:"+ distance_curAdd_To_Des);
							*/
							
							if(timeSeconds==lowerBound_time) { // specific time
								System.out.println("send nitification to the specific sender");
								
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

