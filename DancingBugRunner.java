/**
 * @author BRAD HANEL
 * DATE: 11-FEB-2014
 * ASSIGNMENT: DANCINGBUG
 */
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;


@SuppressWarnings("unused")
public class DancingBugRunner {
	public static void main(String[] args){
		Grid<Actor>vinyl = new UnboundedGrid<Actor>();
    	ActorWorld world = new ActorWorld(vinyl);
    	int steve = 3;
    	SpiralBug bob = new SpiralBug();
    	SpiralBug bob2 = new SpiralBug();
    	SpiralBug bob3 = new SpiralBug();
    	SpiralBug bob4 = new SpiralBug();
    	SpiralBug bob5 = new SpiralBug();
    	SpiralBug bob6 = new SpiralBug();
    	SpiralBug bob7 = new SpiralBug();
    	SpiralBug bob8 = new SpiralBug();
    	SpiralBug bob9 = new SpiralBug();
    	world.add(new Location(0,1), bob);
    	world.add(new Location(2,4), bob2);
    	world.add(new Location(steve,7), bob3);
    	world.add(new Location(4,4), bob4);
    	world.add(new Location(1,5), bob5);
    	world.add(new Location(7,6), bob6);
    	world.add(new Location(7,2), bob7);
    	world.add(new Location(8,8), bob8);
    	world.add(new Location(9,1), bob9);
        world.show();
	}
}
