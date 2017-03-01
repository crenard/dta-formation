package fr.chat.view;

import java.util.*;

public class ChatConsoleLoginView extends ViewComposite {

	private Scanner sc;

	private String login = "";

	public ChatConsoleLoginView(Scanner sc) {
		this.sc = sc;
	}

	public String getLogin() {
		return login;
	}

	@Override
	protected void executeBefore() {
		System.out.print("== Authentification ==\nVeuillez saisir votre login : ");
		login = sc.nextLine();
	}

}
