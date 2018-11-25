package ch.epfl.cs107.play.game.areagame;

import ch.epfl.cs107.play.window.Window;

import ch.epfl.cs107.play.math.DiscreteCoordinates;

import ch.epfl.cs107.play.window.Image;



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
	
	//...
	/**
	* Each game will have its own Cell extension. */
	public abstract class Cell{ //...
		/// variables de classe
		private DiscreteCoordinates coords;
		public Cell(int x, int y) {
		coords = new DiscreteCoordinates(x, y);
		
		}
	
	}
	
	
    public AreaBehavior(Window window, String fileName){
    	
    	behaviorMap = window.getImage(ResourcePath.getBehaviors(fileName), null, false);

    	
    }

}
