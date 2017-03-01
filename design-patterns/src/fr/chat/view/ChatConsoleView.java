package fr.chat.view;

import java.util.*;

import fr.chat.model.ChatMessage;
import fr.chat.model.observer.ChatObservable;
import fr.chat.model.observer.ChatObserver;

public class ChatConsoleView extends ViewComposite {

	public ChatConsoleView(Scanner sc) {
		ChatConsoleTitleView titleView = new ChatConsoleTitleView("= CHAT APP");
		this.add(titleView);
		ChatConsoleLoginView loginView = new ChatConsoleLoginView(sc);
		this.add(loginView);
		ChatConsoleConversationView conversationView = new ChatConsoleConversationView();
		this.add(conversationView);
	}

}
