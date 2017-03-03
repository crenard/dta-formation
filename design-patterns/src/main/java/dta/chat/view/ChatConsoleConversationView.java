package dta.chat.view;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

public class ChatConsoleConversationView extends ViewComposite implements ChatObserver<ChatMessage> {

	@Override
	public void print() {
		System.out.println("== Conversations ==");
	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		System.out.println(obj.getLogin() + " : " + obj.getMsg());
	}

}
