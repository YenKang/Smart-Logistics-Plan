	if(timeSeconds==100.0) {
					System.out.println("timeSeconds:"+ timeSeconds);
					int insertTime=570;
					int insert_BoxSize=1; // small box insertion
					
					Map  veh_box = new HashMap();
					ArrayList insert_Size_Box = new ArrayList(); 
					ArrayList request_array = new ArrayList();
					
					
					
					request_array.add("496493919#2");
					request_array.add(7147.59);
					request_array.add(5832.08);
					request_array.add(150.0);
					
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
									
									
									
									
								
									//Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
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
									
									Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
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
									
									//Map_requestInfo.put(insertTime, request_array ); // request_array should be dynamic
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