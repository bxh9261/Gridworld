/**
 * @author Brad Hanel
 * DATE: 28-FEB-2014
 * ASSIGNMENT: BLUSTERCRITTER
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class BlusterCritter extends Critter {
	private int c;

	/**
	 * pre: courageousnesses >= 0
	 * post: sets the instance variable equal to the integer passed in through the parameter (the BlusterCritter's "courage")
	 */
	public BlusterCritter(int courageousnesses){
		c = courageousnesses;
	}

	/**
	 * pre: none
	 * post: returns an array of critters that are up to 2 spaces away from the critter in any direction
	 */
	@Override 
	public ArrayList<Actor> getActors(){
		ArrayList<Actor> crittos = new ArrayList<Actor>();
		Location loco = getLocation();
		for(int c = loco.getCol() - 2; c <= loco.getCol() + 2; c++){
			for(int r = loco.getRow() - 2; r <= loco.getRow() + 2; r++){
				Location loca = new Location(r,c);
				if(getGrid().isValid(loca) && getGrid().get(loca) instanceof Actor){
					crittos.add(getGrid().get(loca));
				}
			}
		}return crittos;
	}
	/**
	 * pre: actors != null
	 * post: makes the BlusterCritter darker if the amount of actors in the ArrayList "actors" is greater than or equal to the "courage" number provided in the BlusterCritter's parameter
	 */
	@Override
	public void processActors(ArrayList<Actor> actors)
	{
		ArrayList<Actor> akturrs = new ArrayList<Actor>();
		for(Actor act: actors){
			if(act instanceof Critter){
				akturrs.add(act);
			}
		}if (akturrs.size() >= c){
			setColor(getColor().darker());
		}else{
			setColor(getColor().brighter());
		}
	}
}

