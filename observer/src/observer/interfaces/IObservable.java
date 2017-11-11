package observer.interfaces;

public interface IObservable {
	public void addObserver(IObserver o);

	public void removeObserver(IObserver o);

	public void addObserver(IExceptionObserver o);

	public void removeObserver(IExceptionObserver o);

	public void notifyAllObservers(String str);
	
	public void notifyAllObservers(Throwable e);
}
