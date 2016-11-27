package Testing;

import base.*;
import ships.*;


	
public class DarioTesting {
	public static void main(String[] args) {
		GameBoard Board1 = new GameBoard();
		GameBoard Board2 = new GameBoard();
		
		Battleship Battleship1 = new Battleship();
		Battleship Battleship2 = new Battleship();

		
		Destroyer Dest1 = new Destroyer();
		Destroyer Dest2 = new Destroyer();
		
		Coordinate frontDest1 = new Coordinate();
		Coordinate frontDest2 = new Coordinate();
		Coordinate frontBattle1 = new Coordinate();
		Coordinate frontBattle2 = new Coordinate();
		
		frontDest1.getCoord().setLetter(4);
		frontDest1.getCoord().setNum(4);
		
		frontDest2.getCoord().setLetter(6);
		frontDest2.getCoord().setNum(6);
		
		frontBattle1.getCoord().setLetter(1);
		frontBattle1.getCoord().setNum(3);
		
		frontBattle2.getCoord().setLetter(1);
		frontBattle2.getCoord().setNum(7);
		
		Battleship1.setDir(true);
		Battleship2.setDir(true);
		
		Dest1.setDir(false);
		Dest2.setDir(false);
		
		
		Dest1.setShip(frontDest1, Board1);
		Dest2.setShip(frontDest2, Board2);
		
		
		Battleship1.setShip(frontBattle1, Board1);
		Battleship2.setShip(frontBattle2, Board2);
		
		Battleship1.TomaHawk(frontDest2, Board2);
		Dest2.Apache(frontBattle1, true, Board1);
	}
}
