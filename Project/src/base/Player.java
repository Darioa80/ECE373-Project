package base;

import ships.*;
import java.util.*;

public class Player {

	public ArrayList<Ship> OwnedShips;
	public ArrayList<Plane> OwnedPlanes; //C.J. Added this initially for use with the AA gun Firing
	
	public Player(){
		this.OwnedShips = new ArrayList<Ship>(5);
		for (int i = 0; i < 5; i++){
			
		}
	}
	
}
