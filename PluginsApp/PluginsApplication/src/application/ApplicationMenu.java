package application;


import java.util.ArrayList;

import interfaces.IShape;

public class ApplicationMenu {

	private PluginManager pluginMan;
	private Menu mainMenu = null;

	public ApplicationMenu(PluginManager pluginMan) {
		this.pluginMan = pluginMan;
	}

	public void load(CompositeShape list) {
		pluginMan.loadPlugins("/plugins");
		ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();

		int shortCut = 1;
		var plugins = pluginMan.getPlugins();

		for (int i = 0; i < plugins.size(); i++) {
			var currentPlugin = plugins.get(i);
			MenuItem currentItem = new MenuItem(plugins.get(i).getDisplayText(), shortCut++, (parameters) -> {
				IShape shape = currentPlugin.getShape();
				shape.read();
				list.add(shape);
			});
			menuItems.add(currentItem);

		}
		mainMenu = new Menu("Main Menu", -1, menuItems);

	}
	
	public void execute() {
		mainMenu.execute();
	}

}