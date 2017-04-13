/**
 * @author BRAD HANEL
 * ASSIGNMENT: SPIRALBUG
 * DATE: 18-DEC-2013
 */
import info.gridworld.actor.Bug;
public class SpiralBug extends Bug {
	    private int steps;
	    private int sideLength;

	    /**
	     * Constructs a spiral bug that traces a square of a given side length
	     * @param length the side length
	     */
	    public SpiralBug()
	    {
	        steps = 0;
	        sideLength = 1;
	    }

	    /**
	     * Moves to the next location of the spiral.
	     */
	    public void act()
	    {
	        if (steps < sideLength && canMove())
	        {
	            move();
	            steps++;
	        }
	        else
	        {
	        	turn();
	        	turn();
	            steps = 0;
	            sideLength++;
	        }
	    }
	}
