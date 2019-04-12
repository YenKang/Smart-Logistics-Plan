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
import java.util.List;
import java.lang.*;

import de.tudresden.ws.ServiceImpl;
// import de.tudresden.ws.SumoWebservice;
import de.tudresden.ws.TraasWS;

public class Main {

	static String sumo_bin = "C:\\Program Files (x86)\\Eclipse\\Sumo\\bin\\sumo-gui.exe";
	//static String config_file = "simulation\\config.sumo.cfg";
	static String config_file = "C:\\Users\\yen\\Desktop\\src\\de\\tudresden\\ws\\simulation\\config.sumo.cfg";
	static double step_length = 0.01;
	
	public static byte intToByte(int x) {
		return (byte) x;
	}


	public static void main(String[] args) {
		//Start your webservice with the bash or the cmd!
		ServiceImpl ws = new TraasWS().getServiceImplPort();
		//optional
		
		ws.setSumoBinary(sumo_bin);
		ws.setConfig(config_file);
		
			
		ws.addOption("start", "");
		ws.addOption("step-length", step_length+"");
		ws.start("user");
			
		for(int i=0; i<360000; i++){
				
			ws.doTimestep();
			
			if (i%1000==0) {
				ws.vehicleAdd("v"+i, "car", "r1", i, 0, 0.1, (byte) 1); //0.01 m/s
			
				//System.out.println("the person Number of v0"+ws.vehicleGetPersonNumber("v1000"));
				int simTime = ws.simulationGetCurrentTime(); // [in ms]
				System.out.println("simulation time:"+ simTime/1000 + "s");
				
				int stopStartCarNum = ws.simulationGetStopStartingVehiclesNumber();
				int stopEndCarNum =  ws.simulationGetStopEndingVehiclesNumber();
				System.out.println("the number of halted cars on the stop:"+ stopStartCarNum);
				System.out.println("the number of leaved cars on the stop:"+ stopEndCarNum);
				
				int a= ws.vehicleGetLaneIndex("v0");
				System.out.println("LaneIndex(int):"+a);
				
				byte byte0 = intToByte(a);
				System.out.println("byte0=" + byte0);
	
				//List<String> test = ws.simulationConvert2D("gneE0", 300, byte0, "true");
				//System.out.println("simulationConvert2D:"+test);
				
				
				System.out.println("LANE POSITION:"+ ws.vehicleGetLanePosition("v0"));
				double v0_X=ws.vehicleGetPosition("v0").getX();
				double v0_Y=ws.vehicleGetPosition("v0").getY();
				System.out.println("v0 position:"+ "(X:"+v0_X+ ", Y:"+ v0_Y+")");
				double v0_travalDistance = ws.vehicleGetDistance("v0"); // unit is m
				System.out.println("Traveling Distance of v0:"+ v0_travalDistance);
				
				String v0_roadID = ws.vehicleGetRoadID("v0");
				System.out.println("road id of v0:"+ v0_roadID);
				
				String v0_routeID = ws.vehicleGetRouteID("v0");
				System.out.println("route id of v0:"+ v0_routeID);

				//System.out.println(a);
				//stringList v0_edges = ws.vehicleGetRoute("v0");
				List<String> v0_edges = ws.vehicleGetRoute("v0");
				System.out.println("edges of v0:"+ v0_edges);
				
				double offset_X=ws.guiGetOffset("View #0").getX();
				double offset_Y=ws.guiGetOffset("View #0").getY();
				System.out.println("offset_x:"+ offset_X);
				System.out.println("offset_y:"+ offset_Y);
				System.out.println("-----------------------------------------------");


			}

	
		}
			
		ws.stop("user");
		
		
	}

}
