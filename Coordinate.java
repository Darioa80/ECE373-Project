package base;

import base.Location;
public class Coordinate {

	private Location Coord;
	private boolean isOccupied;
	// private Equpiment isOccupiedBy;
	
	public Coordinate(){
		this.Coord = new Location();
		this.isOccupied = false;
		// this.isOccupiedBY = new Equpment();
	}
	
	public Location getCoord(){
		return this.Coord;
	}
	
	public void setCoord(Location newLoc){
		this.Coord = newLoc;
		return;
	}
	
	public Boolean getisOccupied(){
		return this.isOccupied;
	}
	
	public void setIsOccupied(boolean Is){
		this.isOccupied = Is;
		return;
	}
	
	
}	
