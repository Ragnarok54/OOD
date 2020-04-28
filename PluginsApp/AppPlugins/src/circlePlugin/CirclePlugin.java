package circlePlugin;

import interfaces.IPluginsAppPlugin;
import interfaces.IShape;

public class CirclePlugin implements IPluginsAppPlugin {
	@Override
	public String getUniqueNameText() {
		return "CirclePlugin";
	}

	@Override
	public String getDisplayText() {
		return "Circle";
	}

	@Override
	public IShape getShape() {
		return new Circle();
	}
}
