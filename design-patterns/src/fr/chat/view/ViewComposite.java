package fr.chat.view;

import java.util.*;

import fr.chat.controller.ChatAuthController;
import fr.chat.model.ChatMessage;
import fr.chat.model.observer.ChatObservable;
import fr.chat.model.observer.ChatObserver;

public abstract class ViewComposite implements ChatObserver<ChatMessage> {

	private List<ViewComposite> children = new ArrayList<>();

	protected ChatAuthController authController;

	protected String login;

	public void setAuthController(ChatAuthController authController) {
		this.authController = authController;
		this.children.forEach(view -> view.setAuthController(authController));
	}

	public void add(ViewComposite view) {
		children.add(view);
	}

	public int count() {
		return children.size();
	}

	public void print() {
		for (ViewComposite view : children) {
			view.print();
		}
	}

	public void setLogin(String login) {
		this.login = login;
		this.children.forEach(view -> view.setLogin(login));
	}

	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		login = obj.getLogin();
		this.children.forEach(view -> view.update(observable, obj));
	}
}
