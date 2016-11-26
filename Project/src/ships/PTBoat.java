package ships;
import base.*;
/*
 * Patrol Boat can be used for scanning or 
 * attacking larger regions in the enemy’s 
 * grid in place of taking a normal shot.
 */

public class PTBoat extends Ship {
	
	public PTBoat() {
		this.setSize(2);
	}
	
	public void scan() {
		//"Scans or attacks larger regions of the enemy's grid." 
		//So should I just scan the entire board and return the location of a ship??
		int i, j;
		for(i = 0; i < 10; i++) {	//Iterates through the rows
			for(j = 0; j < 10; j++) {	//Iterates through the columns
				
			}
		}
	}
	
	
}
 