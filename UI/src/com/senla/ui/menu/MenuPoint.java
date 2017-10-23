package com.senla.ui.menu;

import com.senla.controller.IController;
import com.senla.ui.action.Action;

public class MenuPoint {
	private Action act;
	private Menu menu;
	private String title;
	private IController controller;

	public MenuPoint(IController controller, Menu menu, String title) {
		this(controller, menu, title, null);
	}

	public MenuPoint(IController controller, Menu menu, String title, Action act) {
		this.controller = controller;
		this.act = act;
		this.title = title;
		this.menu = menu;
	}

	public Menu doWork() throws IllegalArgumentException, IllegalAccessException {
		if (this.act != null) {
			act.doAction(controller);
		}
		return menu;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
