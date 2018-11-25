package ch.epfl.cs107.play.game.demo1.actor;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.GraphicsEntity;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.TextGraphics;
import ch.epfl.cs107.play.game.areagame.io.ResourcePath;
import ch.epfl.cs107.play.math.Vector;

public class MovingRock extends GraphicsEntity {

	private TextGraphics text;
	
	public MovingRock(Vector position, String text) {
		super(position, new ImageGraphics(ResourcePath.getSprite("rock.3"), 0.1f, 0.1f,
				null, Vector.ZERO, 1.0f, -Float.MAX_VALUE));
		
		this.text = new TextGraphics(text, 0.04f, Color.BLUE);
		this.text.setParent(this);
		this.text.setAnchor(new Vector(0f, 0.12f));
	}
	
	public TextGraphics getText() {
		return text;
	}
	
}
