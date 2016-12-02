package ships;
import base.*;


public abstract class Ship extends Equipment {
	private boolean direction;
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	
	
	//default constructor
	public Ship(){
		super();
		direction = true;
	}
	
	//setters and getters
	public void setDir(boolean D){this.direction = D; return;}
	
	public boolean getDir(){return this.direction; }
	
	
	

		
	public boolean setShip(Coordinate frontCoordinate, GameBoard Board){	//This function will be used to place the ships in the grid.
		int size = this.getSize();  //gets the size of the ship
		int i;
		int j;
		int frontCoordRow = frontCoordinate.getCoord().getLetter();
		int frontCoordColumn = frontCoordinate.getCoord().getNum();
		if(this.getDir() == false){ //if direction is horizontal 
			for(i =0; i < size; i++){
				if (Board.getSpaces()[frontCoordRow][frontCoordColumn+i].getisOccupied() == true){
					System.out.println("One of the desired coordinates is occupied, choose a new coordinate or direction for " + this.getName());
					return false;
				}
			}
			if ((frontCoordinate.getCoord().getNum() + size) > (GRID_WIDTH - 1)){	//minus 1 because the grid goes from 0-9 not 1-10
			System.out.println("Coordinate is out of bounds, pick a different Coordinate or direction.");
			return false;
				}
			else {
				for (i = 0; i < size; i++){	//iterates through the columns due to horizontal displacement.
					Board.getSpaces()[frontCoordinate.getCoord().getLetter()][frontCoordinate.getCoord().getNum()+i].setIsOccupiedBy(this);
					Board.getSpaces()[frontCoordinate.getCoord().getLetter()][frontCoordinate.getCoord().getNum()+i].setIsOccupied(true);
					this.setLocation(Board.getSpaces()[frontCoordinate.getCoord().getLetter()][frontCoordinate.getCoord().getNum()+i].getCoord());
				}
			}

			}
		else{	//direction is vertical
			for(i =0; i < size; i++){
				if (Board.getSpaces()[frontCoordRow+i][frontCoordColumn].getisOccupied() == true){
					System.out.println("One of the desired coordinates is occupied, choose a new coordinate or direction for " + this.getName());
					return false;
				}
			}
			if((frontCoordinate.getCoord().getLetter()+size) > (GRID_HEIGHT -1)){
				System.out.println("Coordinate is out of bounds, pick a different Coordinate or direction.");
				return false;	
			}
			else {
				for (j = 0; j < size; j++){		//iterates through rows
					Board.getSpaces()[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].setIsOccupiedBy(this);
					Board.getSpaces()[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].setIsOccupied(true);
					this.setLocation(Board.getSpaces()[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].getCoord());
				}
			}
		}
		return true;
		
		
	}
		
		
		
}
	
	
	
	


