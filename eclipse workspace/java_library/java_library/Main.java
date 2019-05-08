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
	static String config_file = "simulation3/map_edited.sumo.cfg";
	// static double step_length = 0.01; // version1
	static double step_length = 0.001;
	
	// �ϥΰ}�C�覡�ŧi���P�ϥΪ̪��s�u��T�A�����ɥH���̾ڧ��ܼ�������
	static ArrayList<ClientInfo> clientInfos = new ArrayList<ClientInfo>();

	public static void main(String[] args) {
		
		// �}�� server thread �õ��ݨ�L�Ȥ�s�u
		Thread server = new Server(clientInfos);
		server.start();

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
			
			// �}�l�������Үɶ�step
			for (int i = 0; i < 360000; i++) {
				conn.do_timestep();
				
				if (i%6000==0) {
					// �ˬd�O�_���ϥΪ̳s�u�i��
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
						//SumoPositionRoadMap a =(SumoPositionRoadMap) conn.do_job_get(Simulation.convertRoad(lng, lat, true, "ignoring"));
						//System.out.println(a.edgeID);
						//System.out.println(a.laneIndex);
						//System.out.println(a.pos);
						//conn.do_job_set(Vehicle.addFull("v"+i, "r1", "car", "now", "0", "0", "max", "current", "max", "current", "", "", "", 0, 0));
					}
				}
			}
			
			/*
			SumoStopFlags sf_send = new SumoStopFlags(false, false, false, false, false);
			SumoStopFlags sf_rec = new SumoStopFlags(false, false, false, false, false);
			*/

			
				
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
