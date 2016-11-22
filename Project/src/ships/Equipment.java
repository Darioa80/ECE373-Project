package ships;
import java.util.*;
import base.*;

public abstract class Equipment {
	private String name;
	private Location location;
	private ArrayList<Boolean> hits;
	private int size;
	private boolean ownedBy;
	
	
	public Equipment(){
		this.name = "";
		this.location = new Location();
		this.hits = new ArrayList<Boolean>();
		this.size = 1;
		this.ownedBy = true;
		
		
	}
	
	
	//setters and getters
	public void setName(String Name){this.name = Name;	return;}
	public void setLocation(Location Loc){this.location = Loc; return;}
	public void setHit(ArrayList<Boolean> newHits){this.hits =  newHits; return;}
	public void setSize(int s){this.size = s; return;}
	public void setOwner(boolean O){this.ownedBy = O ; return;}
	
	public String getName(){return this.name;}
	public Location getLocation () {return this.location;}
	public ArrayList<Boolean> getHits() {return this.hits;}
	public int getSize() { return this.size; }
	public boolean getOwner() {return this.ownedBy; }
	
	

}
