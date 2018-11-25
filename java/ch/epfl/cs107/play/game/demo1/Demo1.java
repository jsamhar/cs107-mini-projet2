package ch.epfl.cs107.play.game.demo1;

import java.awt.Color;

import ch.epfl.cs107.play.game.Game;
import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.actor.GraphicsEntity;
import ch.epfl.cs107.play.game.actor.ShapeGraphics;
import ch.epfl.cs107.play.game.actor.TextGraphics;
import ch.epfl.cs107.play.game.demo1.actor.MovingRock;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.Circle;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Button;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;

public class Demo1 implements Game {
	
	// framework
	FileSystem fileSystem;
	Window window;
	
	private Actor redCircle;
	private MovingRock movingRock;
	private TextGraphics boom;

	@Override
	public boolean begin(Window window, FileSystem fileSystem) {
		this.window = window;
		this.fileSystem = fileSystem;
		
		redCircle = new GraphicsEntity(Vector.ZERO, new ShapeGraphics(new Circle(0.2f), null,
				Color.RED, 0.005f));
		movingRock = new MovingRock(new Vector(0.2f, 0.2f), "Leghh");
		boom = new TextGraphics("Boom!", 0.1f, Color.RED);
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
		Keyboard keyboard = window.getKeyboard();
		Button arrowDown = keyboard.get(Keyboard.DOWN);
		if(arrowDown.isDown())
			movingRock.update(deltaTime);
		if((redCircle.getPosition().sub(movingRock.getPosition())).getLength() <= 0.2f)
			boom.draw(window);
		redCircle.draw(window);
		movingRock.draw(window);
		movingRock.getText().draw(window);
	}

	@Override
	public int getFrameRate() {
		return 24;
	}
	
}
