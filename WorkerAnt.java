/**
 * WorkerAnt.java  05/10/07
 * Name: 
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>WorkerAnt</code> is a critter who's mission is
 * to take food from <code>Cake and Cookie</code> objects and to
 * deliver it to a <code>QueenAnt</code> object.
 * Initially it looks for food.  After it finds food, it looks for
 * a queen.
 * Worker ants share the location of food and the queen
 * with other ants they encounter.
 * Worker ants with food are red.  If they don't have food,
 * they are black.
 */
public class WorkerAnt extends Critter implements Processable
{
	/** Current amount of food being carried */
	private int foodQuantity;

	/** Location of a <code>Food</code> object */
	private Location foodLoc;

	/** Location of a <code>QueenAnt</code> object */
	private Location queenLoc;

    /**
     * Constructs a <code>WorkerAnt</code> critter.
     * It is originally black (no food) and
     * its direction is chosen randomly from the
     * eight normal cardinal directions.
     */
    public WorkerAnt()
    {
    	setColor(Color.BLACK);
    	foodQuantity = 0;
    	foodLoc = null;
    	queenLoc = null; 
    	int direc = (int)(Math.random()*Location.FULL_CIRCLE/Location.HALF_RIGHT);
    	direc = direc*Location.HALF_RIGHT;
    	setDirection(direc);
    }

	/**
	 * Gives current food and queen locations to <code>ant</code>.
	 * @param ant the calling <code>WorkerAnt</code>
	 */
    public void process(WorkerAnt ant)
    {
    	if(foodLoc != null && getGrid().get(foodLoc) instanceof Food){
    		ant.shareFoodLocation(foodLoc);
    	}else{
    		foodLoc = null;
    	}if(queenLoc != null){
    		ant.shareQueenLocation(queenLoc);
    	}
    }

	/**
	 * Takes <code>fQty</code> amount of food from the
	 * calling <code>Food</code>.
	 * @param fQty the amount of food to take.
	 */
    public void takeFood(int fQty)
    {
    	foodQuantity += fQty;
    }

	/**
	 * Gives food to the calling <code>QueenAnt</code>.
	 * @return the amound of food to give.
	 */
    public int giveFood()
    {
    	int tempQuant = foodQuantity;
    	foodQuantity = 0;
		return tempQuant;
    }

	/**
	 * Receives the <code>fLoc</code> food location from a
	 * <code>Food</code> object.  Saves this location if
	 * it doesn't already have one.
	 * @param fLoc the location of the food.
	 */
    public void shareFoodLocation(Location fLoc)
    {
    	if(foodLoc == null){
    		foodLoc = fLoc;
    	}
    }

	/**
	 * Receives the <code>qLoc</code> queen location from a
	 * <code>QueenAnt</code> object.  Saves this location if
	 * it doesn't already have one.
	 * @param qLoc the location of the queen.
	 */
    public void shareQueenLocation(Location qLoc)
    {
    	if(queenLoc == null){
    		queenLoc = qLoc;
    	}
    }

    /**
     * Processes each of the neighbouring Ant Farm actors.
     * Implemented to get food from <code>Cake and Cookie</code> actors,
     * give food to <code>QueenAnt</code> actors, and to share locations
     * with other <code>WorkerAnt</code> actors.<br />
     * Precondition: All objects in <code>actors</code>
     * are contained in the same grid as this critter.
     * @param actors the actors to be processed
     */
    @Override
    public void processActors(ArrayList<Actor> actors)
    {
    	for(Actor aktur: actors){
    		((Processable) aktur).process(this);
    	}
    }

    /**
     * Gets the possible locations for the next move.
     * Implemented to return the empty neighbouring locations
     * that are roughly in the direction of the current goal
     * (food or queen).  Calls getDesiredDirection to get the
     * direction to the goal.  Then it considers locations which
     * are in that direction or +- Location.HALF_RIGHT degrees.<br />
     * Postcondition: The locations must be valid in the grid
     * of this critter.
     * @return a list of possible locations for the next move
     */
    @Override
    public ArrayList<Location> getMoveLocations()
    {
    	int derp = getDesiredDirection();
		ArrayList<Location> locos = new ArrayList<Location>();
		if(getGrid().isValid(getLocation().getAdjacentLocation(derp))){
			locos.add(getLocation().getAdjacentLocation(derp));
		}if(getGrid().isValid(getLocation().getAdjacentLocation(derp + Location.HALF_RIGHT))){
			locos.add(getLocation().getAdjacentLocation(derp + Location.HALF_RIGHT));
		}if(getGrid().isValid(getLocation().getAdjacentLocation(derp + Location.HALF_LEFT))){
			locos.add(getLocation().getAdjacentLocation(derp + Location.HALF_LEFT));
		}for(int i = 0; i < locos.size(); i++){
			if(getGrid().get(locos.get(i)) != null){
				locos.remove(i);
				i--;
			}
		}return locos;
    }

    /**
     * Moves this critter to the given location, sets its direction,
     * and sets its colour (red = has food, black = does not have food).
     * Implemented to call moveTo.<br />
     * Precondition: <code>loc</code> is valid in the grid of this critter
     * @param loc the location to move to (must be valid)
     */
    @Override
    public void makeMove(Location loc)
    {
    	if(!loc.equals(getLocation())){
    		setDirection(getLocation().getDirectionToward(loc));
    		moveTo(loc);
    	}else{
    		int randy = (int) (Math.random()*2);
    		if(randy == 1){
    			setDirection(getDirection() + Location.HALF_RIGHT);
    		}else{
    			setDirection(getDirection() + Location.HALF_LEFT);
    		}
    	}if(foodQuantity > 0){
    		setColor(Color.RED);
    	}else{
    		setColor(Color.BLACK); 
    	}
    }

	/**
	 * Returns the direction that the ant wants to go.
	 * @return the direction to the queen (if there is food
	 * and a queen's location is known); the direction to the
	 * food (if there is no food and a food's location is known);
	 * the current ant's direction otherwise.
	 */
    private int getDesiredDirection()
    {
		if(queenLoc != null && foodQuantity != 0){
			return getLocation().getDirectionToward(queenLoc);
		}else if(foodLoc != null && foodQuantity == 0){
			return getLocation().getDirectionToward(foodLoc);
		}else{
			return getDirection();
		}
	}

    /**
     * Creates a string that describes this actor.
     * @return a string with the <code>Actor</code> information
     * plus the current amount of food and any known
     * <code>Food</code> and <code>QueenAnt</code> locations.
     */
    @Override
	public String toString()
	{
		return super.toString() + ", fdQty= " + foodQuantity + ", foodLoc= " + foodLoc + ", queenLoc= " + queenLoc; 
	}
}
