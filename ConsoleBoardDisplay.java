/**
 * @author BRAD HANEL
 * ASSIGNMENT: CONSOLEBOARDDISPLAY
 * DATE: 21-JAN-2013
 */
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class ConsoleBoardDisplay implements BoardDisplay {
	private Grid<String> griddle;
	
	public ConsoleBoardDisplay(Grid<String> grd){
		griddle = grd;
	}

	public void display(){
		Location loca = new Location(0,0);
		for(int row=0; row < griddle.getNumRows(); row++){
			for(int col=0; col < griddle.getNumCols(); col++){
				loca = new Location(row,col);
				if(griddle.get(loca) == null)
				System.out.print(".");
				else
				System.out.print(griddle.get(loca));
			}
			System.out.println("");
		}
	}
}
