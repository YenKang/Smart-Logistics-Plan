else if  ( (clientInfo.getRequestNo() == 1) && ( junction==0 )) {
								System.out.println("---------------------------------");
								System.out.println("timeSeconds:"+ timeSeconds);
								
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
								
								//////////////////////////////////////////////////////////////////////////////
								
								// 建立原始display_time_schedule
								ArrayList original_schedule = new ArrayList();
								for(int k=19;k<31;k++){
									original_schedule.add(k*30);
								}

								// [570, 600, 630, ..., 720, 750]

								original_schedule.add((int)currentMin);
								Collections.sort(original_schedule);

								int remove_frequency=0;
								while(remove_frequency<(int)original_schedule.indexOf((int)currentMin)+1) {
									original_schedule.remove(0);
									remove_frequency++;
								}
								// if current time is 10:15
								// [630, 660, 690, ...., 750]
								//System.out.println("RECEIVER request_array:"+ request_array);
								//插入時間在此刻時間點之後

								//Double double_insertTime=Double.valueOf(insertTime);
								int insertTine_in_list =0;
								ArrayList display_time_list = new ArrayList();

								for(int i=;i<original_schedule.size();i++){
									insertTine_in_list = original_schedule.get(i);
									Double double_insertTime=Double.valueOf(insertTine_in_list);
									else if(double_insertTime>currentMin)
									{
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

										//specific_vehID (Str)
										ArrayList veh_array = new ArrayList();//veh_array:[570, 660]
										veh_array = (ArrayList)CarsMap_with_Schedule.get((String) specific_vehID);
										Map  Map_requestInfo = new HashMap();
										Map_requestInfo =(Map) CarsMap_time_to_requestInfo.get((String) specific_vehID);

										if((veh_array.contains(insertTine_in_list))!=true) {

													veh_array.add(insertTine_in_list); // [660] -> [570, 660]
													//System.out.println("veh_array:"+ veh_array);
													Collections.sort(veh_array);
													//System.out.println("veh_array after sorting:"+ veh_array);
													int indexValue = veh_array.indexOf(insertTine_in_list);
													Map_requestInfo.put(insertTine_in_list, request_array ); // request_array should be dynamic
													
													//System.out.println("line 1201"+ "veh_array:"+ veh_array);
													
													// 插入的時間在表中頂端
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
															display_time_list.add(insertTine_in_list);
															System.out.println("display_time_list:"+display_time_list);
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
															display_time_list.add(insertTine_in_list);
															System.out.println("display_time_list:"+display_time_list);
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
															display_time_list.add(insertTine_in_list);
															System.out.println("display_time_list:"+display_time_list);
														}
														
													}
												
										}
									}	
								}
}