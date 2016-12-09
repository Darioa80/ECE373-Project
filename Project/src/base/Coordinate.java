package base;

import base.Location;
import ships.*;
import ships.Equipment;
public class Coordinate {

	private Location Coord;
	private boolean isOccupied;
	private Equipment isOccupiedBy;
	private boolean beenHit;
	private boolean shipFound;
	private boolean beenChecked;
	
	
	public Coordinate(){
		this.Coord = new Location();
		this.isOccupied = false;
		this.isOccupiedBy = null;		//cannot instantiate an abstract class, will leave this null once the ship is defined, it could be setter function
		this.beenHit = false;			//been hit is updated if the coordinate has been targeted previously
		this.shipFound = false;
		this.beenChecked = false;
	}
	
	public void setChecked(boolean C){this.beenChecked = C;}
	public boolean getChecked(){return this.beenChecked;}
	
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
	
	public Equipment getIsOccupiedBy(){
		return this.isOccupiedBy;
	}
	
	public void setIsOccupiedBy(Equipment newEquipment){
		this.isOccupiedBy = newEquipment;
		return;
	}
	
	public boolean getBeenHit(){
		return this.beenHit;
	}
	
	public void setBeenHit(boolean used){
		this.beenHit = used;
		return;
	}
	
	public void setFound(boolean f){this.shipFound = f; return;}
	
	public boolean getFound(){return this.shipFound;}
}
	

