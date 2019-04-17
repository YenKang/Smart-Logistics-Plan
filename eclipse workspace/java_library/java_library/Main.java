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
import de.tudresden.sumo.cmd.Inductionloop;
import de.tudresden.sumo.cmd.Trafficlight;
import de.tudresden.ws.container.SumoVehicleData;
import de.tudresden.ws.container.*;

public class Main {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	static String config_file = "simulation_Tainan/map_from_flow.sumo.cfg";
	// static double step_length = 0.01; // version1
	static double step_length = 0.01;		

	public static void main(String[] args) {
			
		try{	
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			conn.addOption("step-length", step_length+"");
			conn.addOption("start", "true"); //start sumo immediately
		
			//start Traci Server
			conn.runServer(8080);
            conn.setOrder(1);
			
			for(int i=0; i<360000; i++){
				
				conn.do_timestep();
				
				
				if(i%1000==0) {
					//conn.do_job_set(Vehicle.addFull("v"+i, "r1", "car", "now", "0", "0", "max", "current", "max", "current", "", "", "", 0, 0));
				}
				
				double timeSeconds = (double)conn.do_job_get(Simulation.getTime());
				
				System.out.println("timeSeconds:"+ timeSeconds);
				if(timeSeconds%1==0) {
					System.out.println("-----------------------------");
					System.out.println(conn.do_job_get(Simulation.convertGeo(3414.680, 5591.166, false )));
					System.out.println(conn.do_job_get(Simulation.convertGeo(120.216228, 22.987473, true )));
					System.out.println("----------*******-------------");
					
					System.out.println(conn.do_job_get(Simulation.convert2D("303466841", 0.0, (byte)0, false)));
					//System.out.println(conn.do_job_get(Simulation.convertRoad(3414.680, 5591.166, false, "ignoring")));
				

				
				}
				
				if(timeSeconds==60) {
					//System.out.println("LaneIndex:"+ conn.do_job_get(Vehicle.getLaneIndex("v4000")));
				}
				
				
				//System.out.println("LaneIndex:"+ conn.do_job_get(Vehicle.getLaneIndex("v4000")));
		
				//SumoStopFlags sf = new SumoStopFlags(false, false, false, false, false);
				//System.out.println("SumoStopFlags sf:"+ sf);
				
				Double pos = new Double(400.0);  
				byte landIndex = (byte) 0;
				
				if(timeSeconds==60) {
					System.out.println("-------------------------------------------------------");
					//System.out.println(conn.do_job_get(Vehicle.getPosition("v4000")));
					//conn.do_job_get(Simulation.convertRoad(x, y, isGeo));
					//conn.do_job_set(Vehicle.setStop("v4000", "gneE0", pos, landIndex, 10.0, sf));
					System.out.println("vehicle setStop");
					
					double input_x = 240.52040797546346;
					double input_y = -4.8;
					
					// System.out.println(conn.do_job_get(Simulation.convertRoad(240.5204, -4.8, "false")));
				
					// System.out.println(conn.do_job_get(Simulation.convertRoad(240.5204, -4.8, "False")));
					// System.out.println("*Simulation.convert2D(\"gneE0\", 400.0, (byte) 0 , \"false\")*");
					
					// System.out.println(conn.do_job_get(Simulation.convert2D("gneE0", 400.0, (byte) 0 , "POSITION_2D")));
					
					System.out.println("**********************");
					// System.out.println(conn.do_job_get(Simulation.getArrivedNumber()));
					//System.out.println("SumoStopFlags sf:"+ sf);
				}
				
		
			
				
                //int tlsPhase = (int)conn.do_job_get(Trafficlight.getPhase("gneJ1"));
                //String tlsPhaseName = (String)conn.do_job_get(Trafficlight.getPhaseName("gneJ1"));
                //System.out.println(String.format("Step %s, tlsPhase %s (%s)", timeSeconds, tlsPhase, tlsPhaseName));
		
				/*
                SumoVehicleData vehData = (SumoVehicleData)conn.do_job_get(Inductionloop.getVehicleData("loop1"));
                for (SumoVehicleData.VehicleData d : vehData.ll) {
                    System.out.println(String.format("  veh=%s len=%s entry=%s leave=%s type=%s", d.vehID, d.length, d.entry_time, d.leave_time, d.typeID));
                }
                */
			}
			conn.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
	}

}
