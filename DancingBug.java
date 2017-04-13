/**
 * @author BRAD HANEL
 * DATE: 11-FEB-2014
 * ASSIGNMENT: DANCINGBUG
 */
import info.gridworld.actor.Bug;
public class DancingBug extends Bug{
	private int arraySpot;
	private int[] dance;
	
	/**
	 * pre: all indexes of the array danza are not null
	 * post: instantiates a DancingBug object
	 */
	public DancingBug(int[] danza){
		arraySpot = 0;
		dance = danza; 
	}
	/**
	 * pre: none
	 * post: turns the number of times given by the current array entry then acts like a Bug. In the next move it uses the next entry in the array. When the array completes, the bug repeats the pattern.
	 */
	@Override
	public void act(){
		for(int i = 0; i < dance[arraySpot]; i++){
			turn();
			}super.act();
			arraySpot++;
		    if(arraySpot == dance.length)
		        arraySpot = 0;
			
	}
	@Override
	public String toString(){
		String superString = super.toString() + "side lengths = ";
		for(int i = 0; i < dance.length-1; i++){
			superString+= dance[i] + ", ";
		}superString+= "and " + dance[dance.length-1];
		return superString;
	}
}
