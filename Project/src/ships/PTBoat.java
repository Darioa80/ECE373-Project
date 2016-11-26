package ships;
import base.*;
/*
 * Patrol Boat can be used for scanning or 
 * attacking larger regions in the enemy’s 
 * grid in place of taking a normal shot.
 */

public class PTBoat extends Ship {
	
	public PTBoat() {
		//The variables in Equipment		
			this.setSize(2);
			this.setName("Patrol Boat");					//Set the name
			//When is the location array set?
			for(int i = 0; i < this.getSize(); ++i) {
				this.getHits().add(false);
			}
			//When is ownedBy set?			

		//The variables in Ship
			//When is the direction set?
			//Sunk = false is set in Ship class
			this.setSpecialsLeft(0); //Since it has no specials
	}
	
	//No special for Advanced Mission :(
}
 