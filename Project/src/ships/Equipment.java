package ships;
import java.util.*;
import base.*;

public abstract class Equipment {
	private String name;
	private ArrayList<Location> location; //Naomi changed this from a single Location to an ArrayList of Locations
	private ArrayList<Boolean> hits;
	private int size;
	private boolean ownedBy;
	private boolean sunk;
	private int specialsLeft;
	
	public Equipment(){
		this.name = "";
		this.location = new ArrayList<Location>(); //Naomi changed this from a single Location to an ArrayList of Locations
		this.hits = new ArrayList<Boolean>();
		this.size = 1;
		this.ownedBy = true;		//Naomi is going to guess that "true" means ownedBy user and "false" means ownedBy Computer	
		this.sunk = false;
		specialsLeft = 0;
	}
	
	
	//setters and getters
	public void setName(String Name){this.name = Name;	return;}
	public void setLocation(Location Loc){this.location.add(Loc); return;}	//Naomi changed this from a single Location to an ArrayList of Locations
	public void setHit(ArrayList<Boolean> newHits){this.hits =  newHits; return;}
	public void setSize(int s){this.size = s; return;}
	public void setOwner(boolean O){this.ownedBy = O ; return;}
	public void setAHit(int index, boolean hit){	//added a new set function to equpment in order to not have to pass in an arrayList of hits. 
													//Instead we are able to update the hits of an equipment by passing in an index and a boolean element.
		this.getHits().set(index, hit);
	};
	public void setSunk(boolean S){
		this.sunk = S; 
		if(S == true) {				//Ship has sunk
			this.specialsLeft = 0;	//thus, set specialsLieft to 0
		}
		return; 
		}
	public void setSpecialsLeft(int left){this.specialsLeft = left; return; }
	
	public String getName(){return this.name;}
	public ArrayList<Location> getLocation () {return location;}	//Naomi changed this from a single Location to an ArrayList of Locations
	public ArrayList<Boolean> getHits() {return this.hits;}
	public int getSize() { return this.size; }
	public boolean getOwner() {return this.ownedBy; }
	public boolean getSunk(){return this.sunk; }
	public int getSpecialsLeft () {return this.specialsLeft;}

}
