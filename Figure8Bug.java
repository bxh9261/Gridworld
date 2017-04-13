import info.gridworld.actor.Bug;


public class Figure8Bug extends Bug {
	private int steps;
	private int sideLength;
	private int crossover;
	private int crossback;
	
	
	public Figure8Bug(int len){
		steps = 0;
		crossover = 0;
		sideLength = len;
	}

	@Override
	public void turn(){
		
	}
	
}
