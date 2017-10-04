package menu;

import action.Action;

public class MenuPoint {
	private Action act;
	private Menu menu;
	private String title;

	public MenuPoint(Menu menu, String title) {
		this(menu,title,null);
	}

	public MenuPoint(Menu menu, String title, Action act) {
		this.act=act;
		this.title=title;
		this.menu=menu;
	}

	public Menu doWork() throws IllegalArgumentException, IllegalAccessException {
		if (this.act!=null) {
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
