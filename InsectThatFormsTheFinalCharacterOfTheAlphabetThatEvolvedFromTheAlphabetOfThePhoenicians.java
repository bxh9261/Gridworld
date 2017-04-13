/**
 * @author BRAD HANEL
 * ASSIGNMENT: INSECTTHATFORMSTHEFINALCHARACTEROFTHEALPHABETTHATEVOLVEDFROMTHEALPHABETOFTHEPHOENICIANS
 * DATE: 19-DEC-2013
 */
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;


public class InsectThatFormsTheFinalCharacterOfTheAlphabetThatEvolvedFromTheAlphabetOfThePhoenicians extends Bug {
	private int steps;
	private int sideLength;
	private int sideZ;

	/**
	 * Constructs a Z bug that traces an Z of a given side length
	 * @param length the side length
	 */
	public InsectThatFormsTheFinalCharacterOfTheAlphabetThatEvolvedFromTheAlphabetOfThePhoenicians(int length)
	{
		setDirection(Location.EAST);
		sideLength = length;
		sideZ = 0;
	}

	/**
	 * Moves to the next location of the Z.
	 */
	public void act()
	{

		if (steps < sideLength && canMove())
		{
			move();
			steps++;
		}
		else if(steps == sideLength)
		{
			if(sideZ == 0){
				turn();
				turn();
				turn();
				steps = 0;
			}
			else if(sideZ == 1){
				turn();
				turn();
				turn();
				turn();
				turn();
				steps = 0;
			}
			sideZ++;

		}
	}
	@Override public String toString(){
		return super.toString() + "side length = " + sideLength;
	}
}

