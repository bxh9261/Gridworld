import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.awt.Color;


public class Figure8BugRunner {
	public static void main(String[] args){
		Grid<Actor>vinyl = new UnboundedGrid<Actor>();
    	ActorWorld world = new ActorWorld(vinyl);
        Figure8Bug appledash = new Figure8Bug(3);
        appledash.setColor(Color.DARK_GRAY);
        world.add(new Location(20,20), appledash);
        world.show();
	}
}
