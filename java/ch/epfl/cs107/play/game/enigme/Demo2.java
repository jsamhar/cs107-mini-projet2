package ch.epfl.cs107.play.game.enigme;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.AreaGame;
import ch.epfl.cs107.play.game.enigme.area.demo2.Room0;
import ch.epfl.cs107.play.game.enigme.area.demo2.Room1;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.window.Window;

public class Demo2 extends AreaGame {

	private final String title = "Demo 2";
	
	public boolean begin(Window window, FileSystem fileSystem) {
		super.begin(window, fileSystem);
		Area room0 = new Room0();
		Area room1 = new Room1();
		addArea(room0);
		addArea(room1);
		try {
			setCurrentArea(room0.getTitle(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public int getFrameRate() {
		return 24;
	}

	@Override
	public String getTitle() {
		return title;
	}

}
