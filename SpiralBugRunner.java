/**
 * @author BRAD HANEL
 * ASSIGNMENT: SPIRALBUGRUNNER
 * DATE: 18-DEC-2013
 */
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.awt.Color;
public class SpiralBugRunner {

	    public static void main(String[] args)
	    {
	        Grid<Actor>octavia = new UnboundedGrid<Actor>();
	    	ActorWorld world = new ActorWorld(octavia);
	        SpiralBug alice = new SpiralBug();
	        alice.setColor(Color.ORANGE);
	        world.add(new Location(19,19), alice);
	        world.show();
	    }
}
