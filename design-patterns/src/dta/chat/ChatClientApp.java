package dta.chat;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatConversationModel;
import dta.chat.model.socket.ChatSocketImpl;
import dta.chat.view.*;

public class ChatClientApp {

	private static final String IP_ADRESS = "192.168.99.31";
	private static final Integer PORT = 1800;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			ChatConversationModel model = new ChatConversationModel(new ChatSocketImpl(IP_ADRESS, PORT));
			final ChatConsoleView view = new ChatConsoleView(sc);

			view.setAuthController((login) -> model.setLogin(login));

			model.addObserver(view);

			view.print();

			new Thread(() -> {
				while (true) {
					try {
						model.readMessage();
					} catch (ChatClientException e) {
						e.printStackTrace();
					}
				}
			}).start();

			String msg = sc.nextLine();
			while (true) {
				model.sendMessage(msg);
				msg = sc.nextLine();
				if (msg.equalsIgnoreCase("exit")) {
					break;
				}
			}

			try {
				model.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
