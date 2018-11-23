package ch.epfl.cs107.play.game.demo1;

import java.awt.Color;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.GraphicsEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.game.demo1.actor.MovingRock;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Window;

public class Demo1 implements Game {
	
	// framework
	FileSystem fileSystem;
	Window window;
	
	private Actor actor1;
	private MovingRock movingRock;

	@Override
	public boolean begin(Window window, FileSystem fileSystem) {
		this.window = window;
		this.fileSystem = fileSystem;
		
		actor1 = new GraphicsEntity(Vector.ZERO, new ShapeGraphics(new Circle(0.2f), null,
				Color.RED, 0.005f));
		movingRock = new MovingRock(Vector.ZERO, "Hello there");
		return true;
	}

	@Override
	public void end() {
		
	}

	@Override
	public String getTitle() {
		return "Demo1";
	}

	@Override
	public void update(float deltaTime) {
		actor1.draw(window);
		movingRock.draw(window);
	}

	@Override
	public int getFrameRate() {
		return 24;
	}
	
}
