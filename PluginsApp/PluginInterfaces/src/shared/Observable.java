package shared;

import java.util.ArrayList;

import interfaces.IObservable;
import interfaces.IObserver;

// Subject
public class Observable implements IObservable {

	protected ArrayList<IObserver> observers = new ArrayList<IObserver>();

	protected void notifyObservers(Object observable) {
		for (IObserver elem : observers) {
			elem.notification(observable);
		}
	}

	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
		notifyObservers(this);
	}

}
