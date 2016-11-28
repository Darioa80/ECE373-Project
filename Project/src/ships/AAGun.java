package ships;

import base.GameBoard;
import base.Location;
import java.util.*;

public class AAGun {
	private boolean enabled;
	
	
	
	public void setEnabled(boolean en){this.enabled = en; return; }
	public boolean getEnabled(){return this.enabled;}
	
	
	
	public void Fire(Location loc, GameBoard Board, ArrayList<Plane> planes){
		
		
		if(enabled){
			if(planes.get(0).isDestroyed() == false)
				if(planes.get(0).getLoc().getLetter() == loc.getLetter() && planes.get(0).getLoc().getNum() == loc.getNum()){
					planes.get(0).setDestroyed(true);
				}
			
			if(planes.get(1).isDestroyed() == false)
				if(planes.get(1).getLoc().getLetter() == loc.getLetter() && planes.get(1).getLoc().getNum() == loc.getNum()){
					planes.get(1).setDestroyed(true);
				}
			
			if(planes.get(0).isDestroyed() == true && planes.get(1).isDestroyed() == true)
				this.enabled = false;
			return;
		
		}
		else
			//print error message about AA gun being disabled/ unavailable
			return;
	}
}
