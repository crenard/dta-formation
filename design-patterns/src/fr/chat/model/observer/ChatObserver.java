package fr.chat.model.observer;

@FunctionalInterface
public interface ChatObserver<T> {
	void update(ChatObservable<T> observable, T obj);
}
