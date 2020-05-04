package rectanglePlugin;

import interfaces.IPluginsAppPlugin;
import interfaces.IShape;

public class RectanglePlugin implements IPluginsAppPlugin {
	@Override
	public String getUniqueNameText() {
		return "RectangleePlugin";
	}

	@Override
	public String getDisplayText() {
		return "Rectangle";
	}

	@Override
	public IShape getShape() {
		return new Rectangle();
	}
}