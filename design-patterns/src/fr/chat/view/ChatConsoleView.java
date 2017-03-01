package fr.chat.view;

import java.util.*;

public class ChatConsoleView extends ViewComposite {

	public ChatConsoleView(Scanner sc) {
		this.add(new ChatConsoleTitleView("= CHAT APP"));
		this.add(new ChatConsoleLoginView(sc));
		this.add(new ChatConsoleConversationView(sc));
	}
}
