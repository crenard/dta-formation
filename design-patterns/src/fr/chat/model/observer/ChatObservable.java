package fr.chat.model.observer;

import java.util.*;

public abstract class ChatObservable<T> {
	List<ChatObserver<T>> observers = new ArrayList<>();

	public void addObserver(ChatObserver<T> observer) {
		observers.add(observer);
	}

	public void removeObserver(ChatObserver<T> observer) {
		observers.add(observer);
	}

	public void notifyObservers(T msg) {
		observers.forEach(o -> o.update(this, msg));
	}
}
