package ships;
import base.*;


public abstract class Ship extends Equipment {
	private boolean direction;
	private int specialsLeft;
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	
	
	//default constructor
	public Ship(){
		super();
		direction = true;
		specialsLeft = 0;
	}
	
	//setters and getters
	public void setDir(boolean D){this.direction = D; return;}
	public void setSpecialsLeft(int left){this.specialsLeft = left; return; }
	
	public boolean getDir(){return this.direction; }
	public int getSpecialsLeft () {return this.specialsLeft;}
	
	
	
	public void place(GameBoard Board){
		Location loc;
		//this part is just a placeholder for user input.
		//I will change it when the project is further along.
		
		
		//for now True coresponds to vertical and false coresponsed to horizontal
		loc = new Location();
		loc.setLetter('1');
		loc.setNum('1');
		
		
		
		// I will need a completed board class to finish this but the psuedo code will look like this:
		//while(true){
		//I will probably place the user input code here. and make it loop until the user places the
		//the ship in a valid location
		
		//basically all of this will check to see if the place you are trying to place the ship is valid
		//before assigning the ship to that location. it will also assigned the ship to the subsequent 
		//spaces it will occupy on the board.
		//if (Board.Coord[loc.getLetter * 10 + loc.getNum - 1].isOccupied() == true)
		//else if (this.direction = true && this.getsize() - loc.getNum() < 0 &&  )
		//else if (this.direction = false && this.getSize
		//}
		
		return;
		
		
		}
		
		
	public void setShip(Coordinate frontCoordinate, GameBoard Board){	//This function will be used to place the ships in the grid.
		int size = this.getSize();  //gets the size of the ship
		int i;
		int j;
		int frontCoordRow = frontCoordinate.getCoord().getLetter();
		int frontCoordColumn = frontCoordinate.getCoord().getNum();
		if(this.getDir() == false){ //if direction is horizontal 
			for(i =0; i < size; i++){
				if (Board.getSpaces()[frontCoordRow][frontCoordColumn+i].getisOccupied() == true){
					System.out.println("One of the desired coordinates is occupied, choose a new coordinate or direction for " + this.getName());
					return;
				}
			}
			if ((frontCoordinate.getCoord().getNum() + size) > (GRID_WIDTH - 1)){	//minus 1 because the grid goes from 0-9 not 1-10
			System.out.println("Coordinate is out of bounds, pick a different Coordinate or direction.");
			return;
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
					return;
				}
			}
			if((frontCoordinate.getCoord().getLetter()+size) > (GRID_HEIGHT -1)){
				System.out.println("Coordinate is out of bounds, pick a different Coordinate or direction.");
				return;	
			}
			else {
				for (j = 0; j < size; j++){		//iterates through rows
					Board.getSpaces()[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].setIsOccupiedBy(this);
					Board.getSpaces()[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].setIsOccupied(true);
					this.setLocation(Board.getSpaces()[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].getCoord());
				}
			}
		}
		
		
	}
		
		
		
}
	
	
	
	


