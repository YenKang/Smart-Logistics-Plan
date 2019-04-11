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

import de.tudresden.ws.ServiceImpl;
// import de.tudresden.ws.SumoWebservice;
import de.tudresden.ws.TraasWS;

public class Main {

	static String sumo_bin = "C:\\Program Files (x86)\\Eclipse\\Sumo\\bin\\sumo-gui.exe";
	//static String config_file = "simulation\\config.sumo.cfg";
	static String config_file = "C:\\Users\\yen\\Desktop\\src\\de\\tudresden\\ws\\simulation\\config.sumo.cfg";
	static double step_length = 0.01;		

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
			//System.out.println("test");
			if (i%1000==0) {
				ws.vehicleAdd("v"+i, "car", "r1", i, 0, 0.1, (byte) 1); //0.01 m/s
			
				//System.out.println("the person Number of v0"+ws.vehicleGetPersonNumber("v1000"));
				System.out.println(ws.vehicleGetLanePosition("v0"));
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
				System.out.println("-------------------------");


			}

	
		}
			
		ws.stop("user");
		
		
	}

}
