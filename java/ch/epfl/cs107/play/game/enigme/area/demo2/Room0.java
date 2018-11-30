package ch.epfl.cs107.play.game.enigme.area.demo2;

import ch.epfl.cs107.play.game.areagame.actor.Background;

public class Room0 extends Demo2Area {

	public void initializeArea() {
		registerActor(new Background(this));
	}
	
	public String getTitle() {
		return "LevelSelector";
	}
	
}
