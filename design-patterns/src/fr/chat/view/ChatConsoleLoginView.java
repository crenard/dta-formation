package fr.chat.view;

import java.util.*;

public class ChatConsoleLoginView extends ViewComposite {

	private Scanner sc;

	public ChatConsoleLoginView(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void print() {
		System.out.print("== Authentification ==\nVeuillez saisir votre login : ");
		String login = sc.nextLine();
		authController.authenticate(login);
	}
}
