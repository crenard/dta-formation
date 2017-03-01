package fr.chat.model;

public class ChatMessage {
	private String login;
	private String text;

	public ChatMessage(String login, String text) {
		this.login = login;
		this.text = text;
	}

	public String getLogin() {
		return login;
	}

	public String getText() {
		return text;
	}

}
