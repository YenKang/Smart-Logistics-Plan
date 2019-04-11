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
import de.tudresden.ws.ServiceImpl;
// import de.tudresden.ws.SumoWebservice;
import de.tudresden.ws.TraasWS;

public class Main {

	static String sumo_bin = "C:\\Program Files (x86)\\Eclipse\\Sumo\\bin\\sumo-gui.exe";
	static String config_file = "simulation\\config.sumo.cfg";
	//static String config_file = "C:\\Users\\yen\\Desktop\\src\\de\\tudresden\\ws\\simulation\\config.sumo.cfg";
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
			
		for(int i=0; i<3600; i++){
				
			ws.doTimestep();
			//System.out.println("test");
			if (i%10==0) {
				ws.vehicleAdd("v"+i, "car", "r1", i, 0, 15, (byte) 1);
				double a  =ws.vehicleGetSpeed("v"+i);
				
				System.out.println(a);
			}
			/*try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		
		}
			
		ws.stop("user");
		
		
	}

}
