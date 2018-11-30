package ch.epfl.cs107.play.game.enigme.area.demo2;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.enigme.Demo2Behavior;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.window.Window;

public abstract class Demo2Area extends Area {
	
	private String title;
	
	public boolean begin(Window window, FileSystem fileSystem) {
		super.begin(window, fileSystem);
		setBehavior(new Demo2Behavior(window, getTitle()));
		initializeArea();
		return true;
	}
	
	public abstract String getTitle();
	
	public float getCameraScaleFactor() {
		return 22f;
	}
	
	protected abstract void initializeArea();
	
}
