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



public class Main0506 {


	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	// static String config_file = "simulation_Tainan/map_from_flow.sumo.cfg";

	

	static String config_file = "simulation3/map_edited.sumo.cfg";
	static double step_length = 0.01; // version1
	//static double step_length = 0.001;
	
	// �ϥΰ}�C�覡�ŧi���P�ϥΪ̪��s�u��T�A�����ɥH���̾ڧ��ܼ������
	static ArrayList<ClientInfo> clientInfos = new ArrayList<ClientInfo>();
	static int assignSuccess = 0;

	public static void main(String[] args) {
		
		// �}�� server thread �õ��ݨ�L�Ȥ�s�u
		Thread server = new Server(clientInfos, assignSuccess);
		server.start();

		// �i�J�������q

		try {
			
			// �إ�SUMO TraCI�s�u
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			
			conn.addOption("step-length", step_length + "");

			conn.addOption("start", "true"); // start sumo immediately

			// start Traci Server
			conn.runServer(7788);
			conn.setOrder(1);
			/////////////////////
			
			double minDistance=0;
			double min=0;
			double timeStep;
			ArrayList<Double> myList = new ArrayList();

			// �}�l������Үɶ�step
			for (int i = 0; i < 360000; i++) {
				timeStep = (double) conn.do_job_get(Simulation.getTime());
				System.out.println(timeStep);
				conn.do_timestep();
				
				if (i == 1000) {
					JDBC_AVD init_truck = new JDBC_AVD();
					
					for (int j = 1; j<31; j++) {
						SumoPosition2D vPosition = (SumoPosition2D) conn.do_job_get(Vehicle.getPosition(Integer.toString( j )));
						SumoPosition2D v_geo_position = (SumoPosition2D)conn.do_job_get(Simulation.convertGeo(vPosition.x, vPosition.y,false ));
						double x = v_geo_position.x;
						double y = v_geo_position.y;
						double speed = (double)conn.do_job_get(Vehicle.getSpeed(Integer.toString(j)));
						init_truck.insertVehicle(Integer.toString(j), x, y, speed);
						System.out.println(x+y);
					}
					
					//init_truck.insertVehicle(truck_No, lat_now, lng_now, speed);
					for (int j = 1; j<31; j++ ) {
						for (int k = 1; k<4; k++) {
							init_truck.insertContainer("c"+j+"-"+k, 0, "0", j);
						}
						for (int k = 4 ; k<7; k++) {
							init_truck.insertContainer("c"+j+"-"+k, 1, "0", j);
						}
						for (int k = 7 ; k<10; k++) {
							init_truck.insertContainer("c"+j+"-"+k, 2, "0", j);
						}
					}
				}
				
				if (i%100==0) {
					// �ˬd�O�_���ϥΪ̳s�u�i��
					if (clientInfos.size() >0) {
						//System.out.println(clientInfos.size());
						for (int j  = 0; j < clientInfos.size(); j++) {
							ClientInfo clientInfo = clientInfos.get(j);
							if (clientInfo.getRequestNo()==0) {
								double[] lnglat = new double[4];
								lnglat = clientInfo.getLatLng();
								int timeArrived = clientInfo.getTimeArrived();
								clientInfo.assignTest = 5;
								//System.out.println(assignSuccess);
							}
						}
						//System.out.println(conn.do_job_get(Simulation.convertRoad(lng, lat, true, "ignoring")));
						//SumoPositionRoadMap a =(SumoPositionRoadMap) conn.do_job_get(Simulation.convertRoad(lng, lat, true, "ignoring"));
						//System.out.println(a.edgeID);
						//System.out.println(a.laneIndex);
						//System.out.println(a.pos);
						//conn.do_job_set(Vehicle.addFull("v"+i, "r1", "car", "now", "0", "0", "max", "current", "max", "current", "", "", "", 0, 0));
					}
				}			
			}		
			conn.close(); 
		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}
	
}
