package ch.epfl.cs107.play.game.areagame;

import ch.epfl.cs107.play.window.Window;

/**
 * AreaBehavior manages a map of Cells.
 */
public abstract class AreaBehavior
{

    /// The behavior is an Image of size height x width
	private final Image behaviorMap;
	private final int width, height;
	
	/// we will convert the image into an array of cells
	private final Cell[][] cells;
	

    // TODO implements me #PROJECT #TUTO

    /**
     * Default AreaBehavior Constructor
     * @param window (Window): graphic context, not null
     * @param fileName (String): name of the file containing the behavior image, not null
     */
    public AreaBehavior(Window window, String fileName){
    	
    	//...
    	/**
    	* Each game will have its own Cell extension. */
    	public abstract class Cell { //...
    	}
    	
    }

}
