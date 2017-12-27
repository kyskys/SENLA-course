package com.senla.ui.menu;

import com.senla.ui.action.IAction;

public class MenuPoint {
	private IAction act;
	private Menu menu;
	private String title;

	public MenuPoint(Menu menu, String title) {
		this(menu, title, null);
	}

	public MenuPoint(Menu menu, String title, IAction act) {
		this.act = act;
		this.title = title;
		this.menu = menu;
	}

	public Menu doWork() throws Throwable {
		if (this.act != null) {
			act.doAction();
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
