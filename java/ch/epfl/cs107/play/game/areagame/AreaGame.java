package ch.epfl.cs107.play.game.areagame;

import java.util.HashMap;
import java.util.Map;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.window.Window;
import java.lang.Exception; 



/**
 * AreaGame is a type of Game displayed in a (MxN) Grid called Area
 * An AreaGame has multiple Areas
 */
abstract public class AreaGame implements Game {
	//context objects
	private Window window;
	private FileSystem fileSystem;
	///a map containing all the Area of the game
	private Map<String, Area> areas;
	///the current area the game is in:
	private Area currentArea;

    /**
     * Add an Area to the AreaGame list
     * @param a (Area): The area to add, not null
     */
    protected final void addArea(Area a){
    	areas.put(a.getTitle(), a);
    }

    /**
     * Setter for the current area: Select an Area in the list from its key
     * - the area is then begin or resume depending if the area is already started or not and if it is forced
     * @param key (String): Key of the Area to select, not null
     * @param forceBegin (boolean): force the key area to call begin even if it was already started
     * @return (Area): after setting it, return the new current area
     * @throws (Exception): if both the new and the old area are null
     */
    protected final Area setCurrentArea(String key, boolean forceBegin) throws Exception {
        if(currentArea != null) {
        	currentArea.suspend();
        }
        else if(areas.get(key) == null && currentArea == null) {
        	throw new Exception("Both the new and old areas are null.");
        }
        currentArea = areas.get(key);
        if(currentArea.started() && !forceBegin) {
        	currentArea.resume(window, fileSystem);
        } else {
        	currentArea.begin(window, fileSystem);
        }
        return currentArea; //TODO: check if this is correct
    }


    /**@return (Window) : the Graphic and Audio context*/
    protected final Window getWindow(){
        // TODO implements me #PROJECT #TUTO
        return null;
    }

    /**@return (FIleSystem): the linked file system*/
    protected final FileSystem getFileSystem(){
        // TODO implements me #PROJECT #TUTO
        return null;
    }


    /// AreaGame implements Playable

    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
    	this.window = window;
		this.fileSystem = fileSystem;
		
		areas = new HashMap<>();
        return true;
    }


    @Override
    public void update(float deltaTime) {
        currentArea.update(deltaTime);
    }

    @Override
    public void end() {
        // TODO save the game states somewhere
    }

}
