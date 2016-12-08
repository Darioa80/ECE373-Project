package base;

import ships.*;
import java.util.*;

public class Player {

	public ArrayList<Ship> OwnedShips;
	public ArrayList<Plane> OwnedPlanes; //C.J. Added this initially for use with the AA gun Firing
		AirCraftCarrier userACC;
		Battleship userBS;
		Destroyer userD;
		Submarine userS;
		PTBoat userPT;
		
	public Player(){
		//Ship = 0 means Aircraft Carrier 
		//Ship = 1 means Battleship
		//Ship = 2 means Destroyer
		//Ship = 3 means Submarine
		//Ship = 4 means Patrol Boat
		this.userACC = new AirCraftCarrier();
		this.userBS = new Battleship();
		this.userD = new Destroyer();
		this.userS = new Submarine();
		this.userPT = new PTBoat();
		
		Plane p1 = new Plane();
		Plane p2 = new Plane();
		
		this.OwnedPlanes = new ArrayList<Plane>();
		
		this.OwnedPlanes.add(p1);
		this.OwnedPlanes.add(p2);
		
		
		
		this.OwnedShips = new ArrayList<Ship>(5);
		
		createShipsCoorAndLoc();	//Creates all the 5 ships, their coordinates, and locations (NOT the updated coordinates or locations)
		
		this.OwnedShips.add(userACC);
		this.OwnedShips.add(userBS);
		this.OwnedShips.add(userD);
		this.OwnedShips.add(userS);
		this.OwnedShips.add(userPT);
		
		for (int i = 0; i < 5; i++){
			this.OwnedShips.get(i).setOwner(true);
		}
	}
	public void setOwnedShips(Ship aShip){
		OwnedShips.add(aShip);
		return;
	}
	public ArrayList<Ship> getOwnedShips() {
		return OwnedShips;
	}
	
	public void createShipsCoorAndLoc() {
		//User's Aircraft Carrier
			userACC = new AirCraftCarrier();
			Coordinate userACCCoordinate = new Coordinate();
			Location userACCtLocation = new Location();
			userACCCoordinate.setCoord(userACCtLocation);
			
		//User's Battleship
			userBS = new Battleship();
			Coordinate userBSCoordinate = new Coordinate();
			Location userBSLocation = new Location();
			userBSCoordinate.setCoord(userBSLocation);
			
		//User's Destroyer
			userD = new Destroyer();
			Coordinate userDCoordinate = new Coordinate();
			Location userDLocation = new Location();
			userDCoordinate.setCoord(userDLocation);
			
		//User's Submarine
			userS = new Submarine();
			Coordinate userSCoordinate = new Coordinate();
			Location userSLocation = new Location();
			userSCoordinate.setCoord(userSLocation);

		//User's Patrol Boat
			userPT = new PTBoat();
			Coordinate userPTCoordinate = new Coordinate();
			Location userPTLocation = new Location();
			userPTCoordinate.setCoord(userPTLocation);
	}
	
}
