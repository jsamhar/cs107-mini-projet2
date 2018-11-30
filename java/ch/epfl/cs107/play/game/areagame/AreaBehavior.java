package ch.epfl.cs107.play.game.areagame;

import ch.epfl.cs107.play.game.areagame.io.ResourcePath;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Image;
import ch.epfl.cs107.play.window.Window;

/**
 * AreaBehavior manages a map of Cells.
 */
public abstract class AreaBehavior
{
	//
	private final Window window;

    // The behavior is an Image of size height x width
	private final Image behaviorMap;
	private final int width, height;
	
	// we will convert the image into an array of cells
	private final Cell[][] cells;
	
	//

	public AreaBehavior(Window window, String fileName) {
		this.window = window;
		behaviorMap = window.getImage(ResourcePath.getBehaviors(fileName), null, false);
    	width = behaviorMap.getWidth();
    	height = behaviorMap.getHeight();
    	cells = new Cell[width][height];
    }

	/**
	* Each game will have its own Cell extension. 
	* The cell types (WALL, AIR, DOOR etc.) will be defined in the application rather
	* than in the engine/framework */
	public abstract class Cell { //...
		
		private DiscreteCoordinates coords;
		
		public Cell(int x, int y) {
			coords = new DiscreteCoordinates(x, y);
		}
	
	}
	
	public final Image getBehaviorMap() {
		return behaviorMap;
	}
	
	public final int getWidth() {
		return width;
	}
	
	public final int getHeight() {
		return height;
	}
	
	public final void setCellAt(int x, int y, Cell cell) {
		cells[x][y] = cell;
	}

}
