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
					
					/*
					System.out.println("------------convertGeo part-------------");
					System.out.println(conn.do_job_get(Simulation.convertGeo(3414.680, 5591.166, false )));// (x,y)=(3414.680, 5591.166)
					System.out.println(conn.do_job_get(Simulation.convertGeo(2466.06, 7243.26, false ))); // (x,y)=(2466.06, 2466.06)
					System.out.println(conn.do_job_get(Simulation.convertGeo(120.216228, 22.987473, true ))); //(lon, lat)=(120.216228, 22.987473)
					
					System.out.println("----------*******-------------");
					*/
					
					
					/*
					System.out.println("------------convert2D part-------------");
					System.out.println("convert2D('303466841', 0.0, (byte)0, false)");
					System.out.println(conn.do_job_get(Simulation.convert2D("303466841", 0.0, (byte)0, false)));
					System.out.println("convert2D('303466841', 0.0, (byte)0, true)");
					System.out.println(conn.do_job_get(Simulation.convert2D("303466841", 0.0, (byte)0, true)));
					*/
			
					
					System.out.println("------------convertRoad part-------------");
					System.out.println("convertRoad(2466.06, 7243.26, false, 'ignoring'))");
					System.out.println(conn.do_job_get(Simulation.convertRoad(2466.06, 7243.26, false, "ignoring")));
					Object j = conn.do_job_get(Simulation.convertRoad(2466.06, 7243.26, false, "ignoring"));
					System.out.println(j);
					
					System.out.println("convertRoad(4061.28, 5207.22, false, 'ignoring'))");
					System.out.println(conn.do_job_get(Simulation.convertRoad(4061.28, 5207.22, false, "ignoring")));
					System.out.println("-----------------------------");
					
					System.out.println("convertRoad(120.227524, 22.982570, true, 'ignoring'))");
					System.out.println(conn.do_job_get(Simulation.convertRoad(120.227524, 22.982570, true, "ignoring")));
					
				
					
					/*
					// getDistance2D & getDistanceRoad
					System.out.println("-------getDistance2D--------");
					// System.out.println(conn.do_job_get(Simulation.getDistance2D(3414.680, 5591.166, 2466.06, 2466.06, false, false)));
					// System.out.println(conn.do_job_get(Simulation.getDistance2D(3414.680, 5591.166, 2466.06, 2466.06, false, true)));
					System.out.println("-----------------------------");
					
					double startPosX = 4061.28;
					double startPosY = 5207.22;
					double endPosX = 2052.75;
					double endPosY = 6295.79;
					
					double startLon = 120.227524;
					double startLat = 22.982570;
					double endLon = 120.207748;
					double endLat = 22.992048;
					*/
					
					
					
					// System.out.println(conn.do_job_get(Simulation.getDistance2D(3414.680, 5591.166, 2466.06, 2466.06, false, false)));
					
					/*
					System.out.println("-------The Distance of non-geo in isdriving condition--------");
					System.out.println(conn.do_job_get(Simulation.getDistance2D(startPosX, startPosY, endPosX, endPosY, false, true)));
					System.out.println("-------The Distance of non-geo in non-isdriving condition--------");
					System.out.println(conn.do_job_get(Simulation.getDistance2D(startPosX, startPosY, endPosX, endPosY, false, false)));
					*/
					
					/*
					System.out.println("-------The Distance of [geo] in isdriving condition--------");
					System.out.println(conn.do_job_get(Simulation.getDistance2D(startLon, startLat, endLon, endLat, true, false)));

					System.out.println("-----------------------------------------------------");
					
					String startEdgeId = "307244665#2";
					String endEdgeId = "496332196#1";
					double pos1 = 0.0;
					double pos2 = 0.0;
					System.out.println("-------The [driving] Distance of [startEdge to endEdge]--------");
					System.out.println(conn.do_job_get(Simulation.getDistanceRoad(startEdgeId, pos1, endEdgeId, pos2, false)));
					System.out.println("-------The [air] Distance of [startEdge to endEdge] --------");
					System.out.println(conn.do_job_get(Simulation.getDistanceRoad(startEdgeId, pos1, endEdgeId, pos2, true)));
					*/
					
					/*  findRoute 
					System.out.println("---------------findRoute-----------------");
					String fromEdge = "307244665#2";
				    String toEdge = "496332196#1";
				    String vType = "routeByDistance";
				    double depart = 40;
				    int routingMode = 0;
					System.out.println(conn.do_job_get(Simulation.findRoute(fromEdge, toEdge, vType, depart, routingMode)));
					*/
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
