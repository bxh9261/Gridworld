/**
 * @author BRAD HANEL
 * ASSIGNMENT: OCTAGONBUG
 * DATE: 18-DEC-2013
 */
import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
public class OctagonBugRunner {
	public static void main(String[] args)
	{
		Grid<Actor>bonbon = new BoundedGrid<Actor>(21,21);
		ActorWorld world = new ActorWorld(bonbon);
		OctagonBug brad = new OctagonBug(6);
		brad.setColor(Color.MAGENTA);
		OctagonBug sparX = new OctagonBug(4);
		world.add(new Location(13,1), brad);
		world.add(new Location(12,4), sparX);
		world.show();
	}
}
