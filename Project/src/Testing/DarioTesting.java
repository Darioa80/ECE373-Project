package Testing;

import base.*;
import ships.*;


	
public class DarioTesting {
	public static void main(String[] args) {
		GameBoard Board1 = new GameBoard();
		Destroyer Dest1 = new Destroyer();
		Destroyer Dest2 = new Destroyer();
		
		Coordinate frontDest1 = new Coordinate();
	
		
		frontDest1.getCoord().setLetter(4);
		frontDest1.getCoord().setNum(4);
		
		Dest1.setShip(frontDest1, false, Board1);
		
	}
}
