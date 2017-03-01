package fr.chat;

import java.util.*;

import fr.chat.view.*;

public class ChatClientApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			new ChatConsoleView(sc).print();
		}
	}

}
