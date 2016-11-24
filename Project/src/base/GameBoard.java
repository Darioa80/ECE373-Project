package base;

public class GameBoard {
	

	public Coordinate Spaces[][];
	public static final int gridHeight = 10;
	public static final int gridWidth = 10;
	
	public GameBoard(){
		this.Spaces = new Coordinate[gridHeight][gridWidth];
		
	}

	public Coordinate[][] getSpaces(){
		return this.Spaces;
	}
	
	public void setSpace(Coordinate newCoordinate){
		int i;
		int j;
		for (i = 0; i < gridWidth; i++){
			for (j = 0; j < gridHeight; j ++){
				if (newCoordinate.getCoord() == getSpaces()[i][j].getCoord()){
					getSpaces()[i][j] = newCoordinate;
				}
			}
		}
		return;
	}
	
	
}
