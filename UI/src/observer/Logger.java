package observer;

import observer.interfaces.IObserver;

public class Logger implements IObserver{
	private Logger logger = new Logger();//here will be logger
	@Override
	public void display(String str) {
		logger.log(str);//here will be logging operation
	}
}
