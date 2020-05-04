package trianglePlugin;

import interfaces.IPluginsAppPlugin;
import interfaces.IShape;

public class TrianglePlugin implements IPluginsAppPlugin {
	@Override
	public String getUniqueNameText() {
		return "TrianglePlugin";
	}

	@Override
	public String getDisplayText() {
		return "Triangle";
	}

	@Override
	public IShape getShape() {
		return new Triangle();
	}
}