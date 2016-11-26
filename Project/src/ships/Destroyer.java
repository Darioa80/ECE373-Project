package ships;

import java.util.ArrayList;

import base.*;

public class Destroyer extends Ship {
//Should we have a restriction on not being able say, a horiztonal direction for the apache missile at the side edges?
	//since one of the spots will be off the grid
	private int missilesUsed;
	
	public Destroyer(){
		this.setSize(3);
		missilesUsed = 0;
	}
	
	public void Apache(Coordinate centerSpot, boolean direction){
		int i;
		int k;
		int hitscounter;
		//false => horizontal direction
		
		for(i=-1; i < 2; i++){
			Coordinate tempCoordinate = new Coordinate();
			if (direction == false){
			tempCoordinate = GameBoard.Spaces[centerSpot.getCoord().getLetter()][centerSpot.getCoord().getNum()+i];
			if (tempCoordinate.getisOccupied() == true){
				for (k = 0; k < tempCoordinate.getIsOccupiedBy().getHits().size(); k++){		//now that we've identified an enemy ship the hits on that ship must be updated
					if(tempCoordinate.getIsOccupiedBy().getHits().get(k) == false){				//cycles through the hits arraylist until it finds a false 
						ArrayList<Boolean> hits = new ArrayList<Boolean>(tempCoordinate.getIsOccupiedBy().getHits().size());	//In order to set the hits on equipment, a boolean ArrayList must be sent through
																										//hits will be used to set the new hits arraylist of the equipment.
						for(hitscounter =0; hitscounter < k; hitscounter++){					//will retrieve the value of the already updated hits and will update the next one.			
						hits.set(hitscounter, tempCoordinate.getIsOccupiedBy().getHits().get(hitscounter));
					}
						hits.set(k, true);
					}
			}
			}
		}
			else {
				tempCoordinate = GameBoard.Spaces[centerSpot.getCoord().getLetter()+i][centerSpot.getCoord().getNum()];
				if (tempCoordinate.getisOccupied() == true){
					for (k = 0; k < tempCoordinate.getIsOccupiedBy().getHits().size(); k++){		//now that we've identified an enemy ship the hits on that ship must be updated
						if(tempCoordinate.getIsOccupiedBy().getHits().get(k) == false){				//cycles through the hits arraylist until it finds a false 
							ArrayList<Boolean> hits = new ArrayList<Boolean>(tempCoordinate.getIsOccupiedBy().getHits().size());	//In order to set the hits on equipment, a boolean ArrayList must be sent through
																											//hits will be used to set the new hits arraylist of the equipment.
							for(hitscounter =0; hitscounter < k; hitscounter++){					//will retrieve the value of the already updated hits and will update the next one.			
							hits.set(hitscounter, tempCoordinate.getIsOccupiedBy().getHits().get(hitscounter));
						}
							hits.set(k, true);
						}
				}
				}
			}
		}
	}
	
	
	
}
