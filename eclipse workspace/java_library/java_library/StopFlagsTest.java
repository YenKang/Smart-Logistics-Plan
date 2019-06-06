
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;

import de.tudresden.ws.container.*;

public class StopFlagsTest {
	static String sumo_bin = "sumo-gui";
	static String config_file = "simulation4/map.sumo.cfg";
	static double step_length = 0.01;
	
	public static void main(String[] args) {
		try {
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			conn.addOption("step-length", step_length + "");
			conn.addOption("start", "true"); // start sumo immediately
			// start Traci Server
			conn.runServer(8080);
			conn.setOrder(1);
			double vehicle_speed = 4.0; //4 [m/s]	
			// 模擬開始
			for (int i = 0; i < 360000000; i++) {
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());			
				if(timeSeconds==100.0) {
					String edge1 = "41389174#2";
					double pos1 = 10.0;
					double until_1 = 500.0;
					SumoStopFlags sf1 = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop("1", edge1 , pos1, (byte)0,  0.0,  sf1, pos1, until_1));
				}				
				if(timeSeconds==150.0) {
					/*String edge1 = "41389174#2";
					double pos1 = 10.0;
					double until_1 = 500.0;
					SumoStopFlags sf1 = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop("1", edge1 , pos1, (byte)0,  0.0,  sf1, pos1, until_1));*/
										
					String edge2 = "304973679#2";
					double pos2 = 5.4;
					double until_2 = 800.0;
					SumoStopFlags sf1 = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop("1", edge2 , pos2, (byte)0,  0.0,  sf1, pos2, until_2));
				}			
				if(timeSeconds==200.0) {
					/*String edge1 = "41389174#2";
					double pos1 = 10.0;
					double until_1 = 500.0;
					SumoStopFlags sf1 = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop("1", edge1 , pos1, (byte)0,  0.0,  sf1, pos1, until_1));
					
					String edge2 = "304973679#2";
					double pos2 = 5.4;
					double until_2 = 800.0;
					SumoStopFlags sf2 = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop("1", edge2 , pos2, (byte)0,  0.0,  sf2, pos2, until_2));*/
					
					String edge3 = "227913938#0";
					double pos3 = 10.4;
					double until_3 = 1200.0;
					SumoStopFlags sf3 = new SumoStopFlags(false, false, false, false, false); 
				    conn.do_job_set(Vehicle.setStop("1", edge3 , pos3, (byte)0,  0.0,  sf3, pos3, until_3));

				}
				if(timeSeconds==300.0){
					String edge2 = "304973679#2";
					double pos2 = 5.4;
					double until_2 = 800.0;
					SumoStopFlags sf2 = new SumoStopFlags(false, false, false, false, false);
					conn.do_job_set(Vehicle.setStop("1", edge2 , pos2, (byte)0,  0.0,  sf2, pos2, until_2));
				}
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

