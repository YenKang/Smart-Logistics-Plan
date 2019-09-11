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
import de.tudresden.sumo.util.SumoCommand;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import de.tudresden.ws.container.*;

public class MainCopy5_receiver_request {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	  static String config_file = "simulation4/map.sumo.cfg";

	// static double step_length = 0.01; // version1

	static double step_length = 0.01;
	//double vehicle_speed = 5.0; //5 [m/s]
	// 
	static ArrayList<ClientInfo> clientInfos = new ArrayList<ClientInfo>();
	static ArrayList<AssignResult> assignResults = new ArrayList<AssignResult>();

	public static void main(String[] args) {
		
		Thread server = new Server(clientInfos, assignResults);
		server.start();

		try {			
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			conn.addOption("step-length", step_length + "");
			conn.addOption("start", "true"); // start sumo immediately			

			// init HashMap
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
			/*
			v3_large_Box.add(331);
			*/
			
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
			
			ArrayList v3_TimeSchedule = new ArrayList();
			/*
			v3_TimeSchedule.add(720);
			*/
			CarsMap_with_Schedule.put("3", v3_TimeSchedule);
			
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
			v1_570_to_requestInfo.add("111");
			v1_570_to_requestInfo.add("ABC");
			v1_570_to_requestInfo.add("ABC");
			v1_570_to_requestInfo.add("test_order");
			
			
			ArrayList v1_660_to_requestInfo = new ArrayList();
			v1_660_to_requestInfo.add("273445903#7");
			v1_660_to_requestInfo.add(2966.38);
			v1_660_to_requestInfo.add(6993.0);
			v1_660_to_requestInfo.add(60.0);
			v1_660_to_requestInfo.add(0);
			v1_660_to_requestInfo.add("111");
			v1_660_to_requestInfo.add("ABC");
			v1_660_to_requestInfo.add("ABC");
			v1_660_to_requestInfo.add("test_order");
			
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
			v2_660_to_requestInfo.add("111");
			v2_660_to_requestInfo.add("ABC");
			v2_660_to_requestInfo.add("ABC");
			v2_660_to_requestInfo.add("test_order");
			
			v2_time_to_requestInfo.put(660, v2_660_to_requestInfo);
			
			System.out.println("v2_time_to_requestInfo:"+ v2_time_to_requestInfo);
			
			Map  v3_time_to_requestInfo = new HashMap();
			
			/*
			ArrayList v3_720_to_requestInfo = new ArrayList();
			v3_720_to_requestInfo.add("405115648#1");
			v3_720_to_requestInfo.add(8950.04);
			v3_720_to_requestInfo.add(6800.84);
			v3_720_to_requestInfo.add(240.0);
			v3_720_to_requestInfo.add(0);
			v3_720_to_requestInfo.add("111");
			v3_720_to_requestInfo.add("ABC");
			v3_720_to_requestInfo.add("ABC");
			v3_720_to_requestInfo.add("test_order");
			v3_time_to_requestInfo.put(720, v3_720_to_requestInfo);
			System.out.println("v3_time_to_requestInfo:"+ v3_time_to_requestInfo);*/
			
			ArrayList v3_requestInfo = new ArrayList();
			
			CarsMap_time_to_requestInfo.put("1", v1_time_to_requestInfo);
			CarsMap_time_to_requestInfo.put("2", v2_time_to_requestInfo);
			CarsMap_time_to_requestInfo.put("3", v3_time_to_requestInfo);
			
			System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
			
			// HashMap init finish

			// start Traci Server
			conn.runServer(7780); // 7789 at 10:35
			conn.setOrder(1);
			conn.do_job_set(Gui.setSchema("View #0", "real world")); // change the view mode like real world

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
			

			conn.do_job_set(Vehicle.setParameter("1", "111", "1"));
			conn.do_job_set(Vehicle.setParameter("1", "112", "1"));
			conn.do_job_set(Vehicle.setParameter("2", "221", "1"));

			/////////////////////////////////////////////////////////////////
			
			Map  CarsMapWithSchedule = new HashMap();
			//ArrayList v1_sender_TimeSchedule = new ArrayList();
			
			double vehicle_speed = 3.8; //3.8 [m/s] , estimated average vehicle speed
			
			SumoColor veh1_color = new SumoColor(255 ,0, 0,255);
			conn.do_job_set(Vehicle.setColor("1", veh1_color));
			SumoColor veh2_color = new SumoColor(0 ,255, 255,255);
			conn.do_job_set(Vehicle.setColor("2", veh2_color));
			
			//////////////////////////////////////////////////////////////////////////////////////////////////	
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////////////

			for (int i = 0; i < 360000000; i++) {			
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());
				//System.out.println("timeSeconds:"+ timeSeconds);				
				// 初始化資料庫
				
				if (i == 10) {
					/*setRoute*/
					double currentMin = (540+ timeSeconds/60.0);
					for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) 
					{
						System.out.println("------Initialization of all routes-------");

						String vehID = Integer.toString(veh); 				
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
						
						Map  Map_requestInfo = new HashMap();
						Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(vehID);

						if(Map_requestInfo.size()!=0) {
							
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
							//System.out.println("Map_requestInfo:"+ Map_requestInfo);
							//System.out.println("curEdge:"+ curEdge);
							//System.out.println("Arrival edges_list:"+ edges_list);	
							//System.out.println("newRoute_before:"+ newRoute);

							if(stages_list.size()>0){
								conn.do_job_set(Vehicle.setRoute(vehID, routes));
							}
						// setStop stage
							for(int veh_array_index=0; veh_array_index<veh_array.size();veh_array_index++) {
								String edge = (String) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(0); // 570
								double pos =  (double) ((ArrayList) Map_requestInfo.get(veh_array.get(veh_array_index))).get(3);		
								// SumoStopFlags sf3 = new SumoStopFlags(false, false, false, false, false);
								double until = 60.0*((Integer) veh_array.get(veh_array_index)-530);
								//System.out.println("edge:"+ edge);
								//System.out.println("pos:"+ pos);
								//System.out.println("until:"+ until);
								SumoStopFlags sf_0 = new SumoStopFlags(false, false, false, false, false);
								conn.do_job_set(Vehicle.setStop(vehID, edge, pos, (byte)0,  0.0,  
										sf_0, pos, until));

							}
						}	
				  	}
					
					//////////////////////////////////////////// 

					/*
					JDBC_AVD init_DB = new JDBC_AVD();
					for (int j = 1; j < 4; j++) {
						// 
						SumoPosition2D vPosition = (SumoPosition2D) conn.do_job_get(Vehicle.getPosition(Integer.toString( j )));
						SumoPosition2D v_geo_position = (SumoPosition2D)conn.do_job_get(Simulation.convertGeo(vPosition.x, vPosition.y,false ));
						double x = v_geo_position.x;
						double y = v_geo_position.y;
						double speed = (double)conn.do_job_get(Vehicle.getSpeed(Integer.toString(j)));
						init_DB.insertVehicle(Integer.toString(j), y, x, speed);
						System.out.println(x+y);
						if ( j == 1) {
							init_DB.insertContainer("111", 1, 1, "0", "1");
							init_DB.insertContainer("112", 1, 1, "0", "1");
							init_DB.insertContainer("113", 1, 0, "0", "1");
							init_DB.insertContainer("121", 2, 1, "0", "1");
							init_DB.insertContainer("122", 2, 0, "0", "1");
							init_DB.insertContainer("123", 2, 0, "0", "1");
							init_DB.insertContainer("131", 3, 0, "0", "1");
							init_DB.insertContainer("132", 3, 0, "0", "1");
							init_DB.insertContainer("133", 3, 0, "0", "1");
						}
						else if ( j == 2) {
							init_DB.insertContainer("211", 1, 0, "0", "2");
							init_DB.insertContainer("212", 1, 0, "0", "2");
							init_DB.insertContainer("213", 1, 0, "0", "2");
							init_DB.insertContainer("221", 2, 1, "0", "2");
							init_DB.insertContainer("222", 2, 0, "0", "2");
							init_DB.insertContainer("223", 2, 0, "0", "2");
							init_DB.insertContainer("231", 3, 0, "0", "2");
							init_DB.insertContainer("232", 3, 0, "0", "2");
							init_DB.insertContainer("233", 3, 0, "0", "2");
						}
						else if ( j == 3) {
							init_DB.insertContainer("311", 3, 0, "0", "3");
							init_DB.insertContainer("312", 3, 0, "0", "3");
							init_DB.insertContainer("313", 3, 0, "0", "3");
							init_DB.insertContainer("321", 3, 0, "0", "3");
							init_DB.insertContainer("322", 3, 0, "0", "3");
							init_DB.insertContainer("323", 3, 0, "0", "3");
							init_DB.insertContainer("331", 3, 0, "0", "3");
							init_DB.insertContainer("332", 3, 0, "0", "3");
							init_DB.insertContainer("333", 3, 0, "0", "3");
						}
					}
					*/
				}
				
				//////////////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////////////
				// 每 100 i 偵測是否有 request 進來
				if ( i % 100 == 0) {
					if (clientInfos.size() > 0) {
						for (int j =0; j < clientInfos.size(); j++) 
						{
							// 取得訂單物件資料 
							ClientInfo clientInfo = clientInfos.get(j);
							AssignResult assignResult = assignResults.get(j);
							// 宣告派遣成功時上船資料庫的暫存資料
							int container_DB_insert = 0;
							int truck_DB_insert = 0;

							ArrayList isJunction_in_all_vehs = new ArrayList();
							for(int veh=1;veh<cars_Box.size()+1;veh++) {
								String vehID = Integer.toString(veh); 			
								String curEdge =(String) conn.do_job_get(Vehicle.getRoadID(vehID));
								boolean isJunction =curEdge.contains(":");
								isJunction_in_all_vehs.add(isJunction);
							}
							
							int junction = 0;
							// 當只要有其中一台車此刻是在十字路口
							if(isJunction_in_all_vehs.contains(true)) {
								junction = 1;
								synchronized(assignResult) {
									Thread.sleep(500);
									assignResult.setResult(-2);
									assignResult.notify();
								}
								System.out.print("this request insertion failed, please pick other time!");
							}

							//////////////////////////////////////////////////////////////////////////////////////////////////
							//////////////////////////////////////////////////////////////////////////////////////////////////
							//////////////////////////////////////////////////////////////////////////////////////////////////
							// 若使用者為 sender
							if ( (clientInfo.getRequestNo() == 0) && ( junction == 0 ))  {
								System.out.println("---------------------------------");
								System.out.println("timeSeconds:"+ timeSeconds);
								System.out.println("cars_Box before inserting request:"+ cars_Box);
								System.out.println("CarsMap_with_Schedule before inserting request:"+ CarsMap_with_Schedule);
								// 從 clientInfo 取得使用者相關資料
								double[] lnglat = clientInfo.getLngLat();
								double sender_lng = lnglat[0];
								double sender_lat = lnglat[1];
								SumoPositionRoadMap sender_roadmap = (SumoPositionRoadMap) conn.do_job_get(
										Simulation.convertRoad(sender_lng, sender_lat, true, "ignoring"));
								String sender_edge = sender_roadmap.edgeID;
								int sender_lane = sender_roadmap.laneIndex;
								double sender_pos = sender_roadmap.pos;
								int sender_time = clientInfo.getTimeArrived();
								SumoPosition2D senderPosition2d = (SumoPosition2D) conn.do_job_get(
										Simulation.convertGeo(sender_lng, sender_lat, true));
								double sender_x = senderPosition2d.x;
								double sender_y = senderPosition2d.y;

								double currentMin = (540+ timeSeconds/60.0);
								int insertTime = 540+ sender_time*30;
								int insert_BoxSize = clientInfo.getSize();
								// 新增變數確定要插入的是哪一台車
								int insertCar =0;
								
								
								String sender_name = clientInfo.getSenderID();
								String receiver_name = clientInfo.getReceiverID();
								// 取得 device key
								JDBC_AVD deviceID_getterS = new JDBC_AVD();
								String sender_DID = deviceID_getterS.QueryDeviceKey(sender_name);
								JDBC_AVD deviceID_getterR = new JDBC_AVD();
								String receiver_DID = deviceID_getterR.QueryDeviceKey(receiver_name);						
								// 這裡要隨機產生 order_No!!
								// 先以時間生成流水號代替
								SimpleDateFormat sdft = new SimpleDateFormat("yyMMddhhmmss");
								Date nowdate = new Date();
								String order_No = sdft.format(nowdate);
								
								ArrayList request_array = new ArrayList();
								
								// request_array 
								request_array.add(sender_edge);
								request_array.add(sender_x);
								request_array.add(sender_y);
								request_array.add(sender_pos);
								
								request_array.add(0); // 4
								request_array.add(0); // 5
								request_array.add(sender_DID); // 6
								request_array.add(receiver_DID); // 7
								request_array.add(order_No); // 8
								
								//System.out.println("request_array:"+ request_array);
								System.out.println("insertTime:"+ insertTime);

								// 插入時間在此刻時間點之前
								Double double_insertTime=Double.valueOf(insertTime);
								if(double_insertTime<currentMin){
									System.out.println("insertion-time is earlier than current time!");
									synchronized(assignResult) {
										Thread.sleep(500);
										assignResult.setResult(0);
										assignResult.notify();
									}
								}
								// 插入時間在此刻時間點之後
								else if(double_insertTime>currentMin){
									//
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
										if(insert_capacity==3) {
											CarsMapSchedule_afterBoxFilter.remove(vehID);
											CarsMap_timeToRequestInfo_afterBoxFilter.remove(vehID);
										}
									}
									// 若無任何可用箱子的偵測
									if (CarsMapSchedule_afterBoxFilter.size() ==0) {
										synchronized(assignResult) {
											Thread.sleep(500);
											assignResult.setResult(-1);
											assignResult.notify();
										}
									}
									//////////////////////////////////////////////////////
									
									// 若貨櫃篩選通過則進入時間篩選
									// Time schedule filtering
									// 全部插滿
									ArrayList isFull_in_all_Veh_arrays = new ArrayList();
									for(Object vehID:CarsMapSchedule_afterBoxFilter.keySet()) 
									{
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
										int insert_capacity = ((ArrayList) veh_box.get(insert_BoxSize)).size(); // if insert_BoxSize=1, arrayList(v3_small_Box[])
										// there is no schedule in this car 
										// 本車尚無排程
										if(veh_array.size()==0) {
											SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition((String) vehID));
											double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
													(double)request_array.get(1), (double)request_array.get(2), veh_Position.x, veh_Position.y, false, true));
											System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
											double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
											System.out.println("travelTime_curr_To_Index:"+ travelTime_curr_To_Index);
											double diffDuration_curAddrTo_Des = 60*(insertTime-540)-timeSeconds;
											System.out.println("diffDuration_curAddrTo_Des:"+ diffDuration_curAddrTo_Des);								
											// 本車尚無排程且訂單時間段可插入排程
											if(travelTime_curr_To_Index<diffDuration_curAddrTo_Des) {
												veh_array.add(insertTime); // v3_timeSchedule [570]
												int insert_BoxIndex = 1+ 10*insert_BoxSize+ 100*int_vehID;
												System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
												insertCar = int_vehID;
												String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
												((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
												
												//setParameter
												conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
												cars_Box.put(int_vehID, veh_box);

												Map_requestInfo.put(insertTime, request_array ); 
												CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
												CarsMap_with_Schedule.put((String) vehID, veh_array);
												System.out.println("-----------after inserting------------");
												//System.out.println("Map_requestInfo:"+ Map_requestInfo);
												//System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
												System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
												System.out.println("cars_Box:"+ cars_Box);
												
												truck_DB_insert = int_vehID;
												container_DB_insert = insert_BoxIndex;
												break;
											}
											// 此時間段無法到達
											else{
												// can not arrive!
												synchronized(assignResult) {
													Thread.sleep(500);
													assignResult.setResult(0);
													assignResult.notify();
												}
												System.out.println("this request insertion falied, please pick other time!");
												break;
											}
										}
										// 此車目前排程非空 line379-562
										else {
											boolean isFull_this_veh = veh_array.contains(insertTime);
											isFull_in_all_Veh_arrays.add(isFull_this_veh);
											if((veh_array.contains(insertTime))!=true) {
												veh_array.add(insertTime);
												//System.out.println("veh_array:"+ veh_array);
												Collections.sort(veh_array);
												//System.out.println("veh_array after sorting:"+ veh_array);
												int indexValue = veh_array.indexOf(insertTime);
												Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic										
												// 插入點為最前頭
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
													double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60*0.67;						
													// 此時段可到達
													if((travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) &&
															(timeSeconds+travelTime_curr_To_Index) <(insertTime-540)*60) {													
														// BoxIndex insertion 416-439
														if(insert_capacity==0) {
															int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
															System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
															insertCar = int_vehID;
															String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);

															((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);
															// setParameter
															conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
															cars_Box.put(int_vehID, veh_box);
															System.out.println("cars_Box:"+ cars_Box);
															
															truck_DB_insert = int_vehID;
															container_DB_insert = insert_BoxIndex;
														}
														else if(insert_capacity==1){
															int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
															System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
															insertCar = int_vehID;
															String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);
															((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);											
															// setParameter
															conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
															cars_Box.put(int_vehID, veh_box);
															System.out.println("cars_Box:"+ cars_Box);
															
															truck_DB_insert = int_vehID;
															container_DB_insert = insert_BoxIndex;
														}									
														else if(insert_capacity==2){
															int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;	
															System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
															insertCar = int_vehID;
															String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);													
															((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);													
															// setParameter
															conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
															cars_Box.put(int_vehID, veh_box);
															
															truck_DB_insert = int_vehID;
															container_DB_insert = insert_BoxIndex;
														}	
														CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
														break;
													}
													// 此時段無法插入排程
													else {
														synchronized(assignResult) {
															Thread.sleep(500);
															assignResult.setResult(0);
															assignResult.notify();
														}
														
														System.out.print("this request insertion failed, please pick other time!");
														//System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
														
														// NEED TO CHANGE CARSMAP_TO_REQUEST
														break;
													}
												}
												// 插入點為排程最後
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
													double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60*0.67;
													// 此時段可插入排程
													if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex) {
														// BoxIndex insertion
														if(insert_capacity==0) {
															int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
															System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
															insertCar = int_vehID;
															String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);												
															((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);													
															// setParameter
															conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
															cars_Box.put(int_vehID, veh_box);		
															
															truck_DB_insert = int_vehID;
															container_DB_insert = insert_BoxIndex;
														}
														else if(insert_capacity==1){
															int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
															System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
															insertCar = int_vehID;
															String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);	
															((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);														
															// setParameter
															conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
															cars_Box.put(int_vehID, veh_box);
															
															truck_DB_insert = int_vehID;
															container_DB_insert = insert_BoxIndex;
														}								
														else if(insert_capacity==2){
															int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
															System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
															insertCar = int_vehID;
															String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);															
															((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);														
															// setParameter
															conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
															cars_Box.put(int_vehID, veh_box);
															
															truck_DB_insert = int_vehID;
															container_DB_insert = insert_BoxIndex;
														}												
														Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
														CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);
														
														break;
													}
													// 此時段無法插入排程
													else {
														synchronized(assignResult) {
															Thread.sleep(500);
															assignResult.setResult(0);
															assignResult.notify();
														}

														
														System.out.print("this request insertion failed, please pick other time!");
														//System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
														break;
													}			
												}
												// 插入點為排程中間 (前後有其他預定地點)
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
													
													double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60*0.67;
													double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60*0.67;
													// 此時段可插入排程
													if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex && 
															travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex){
														// BoxIndex insertion
														if(insert_capacity==0) {
															int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
															System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
															insertCar = int_vehID;
															String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);														
															((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);													
															// setParameter
															conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
															cars_Box.put(int_vehID, veh_box);			
															
															truck_DB_insert = int_vehID;
															container_DB_insert = insert_BoxIndex;
														}
														else if(insert_capacity==1){
															int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
															System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
															insertCar = int_vehID;
															String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);														
															((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);										
															// setParameter
															conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
															cars_Box.put(int_vehID, veh_box);	
															
															truck_DB_insert = int_vehID;
															container_DB_insert = insert_BoxIndex;
														}
														else if(insert_capacity==2){
															int insert_BoxIndex = (insert_capacity+1)+ 10*insert_BoxSize+100*int_vehID;
															System.out.println("insert_BoxIndex:"+ insert_BoxIndex);
															insertCar = int_vehID;
															String String_insert_BoxIndex = Integer.toString(insert_BoxIndex);														
															((ArrayList) veh_box.get(insert_BoxSize)).add(insert_BoxIndex);										
															// setParameter
															conn.do_job_set(Vehicle.setParameter((String) vehID, String_insert_BoxIndex, "1"));
															cars_Box.put(int_vehID, veh_box);			
															
															truck_DB_insert = int_vehID;
															container_DB_insert = insert_BoxIndex;
														}													
														CarsMap_time_to_requestInfo.put(vehID, Map_requestInfo);																												
														break;
													}
													// 篩選失敗，此時段無法插入排程
													else {
														synchronized(assignResult) {
															Thread.sleep(500);
															assignResult.setResult(0);
															assignResult.notify();
														}
													
														System.out.println("this request insertion failed, please pick other time!");
														//System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
														break;
													}
												}
											}
										}		
										}

										// 3 means the number of all cars
										// 插入的時程，全部的車都已有該時程，通知使用者另選時間
										if(isFull_in_all_Veh_arrays.size()==CarsMapSchedule_afterBoxFilter.size()){
											if (isFull_in_all_Veh_arrays.contains(false)!=true) {
												synchronized(assignResult) {
													Thread.sleep(500);
													assignResult.setResult(0);
													assignResult.notify();
												}
												System.out.println("this request insertion failed, please pick other time!");	
											}
										}

										//////////////////////////////////////////////////////////////////////////////////////////////////
										
										// 結束時間篩選流程
										// 準備判斷是否通過篩選，利用 assignResult 值判斷前面是否篩選失敗，若成功則為1
										// 成功則準備新增訂單資料進資料庫
										if (assignResult.getResult() == 1) {
											//System.out.println("ya!");
											synchronized(assignResult) {
												Thread.sleep(500);
												assignResult.notify();
											}
											//JDBC_AVD order_success = new JDBC_AVD();								
											
											String container_id = Integer.toString(container_DB_insert);
											String truck_id = Integer.toString(truck_DB_insert);
											double weight = clientInfo.getWeight();
											String cargo_content = clientInfo.getCargoContent();
											int price = clientInfo.getPrice();
											double receiver_lng = lnglat[2];
											double receiver_lat = lnglat[3];
											
											// order_No 在前面 (line 290) 即產生
											// 新增訂單
											JDBC_AVD order_success = new JDBC_AVD();				
											order_success.insertOrder(order_No, sender_name, receiver_name, container_id, truck_id, weight,
													cargo_content, insert_BoxSize, price, sender_lng, sender_lat, receiver_lng, receiver_lat, sender_time);
										}
										System.out.println("-------------route arrangement-------------");
										// set routes
										// 無論前面是否成功皆進行 SET ROUTES
										for(int veh=1; veh<=CarsMap_with_Schedule.size();veh++) 
										{
											System.out.println("---------------------------------");
								
											String vehID = Integer.toString(veh); 
											System.out.println("vehID:"+ vehID);
											ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
											veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
											veh_array.add((int)currentMin);
											Collections.sort(veh_array);
											//System.out.println("sort(veh_array):"+ veh_array);

											// 判斷 (int)currentMin 此刻時間，在veh_array中的index 是否為0
											int index_currentMin = veh_array.indexOf((int)currentMin);
											if(index_currentMin==0){
												veh_array.remove(index_currentMin); // remove the currentMin element
											}

											else{
												int previousIndex_currentMin = index_currentMin-1;

												// the vehicle is in the stopping stage
												int curMin_fromArray = (int) veh_array.get(index_currentMin);
												int value_before_curMin_fromArray = (int) veh_array.get(index_currentMin)+10;
												if(curMin_fromArray<value_before_curMin_fromArray){
													// configure veh_array
													// [570, 630, 660, 667, 720]-> [660, 720]
													for(int remove_Time=0;remove_Time<index_currentMin-1;remove_Time++){
														veh_array.remove(0);
													}

													//System.out.println("veh_array after for-loop:"+ veh_array);
													veh_array.remove((int)veh_array.indexOf((int)currentMin));
												}

												//  the vehicle is in the moving stage
												else{
													// configure veh_array
													// [570, 601, 720]-> [720]
													for(int remove_Time=0;remove_Time<index_currentMin+1;remove_Time++){
														veh_array.remove(0);
													}
													//System.out.println("veh_array after for-loop:"+ veh_array);
												}
											}
											System.out.println("veh_array after configuration:"+ veh_array);
										    ////////////////////////////////////////////////////////////////////						
										
											// 如果有插入任務	
											if(insertCar!=0){
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
												//System.out.println("Map_requestInfo:"+ Map_requestInfo);
												System.out.println("curEdge:"+ curEdge);
												//System.out.println("Arrival edges_list:"+ edges_list);	
												//System.out.println("newRoute_before:"+ newRoute);

												if(stages_list.size()>0){
													conn.do_job_set(Vehicle.setRoute(vehID, routes));
												}

												// only add one new setStop on the dispatched car
												if(veh==insertCar){
													ArrayList veh_array_for_setStop = new ArrayList();
													Map  Map_requestInfo_for_setStop = new HashMap();
													String insertCar_ID = Integer.toString(insertCar);
													veh_array_for_setStop = (ArrayList)CarsMap_with_Schedule.get(insertCar_ID);
													Map_requestInfo_for_setStop =(Map) CarsMap_time_to_requestInfo.get(insertCar_ID);
													
													System.out.println("insertCar_ID:"+insertCar_ID);
													System.out.println("insertTime:"+insertTime);
													System.out.println("veh_array_for_setStop:"+ veh_array_for_setStop);
													//System.out.println("Map_requestInfo_for_setStop:"+ Map_requestInfo_for_setStop);
													String edge = (String) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(0); // 570
													double pos =  (double) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(3);
													double until = 60.0*(insertTime-530);
													SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
													conn.do_job_set(Vehicle.setStop(insertCar_ID, edge, pos, (byte)0,  0.0,  sf, pos, until));
												}
											}
										}
										System.out.println("cars_Box after inserting request:"+ cars_Box);
										System.out.println("CarsMap_with_Schedule after inserting request:"+ CarsMap_with_Schedule);
										
									}
								
								}
							
							//////////////////////////////////////////////////////////////////////////////////////////////////
							//////////////////////////////////////////////////////////////////////////////////////////////////
							// 若為 receiver 的 request
							else if  ( (clientInfo.getRequestNo() == 1) && ( junction==0 )) {
								System.out.println("---------------------------------");
								System.out.println("timeSeconds:"+ timeSeconds);
								System.out.println("cars_Box before inserting request:"+ cars_Box);
								System.out.println("CarsMap_with_Schedule before inserting request:"+ CarsMap_with_Schedule);
								// 從 clientInfo 取得使用者相關資料
								String order_No = clientInfo.getOrderNo();
								int container_id = Integer.parseInt(clientInfo.getContainerNo());
								String truck_id = clientInfo.getTruckNo();
								double[] lnglat = clientInfo.getLngLat();
								
								// 找出 receiver 的位置
								double receiver_lng = lnglat[2];
								double receiver_lat = lnglat[3];
								SumoPositionRoadMap receiver_roadmap = (SumoPositionRoadMap) conn.do_job_get(
										Simulation.convertRoad(receiver_lng, receiver_lat, true, "ignoring"));
								
								String receiver_edge = receiver_roadmap.edgeID;
								int receiver_lane = receiver_roadmap.laneIndex;
								double receiver_pos = receiver_roadmap.pos;
								int receiver_time = clientInfo.getTimeArrived();
								SumoPosition2D receiverPosition2d = (SumoPosition2D) conn.do_job_get(
										Simulation.convertGeo(receiver_lng, receiver_lat, true));
								double receiver_x = receiverPosition2d.x;
								double receiver_y = receiverPosition2d.y;

								double currentMin = (540+ timeSeconds/60.0);
								int insertTime = 540+ receiver_time*30;
								int insert_BoxSize = clientInfo.getSize();
								// 新增變數確定要插入的是哪一台車
								int insertCar =0;
								String sender_name = clientInfo.getSenderID();
								String receiver_name = clientInfo.getReceiverID();
								
								JDBC_AVD deviceID_getterS = new JDBC_AVD();
								String sender_DID = deviceID_getterS.QueryDeviceKey(sender_name);
								JDBC_AVD deviceID_getterR = new JDBC_AVD();
								String receiver_DID = deviceID_getterR.QueryDeviceKey(receiver_name);
								
								ArrayList request_array = new ArrayList();
								// request_array 
								request_array.add(receiver_edge);
								request_array.add(receiver_x);
								request_array.add(receiver_y);
								request_array.add(receiver_pos);
								request_array.add(1); // 4
								request_array.add(container_id); // 5
								request_array.add(sender_DID); // 6
								request_array.add(receiver_DID); // 7
								request_array.add(order_No); // 8

								int boxIndex = (int) request_array.get(5);
								int specific_veh = boxIndex /100;
								insertCar = specific_veh;
								int acceptReceiverOrder =0 ;
								String specific_vehID = Integer.toString(specific_veh);
								
								System.out.println("-------------------------");
								System.out.println("timeSeconds:"+ timeSeconds);
								System.out.println("insertTime:"+ insertTime);
								System.out.println("boxIndex:"+ boxIndex);
								//System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
								System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
								System.out.println("cars_Box:"+ cars_Box);

								//System.out.println("RECEIVER request_array:"+ request_array);
								// 插入時間在此刻時間點之後
								Double double_insertTime=Double.valueOf(insertTime);
							
								if(double_insertTime<currentMin){
									System.out.println("this request insertion-time is less than crrent time");
									synchronized(assignResult) {
										Thread.sleep(500);
										assignResult.setResult(0);
										assignResult.notify();
									}
								}

								//
								else if(double_insertTime>currentMin){
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
							
						
										// 不可能發生 首次到的狀況
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
												//System.out.println("Map_requestInfo:"+ Map_requestInfo);
												//System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
												System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
												System.out.println("cars_Box:"+ cars_Box);
												/*
												synchronized(assignResult) {
													Thread.sleep(500);
													assignResult.setResult(1);
													assignResult.notify();
												}
												*/
											}

										}
										//System.out.println("line 1187"+ "veh_array:"+ veh_array);
										else {
											// 此插入時段的排程在時間表中沒出現過
											System.out.println("line 1190");
											System.out.println("line 1191"+ "veh_array:"+ veh_array);
											if((veh_array.contains(insertTime))!=true) {

												veh_array.add(insertTime);
												//System.out.println("veh_array:"+ veh_array);
												Collections.sort(veh_array);
												//System.out.println("veh_array after sorting:"+ veh_array);
												int indexValue = veh_array.indexOf(insertTime);
												Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
												
												System.out.println("line 1201"+ "veh_array:"+ veh_array);
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
													double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60*0.67;
												
													if((travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) &&
															(timeSeconds+travelTime_curr_To_Index) <(insertTime-540)*60) {
														acceptReceiverOrder =1;
														CarsMap_with_Schedule.put((String) vehID, veh_array);
														Map_requestInfo.put(insertTime, request_array ); 
														CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
														System.out.println("-----------after inserting------------");
														//System.out.println("Map_requestInfo:"+ Map_requestInfo);
														//System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
														System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
														System.out.println("cars_Box:"+ cars_Box);
													
														/*
														synchronized(assignResult) {
															Thread.sleep(500);
															assignResult.setResult(1);
															assignResult.notify();
														}
														*/
														break;
													}
													// 此時段無法插入排程
													else {
														
														System.out.print("veh_array:"+ veh_array);
														System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
														//System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
														synchronized(assignResult) {
															Thread.sleep(500);
															assignResult.setResult(0);
															assignResult.notify();
														}
														// NEED TO CHANGE CARSMAP_TO_REQUEST
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
													double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60*0.67;
													
													if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex) {
														acceptReceiverOrder = 1;
														CarsMap_with_Schedule.put((String) vehID, veh_array);
														Map_requestInfo.put(insertTime, request_array ); 
														CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
														System.out.println("-----------after inserting------------");
														//System.out.println("Map_requestInfo:"+ Map_requestInfo);
														//System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
														System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
														System.out.println("cars_Box:"+ cars_Box);
														/*
														synchronized(assignResult) {
															Thread.sleep(500);
															assignResult.setResult(1);
															assignResult.notify();
														}
														*/
														break;
													}
													else {
														System.out.print("this request insertion failed, please pick other time!");
														System.out.print("line1297"+"veh_array:"+ veh_array);
														System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
														//System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
														synchronized(assignResult) {
															Thread.sleep(500);
															assignResult.setResult(0);
															assignResult.notify();
														}
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
													
													double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60*0.67;
													double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60*0.67;
													
													if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex && 
															travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex)
													{											
														acceptReceiverOrder =1;
														CarsMap_with_Schedule.put((String) vehID, veh_array);
														Map_requestInfo.put(insertTime, request_array ); 
														CarsMap_time_to_requestInfo.put((String) vehID, Map_requestInfo);
														System.out.println("-----------after inserting------------");
														//System.out.println("Map_requestInfo:"+ Map_requestInfo);
														//System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);
														System.out.println("CarsMap_with_Schedule:"+ CarsMap_with_Schedule);
														System.out.println("cars_Box:"+ cars_Box);
														/*
														synchronized(assignResult) {
															Thread.sleep(500);
															assignResult.setResult(1);
															assignResult.notify();
														}		
														*/																	
														break;
													}
													// 篩選失敗，此時段無法插入排程
													else {
														
														System.out.println("this request insertion failed, please pick other time!");
														System.out.println("line1357"+"veh_array:"+ veh_array);
														System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
														//System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
														synchronized(assignResult) {
															Thread.sleep(500);
															assignResult.setResult(0);
															assignResult.notify();
														}
														break;
													}
												}
											}

											// 此時段已有插入時段的排程
											else{
												
												System.out.println("this request insertion failed, please pick other time!");
												System.out.print("line1345"+"veh_array:"+ veh_array);
												System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
												//System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);
												synchronized(assignResult) {
													Thread.sleep(500);
													assignResult.setResult(0);
													assignResult.notify();
												}
												// 本時段本車已有排程 (android之後要改)
												/*synchronized(assignResult) {
													Thread.sleep(500);
													assignResult.setResult(-3);
													assignResult.notify();
												}*/
												break;
											}
										}
									}
									// 若篩選成功，則 rs 會維持1，準備更新資料庫狀態
									if (assignResult.getResult() == 1) {
										//System.out.println("ya!");
										synchronized(assignResult) {
											Thread.sleep(500);
											assignResult.notify();
										}
										// 新增訂單
										JDBC_AVD order_success = new JDBC_AVD();			
										order_success.UpdateOrderStatus(order_No, "3");
										// order_success.insertOrder(order_No, sender_name, receiver_name, container_id, truck_id, weight,
										//		cargo_content, insert_BoxSize, price, sender_lng, sender_lat, receiver_lng, receiver_lat, sender_time);
											
									}

									if(acceptReceiverOrder==1){
										System.out.println("-------------route arrangement---------------");
										// set routes
										System.out.println("---------------------------------");
										System.out.println("insertCar"+ insertCar);
										String vehID = Integer.toString(insertCar); 
										System.out.println("vehID:"+ vehID);
										ArrayList veh_array = new ArrayList();//veh_array:[570, 660]			
										veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
										veh_array.add((int)currentMin);
										Collections.sort(veh_array);
										//System.out.println("sort(veh_array):"+ veh_array);

										// 判斷 (int)currentMin 此刻時間，在veh_array中的index 是否為0
										int index_currentMin = veh_array.indexOf((int)currentMin);
										if(index_currentMin==0){
											veh_array.remove(index_currentMin); // remove the currentMin element
										}

										else{
											int previousIndex_currentMin = index_currentMin-1;

											// the vehicle is in the stopping stage
											int curMin_fromArray = (int) veh_array.get(index_currentMin);
											int value_before_curMin_fromArray = (int) veh_array.get(index_currentMin)+10;
											if(curMin_fromArray<value_before_curMin_fromArray){
												// configure veh_array
												// [570, 630, 660, 667, 720]-> [660, 720]
												for(int remove_Time=0;remove_Time<index_currentMin-1;remove_Time++){
													veh_array.remove(0);
												}

												//System.out.println("veh_array after for-loop:"+ veh_array);
												veh_array.remove((int)veh_array.indexOf((int)currentMin));
											}

											//  the vehicle is in the moving stage
											else{
												// configure veh_array
												// [570, 601, 720]-> [720]
												for(int remove_Time=0;remove_Time<index_currentMin+1;remove_Time++){
													veh_array.remove(0);
												}
												//System.out.println("veh_array after for-loop:"+ veh_array);
											}
										}
										System.out.println("veh_array after configuration:"+ veh_array);
										////////////////////////////////////////////////////////////////////
										if(veh_array.contains(insertTime)==true){
											Map  Map_requestInfo = new HashMap();
											Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get(vehID);
											//System.out.println("Map_requestInfo:"+ Map_requestInfo);
											
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
											//System.out.println("newRoute_before:"+ newRoute);

											if(stages_list.size()>0){
												conn.do_job_set(Vehicle.setRoute(vehID, routes));
											}

											// only add one new setStop on the dispatched car
											
											ArrayList veh_array_for_setStop = new ArrayList();
											Map  Map_requestInfo_for_setStop = new HashMap();
											String insertCar_ID = Integer.toString(insertCar);
											veh_array_for_setStop = (ArrayList)CarsMap_with_Schedule.get(insertCar_ID);
											Map_requestInfo_for_setStop =(Map) CarsMap_time_to_requestInfo.get(insertCar_ID);
											
											System.out.println("insertCar_ID:"+insertCar_ID);
											System.out.println("insertTime:"+insertTime);
											System.out.println("veh_array_for_setStop:"+ veh_array_for_setStop);
											//System.out.println("Map_requestInfo_for_setStop:"+ Map_requestInfo_for_setStop);
											String edge = (String) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(0); // 570
											double pos =  (double) ((ArrayList) Map_requestInfo_for_setStop.get(insertTime)).get(3);
											double until = 60.0*(insertTime-530);
											SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
											conn.do_job_set(Vehicle.setStop(insertCar_ID, edge, pos, (byte)0,  0.0,  sf, pos, until));
										}

										else{
											System.out.println("No insertion request");
										}

										System.out.println("cars_Box after inserting request:"+ cars_Box);
										System.out.println("CarsMap_with_Schedule after inserting request:"+ CarsMap_with_Schedule);
									}
								}	
							}
							// 收件者的時間過濾
							else if  ( (clientInfo.getRequestNo() == 2) && ( junction==0 )) {
								// 從 clientInfo 取得使用者相關資料
								
								int container_id = Integer.parseInt(clientInfo.getContainerNo());
								String truck_id = clientInfo.getTruckNo();
								double[] lnglat = clientInfo.getLngLat();
								
								// 找出 receiver 的位置
								double receiver_lng = lnglat[2];
								double receiver_lat = lnglat[3];
								
								SumoPositionRoadMap receiver_roadmap = (SumoPositionRoadMap) conn.do_job_get(
										Simulation.convertRoad(receiver_lng, receiver_lat, true, "ignoring"));
								
								String receiver_edge = receiver_roadmap.edgeID;
								int receiver_lane = receiver_roadmap.laneIndex;
								double receiver_pos = receiver_roadmap.pos;

								SumoPosition2D receiverPosition2d = (SumoPosition2D) conn.do_job_get(
										Simulation.convertGeo(receiver_lng, receiver_lat, true));
								double receiver_x = receiverPosition2d.x;
								double receiver_y = receiverPosition2d.y;

								double currentMin = (540+ timeSeconds/60.0);
								
								//
								ArrayList request_array = new ArrayList();
								request_array.add(receiver_edge);
								request_array.add(receiver_x);
								request_array.add(receiver_y);
								request_array.add(receiver_pos);
								request_array.add(0);
								
								String specific_vehID = truck_id;
								
								System.out.println("request_array:"+ request_array);
								//////////////////////////////////////////////////////////////////////////////
								
								// 建立原始display_time_schedule
								ArrayList original_schedule = new ArrayList();
								for(int k=19;k<31;k++){
									original_schedule.add(k*30);
								}

								// [570, 600, 630, ..., 720, 750]
								
								original_schedule.add((int)currentMin);
								Collections.sort(original_schedule);
								System.out.println("original_schedule after sorting:"+ original_schedule);
								
								int remove_frequency=0;
								while(remove_frequency<(int)original_schedule.indexOf((int)currentMin)+1) {
									original_schedule.remove(0);
									remove_frequency++;
								}
								System.out.println("original_schedule after filtering:"+ original_schedule);
								
								// if current time is 10:15
								// [630, 660, 690, ...., 750]
								
								int insertTime= 0;
								
								//插入時間在此刻時間點之後

								//Double double_insertTime=Double.valueOf(insertTime);
								int insertTine_in_list =0;
								ArrayList display_time_list = new ArrayList();

								for(int n=0;n<original_schedule.size();n++){
									insertTime = (int) original_schedule.get(n);
									//System.out.println("insertTime in line416:"+ insertTime);
									Double double_insertTime=Double.valueOf(insertTime);
									
									if(double_insertTime>currentMin)
									{
										HashMap  CarsMapSchedule_fromReceiverRequest = new HashMap();
										Iterator iter = CarsMap_with_Schedule.entrySet().iterator(); 
										while (iter.hasNext()) {
											Map.Entry entry = (Map.Entry) iter.next(); 
											String key = (String) entry.getKey(); 
											Object value = entry.getValue();
											
											if(key.equals(specific_vehID)) {
												CarsMapSchedule_fromReceiverRequest.put(key, value);
											}	
										}

										//specific_vehID (Str)
										ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
										System.out.println("veh_array line1622:"+ veh_array);
										veh_array = (ArrayList)CarsMap_with_Schedule.get((String) specific_vehID);
										Map  Map_requestInfo = new HashMap();
										Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) specific_vehID);
										System.out.println("veh_array line1626:"+ veh_array);
										System.out.println("Map_requestInfo in line1627:"+ Map_requestInfo);

										if((veh_array.contains(insertTime))!=true) {

													veh_array.add(insertTime); // [660] -> [570, 660]
													System.out.println("veh_array:"+ veh_array);
													Collections.sort(veh_array);
													System.out.println("veh_array after sorting:"+ veh_array);
													int indexValue = veh_array.indexOf(insertTime);
													Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
													
													//System.out.println("insertTime:"+ insertTime);
													//System.out.println("line 1201"+ "veh_array:"+ veh_array);
													
													// 插入的時間在表中頂端
													if(indexValue==0) {
														SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition(specific_vehID));
														
														double distance_curr_To_Index = (double)conn.do_job_get(Simulation.getDistance2D(
																(double)request_array.get(1), (double)request_array.get(2), 
																veh_Position.x, veh_Position.y, false, true));
														
														System.out.println("distance_curr_To_Index:"+ distance_curr_To_Index);
														double travelTime_curr_To_Index = distance_curr_To_Index/vehicle_speed;
														System.out.println("Map_requestInfo:"+ Map_requestInfo);
														
														int key_afterIndex = (int) veh_array.get(indexValue+1);
														double request_x_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(1);
														double request_y_afterIndex = (double)((ArrayList) Map_requestInfo.get(key_afterIndex)).get(2);
														double distance_afterIndexToIndex = (double)(conn.do_job_get(Simulation.getDistance2D(
																request_x_afterIndex, request_y_afterIndex,
																(double)request_array.get(1), (double)request_array.get(2), false, true)));
														
														double travelTime_afterIndexToIndex = distance_afterIndexToIndex/vehicle_speed;			
														double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60*0.67;
														
														System.out.println("insertTime:"+ insertTime);
														
														if((travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex) &&
																(timeSeconds+travelTime_curr_To_Index) <(insertTime-540)*60) {
															display_time_list.add(insertTime);
															System.out.println("display_time_list in the top:"+insertTime);
															//break;
														}
														// 此時段無法插入排程
														
													}

													// 插入的時間在表尾端
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
														double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60*0.67;
														
														if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex) {
															display_time_list.add(insertTime);
															System.out.println("display_time_list in the tail:"+display_time_list);
														}
													
																								
													}

													// 插入的時間在表中端
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
														
														double diffDuration_IndexToBeforeIndex = ((int) veh_array.get(indexValue)-(int) veh_array.get(indexValue-1))*60*0.67;
														double diffDuration_afterIndexToIndex = ((int) veh_array.get(indexValue+1)-(int) veh_array.get(indexValue))*60*0.67;
														
														if(travelTime_IndexToBeforeIndex<diffDuration_IndexToBeforeIndex && 
																travelTime_afterIndexToIndex<diffDuration_afterIndexToIndex)
														{											
															display_time_list.add(insertTime);
															System.out.println("display_time_list in the middle:"+display_time_list);
														}
														
													}

													System.out.println("Map_requestInfo in line1729"+ Map_requestInfo.get(insertTime));
												
										}
										
										if(Map_requestInfo.containsKey(insertTime)==false) {
											Map_requestInfo.remove(insertTime);
										}
										

										System.out.println("Map_requestInfo after removing:"+ Map_requestInfo);	
										int index= veh_array.indexOf(insertTime);
										veh_array.remove(index);
										
										//veh_array.remove(veh_array.size()-1);
										System.out.println("veh_array after removing:"+ veh_array);	
									}	
								}

								//Map_requestInfo.remove(insertTime);	


								// System.out.println(display_time_list.get(0));
								// 沒有可到達的時間段
								if (display_time_list.size()==0) {
									synchronized(assignResult) {
										Thread.sleep(500);
										assignResult.setResult(0);								
										assignResult.notify();
									}
								}
								// 已過濾成功
								else {
									String timeFilter = "000000000000";
									char[] tfChar = timeFilter.toCharArray();
									for (int s=0; s<display_time_list.size(); s++) {
										switch (display_time_list.get(s).toString()) {
											case "570":
												// System.out.println("有喔!");	
												tfChar[0] = '1';
												break;
											case "600":
												tfChar[1] = '1';
												break;
											case "630":
												tfChar[2] = '1';
												break;
											case "660":
												tfChar[3] = '1';
												break;
											case "690":
												tfChar[4] = '1';
												break;
											case "720":
												tfChar[5] = '1';
												break;
											case "750":
												tfChar[6] = '1';
												break;
											case "780":
												tfChar[7] = '1';
												break;
											case "810":
												tfChar[8] = '1';
												break;
											case "840":
												tfChar[9] = '1';
												break;
											case "870":
												tfChar[10] = '1';
												break;
											case "900":
												tfChar[11] = '1';
												break;
										}
									}
									timeFilter = new String(tfChar);
									System.out.println(timeFilter);	
									synchronized(assignResult) {
										Thread.sleep(500);
										assignResult.setResult(1);
										assignResult.setTF(timeFilter);
										assignResult.notify();
									}
								}

								System.out.println("display_time_list"+ display_time_list);		
								display_time_list.clear();

							}
						}
						clientInfos.clear();
						assignResults.clear();
					}
				}
				//////////////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////////////
				//////////////////////////////////////////////////////////////////////////////////////////////////
				// 到達目的地的前 10 分鐘 (提前作通知)
				/*
				if(timeSeconds % 600==0) {
					for(int veh=1;veh<CarsMap_with_Schedule.size()+1;veh++) {
						String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID);
						Map eachVeh_requestInfo = new HashMap();
						eachVeh_requestInfo = (Map) CarsMap_time_to_requestInfo.get(vehID);				
						//System.out.println("CarsMap_time_to_requestInfo:"+ CarsMap_time_to_requestInfo);					
						//System.out.println("eachVeh_requestInfo:"+ eachVeh_requestInfo);						
						for(int veh_array_Index=0; veh_array_Index<veh_array.size();veh_array_Index++) {
							int arrival_time =(int) veh_array.get(veh_array_Index);
							ArrayList requestInfo = new ArrayList();
							
							requestInfo = (ArrayList) eachVeh_requestInfo.get(arrival_time);					
							System.out.println("requestInfo in line745:"+ requestInfo);							
							int upperBound_time = (arrival_time-540)*60;
							int lowerBound_time = (arrival_time-540-10)*60; //1200s							

							if(timeSeconds==lowerBound_time) { // specific time
								// sender 及 receiver 都要通知
								// 因為還沒初始設置完畢，先只用第二台測試
								// 提前通知的部分包括 sender 以及 receiver，因此要做判斷
								int isReceiver = (int) requestInfo.get(4);
								FcmNotify notifyEarly = new FcmNotify();
								// 通知 sender
								if (isReceiver == 0) {
									if (veh ==2) {
										System.out.println("The system is in the notification stage!");	
										System.out.println("send notification to the specific sender");	
										String sender_DID = (String) requestInfo.get(6);
										System.out.println(sender_DID);
										// FcmNotify notifySenderEarly = new FcmNotify();
										notifyEarly.pushFCMNotification(sender_DID, "貨車即將到達", "貨車將於約10分後到達。");
									}
								}
								// 通知 receiver
								else if (isReceiver == 1) {
									if (veh ==2) {
										System.out.println("The system is in the notification stage!");	
										System.out.println("send notification to the specific sender");	
										String receiver_DID = (String) requestInfo.get(7);
										System.out.println(receiver_DID);
										// FcmNotify notifySenderEarly = new FcmNotify();
										notifyEarly.pushFCMNotification(receiver_DID, "貨車即將到達", "貨車將於約10分後到達。");
									}
								}
							}													
						}
					}
				}
				*/
				// 通知完後繼續移動
				// 當車子已經到達 sender 位置，則通知 sender 及 receiver 選擇時間
				// when the vehicle arrive to the destination (sender address & receiver address)
				if(timeSeconds%900==0) {
					for(int veh=1;veh<CarsMap_with_Schedule.size()+1;veh++) {
						String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID); // {1=[570,660]}
						Map eachVeh_requestInfo = new HashMap();
						eachVeh_requestInfo = (Map) CarsMap_time_to_requestInfo.get(vehID);			
						for(int veh_array_Index=0; veh_array_Index<veh_array.size();veh_array_Index++) {
							int arrival_time =(int) veh_array.get(veh_array_Index); // [570,660] ->570
							ArrayList requestInfo = new ArrayList();
							requestInfo = (ArrayList) eachVeh_requestInfo.get(arrival_time);// 570=[496257308#5, 3937.13, 5039.67, 50.0, 0,111, "kjkjk44"] //userDEvicekeyID
							
							int specific_time = (arrival_time-540)*60;						
							int upload_Unload_time = (arrival_time-540+3)*60;
							
							// 先確定是 sender or receiver  
							int isReceiver = (int) requestInfo.get(4);
							// 到達目的地
							if(timeSeconds==specific_time) { // specific time
								System.out.println("send notification to the specific sender");	
								// case1:sender destination
								if(isReceiver==0) {
									// notify sender that the car arrived to sender's address via userDevicekeyID								
									System.out.println("we arrive to the sender's address");
									System.out.println("send notification to the specific sender");	
									System.out.println("line1554" +requestInfo);
									// 4: isReceiver, 5: container id, 6: senderDID, 7. receiverDID
									String sender_DID =(String) requestInfo.get(6);
									FcmNotify notifySender = new FcmNotify();
									notifySender.pushFCMNotification(sender_DID, "貨車已到達", "貨車已到達收貨點，請準備上貨。");
									
									// 更新資料庫中的貨物狀態，以便 android 介面進行更改 ( 狀態: 已到 S )
									String order_No = (String)requestInfo.get(8);
									JDBC_AVD arrive_at_sender = new JDBC_AVD();
									arrive_at_sender.UpdateOrderStatus(order_No, "1");

									//conn.do_job_set(Gui.trackVehicle("View #0", "2"));
									//conn.do_job_set(Gui.setZoom("View #0", 6000.0));

								}
								// case2:receiver destination
								else if(isReceiver==1) {
									// notify receiver to unload the container
									// step1:notify receiver that the car arrived to receiver via userDevicekeyID						
									String receiver_DID = (String) requestInfo.get(7);
									FcmNotify notifyReceiver = new FcmNotify();
									notifyReceiver.pushFCMNotification(receiver_DID, "貨車已到達", "貨物已送達，請準備簽收。");
									// 更新資料庫中的貨物狀態，以便 android 介面進行更改 ( 狀態: 已到 R )
									String order_No = (String)requestInfo.get(8);
									JDBC_AVD arrive_at_receiver = new JDBC_AVD();
									arrive_at_receiver.UpdateOrderStatus(order_No, "4");																	
								}
							}
							// 到達目的地後3分鐘 (模擬 sender 進行上貨及 receiver 收貨)
							else if (timeSeconds == upload_Unload_time) {
								
								// sender 上貨完畢
								if (isReceiver == 0) {
									// notify receiver ID       
									// 更新資料庫中的貨物狀態，以便 android 介面進行更改  ( 狀態: 已寄出)
									System.out.println("line 1405:" +requestInfo);
									String order_No = (String)requestInfo.get(8);
									JDBC_AVD sender_confirt = new JDBC_AVD();
									sender_confirt.UpdateOrderStatus(order_No, "2");
									String receiver_DID = (String) requestInfo.get(7);
									FcmNotify notifyReceiverTimeSelect = new FcmNotify();
									notifyReceiverTimeSelect.pushFCMNotification(receiver_DID, "貨物已上車", "寄件人已將貨物寄出，可選擇取貨時間。");
									// wait for receiver's time-selection
								}
								// receiver 收貨完畢
								else if (isReceiver == 1) {
									// 更新資料庫的貨物狀態，確認此訂單流程已結束 ( 狀態: 已簽收)
									String order_No = (String)requestInfo.get(8);
									JDBC_AVD receiver_confirt = new JDBC_AVD();
									receiver_confirt.UpdateOrderStatus(order_No, "5");
									
									// step2:unload the container
									int int_boxIndex = (int) requestInfo.get(5);
									String boxIndex = Integer.toString(int_boxIndex); 
									// change container id of the car in SUMO
									System.out.println("boxIndex:"+ boxIndex);
									conn.do_job_set(Vehicle.setParameter(vehID, boxIndex, "0"));
									Map veh_Box = new HashMap();
									veh_Box = (Map) cars_Box.get(veh); // v1_Box:{1=[111, 112], 2=[], 3=[]}
									int boxSize = (int_boxIndex-veh*100)/10;
									ArrayList boxList = new ArrayList();
									boxList = (ArrayList) veh_Box.get(boxSize); // [111, 112]
									int Index_specific_Box = boxList.indexOf(int_boxIndex);
									boxList.remove(Index_specific_Box);
									
									veh_Box.put(boxSize, boxList);
									cars_Box.put(veh,veh_Box);
									System.out.println("we arrive to the receiver's address");
									System.out.println("after unloading container, cars_Box is "+ cars_Box);
								}
							}						
						}
					}
				}
				if(timeSeconds%300 == 0) {
					for(int veh=1;veh<CarsMap_with_Schedule.size()+1;veh++) {
						String vehID = Integer.toString(veh); 
						ArrayList veh_array = new ArrayList();
						veh_array = (ArrayList)CarsMap_with_Schedule.get(vehID); // {1=[570,660]}
						Map eachVeh_requestInfo = new HashMap();
						eachVeh_requestInfo = (Map) CarsMap_time_to_requestInfo.get(vehID);			
						for(int veh_array_Index=0; veh_array_Index<veh_array.size();veh_array_Index++) {
							int arrival_time =(int) veh_array.get(veh_array_Index); // [570,660] ->570
							ArrayList requestInfo = new ArrayList();
							requestInfo = (ArrayList) eachVeh_requestInfo.get(arrival_time);// 570=[496257308#5, 3937.13, 5039.67, 50.0, 0,111, "kjkjk44"] //userDEvicekeyID
							
							int specific_time = (arrival_time-540)*60;						
							int upload_Unload_time = (arrival_time-540+5)*60;
							int lowerBound_time =  (arrival_time-540-5)*60;
							
							// 先確定是 sender or receiver  
							int isReceiver = (int) requestInfo.get(4);
							// 到達目的地後5分鐘 (模擬 sender 進行上貨及 receiver 收貨)
							if (timeSeconds == upload_Unload_time) {
								System.out.println("Do something after 3 mins");
								// sender 上貨完畢
								if (isReceiver == 0) {
									// notify receiver ID       
									// 更新資料庫中的貨物狀態，以便 android 介面進行更改  ( 狀態: 已寄出)
									//System.out.println("line 1405:" +requestInfo);
									String order_No = (String)requestInfo.get(8);
									JDBC_AVD sender_confirt = new JDBC_AVD();
									sender_confirt.UpdateOrderStatus(order_No, "2");
									String receiver_DID = (String) requestInfo.get(7);
									FcmNotify notifyReceiverTimeSelect = new FcmNotify();
									notifyReceiverTimeSelect.pushFCMNotification(receiver_DID, "貨物已上車", "寄件人已將貨物寄出，請到我的貨物可選擇收貨時間。");

									// wait for receiver's time-selection
								}
								// receiver 收貨完畢
								else if (isReceiver == 1) {
									// 更新資料庫的貨物狀態，確認此訂單流程已結束 ( 狀態: 已簽收)
									String order_No = (String)requestInfo.get(8);
									JDBC_AVD receiver_confirt = new JDBC_AVD();
									receiver_confirt.UpdateOrderStatus(order_No, "5");
									
									// step2:unload the container
									int int_boxIndex = (int) requestInfo.get(5);
									String boxIndex = Integer.toString(int_boxIndex); 
									// change container id of the car in SUMO
									conn.do_job_set(Vehicle.setParameter(vehID, boxIndex, "0"));
									Map veh_Box = new HashMap();
									veh_Box = (Map) cars_Box.get(veh); // v1_Box:{1=[111, 112], 2=[], 3=[]}
									int boxSize = (int_boxIndex-veh*100)/10;
									ArrayList boxList = new ArrayList();
									boxList = (ArrayList) veh_Box.get(boxSize); // [111, 112]
									int Index_specific_Box = boxList.indexOf(int_boxIndex);
									boxList.remove(Index_specific_Box);
									
									veh_Box.put(boxSize, boxList);
									cars_Box.put(veh,veh_Box);
									System.out.println("we arrive to the receiver's address");
									System.out.println("after unloading container, cars_Box is "+ cars_Box);
								}
							}

							// 到達目的地前5分鐘通知
							if(timeSeconds==lowerBound_time) { // specific time
								// sender 及 receiver 都要通知
								// 因為還沒初始設置完畢，先只用第二台測試
								// 提前通知的部分包括 sender 以及 receiver，因此要做判斷
								//int isReceiver = (int) requestInfo.get(4);
								FcmNotify notifyEarly = new FcmNotify();
								// 通知 sender
								if (isReceiver == 0) {
									System.out.println("The system is in the notification stage!");	
									System.out.println("send notification to the specific sender");	
									System.out.println("veh"+ vehID+ " will soon arrived to the sender's address!");	
									String sender_DID = (String) requestInfo.get(6);
									//System.out.println(sender_DID);
									System.out.println("貨車即將到達寄件人,貨車將於約5分後到達。");
									// FcmNotify notifySenderEarly = new FcmNotify();
									notifyEarly.pushFCMNotification(sender_DID, "貨車即將到達", "貨車將於約5分後到達。");							
																
								}
								// 通知 receiver
								else if (isReceiver == 1) {
									System.out.println("The system is in the notification stage!");	
									System.out.println("send notification to the specific reciver");	
									System.out.println("veh"+ vehID+ " will soon arrived to the reveiver's address!");
									String receiver_DID = (String) requestInfo.get(7);
									// System.out.println(receiver_DID);
									// FcmNotify notifySenderEarly = new FcmNotify();
									
									notifyEarly.pushFCMNotification(receiver_DID, "貨車即將到達", "貨車將於約5分後到達。");
									System.out.println("貨車即將到達收件人,貨車將於約5分後到達。");
								}
							}
						}
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