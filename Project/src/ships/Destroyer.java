package ships;

import java.util.ArrayList;

import base.*;

public class Destroyer extends Ship {
//Should we have a restriction on not being able say, a horiztonal direction for the apache missile at the side edges?
	//since one of the spots will be off the grid
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	
	public Destroyer(){
		this.setSize(3);
		this.setSpecialsLeft(2);
		this.setName("Destroyer");
		this.setSpecialsLeft(2);
		for (int i =0; i < this.getSize(); i++){
			this.getHits().add(false);
			//this.getLocation().add(new Location());
			//this.getHits().set(i, false);
		}
		this.setSunk(false);
		
	}
	
	public void Apache(Coordinate centerSpot, boolean direction, GameBoard Board){
		int i;
		int k;
		int centerSpotColumn = centerSpot.getCoord().getNum();
		int centerSpotRow = centerSpot.getCoord().getLetter();
		//false => horizontal direction
		
		if (this.getSpecialsLeft() < 1){		//double checks special can be used
			return;
		}

		for(i=-1; i < 2; i++){
			if (direction == false){
				if(((centerSpotRow) > (GRID_HEIGHT -1)) || ((centerSpotColumn+i) > (GRID_WIDTH -1))){
				}
			else {
			if(Board.getSpaces()[centerSpot.getCoord().getLetter()][centerSpot.getCoord().getNum()+i].getBeenHit() == true){
			}
			else{
					if (Board.getSpaces()[centerSpotRow][centerSpotColumn+i].getisOccupied() == true){
						for (k = 0; k < Board.getSpaces()[centerSpotRow][centerSpotColumn+i].getIsOccupiedBy().getHits().size(); k++){		//now that we've identified an enemy ship the hits on that ship must be updated
							if(Board.getSpaces()[centerSpotRow][centerSpotColumn+i].getIsOccupiedBy().getHits().get(k) == false){				//cycles through the hits arraylist until it finds a false 
								Board.getSpaces()[centerSpotRow][centerSpotColumn+i].setBeenHit(true);
								Board.getSpaces()[centerSpotRow][centerSpotColumn+i].getIsOccupiedBy().getHits().set(k, true);
								if(k == (Board.getSpaces()[centerSpotRow+i][centerSpotColumn].getIsOccupiedBy().getHits().size()-1)){
									Board.getSpaces()[centerSpotRow+i][centerSpotColumn].getIsOccupiedBy().setSunk(true);
								}
									
								break;
							}
						}
					}
				}
			}
		}
			else {
				if(((centerSpotRow+i) > (GRID_HEIGHT -1)) || ((centerSpotColumn) > (GRID_WIDTH -1))){
				}
			else {
				if(Board.getSpaces()[centerSpot.getCoord().getLetter()+i][centerSpot.getCoord().getNum()].getBeenHit() == true){
				}
				else{
				if (Board.getSpaces()[centerSpotRow+i][centerSpotColumn].getisOccupied() == true){
					for (k = 0; k < Board.getSpaces()[centerSpotRow+i][centerSpotColumn].getIsOccupiedBy().getHits().size(); k++){		//now that we've identified an enemy ship the hits on that ship must be updated
						if(Board.getSpaces()[centerSpotRow+i][centerSpotColumn].getIsOccupiedBy().getHits().get(k) == false){				//cycles through the hits arraylist until it finds a false 
							Board.getSpaces()[centerSpotRow+i][centerSpotColumn].setBeenHit(true);
							Board.getSpaces()[centerSpotRow+i][centerSpotColumn].getIsOccupiedBy().getHits().set(k, true);
								if(k == (Board.getSpaces()[centerSpotRow+i][centerSpotColumn].getIsOccupiedBy().getHits().size()-1)){
									Board.getSpaces()[centerSpotRow+i][centerSpotColumn].getIsOccupiedBy().setSunk(true);
								}
						break;
						}
				}
				}
			}
			}	
		}
		}
		this.setSpecialsLeft(getSpecialsLeft()-1);
	}
	
}
