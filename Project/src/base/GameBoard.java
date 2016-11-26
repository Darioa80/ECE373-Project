package base;

import java.util.ArrayList;
import ships.*;
/*
 *   1  2  3  4  5  6  7  8  9  10
 * A
 * B
 * C
 * D
 * E
 * F
 * G
 * H
 * I
 * J
 * 
 */

public class GameBoard {
	
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	public static Coordinate[][] Spaces;	//This is the board spaces of type coordinate?

	
	public GameBoard(){
		this.Spaces = new Coordinate[GRID_HEIGHT][GRID_WIDTH];
		int i = 0; int j = 0;
		Location tempLocation = new Location();
		for (j = 0; j < GRID_HEIGHT; j++){
			for (i = 0; i < GRID_WIDTH; i++){
				Spaces[j][i] = new Coordinate();
				tempLocation.setLetter(i);
				tempLocation.setNum(j);
				Spaces[j][i].setCoord(tempLocation);
			}
		}
	}

	public Coordinate[][] getSpaces(){
		return this.Spaces;	//returns all 100 spaces
	}
	
	public void setSpace(Coordinate newCoordinate){
		int i = 0, j = 0;
		for (j = 0; j < GRID_HEIGHT; j++){
			for (i = 0; i < GRID_HEIGHT; i ++){
				if (newCoordinate.getCoord().getLetter() == getSpaces()[j][i].getCoord().getLetter()){
					if(newCoordinate.getCoord().getNum() == getSpaces()[j][i].getCoord().getNum()){
						getSpaces()[j][i] = newCoordinate;
					}
				}
			}
		}
		
		
		//newCoordinate.getCoord().getLetter(); //this returns the location
		//newCoordinate.getCoord().getNum(); //this returns the location
		return;
	}
	
	
}
