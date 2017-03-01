package fr.chat.view;

import java.util.Scanner;

public class ChatConsoleConversationView extends ViewComposite {

	private Scanner sc;
	private String message;

	public ChatConsoleConversationView(Scanner sc) {
		this.sc = sc;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public void print() {
		System.out.println("== Conversations ==");
		message = sc.nextLine();
	}

}
