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

import java.util.Calendar;
import java.text.SimpleDateFormat;

import it.polito.appeal.traci.SumoTraciConnection;
import sun.print.PSPrinterJob.PluginPrinter;
import de.tudresden.sumo.cmd.Simulation;
import de.tudresden.sumo.cmd.Vehicle;

import java.util.ArrayList;
import java.util.LinkedList;


import de.tudresden.sumo.cmd.Person;

import de.tudresden.ws.container.*;

public class Main {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	// static String config_file = "simulation_Tainan/map_from_flow.sumo.cfg";

	

	static String config_file = "simulation4/map.sumo.cfg";
	static double step_length = 0.01; // version1
	//static double step_length = 0.001;
	
	// �ϥΰ}�C�覡�ŧi���P�ϥΪ̪��s�u��T�A�����ɥH���̾ڧ��ܼ������
	static ArrayList<ClientInfo> clientInfos = new ArrayList<ClientInfo>();

	public static void main(String[] args) {
		
		// �}�� server thread �õ��ݨ�L�Ȥ�s�u
		//Thread server = new Server(clientInfos, );
		//server.start();

		// �i�J�������q

		try {
			
			// �إ�SUMO TraCI�s�u
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			
			conn.addOption("step-length", step_length + "");

			conn.addOption("start", "true"); // start sumo immediately

			// start Traci Server
			conn.runServer(7777);
			conn.setOrder(1);
			/////////////////////
			
			double minDistance=0;
			double min=0;
			
			String pickVeh="";
			ArrayList<Double> myList = new ArrayList();
			int isStopped=0;
			

			// �}�l������Үɶ�step
			for (int i = 0; i < 360000; i++) {
		
				double timeStep = (double) conn.do_job_get(Simulation.getTime());
				conn.do_timestep();
				
				if (i%10000==0) {
					//conn.do_job_set(Vehicle.addFull("v"+i, "r1", "routeByDistance", "now", "0", "0", "max", "current", "max", "current", "", "", "", 0, 0));
					// conn.do_job_set(Vehicle.add("v"+i, "routeByDistance", "r_test", i, 12.0, 7.0, (byte)0));
					
					
					//System.out.println(clientInfos.size());
					if (clientInfos.size() >0) {
						for (int j  = 0; j < clientInfos.size(); j++) {
							ClientInfo clientInfo = clientInfos.get(j);
							if (clientInfo.getRequestNo()==0) {
								double[] lnglat = new double[4];
								lnglat = clientInfo.getLatLng();
								int timeArrived = clientInfo.getTimeArrived();
							}
						}
						//System.out.println(conn.do_job_get(Simulation.convertRoad(lng, lat, true, "ignoring")));
						

						// SumoPositionRoadMap a =(SumoPositionRoadMap) conn.do_job_get(Simulation.convertRoad(lng, lat, true, "ignoring"));
						// System.out.println(a.edgeID);
						// System.out.println(a.laneIndex);
						// System.out.println(a.pos);
						
						//conn.do_job_set(Vehicle.addFull("v"+i, "r1", "car", "now", "0", "0", "max", "current", "max", "current", "", "", "", 0, 0));
					}
					//conn.do_job_set(Vehicle.addFull("v"+i, "r1", "car", "now", "0", "0", "max", "current", "max", "current", "", "", "", 0, 0));
						
				}
				
				// Initialize containerCapacity of all ten cars
				
				/*
				for(i=0;i<10;i++) {
					String vehID = Integer.toString(i);
					conn.do_job_set(Vehicle.setParameter(vehID, "containerCapacity","6"));
					String value = (String)conn.do_job_get(Vehicle.getParameter(vehID, "containerCapacity"));
					System.out.println("vehID:"+ vehID+ ",value:" + value);
				}
				*/
				
				
				// Initialize containerNumber of all ten cars
			 
				/*
				for(i=0;i<10;i++) {
					String vehID = Integer.toString(i);
					conn.do_job_set(Vehicle.setParameter(vehID, "containerNumber","0"));
					String value = (String)conn.do_job_get(Vehicle.getParameter(vehID, "containerNumber"));
					System.out.println("vehID:"+ vehID+ ",value:" + value);
				}
				*/
				
				
				if(timeStep %10==0) {
					/*
					SumoPosition2D v8_position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition("8"));
					SumoPosition2D v8_geo_position = (SumoPosition2D)conn.do_job_get(Simulation.convertGeo(v8_position.x, v8_position.y, false));
					System.out.println("timeStep:" + timeStep);
					System.out.println("v8_geo_position:" +v8_geo_position);
					*/
				}
				
				/** pick the car within min distance to the destination (10316, 5407)**/
				
				if(timeStep==20.0) {
					System.out.println("--------------------------------");
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Calendar calendar = Calendar.getInstance();
					System.out.println(formatter.format(calendar.getTime()));
					System.out.println("timeStep:"+ timeStep);
					
					for(int k=1;k<31;k++) {
						String vehID = Integer.toString(k);
						SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition(vehID));
						double eachDistance = (double)(conn.do_job_get(Simulation.getDistance2D(8465, 6338, veh_Position.x, veh_Position.y, false, true)));
						System.out.println(k+ "," + "eachDistance:" + eachDistance );
					
						myList.add(eachDistance);
						min = myList.get( 0);				
					
					}
					
					
					for(int j=0; j<30;j++) {
						if(myList.get(j)<min) {
							min =myList.get(j);
						}
					}
					
					
					System.out.println("min:"+ min);
					int a = myList.indexOf(min)+1;
					System.out.println("min car Index:"+ a);
					pickVeh = Integer.toString(a);
					
					
					conn.do_job_set(Vehicle.changeTarget("17", "-537706053#0"));
					SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop(pickVeh, "-537706053#0", 1.0, (byte)0, 50.0, sf));
					
					System.out.println("isStopped:"+ isStopped +" timeStep:"+ timeStep);
					isStopped = (Integer)conn.do_job_get(Vehicle.isStopped(pickVeh));
					
				}
				
				// got the request of sender
				if(timeStep>20.0) {
					SumoPosition2D currPos = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition(pickVeh));
					double currDistance = (double)(conn.do_job_get(Simulation.getDistance2D(8465, 6338,currPos.x, currPos.y,false, true )));
					
					if (currDistance<305.0 && currDistance>300.0) {
						System.out.println("The car would arrive to the sender's address within 300m");
					}
					
					isStopped = (Integer)conn.do_job_get(Vehicle.isStopped(pickVeh));
					
					if(isStopped==1) {
						System.out.println("Now the car arrived to the sender's address"+ " at timeStep:"+ timeStep);
						System.out.println("isStopped:"+ isStopped+ "timeStep:"+ timeStep);

						conn.do_job_set(Vehicle.changeTarget(pickVeh, "405115649"));
						SumoStopFlags sf_r = new SumoStopFlags(false, false, false, false, false);
						conn.do_job_set(Vehicle.setStop(pickVeh, "405115649", 1.0, (byte)0, 50.0, sf_r));
						
						if(timeStep==315.0) {
							conn.do_job_set(Vehicle.resume(pickVeh));
							isStopped = (Integer)conn.do_job_get(Vehicle.isStopped(pickVeh));
						}
					}
					
					/*
					while(isStopped==1) {
						// wait for the reply of receiver
						
						conn.do_job_set(Vehicle.changeTarget(pickVeh, "405115649"));
						SumoStopFlags sf_r = new SumoStopFlags(false, false, false, false, false);
						conn.do_job_set(Vehicle.setStop(pickVeh, "405115649", 1.0, (byte)0, 50.0, sf_r));
						
						if(timeStep==315.0) {
							conn.do_job_set(Vehicle.resume(pickVeh));
							isStopped = (Integer)conn.do_job_get(Vehicle.isStopped(pickVeh));
						}
					}
					*/
					
					//System.out.println("isStopped:"+ isStopped+ ",timeStep:"+ timeStep);
				}
				
				
				
			     
				
		
				/**  destination (10316, 5407) at 40s  **/
				if(timeStep==40.0) {
					
				
					
					SumoPosition2D v8Position = (SumoPosition2D) conn.do_job_get(Vehicle.getPosition("8"));
					
					SumoPosition2D v8_geo_position = (SumoPosition2D)conn.do_job_get(Simulation.convertGeo(v8Position.x, v8Position.y,false ));
					
					System.out.println("v8_geo_position:"+ v8_geo_position);
					
					/*
						System.out.println("--------------------------------");
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						Calendar calendar = Calendar.getInstance();
						System.out.println(formatter.format(calendar.getTime()));
						
						System.out.println("timeStep:"+ timeStep);
						for(int k=0;k<30;k++) {
							String vehID = Integer.toString(k);
							SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition(vehID));
							double eachDistance = (double)(conn.do_job_get(Simulation.getDistance2D(8465, 6338, veh_Position.x, veh_Position.y, false, true)));
							System.out.println(k+ "," + "eachDistance:" + eachDistance );
						
							myList.add(eachDistance);
						}
						
						// arrive within 5-10 mins at (v=10m/s)
						for(int j=0; j<30;j++) {
							if(3000< myList.get(j) && myList.get(j)<6000) {
								System.out.println(j+ " is the candidate car");
							}
						}
					
					*/
					
				}
				
				/**  60  **/
				
				if(timeStep==60.0) {
					
					/*
					System.out.println("--------------------------------");
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Calendar calendar = Calendar.getInstance();
					System.out.println(formatter.format(calendar.getTime()));
					
					System.out.println("timeStep:"+ timeStep);
					
					for(int k=0;k<30;k++) {
						String vehID = Integer.toString(k);
						SumoPosition2D veh_Position = (SumoPosition2D)conn.do_job_get(Vehicle.getPosition(vehID));
						double eachDistance = (double)(conn.do_job_get(Simulation.getDistance2D(8465, 6338, veh_Position.x, veh_Position.y, false, true)));
						System.out.println(k+ "," + "eachDistance:" + eachDistance );
					
						myList.add(eachDistance);
					}
					/*
					
					/*
					for(int j=0; j<30;j++) {
						if(1800< myList.get(j) && myList.get(j)<2400) {
							System.out.println(j+ " is the candidate car");
						}
					}*/
					
					//double a = (double)(conn.do_job_get(Simulation.getDistance2D(862.51, 1188.05, 8465, 6338, false, true)));
					// System.out.println("a:"+a);
					
					/*
					String fromEdge = "561954792#3";
					String toEdge = "-537706053#0";
					String vType ="truck"; // check vtype in rou.xml
					double depart = 60.0;
					int routingMode = 0;
					SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute(fromEdge, toEdge, vType, depart,routingMode));
					double TravelTimeToSender = stage.travelTime;
				
					double distance = (double)conn.do_job_get(Simulation.getDistanceRoad("561954792#3", 70.0, "-537706053#0", 0.0, true));
				
					System.out.println("distance:" + distance);
					System.out.println("TravelTimeToSender:" + TravelTimeToSender);
					conn.do_job_set(Vehicle.changeTarget("10", "-537706053#0"));
					*/
				
				}
		       
			
				
				if(timeStep%10==0) {
					//double v10_speed = (double)conn.do_job_get(Vehicle.getSpeed("10"));
					//System.out.println("v10_speed:" + v10_speed);
				}
				
				
				
				
			}
			
		
			
				
			conn.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}
	
}
