/**
 * @author BRAD HANEL
 * ASSIGNMENT: OCTAGONBUG
 * DATE: 18-DEC-2013
 */
import info.gridworld.actor.Bug;

public class OctagonBug extends Bug {
	private int steps;
	private int sideLength;

	/**
	 * Constructs an octagon bug that traces an octagon of a given side length
	 * @param length the side length
	 */
	public OctagonBug(int length)
	{
		steps = 0;
		sideLength = length;
	}

	/**
	 * Moves to the next location of the octagon.
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
			steps = 0;
		}
	}
	/**
	 * pre: none
	 * post: returns the string from super, including new parameters
	 */
	@Override public String toString(){
		return super.toString() + "side length = " + sideLength;
	}
}
