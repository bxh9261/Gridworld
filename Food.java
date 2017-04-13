/**
 * Food.java  05/10/07
 * Name:
 */

import info.gridworld.actor.Actor;

/**
 * <code>Food</code> is the top level abstract class for different
 * types of food.  A food object waits for a
 * <code>WorkerAnt</code> to get food from it.  It does not act.
 */
public abstract class Food extends Actor implements Processable
{
	/** The size of a bite */
	private final int BITE_SIZE;

	/** The size of the piece of food */
	private final int TOTAL_SIZE;

	/** The total amount of food eaten */
	private int foodEaten; 

    /**
     * Constructs a <code>Food</code> actor.  The image is
     * displayed for this actor without tinting.
     */
	public Food(int bite, int size)
	{
		BITE_SIZE = bite;
		TOTAL_SIZE = size;
		foodEaten = 0;
		setColor(null);
	}

	/**
	 * Gives food and current location to <code>ant</code>.
	 * @param ant the calling <code>WorkerAnt</code>
	 */
	public void process(WorkerAnt employee)
	{
		if(BITE_SIZE <= TOTAL_SIZE-foodEaten){
			employee.takeFood(BITE_SIZE);
			foodEaten += BITE_SIZE;
		}else{
			employee.takeFood(TOTAL_SIZE-foodEaten);
			foodEaten = TOTAL_SIZE;
		}if(foodEaten == TOTAL_SIZE){
			removeSelfFromGrid();
		}else{
			employee.shareFoodLocation(getLocation());
		}
	}

    /**
     * "Do nothing" act method.  This is provided for the Ant Farm
     * <code>Cake, Cookie, and QueenAnt</code> classes which do not act.
     */
    @Override
    public void act()
    {
    }

    /**
     * Creates a string that describes this actor.
     * @return a string with the <code>Actor</code> information
     * plus the amount of food eaten from this <code>Cake</code>
     */
    @Override
	public String toString()
	{
		return super.toString() + ", BITE_SIZE= " + BITE_SIZE + ", TOTAL_SIZE= " + TOTAL_SIZE + ", foodEaten= " + foodEaten; 
	}
}
