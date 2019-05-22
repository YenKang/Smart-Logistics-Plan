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

public class MainCopy3withBigMapandOneCar {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	  static String config_file = "simulation4/map.sumo.cfg";

	// static double step_length = 0.01; // version1

	static double step_length = 0.3;
	//double vehicle_speed = 5.0; //5 [m/s]

	public static void main(String[] args) {

		try {
			
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			conn.addOption("step-length", step_length + "");
			conn.addOption("start", "true"); // start sumo immediately
			
			String gateway_EdgeID = "228022808#0";
			double gateway_x = 8038.25;
			double gateway_y = 6425.07;
			double gateway_pos =25.0;
			int    gateway_laneIndex = 0;
			

			// start Traci Server
			conn.runServer(8080);
			conn.setOrder(1);
			
			Map  CarsMapWithSchedule = new HashMap();
			ArrayList v1_sender_TimeSchedule = new ArrayList();
			
			double vehicle_speed = 4.0; //4 [m/s]
			
			// vehicle1
	
		

			
			// vehicle2
			ArrayList v2_sender_TimeSchedule = new ArrayList();
			
			v2_sender_TimeSchedule.add(600);
			CarsMapWithSchedule.put("2",v2_sender_TimeSchedule);
			
			Map v2_TimeToSenderInfo = new HashMap();
			
			ArrayList sender2_Array = new ArrayList();
			sender2_Array.add("496257308#5");
			sender2_Array.add(3937.13);
			sender2_Array.add(5039.67);
			
			v2_TimeToSenderInfo.put(600, sender2_Array);
		
			
			System.out.println("v2_TimeToSenderInfo:"+ v2_TimeToSenderInfo);
			System.out.println("sender2_Array:"+ sender2_Array);
			
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			
			v2_sender_TimeSchedule.add(660);
			CarsMapWithSchedule.put("2",v2_sender_TimeSchedule);
			
			ArrayList sender3_Array = new ArrayList();
			sender3_Array.add("273445903#7");
			sender3_Array.add(2966.38);
			sender3_Array.add(6993.0);
			v2_TimeToSenderInfo.put(660, sender3_Array);
			
			System.out.println("v2_TimeToSenderInfo:"+ v2_TimeToSenderInfo);
			System.out.println("sender3_Array:"+ sender3_Array);
			
			System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
			System.out.println("-----------------------------------------------");
			
			
			
			
		
			for (int i = 0; i < 360000; i++) {
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());
				//System.out.println("timeSeconds:"+ timeSeconds);
				
				double Distance_Sender2ToSender3 = (double)(conn.do_job_get(Simulation.getDistance2D(
						(double)sender2_Array.get(1), 
						(double)sender2_Array.get(2), 
						(double)sender3_Array.get(1), 
						(double)sender3_Array.get(2), false, true)));
				
				//System.out.println("Distance_Sender2ToSender3:"+ Distance_Sender2ToSender3);
				
				double Distance_StartToSender3 = (double)(conn.do_job_get(Simulation.getDistance2D(
						(double)sender2_Array.get(1), 
						(double)sender2_Array.get(2), 
						10806.12, 3567.21, false, true)));
				
				//System.out.println("Distance_Sender2ToSender3:"+ Distance_Sender2ToSender3);
				
				
				
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
				
	
				if(timeSeconds==10.3) {
					System.out.println("-----------------------------------------------");
					System.out.println("Distance_Sender2ToSender3:"+ Distance_Sender2ToSender3);
					System.out.println("Distance_StartToSender3:"+ Distance_StartToSender3);
					
					conn.do_job_set(Vehicle.changeTarget("2", (String)sender2_Array.get(0)));
					
					//conn.do_job_set(Vehicle.changeTarget("2", (String)sender3_Array.get(0)));
				}
				
				
				// At 09:06 (360), got the request of sender4 with  09:30
				/*
				if(timeSeconds>360.0 && timeSeconds<361.0) {
					ArrayList sender4_Array = new ArrayList();
					sender4_Array.add("297579234");
					sender4_Array.add(8973.76);
					sender4_Array.add(3772.53);
					
					SumoPosition2D v2_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition("2")); 
					double Distance_v2toSender4= (double)(conn.do_job_get(
							Simulation.getDistance2D((double)sender4_Array.get(1), (double)sender4_Array.get(2),
									v2_Position.x, v2_Position.y, false, true)));
					double travelTime_v2toSender4 = Distance_v2toSender4/vehicle_speed;
					
					double duration_curPos_to_Index = 1440; //(570min-546min)*60=24min*60 s/min= 1440s
					System.out.println("travelTime_v2toSender4:"+ travelTime_v2toSender4);
					System.out.println("duration_curPos_to_Index:"+ duration_curPos_to_Index);
					
					double Distance_Sender2ToSender4 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender4_Array.get(1), 
							(double)sender4_Array.get(2), 
							(double)sender2_Array.get(1), 
							(double)sender2_Array.get(2), false, true)));
					
					System.out.println("Distance_Sender2ToSender4:"+ Distance_Sender2ToSender4);
					
					if(travelTime_v2toSender4< duration_curPos_to_Index 
							&& Distance_Sender2ToSender4/vehicle_speed<1800 ) {
						System.out.println("sender4_Array passed");
					}	
					
				}*/
				
				if(timeSeconds==600.6) { //09:10 i==2001
					System.out.println("-----------------------------------------------");
					System.out.println("i:"+ i);
					System.out.println("timeSeconds:"+ timeSeconds);
					ArrayList sender4_Array = new ArrayList();
					sender4_Array.add("297579234");
					sender4_Array.add(8973.76);
					sender4_Array.add(3772.53);
					
					SumoPosition2D v2_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition("2")); 
					
					System.out.println("v2_Position:"+ v2_Position);
					
					double Distance_v2toSender4= (double)(conn.do_job_get(
							Simulation.getDistance2D((double)sender4_Array.get(1), (double)sender4_Array.get(2),
									v2_Position.x, v2_Position.y, false, true)));
					
					double travelTime_v2toSender4 = Distance_v2toSender4/vehicle_speed;
					
					double duration_curPos_to_Index = 1200; //(570min-550min)*60=20min*60 s/min= 1200s
					System.out.println("Distance_v2toSender4:"+ Distance_v2toSender4);
					System.out.println("travelTime_v2toSender4:"+ travelTime_v2toSender4);
					System.out.println("duration_curPos_to_Index:"+ duration_curPos_to_Index);
					
					double Distance_Sender2ToSender4 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender4_Array.get(1), 
							(double)sender4_Array.get(2), 
							(double)sender2_Array.get(1), 
							(double)sender2_Array.get(2), false, true)));
					
					System.out.println("Distance_Sender2ToSender4:"+ Distance_Sender2ToSender4);
					System.out.println("TravelTime_Sender2ToSender4:"+ Distance_Sender2ToSender4/vehicle_speed);
					
					if(travelTime_v2toSender4< duration_curPos_to_Index 
							&& Distance_Sender2ToSender4/vehicle_speed<1800 ) {
						System.out.println("sender4_Array passed");
						conn.do_job_set(Vehicle.changeTarget("2", (String)sender4_Array.get(0)));
						
						SumoStopFlags sf_v2 = new SumoStopFlags(false, false, false, false, false);
						
						conn.do_job_set(Vehicle.setStop("2", (String)sender4_Array.get(0) , 540.0, (byte)0, 1200.0, sf_v2));
						
						v2_sender_TimeSchedule.add(570); //09:30
						Collections.sort(v2_sender_TimeSchedule);
						System.out.println("v2_TimeToSenderInfo:"+ v2_TimeToSenderInfo);
						
						v2_TimeToSenderInfo.put(570, sender4_Array);
						
						//CarsMapWithSchedule.put(2, v2_sender_TimeSchedule);
						System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
					
						System.out.println("v2_sender_TimeSchedule:"+ v2_sender_TimeSchedule);
						
					
						
						
					}	
					
					else {
						System.out.println("the insertion of sender4_Array failed");
					}
					
					
					
				}
				// At 09:40, a request of sender5 in 10:30

				if(timeSeconds==1200.0) {
					System.out.println("-----------------------------------------------");
					//System.out.println("i:"+ i);
					System.out.println("timeSeconds:"+ timeSeconds);
					ArrayList sender5_Array = new ArrayList();
					sender5_Array.add("496493919#2"); // Hayashi Department Store
					sender5_Array.add(7147.89);
					sender5_Array.add(5832.08);
					
					
	
					double Distance_Sender2ToSender5 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender5_Array.get(1), 
							(double)sender5_Array.get(2), 
							(double)sender2_Array.get(1), 
							(double)sender2_Array.get(2), false, true)));
					
					double Distance_Sender5ToSender3 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender5_Array.get(1), 
							(double)sender5_Array.get(2), 
							(double)sender3_Array.get(1), 
							(double)sender3_Array.get(2), false, true)));
					
					double TravelTime_Sender2ToSender5 = Distance_Sender2ToSender5/vehicle_speed;
					double TravelTime_Sender5ToSender3 = Distance_Sender5ToSender3/vehicle_speed;
			
					System.out.println("Distance_Sender2ToSender5:"+ Distance_Sender2ToSender5);
					System.out.println("TravelTime_Sender2ToSender5:"+ TravelTime_Sender2ToSender5);
					
					System.out.println("Distance_Sender5ToSender3:"+ Distance_Sender5ToSender3);
					System.out.println("TravelTime_Sender5ToSender3:"+ TravelTime_Sender5ToSender3);
					
					if(TravelTime_Sender2ToSender5<1800 && TravelTime_Sender5ToSender3<1800) {
						System.out.println("sender5_Array passed");
						//conn.do_job_set(Vehicle.changeTarget("2", (String)sender4_Array.get(0)));
						
						v2_sender_TimeSchedule.add(630); //10:30
						Collections.sort(v2_sender_TimeSchedule);
						System.out.println("v2_sender_TimeSchedule:"+ v2_sender_TimeSchedule);
						
						v2_TimeToSenderInfo.put(630, sender5_Array);
						System.out.println("v2_TimeToSenderInfo:"+ v2_TimeToSenderInfo);
					
						System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
					
						
	
					}
					
				}
				
				// the vehicle2 arrived to the sender4 at 09:18, 
				// stopped for 10mins, and arranged the new route to 
				
				if(timeSeconds==1800) {
					System.out.println("-----------------------------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					conn.do_job_set(Vehicle.changeTarget("2", (String)sender2_Array.get(0)));
					
					SumoStopFlags sf_v2 = new SumoStopFlags(false, false, false, false, false);
					
					conn.do_job_set(Vehicle.setStop("2", (String)sender2_Array.get(0) , 50.0, (byte)0, 1200.0, sf_v2));
					
					conn.do_job_set(Vehicle.resume("2"));
					//conn.do_job_set(Vehicle.changeTarget("2", (String)sender2_Array.get(0)));
					

				}
				
				if(timeSeconds==4200.0) { //At 10:10, the car would leave from the sender2 
				
					System.out.println("-----------------------------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					conn.do_job_set(Vehicle.changeTarget("2", (String)((ArrayList) v2_TimeToSenderInfo.get(630)).get(0)));
					
					SumoStopFlags sf_v2 = new SumoStopFlags(false, false, false, false, false);
					
					conn.do_job_set(Vehicle.setStop("2", (String)((ArrayList) v2_TimeToSenderInfo.get(630)).get(0) , 
							150.0, (byte)0, 1200.0, sf_v2));
					
					conn.do_job_set(Vehicle.resume("2"));
					//conn.do_job_set(Vehicle.changeTarget("2", (String)sender2_Array.get(0)));
					
				}
				
				if(timeSeconds==5400.0) {
					System.out.println("-----------------------------------------------");
					//System.out.println("i:"+ i);
					System.out.println("timeSeconds:"+ timeSeconds);
					ArrayList sender6_Array = new ArrayList();
					sender6_Array.add("405115648#1"); // medical school of ncku
					sender6_Array.add(8950.04);
					sender6_Array.add(6800.84);
					sender6_Array.add(240.0); // pos
					
					
	
					double Distance_Sender3ToSender6 = (double)(conn.do_job_get(Simulation.getDistance2D(
							(double)sender3_Array.get(1), 
							(double)sender6_Array.get(2), 
							(double)sender6_Array.get(1), 
							(double)sender6_Array.get(2), false, true)));
					
				
					
					double TravelTime_Sender3ToSender6 = Distance_Sender3ToSender6/vehicle_speed;
					
			
					System.out.println("Distance_Sender3ToSender6:"+ Distance_Sender3ToSender6);
					System.out.println("TravelTime_Sender3ToSender6:"+ TravelTime_Sender3ToSender6);
					
					if(TravelTime_Sender3ToSender6 < 1800) {
						System.out.println("sender6_Array passed");
						//conn.do_job_set(Vehicle.changeTarget("2", (String)sender4_Array.get(0)));
						
						v2_sender_TimeSchedule.add(690); //11:30
						Collections.sort(v2_sender_TimeSchedule);
						System.out.println("v2_sender_TimeSchedule:"+ v2_sender_TimeSchedule);
						
						v2_TimeToSenderInfo.put(690, sender6_Array);
						System.out.println("v2_TimeToSenderInfo:"+ v2_TimeToSenderInfo);
					
						System.out.println("CarsMapWithSchedule:"+ CarsMapWithSchedule);
					}
				}
				
				if(timeSeconds==6000.0) { // At 10:40, the car would leave from the sender5
					System.out.println("-----------------------------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					conn.do_job_set(Vehicle.changeTarget("2", (String)sender3_Array.get(0)));
					
					SumoStopFlags sf_v2 = new SumoStopFlags(false, false, false, false, false);
					
					conn.do_job_set(Vehicle.setStop("2", (String)sender3_Array.get(0) , 60.0, (byte)0, 1200.0, sf_v2));
					
					conn.do_job_set(Vehicle.resume("2"));
					//conn.do_job_set(Vehicle.changeTarget("2", (String)sender2_Array.get(0)));
				}
				
				if(timeSeconds==7800.0) { //At 11:10, the car would leave from the sender3
					System.out.println("-----------------------------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					conn.do_job_set(Vehicle.changeTarget("2", 
							(String)((ArrayList) v2_TimeToSenderInfo.get(690)).get(0)));
					
					SumoStopFlags sf_v2 = new SumoStopFlags(false, false, false, false, false);
					
					conn.do_job_set(Vehicle.setStop("2", 
							(String)((ArrayList) v2_TimeToSenderInfo.get(690)).get(0) , 
							(double)((ArrayList) v2_TimeToSenderInfo.get(690)).get(3), 
							(byte)0, 1200.0, sf_v2));
					
					conn.do_job_set(Vehicle.resume("2"));
				}
				
				if(timeSeconds==9600.0) { //At 11:40, the car the car would leave from the sender6 of NCKU
					
					
					System.out.println("-----------------------------------------------");
					System.out.println("timeSeconds:"+ timeSeconds);
					conn.do_job_set(Vehicle.changeTarget("2", gateway_EdgeID));
					
					SumoStopFlags sf_v2 = new SumoStopFlags(false, false, false, false, false);
					
					conn.do_job_set(Vehicle.setStop("2", 
							gateway_EdgeID , gateway_pos, (byte)0, 1200.0, sf_v2));
					
			
				
				}
				
				
				
				
				/*
				if(timeSeconds>2109.0 && timeSeconds<2183.0)  {
					System.out.println("timeSeconds:"+ timeSeconds);
					System.out.println("Distance_Sender2ToSender3:"+ Distance_Sender2ToSender3);
				
					conn.do_job_set(Vehicle.changeTarget("2", (String)sender3_Array.get(0)));
					//conn.do_job_set(Vehicle.changeTarget("2", "496257308#5"));
				}*/
	
			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
