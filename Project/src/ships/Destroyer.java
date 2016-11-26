package ships;

import java.util.ArrayList;

import base.*;

public class Destroyer extends Ship {
//Should we have a restriction on not being able say, a horiztonal direction for the apache missile at the side edges?
	//since one of the spots will be off the grid
	
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
		
	}
	
	public void Apache(Coordinate centerSpot, boolean direction, GameBoard Board){
		int i;
		int k;
		int numHits = 0;
		//false => horizontal direction
		
		if (this.getSpecialsLeft() < 1){
			return;
		}
		for(i=-1; i < 2; i++){
			if(direction == false){
			if(Board.getSpaces()[centerSpot.getCoord().getLetter()][centerSpot.getCoord().getNum()+i].getBeenHit() == true){
				System.out.println("One of these coordinates has already been targetted. Please choose another coordinate to use the Apache missile.");
				return;
				
			}
			}
			else {
				if(Board.getSpaces()[centerSpot.getCoord().getLetter()+i][centerSpot.getCoord().getNum()].getBeenHit() == true){
					System.out.println("One of these coordinates has already been targetted. Please choose another coordinate to use the Apache missile.");
					return;
				}
			}
		}
		
		
		for(i=-1; i < 2; i++){
			Coordinate tempCoordinate = new Coordinate();
			if (direction == false){
				tempCoordinate = Board.getSpaces()[centerSpot.getCoord().getLetter()][centerSpot.getCoord().getNum()+i];
					if (tempCoordinate.getisOccupied() == true){
						for (k = 0; k < tempCoordinate.getIsOccupiedBy().getHits().size(); k++){		//now that we've identified an enemy ship the hits on that ship must be updated
							if(tempCoordinate.getIsOccupiedBy().getHits().get(k) == false){				//cycles through the hits arraylist until it finds a false 
								tempCoordinate.getIsOccupiedBy().getHits().set(k, true);
								//if (k == (tempCoordinate.getIsOccupiedBy().getHits().size() - 1)){
								//	tempCoordinate.getIsOccupiedBy().set
								//}
									
								break;
					}
			}
		}
			
	}
			else {
				tempCoordinate = Board.getSpaces()[centerSpot.getCoord().getLetter()+i][centerSpot.getCoord().getNum()];
				if (tempCoordinate.getisOccupied() == true){
					for (k = 0; k < tempCoordinate.getIsOccupiedBy().getHits().size(); k++){		//now that we've identified an enemy ship the hits on that ship must be updated
						if(tempCoordinate.getIsOccupiedBy().getHits().get(k) == false){				//cycles through the hits arraylist until it finds a false 
						tempCoordinate.getIsOccupiedBy().getHits().set(k, true);
						break;
						}
				}
				}
			}
		}
		this.setSpecialsLeft(getSpecialsLeft()-1);
	}
	
}
