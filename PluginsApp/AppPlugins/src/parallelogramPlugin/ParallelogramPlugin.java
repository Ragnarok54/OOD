package parallelogramPlugin;

import interfaces.IPluginsAppPlugin;
import interfaces.IShape;

public class ParallelogramPlugin implements IPluginsAppPlugin {
	@Override
	public String getUniqueNameText() {
		return "ParallelogramPlugin";
	}

	@Override
	public String getDisplayText() {
		return "Parallelogram";
	}

	@Override
	public IShape getShape() {
		return new Parallelogram();
	}
}