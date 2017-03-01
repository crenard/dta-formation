package fr.chat.model;

import fr.chat.model.observer.ChatObservable;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	private String login = "";

	public void setLogin(String login) {
		this.login = login;
		this.notifyObservers(new ChatMessage("Welcome", login));
	}

	public void sendMessage(String msg) {
		this.notifyObservers(new ChatMessage(login, msg));
	}
}
