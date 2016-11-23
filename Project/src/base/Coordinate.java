package base;

import base.Location;
import ships.*;
public class Coordinate {

	private Location Coord;
	private boolean isOccupied;
	private Equipment isOccupiedBy;
	
	public Coordinate(){
		this.Coord = new Location();
		this.isOccupied = false;
		this.isOccupiedBy = new Equipment();
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
	
	public Equipment getisOccupiedBy(){
		return this.isOccupiedBy;
	}
	
	public void setIsOccupiedBy(Equipment newEquipment){
		this.isOccupiedBy = newEquipment;
		return;
	}
	
	
}	
