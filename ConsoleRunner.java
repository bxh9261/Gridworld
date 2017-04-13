/**
 * @author BRAD HANEL
 * ASSIGNMENT: CONSOLERUNNER
 * DATE: 21-JAN-2013
 */
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class ConsoleRunner {	
	public static void main(String[] args){
		Grid<String> board = new BoundedGrid<String>(5, 8);
		
		board.put(new Location(0,0), "A");
		board.put(new Location(4,1), "B");
		board.put(new Location(3,2), "C");
		ConsoleBoardDisplay cd = new ConsoleBoardDisplay(board);
		cd.display();
	}
}
