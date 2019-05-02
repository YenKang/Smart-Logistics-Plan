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

import java.util.LinkedList;

import de.tudresden.sumo.cmd.Inductionloop;
import de.tudresden.sumo.cmd.Person;
import de.tudresden.sumo.cmd.Trafficlight;
import de.tudresden.ws.container.*;

public class Main {

	static String sumo_bin = "sumo-gui";
	// static String config_file = "simulation/map.sumo.cfg";
	   static String config_file = "simulation_Tainan/map_from_flow.sumo.cfg";
	// static String config_file = "simulation3/map_edited.sumo.cfg";
	// static double step_length = 0.01; // version1

	static double step_length = 0.01;

	public static void main(String[] args) {

		try {
			SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
			conn.addOption("step-length", step_length + "");
			conn.addOption("start", "true"); // start sumo immediately

			
			// start Traci Server
			conn.runServer(8080);
			conn.setOrder(1);
			
			SumoStopFlags sf_rec = new SumoStopFlags(false, false, false, false, false);

			for (int i = 0; i < 360000; i++) {
				conn.do_timestep();
				double timeSeconds = (double) conn.do_job_get(Simulation.getTime());
				
				double sender_x = 3003.22;
				double sender_y = 6763.46;
				String senderEdge = "-537706053#2";
				
				
				if(timeSeconds % 1==0) 
				{
					
					/*
					String curEdge = (String)conn.do_job_get(Vehicle.getRoadID("8")); // String vehID
					SumoPosition2D v8Position = (SumoPosition2D) conn.do_job_get(Vehicle.getPosition("8"));
					SumoPosition2D v9Position = (SumoPosition2D) conn.do_job_get(Vehicle.getPosition("9"));
					
					System.out.println("current edgeID is:" + curEdge + " in " + timeSeconds + " seconds");
					System.out.println("current position is:" + v8Position);
					System.out.println("current position x:" + v8Position.x + " y:" + v8Position.y + " in " + timeSeconds + " seconds");
		
					double v8toSenderDistance = (double)(conn.do_job_get(Simulation.getDistance2D(sender_x, sender_y, v8Position.x, v8Position.y, false, false)));
					System.out.println("current distance between v8 to sender is:" + v8toSenderDistance);
					
					double v9toSenderDistance = (double)(conn.do_job_get(Simulation.getDistance2D(sender_x, sender_y, v9Position.x, v9Position.y, false, false)));
					System.out.println("current distance between v9 to sender is:" + v9toSenderDistance);
					*/
					
					/*
					
					if((v9toSenderDistance< v8toSenderDistance) && timeSeconds==60.0 ) {
						System.out.println("we dispath v9 to the sender address!");
					}
					
					else if(v9toSenderDistance > v8toSenderDistance && (timeSeconds==60.0)) 
					{
						System.out.println("we dispath v8 to the sender address!");
						System.out.println("Default Route:");
						SumoStringList edgeList = (SumoStringList)conn.do_job_get(Vehicle.getRoute("8"));
						LinkedList<String> defaultRouteList = new LinkedList<String>(); 
						
						for(i=0; i<edgeList.size(); i++) {
							defaultRouteList.add(edgeList.get(i));
						}
						System.out.println("defaultRouteList:"+ defaultRouteList);
						
						conn.do_job_set(Vehicle.changeTarget("8", senderEdge));
						
						System.out.println("changing Route:");
						SumoStringList new_edgeList = (SumoStringList)conn.do_job_get(Vehicle.getRoute("8"));
						LinkedList<String> changedRouteList = new LinkedList<String>(); 
						
						for(i=0; i<new_edgeList.size(); i++) {
							changedRouteList.add(new_edgeList.get(i));
						}
						System.out.println("changedRouteList:"+ changedRouteList);
						
						String fromEdge = curEdge;
						String toEdge = senderEdge;
						String vType ="routeByDistance"; 
						double depart = 60.0; 
						int routingMode = 0;
						SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute(fromEdge, toEdge, vType, depart,routingMode));
						double TravelTimeToSender = stage.travelTime;
						
						System.out.println("We need "+ TravelTimeToSender+" s from current edge to sender address");
						
						SumoStopFlags sf_send = new SumoStopFlags(false, false, false, false, false);
						// conn.do_job_set(Vehicle.setStop(vehID, edgeID, pos, laneIndex, duration, sf));
						
						 conn.do_job_set(Vehicle.setContainerStop("8", "senderAddr_stop", 20.0, 100));
						
						//conn.do_job_set(Vehicle.setStop("8", senderEdge, 0, (byte)0, 20.0, sf_send ));
				
				
				    }
				    /*
					

					if(timeSeconds==212.00) {
						
						String receiverEdge = "486363286#0";
						
						conn.do_job_set(Vehicle.changeTarget("8", receiverEdge));
						
						
						//SumoStopFlags sf_rec = new SumoStopFlags(false, false, false, false, false);
			
						
						//conn.do_job_set(Vehicle.setStop("8", receiverEdge, 0.0, (byte)0, 20.0, sf_rec ));
						
						
					}
					
					
					--------------------------------------------------------------------------------------------------------
					
					
					/*
					if(timeSeconds==130.0) {
						String fromEdge = curEdge;
						String toEdge = "160253722#3";
						String vType ="routeByDistance"; 
						double depart = 60.0; 
						int routingMode = 0;
						SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute(fromEdge, toEdge, vType, depart,routingMode));
						LinkedList<String> newRoute = new LinkedList<String>(); 
						
						for (String eadge :stage.edges){ 
							newRoute.add(eadge); 
						}
						
						System.out.println("newRoute:"+ newRoute);
						System.out.println("Trave time in the new route:"+ stage.travelTime);
						System.out.println("Default Route:");
						SumoStringList edgeList = (SumoStringList)conn.do_job_get(Vehicle.getRoute("flow0.0"));
						LinkedList<String> getRouteList = new LinkedList<String>(); 
						
						for(i=0; i<edgeList.size(); i++) {
							getRouteList.add(edgeList.get(i));
						}
						System.out.println("getRouteList:"+ getRouteList);
						conn.do_job_set(Vehicle.setRoute("flow0.0", stage.edges));
						System.out.println("Changed Route:");
						SumoStringList changedEdgeList = (SumoStringList)conn.do_job_get(Vehicle.getRoute("flow0.0"));
						LinkedList<String> changedRouteList = new LinkedList<String>();
						for(i=0; i<changedEdgeList.size(); i++) {
							changedRouteList.add(changedEdgeList.get(i));
						}
						System.out.println("changedRouteList:"+ changedRouteList);	
					}
					*/
				}
				
				if(timeSeconds==137.00) {
					
					//String curEdge = (String)conn.do_job_get(Vehicle.getRoadID("flow0.0"));
					//System.out.println("current edgeID is:" + curEdge );
				}

				/*
				 * String fromEdge = "307244665#4"; String toEdge = "31794904#2"; 
				 * String vType ="routeByDistance"; 
				 * double depart = 60.0; 
				 * int routingMode = 0;
				 * 
				 * //System.out.println(conn.do_job_get(Simulation.findRoute(fromEdge, toEdge,
				 * vType, depart, routingMode))); 
				 * 
				 * SumoStage stage = (SumoStage)
				 * conn.do_job_get(Simulation.findRoute(fromEdge, toEdge, vType, depart,
				 * routingMode));
				 * 
				 * System.out.println("findRoute result stage:"); for (String s : stage.edges) {
				 * System.out.println("  " + s); }
				 */

				/*
				 * System.out.println("stage:"+ stage); 
				 * System.out.println("stage.edges:"+
				 * stage.edges); 
				 * System.out.println("stage.edges.get(0):"+ stage.edges.get(0));
				 * 
				 * LinkedList<String> newRoute = new LinkedList<String>(); 
				 * for (String eadge :stage.edges){ newRoute.add(eadge); } 
				 * 
				 * System.out.println("newRoute:"+
				 * newRoute);
				 */

				// conn.do_job_srt(Vehicle.add(vehID, typeID, routeID, depart, pos, speed,
				// lane));

			
				
				
				if (timeSeconds == 90.0) {
					String senderEdgeID = "160253722#1";
					System.out.println("The roadID of flow0.0 at 90s is:");

					// System.out.println(conn.do_job_get(Vehicle.getRoadID("flow0.0")));
					conn.do_job_set(Vehicle.changeTarget("flow0.0", senderEdgeID));
					System.out.println("after Vehicle.changeTarget");
					
					SumoStopFlags sf_send = new SumoStopFlags(false, false, false, false, false);
					double duration = 20.0;
					conn.do_job_set(Vehicle.setStop("flow0.0", senderEdgeID, 1.0, (byte) 1, duration, sf_send));
				}
				
				
				String currentEdge = (String)conn.do_job_get(Vehicle.getRoadID("flow0.0"));
				int personNum = (Integer)conn.do_job_get(Vehicle.getPersonNumber("flow0.0"));
				
				if(timeSeconds==190.0) {
					String testPersonID = "ffw";
					String TestEdgeID = "160253722#1";
					double testPos = 1.0;
					double testDepart = timeSeconds;
					String testTypeID = "DEFAULT_PEDTYPE";
					
					conn.do_job_set(Person.add(testPersonID, TestEdgeID, testPos, testDepart, testTypeID));
					
					
					SumoColor curColor = new SumoColor(256, 0 ,0 ,0);
					
					conn.do_job_set(Person.setColor("ffw", curColor));
					
					
					System.out.println("personNum:" + personNum + " in " + timeSeconds+ " seconds" );
				
					//System.out.print(conn.do_job_get(Person.getPosition("ffw")));
					//String stopID = "containerStop1";
					
					//conn.do_job_set(Person.appendWaitingStage(testPersonID, 20, "waiting", stopID));
								
				}
				
				if(timeSeconds ==213) {
					//SumoPosition2D position = (SumoPosition2D)conn.do_job_get(Person.getPosition("ffw"));
					//System.out.print("person position:" + position);
					
					personNum = personNum +1;
					System.out.println("personNum:" + personNum + " in " + timeSeconds + " seconds");
				}
				
				
				
				if (timeSeconds == 214.0) {
					
					String receiverEdgeID = "-279032146#1";
					conn.do_job_set(Vehicle.changeTarget("flow0.0", receiverEdgeID));

					

					double duration = 20.0;
					conn.do_job_set(Vehicle.setStop("flow0.0", receiverEdgeID, 1.0, (byte) 0, duration, sf_rec));
				
				}
				
				if(sf_rec.triggered) {
					System.out.print("triggered is true" + " in " + timeSeconds);
					personNum = personNum -1;
					System.out.println("personNum:" + personNum + " in " + timeSeconds );
	
				}
				
				String curEdge = (String)conn.do_job_get(Vehicle.getRoadID("flow0.0"));
				
				
				if(curEdge.equals("-279032146#1")) 
				{
				    personNum = personNum -1;
					System.out.print("personNum:" + personNum + " in " + timeSeconds );
					
				}
				
				

				if (i % 1 == 0) {

					//conn.do_job_set(Vehicle.addFull("v"+i, "r1", "car", "now", "0", "0", "max",
					// "current", "max", "current", "", "", "", 0, 0));
					

				
				}

				// System.out.println("timeSeconds:"+ timeSeconds);

				if (timeSeconds % 1 == 0) {
					// System.out.println("The roadID of flow0.0 now is:");
					// System.out.println(conn.do_job_get(Vehicle.getRoadID("flow0.0")));

					/*
					 * System.out.println("getRoute('flow0.0')"); 
					 * SumoStringList K= (SumoStringList) conn.do_job_get(Vehicle.getRoute("flow0.0")); 
					 * //String asd[] = K
					 * System.out.println(K.get(2));
					 */
					
					/*
					 System.out.println("------------convertGeo part-------------");
					 System.out.println(conn.do_job_get(Simulation.convertGeo(3414.680, 5591.166, false)));// (x,y)=(3414.680,
																											// 5591.166)
					 // System.out.println(conn.do_job_get(Simulation.convertGeo(2466.06, 7243.26,
					 // false ))); // (x,y)=(2466.06, 2466.06)
					 System.out.println(conn.do_job_get(Simulation.convertGeo(120.22021170569616, 23.031769661295733, true))); //
					 System.out.println("----------*******-----------------------");
					*/
					
					 /*
					 System.out.println("---------------findRoute-----------------"); 
					 String fromEdge = "307244665#4"; 
					 String toEdge = "-298597679#1"; 
					 String vType = "routeByDistance"; 
					 double depart = 60.0; 
					 int routingMode = 0;
					 */
					 
					 /*
					 System.out.println(conn.do_job_get(Simulation.findRoute(fromEdge, toEdge,vType, depart, routingMode))); 
					 SumoStage stage = (SumoStage)conn.do_job_get(Simulation.findRoute(fromEdge, toEdge, vType, depart, routingMode)); 
					 System.out.println(stage.travelTime);
					 */	

					// SumoStringList KKKK = KKK.edges;
					// System.out.println(KKKK.get(0));

					/*
					 * System.out.println("------------convert2D part-------------");
					 * System.out.println("convert2D('-537706053#2', 0.0, (byte)0, false)");
					 * System.out.println(conn.do_job_get(Simulation.convert2D("-537706053#2", 0.0,
					 * (byte)0, false)));
					 */

					// System.out.println("convert2D('313194758#1', 0.0, (byte)0, true)");
					// System.out.println(conn.do_job_get(Simulation.convert2D("313194758#1", 0,
					// (byte)0, false)));

					// System.out.println(" ");
					// System.out.println(" ");

					/*
					 * System.out.println("------------convertRoad part-------------");
					 * System.out.println("convertRoad(2989.02, 6765.41, false, 'ignoring'))");
					 * System.out.println(conn.do_job_get(Simulation.convertRoad(2989.02, 6765.41,
					 * false, "ignoring")));
					 */

					/*
					 * System.out.println("convertRoad(4061.28, 5207.22, false, 'ignoring'))");
					 * System.out.println(conn.do_job_get(Simulation.convertRoad(4061.28, 5207.22,
					 * false, "ignoring"))); System.out.println("-----------------------------");
					 * 
					 * System.out.println("convertRoad(120.227524, 22.982570, true, 'ignoring'))");
					 * System.out.println(conn.do_job_get(Simulation.convertRoad(120.227524,
					 * 22.982570, true, "ignoring")));
					 */

					/*
					 * // getDistance2D & getDistanceRoad
					 * System.out.println("-------getDistance2D--------"); //
					 * System.out.println(conn.do_job_get(Simulation.getDistance2D(3414.680,
					 * 5591.166, 2466.06, 2466.06, false, false))); //
					 * System.out.println(conn.do_job_get(Simulation.getDistance2D(3414.680,
					 * 5591.166, 2466.06, 2466.06, false, true)));
					 * System.out.println("-----------------------------");
					 * 
					 * double startPosX = 4061.28; double startPosY = 5207.22; double endPosX =
					 * 2052.75; double endPosY = 6295.79; double startLon = 120.227524; double
					 * startLat = 22.982570; double endLon = 120.207748; double endLat = 22.992048;
					 * 
					 * // System.out.println(conn.do_job_get(Simulation.getDistance2D(3414.680,
					 * 5591.166, 2466.06, 2466.06, false, false)));
					 * 
					 * System.out.
					 * println("-------The Distance of non-geo in isdriving condition--------");
					 * System.out.println(conn.do_job_get(Simulation.getDistance2D(startPosX,
					 * startPosY, endPosX, endPosY, false, true))); System.out.
					 * println("-------The Distance of non-geo in non-isdriving condition--------");
					 * System.out.println(conn.do_job_get(Simulation.getDistance2D(startPosX,
					 * startPosY, endPosX, endPosY, false, false))); System.out.
					 * println("-------The Distance of [geo] in isdriving condition--------");
					 */

					/*
					 * //System.out.println(conn.do_job_get(Simulation.getDistance2D(startLon,
					 * startLat, endLon, endLat, true, false)));
					 * 
					 * System.out.println("------------------getDistanceRoad-----------------------"
					 * ); String startEdgeId = "307244665#2"; String endEdgeId = "496332196#1";
					 * double pos1 = 0.0; double pos2 = 0.0; System.out.
					 * println("-------The [driving] Distance of [startEdge to endEdge]--------");
					 * System.out.println(conn.do_job_get(Simulation.getDistanceRoad(startEdgeId,
					 * pos1, endEdgeId, pos2, false))); System.out.
					 * println("-------The [air] Distance of [startEdge to endEdge] --------");
					 * System.out.println(conn.do_job_get(Simulation.getDistanceRoad(startEdgeId,
					 * pos1, endEdgeId, pos2, true)));
					 */

					/*
					 * // findRoute System.out.println("---------------findRoute-----------------");
					 * String fromEdge = "307244665#2"; String toEdge = "496332196#1"; String vType
					 * = "routeByDistance"; double depart = 40; int routingMode = 0;
					 * System.out.println(conn.do_job_get(Simulation.findRoute(fromEdge, toEdge,
					 * vType, depart, routingMode)));
					 */
				}

			

				// int tlsPhase = (int)conn.do_job_get(Trafficlight.getPhase("gneJ1"));
				// String tlsPhaseName =
				// (String)conn.do_job_get(Trafficlight.getPhaseName("gneJ1"));
				// System.out.println(String.format("Step %s, tlsPhase %s (%s)", timeSeconds,
				// tlsPhase, tlsPhaseName));

				/*
				 * SumoVehicleData vehData =
				 * (SumoVehicleData)conn.do_job_get(Inductionloop.getVehicleData("loop1")); for
				 * (SumoVehicleData.VehicleData d : vehData.ll) {
				 * System.out.println(String.format("  veh=%s len=%s entry=%s leave=%s type=%s",
				 * d.vehID, d.length, d.entry_time, d.leave_time, d.typeID)); }
				 */
			}
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
