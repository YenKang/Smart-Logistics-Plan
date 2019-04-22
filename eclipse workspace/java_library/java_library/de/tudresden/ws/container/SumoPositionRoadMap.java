package de.tudresden.ws.container;

public class SumoPositionRoadMap implements SumoObject {
	public String edgeID;
	public Byte  laneIndex;
	public double pos;
	
	public SumoPositionRoadMap(){
		this.edgeID="";
		this.laneIndex=0;
		this.pos = 0.0;
	}
	
	public SumoPositionRoadMap(String edgeID, byte laneIndex, double pos) {
		this.edgeID = edgeID;
		this.laneIndex = laneIndex;
		this.pos = pos;
	}
	
	public String toString() {
		// return this.edgeID+ "_"+ this.laneIndex+ ","+ this.pos;
		return this.edgeID+","+ this.pos+ ","+(this.laneIndex);
	}
}
