package ships;
import java.util.ArrayList;

public class AirCraftCarrier extends Ship {
	private ArrayList<Plane> Planes = new ArrayList<Plane>();
	
	
	// I changed it so that the window can ask the user which firingPattern
	// And if they say in the shape of a cross, "firingPattern" will be true
	// If they say in the shape of an X, "firingPattern" will be false
	public boolean Exocet(boolean firingPattern){
		//FIXME
		
		if (firingPattern == true) {
			//attack using a firing pattern that resembles a cross
		}
		else if (firingPattern == false) {
			//attack using a firing pattern that resembles an X
		}
		
		return true;
	}
}
