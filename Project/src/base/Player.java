package base;

import ships.*;
import java.util.*;

public class Player {

	public ArrayList<Ship> OwnedShips;
	public ArrayList<Plane> OwnedPlanes; //C.J. Added this initially for use with the AA gun Firing
	
	public Player(){
		//Ship = 1 means Aircraft Carrier 
		//Ship = 2 means Battleship
		//Ship = 3 means Destroyer
		//Ship = 4 means Patrol Boat
		//Ship = 5 means Submarine
		this.OwnedShips = new ArrayList<Ship>(5);
		
		AirCraftCarrier acc = new AirCraftCarrier();
		Battleship bs = new Battleship();
		Destroyer d = new Destroyer();
		Submarine s = new Submarine();
		PTBoat pt = new PTBoat();
		
		this.OwnedShips.add(acc);
		this.OwnedShips.add(bs);
		this.OwnedShips.add(d);
		this.OwnedShips.add(s);
		this.OwnedShips.add(pt);
		
		
		for (int i = 0; i < 5; i++){
			this.OwnedShips.get(i).setOwner(true);
		}
	}
	public void setOwnedShips(Ship aShip){
		OwnedShips.add(aShip);
		return;
	}
	public ArrayList<Ship> getOwnedShips() {
		return OwnedShips;
	}
	
	public void initSettingAllShips(int mode, int ship) { 
		//mode = 1 means Classic. mode = 2 means Salvo. mode = 3 means Advanced.
		//Ship = 1 means Aircraft Carrier 
		//Ship = 2 means Battleship
		//Ship = 3 means Destroyer
		//Ship = 4 means Submarine
		//Ship = 5 means Patrol Boat
		if(ship == 0) {			//Aircraft Carrier
			
		}
		else if (ship == 1) {	//Battleship
			
		} 
		else if (ship == 2) {	//Destroyer
			
		}		
		else if (ship == 3) {	//Submarine
			
		}
		else if (ship == 4) {	//Patrol Boat
			
		}
		
		//FIXME idk where planes get set 
	}
	
}
