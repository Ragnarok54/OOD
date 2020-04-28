package squarePlugin;

import circlePlugin.Circle;
import interfaces.IPluginsAppPlugin;
import interfaces.IShape;

public class SquarePlugin implements IPluginsAppPlugin {
	@Override
	public String getUniqueNameText() {
		return "SquarePlugin";
	}

	@Override
	public String getDisplayText() {
		return "Square";
	}

	@Override
	public IShape getShape() {
		return new Square();
	}
}
