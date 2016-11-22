package ships;
import base.*;


public class Plane extends Equipment {
	private boolean destroyed;
	private Location loc;
	
	
	public Plane(){
		super();
		
		this.destroyed = false;
		this.loc = new Location();
		
	}
	
	
	//setters and getters
	public void setLoc(Location L){this.loc = L; return;}
	public void setDestroyed(boolean D){ this.destroyed = D; return;}
	
	public Location getLoc(){return this.loc;}
	public boolean isDestroyed(){return this.destroyed;}
	
	public void Scan(Location center, boolean patern, GameBoard Board){
		
		
		
		
		
		
		
		return;
	}
	
	
	
	
}
