package fr.chat.view;

import fr.chat.model.ChatMessage;
import fr.chat.model.observer.ChatObservable;
import fr.chat.model.observer.ChatObserver;

public class ChatConsoleConversationView extends ViewComposite implements ChatObserver<ChatMessage> {

	@Override
	public void print() {
		System.out.println("== Conversations ==");
	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		System.out.println(obj.getLogin() + " : " + obj.getText());
	}

}
