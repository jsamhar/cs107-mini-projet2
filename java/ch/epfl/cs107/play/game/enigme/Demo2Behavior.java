package ch.epfl.cs107.play.game.enigme;

import ch.epfl.cs107.play.game.areagame.AreaBehavior;
import ch.epfl.cs107.play.window.Window;

public class Demo2Behavior extends AreaBehavior {
	
	public Demo2Behavior(Window window, String fileName) {
		super(window, fileName);
		// fill in the cells
		for(int x = 0; x < getWidth(); ++x) {
			for(int y = 0; y < getHeight(); ++y) {
				setCellAt(x, y, new Demo2Cell(x, y, Demo2CellType.toType(getBehaviorMap().getRGB(getHeight()-1-y, x))));
			}
		}
	}

	public enum Demo2CellType {
		NULL(0),
		WALL(-16777216),
		DOOR(-65536),
		WATER(-16776961),
		INDOOR_WALKABLE(-1),
		OUTDOOR_WALKABLE(-14112955);
		
		final int type;
		
		Demo2CellType(int type) {
			this.type = type;
		}
		
		static Demo2CellType toType(int type) {
			for(Demo2CellType ct : Demo2CellType.values())
				if(ct.type == type)
					return ct;
			return Demo2CellType.NULL;
		}
		
	}
	
	public class Demo2Cell extends Cell {
		
		private Demo2CellType type;

		private Demo2Cell(int x, int y, Demo2CellType type) {
			super(x, y);
			this.type = type;
		}
		
	}
	
}
