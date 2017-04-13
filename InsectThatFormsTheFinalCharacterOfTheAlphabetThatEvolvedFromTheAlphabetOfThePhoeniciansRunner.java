/**
 * @author BRAD HANEL
 * ASSIGNMENT: SPIRALBUGRUNNER
 * DATE: 18-DEC-2013
 */
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class InsectThatFormsTheFinalCharacterOfTheAlphabetThatEvolvedFromTheAlphabetOfThePhoeniciansRunner {
	public static void main(String[] args){
	Grid<Actor>bonbon = new BoundedGrid<Actor>(21,21);
	ActorWorld world = new ActorWorld(bonbon);
	InsectThatFormsTheFinalCharacterOfTheAlphabetThatEvolvedFromTheAlphabetOfThePhoenicians brad = new InsectThatFormsTheFinalCharacterOfTheAlphabetThatEvolvedFromTheAlphabetOfThePhoenicians(6);
	brad.setColor(Color.MAGENTA);
	InsectThatFormsTheFinalCharacterOfTheAlphabetThatEvolvedFromTheAlphabetOfThePhoenicians sparX = new InsectThatFormsTheFinalCharacterOfTheAlphabetThatEvolvedFromTheAlphabetOfThePhoenicians(4);
	world.add(new Location(12,12), brad);
	world.add(new Location(2,2), sparX);
	world.show();
	}
}