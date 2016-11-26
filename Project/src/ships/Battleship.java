package ships;

import base.Location;
import base.Coordinate;
import base.*;
import java.util.ArrayList;


public class Battleship extends Ship{
	private int timesUsed;
	public static final int tomahawkArea = 9;
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	
	public Battleship(){
		this.setSize(4);
		this.timesUsed = 0;
	}
	
	public int getTimesUsed() {
		return this.timesUsed;
	}
	
	public boolean TomaHawk(Coordinate centerSpot){		//not sure why this is boolean
				//records the misses/hits of the tomahawk missile
		if (getTimesUsed() > 0){	
			return false;
		}
		ArrayList<Coordinate> targetCoordinates = new ArrayList<Coordinate>(tomahawkArea); //will store all the targetted coordinates.
		int i;			//Is used to go through three horizontal spots 
		int j;			//Is used to go through three vertical spots
		int k = 0;			//will cycle through the hits array
		int hitscounter;
		boolean hitAnything = false;
		
		for (j=-1; j < 2; j++){
			for (i=-1; i < 2; i++){						//The double for loop will go through the 3x3 area the tomahawk target
				
				Coordinate tempCoordinate = new Coordinate();
				tempCoordinate = GameBoard.Spaces[centerSpot.getCoord().getLetter()+j][centerSpot.getCoord().getNum()+i];
					if (tempCoordinate.getisOccupied() == true){		//if an enemy boat is in the coordinate, the hits on the enemy ship will be updated
						//hits  = tempCoordinate.getIsOccupiedBy().getHits();
						for (k = 0; k < tempCoordinate.getIsOccupiedBy().getHits().size(); k++){		//now that we've identified an enemy ship the hits on that ship must be updated
							if(tempCoordinate.getIsOccupiedBy().getHits().get(k) == false){				//cycles through the hits arraylist until it finds a false 
								ArrayList<Boolean> hits = new ArrayList<Boolean>(tempCoordinate.getIsOccupiedBy().getHits().size());	//In order to set the hits on equipment, a boolean ArrayList must be sent through
																												//hits will be used to set the new hits arraylist of the equipment.
								for(hitscounter =0; hitscounter < k; hitscounter++){					//will retrieve the value of the already updated hits and will update the next one.			
								hits.set(hitscounter, tempCoordinate.getIsOccupiedBy().getHits().get(hitscounter));
							}
								hits.set(k, true);
								hitAnything = true;
							}
						}
						//else check if the ship has already been destroyed or should be destroyed
					}
		}
		}
		timesUsed++;
		return hitAnything;
	}
	


}
