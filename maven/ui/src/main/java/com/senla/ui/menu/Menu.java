package com.senla.ui.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<MenuPoint> list = new ArrayList<MenuPoint>();
	private String title;

	public Menu(String title) {
		this.title = title;
	}

	public List<MenuPoint> getList() {
		return list;
	}

	public void setList(List<MenuPoint> list) {
		this.list = list;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void add(MenuPoint menuPoint) {
		list.add(menuPoint);
	}

	public void showMenu() {
		System.out.println(title);
		for (int i = 0; i < list.size(); i++) {
			MenuPoint menuPoint = list.get(i);
			System.out.println(String.format("%s. %s", i + 1, menuPoint.getTitle()));
		}
	}
}
