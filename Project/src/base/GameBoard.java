package base;

import java.util.ArrayList;

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
	
	public Coordinate[][] Spaces;	//This is the board spaces of type coordinate?
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	
	public GameBoard(){
		this.Spaces = new Coordinate[GRID_HEIGHT][GRID_WIDTH];
	}

	public Coordinate[][] getSpaces(){
		return this.Spaces;	//returns all 100 spaces
	}
	
	public void setSpace(Coordinate newCoordinate){
		int i = 0, j = 0;
		/*for (i = 0; i < GRID_WIDTH; i++){
			for (j = 0; j < GRID_HEIGHT; j ++){
				if (newCoordinate.getCoord() == getSpaces()[i][j].getCoord()){
					getSpaces()[i][j] = newCoordinate;
				}
			}
		}*/
		
		
		newCoordinate.getCoord().getLetter(); //this returns the location
		newCoordinate.getCoord().getNum(); //this returns the location
		return;
	}
	
	
}
