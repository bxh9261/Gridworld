import java.util.ArrayList;
import info.gridworld.grid.Location;

public class QuickCrab extends CrabCritter{

	/** 
	 * pre: none
	 * post: returns the location two to the right and two to the left of the crab if they are null
	 */ 
	public ArrayList<Location> getMoveLocations(){
		ArrayList<Location> locamotives = new ArrayList<Location>();
		Location right = getLocation().getAdjacentLocation(getDirection()+90).getAdjacentLocation(getDirection()+90);
		Location left = getLocation().getAdjacentLocation(getDirection()-90).getAdjacentLocation(getDirection()-90);
		if((getGrid().isValid(right)) && getGrid().get(right) == null)
			locamotives.add(right);
		if(getGrid().isValid(left)&&getGrid().get(left)==null)
			locamotives.add(left);
		return locamotives;
	}

}


