package ships;

import base.Location;
import base.Coordinate;
import base.*;
import java.util.ArrayList;


public class Battleship extends Ship{
	public static final int tomahawkArea = 9;
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	
	public Battleship(){
		this.setSize(4);
		this.setSpecialsLeft(1);
		this.setName("BattleShip");
		for(int i = 0; i < this.getSize(); i++){
		this.getHits().add(false);
		this.setSunk(false);
		//this.getLocation().add(new Location());
		}
	}
	
	
	public boolean TomaHawk(Coordinate centerSpot, GameBoard Board){		//not sure why this is boolean
				//records the misses/hits of the tomahawk missile
		if (this.getSpecialsLeft() < 1){	
			return false;
		}
		
		int i;			//Is used to go through three horizontal spots 
		int j;			//Is used to go through three vertical spots
		int k = 0;			//will cycle through the hits array
		boolean hitAnything = false;
		int centerSpotRow = centerSpot.getCoord().getNum();
		int centerSpotColumn = centerSpot.getCoord().getLetter();
		for (j=-1; j < 2; j++){
			for (i=-1; i < 2; i++){						//The double for loop will go through the 3x3 area the tomahawk target
				if(((centerSpotRow+j) > (GRID_HEIGHT -1)) || ((centerSpotColumn+i) > (GRID_WIDTH -1))){
					}
				else {
				if(Board.getSpaces()[centerSpotRow+j][centerSpotColumn+i].getBeenHit() == true){
				}
				else {
					if (Board.getSpaces()[centerSpotRow+j][centerSpotColumn+i].getisOccupied() == true){		//if an enemy boat is in the coordinate, the hits on the enemy ship will be updated
						for (k = 0; k < Board.getSpaces()[centerSpotRow+j][centerSpotColumn+i].getIsOccupiedBy().getHits().size(); k++){		//now that we've identified an enemy ship the hits on that ship must be updated
							if(Board.getSpaces()[centerSpotRow+j][centerSpotColumn+i].getIsOccupiedBy().getHits().get(k) == false){				//cycles through the hits arraylist until it finds a false 
								Board.getSpaces()[centerSpotRow+j][centerSpotColumn+i].setBeenHit(true);			//sets the current Coordinate to been hit
								Board.getSpaces()[centerSpotRow+j][centerSpotColumn+i].getIsOccupiedBy().getHits().set(k, true);
								if(k == (Board.getSpaces()[centerSpotRow+j][centerSpotColumn+i].getIsOccupiedBy().getHits().size()-1)){
									Board.getSpaces()[centerSpotRow+i][centerSpotColumn].getIsOccupiedBy().setSunk(true);
								}
								hitAnything = true;
								break;
							}
					
						}
						//else check if the ship has already been destroyed or should be destroyed
					}
					Board.getSpaces()[centerSpotRow+j][centerSpotColumn + i].setBeenHit(true);
				}
			}
		}
	}
		this.setSpecialsLeft(getSpecialsLeft()-1);
		return hitAnything;
	}
	


}
