package ships;

import base.Location;
import base.Coordinate;
import java.util.ArrayList;

public class Battleship extends Ship{
	private int timeUsed;
	public static final int tomahawkArea = 9;
	public Battleship(){
		this.timeUsed = 0;
	}
	
	public boolean TomaHawk(Coordinate centerSpot){
		boolean hits[] = new boolean[tomahawkArea];			//records the misses/hits of the tomahawk missile
		ArrayList<Coordinate> targetCoordinates = new ArrayList<Coordinate>(tomahawkArea); //will store all the targetted coordinates.
		int i;			//Is used to go through three horizontal spots 
		int j;			//Is used to go through three vertical spots
		int k = 0;			//will cycle through the hits array
		for (j=-1; j < 2; j++){
			for (i=-1; i < 2; i++){						//The double for loop will go through the 3x3 area the tomahawk targets.
				Coordinate tempCoordinate = new Coordinate();
				Location tempLocation = new Location();
				tempLocation.setNum(centerSpot.getCoord().getNum() + i);
				tempLocation.setLetter(centerSpot.getCoord().getLetter() + j);
				tempCoordinate.setCoord(tempLocation);
					if (tempCoordinate.getisOccupied() == true){		//if an enemy boat is in the corrdinate, the hits on the enemy ship will be updated
						tempCoordinate.getOccupiedby().getLocations();
						
					}
				hits[k] = tempCoordinate.getisOccupied(); 
		}
		}
		
		
	}

}
