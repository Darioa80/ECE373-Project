package ships;
import java.util.ArrayList;

import base.*;

public class Submarine extends Ship{
	
	public Submarine() {
		//The variables in Equipment
			this.setSize(3);							//Set the size of the ship
			this.setName("Submarine");					//Set the name
			//When is the location array set?
			for(int i = 0; i < this.getSize(); ++i) {	//Set the hits array list to false since it hasn't been hit
				this.getHits().add(false);
			}
			//ownedBy is be set in the driver.

		//The variables in Ship
			//Direction is set in the driver.
			//Sunk is set in Ship class.	
			this.setSpecialsLeft(2);					//Set the number of specials left
	}
	
	public void Torpedo(Coordinate spotChosen, boolean direction, GameBoard board){
		int i = 0, j =0, k=0;
		int sizeOfHitArrayList = 0;		
		
		/*
		 * For the Torpedo, a spot at the edge of the grid will be chosen. 
		 * If a spot is selected along the vertical edges of the grid, the 
		 * Torpedo will fire at the corresponding row. 
		 * If a spot is selected along the horizontal edges, the Torpedo 
		 * will fire at the corresponding column.  
		 * The Torpedo will hit every spot in that row / column until it 
		 * finds a location with an enemy ship. 
		 * It'll shoot that location and the torpedo will stop.
		 * The player can fire two Torpedoes per game and are lost if used 
		 * or if the Submarine is sunk.
		 * 
		 */
		
		if(this.getSpecialsLeft() > 0) {
			this.setSpecialsLeft(this.getSpecialsLeft()-1); //Update the amount of specials left
			
			if(direction == true) { //Torpedo is shot vertically, so column j stays the same
				j = spotChosen.getCoord().getLetter(); //column j stays the same since the torpedo is shot in the vertical direction
				for(i = 0; i < 10; i++) {			//iterate through the rows
					
					if(board.getSpaces()[i][j].getBeenHit() == false) {			//If this location hasn't been hit
						board.getSpaces()[i][j].setBeenHit(true);			//hit the spot that is occupied
						if(board.getSpaces()[i][j].getisOccupied() == true){ 	//checks if this location is occupied by something
							
							sizeOfHitArrayList = board.getSpaces()[i][j].getIsOccupiedBy().getHits().size(); 
							for (k = 0; k < sizeOfHitArrayList; k++){		//We need to update the hits array of enemy's ship we hit
								if(board.getSpaces()[i][j].getIsOccupiedBy().getHits().get(k) == false) {	//Finds the first item listed as "false" and updates it to true
									board.getSpaces()[i][j].getIsOccupiedBy().getHits().set(k, true); 	//sets one of the arrayList's items to true (meaning it's true that it has been hit)
									if(k == sizeOfHitArrayList - 1){	//if k = the last spot in that arrayList, that means the entire array is filled with "trues" which means the entire ship has been sunk!!!! 
										board.getSpaces()[i][j].getIsOccupiedBy().setSunk(true);		//So change the sunk variable from false to true
									}
									break; //break out of this arrayList for loop
								}
							}
							
							return; //The second it hits a spot, get out of this method
						}
					}
				}
				
				
			}
			else {					//Torpedo is shot horizontally
				i = spotChosen.getCoord().getNum();	//row i stays the same since the torpedo is shot in the horizontal direction
				for(j = 0; j < 10; j++) {				//iterate through the columns
					
					if(board.getSpaces()[i][j].getBeenHit() == false) {			//If this location hasn't been hit
						board.getSpaces()[i][j].setBeenHit(true);			//hit the spot that is occupied
						if(board.getSpaces()[i][j].getisOccupied() == true){ 	//checks if this location is occupied by something
							
							sizeOfHitArrayList = board.getSpaces()[i][j].getIsOccupiedBy().getHits().size(); 
							for (k = 0; k < sizeOfHitArrayList; k++){		//We need to update the hits array of enemy's ship we hit
								if(board.getSpaces()[i][j].getIsOccupiedBy().getHits().get(k) == false) {	//Finds the first item listed as "false" and updates it to true
									board.getSpaces()[i][j].getIsOccupiedBy().getHits().set(k, true); 	//sets one of the arrayList's items to true (meaning it's true that it has been hit)
									if(k == sizeOfHitArrayList - 1){	//if k = the last spot in that arrayList, that means the entire array is filled with "trues" which means the entire ship has been sunk!!!! 
										board.getSpaces()[i][j].getIsOccupiedBy().setSunk(true);		//So change the sunk variable from false to true
									}
									break; //break out of this arrayList for loop
								}
							}
							
							return; //The second it hits a spot, get out of this method
						}
					}
					
				}
			}
			
		}
		else { //no torpedoes left :'(
			//Return an error message?? I mean, it should never even get here.
		}
		
		return;
	}
	
	
	public boolean Sonar(Coordinate centerCoor, GameBoard board){	//Returns true if it found a ship in that 3x3 square. Returns false otherwise
		int i = 0, j = 0;
		/*
		 * Sonar does not damage the enemy ships and has no limit to the number of 
		 * times it can be used. The player picks a 3x3 square and  the Sonar tells
		 * the player if any enemy ship is located there, but does not tell the user 
		 * the exact location of the enemy ship.
		 * If the submarine is sunk, the user can't use the Sonar. 
		 */
		for(i = centerCoor.getCoord().getLetter() - 1; i <= centerCoor.getCoord().getLetter() + 1; i++){ //iterates through the row above and below the row that was selected  
			for(j = centerCoor.getCoord().getNum() - 1; j <= centerCoor.getCoord().getNum() + 1; j++) {	//iterates through the column above and below the column that was selected
				if((i >= 0) && (i < 10) && (j >= 0) && (j < 10)) {	//if the location is within the bounds
					if(board.getSpaces()[i][j].getBeenHit() == false) {		//If this location hasn't been hit
						if(board.getSpaces()[i][j].getisOccupied() == true){ //checks if this location is occupied by something
							return true; //returns true if the enemy's board has a boat located in that position
						}
					}
				}
			}
		}
		return false; //Returns false if no ship is located in that 3x3 square
	}
}












