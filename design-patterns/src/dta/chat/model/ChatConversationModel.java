package dta.chat.model;

import dta.chat.exception.ChatClientException;
import dta.chat.history.HistoryFacade;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatSocket;

public class ChatConversationModel extends ChatObservable<ChatMessage> implements ChatSocket {

	private ChatSocket socket;

	private String login;
	HistoryFacade facade = new HistoryFacade();

	public ChatConversationModel(ChatSocket socket) {
		this.socket = socket;
	}

	public void setLogin(String login) {
		this.login = login;
		this.notifyObservers(new ChatMessage("Welcome", login));
		facade.findLastMessages().forEach(m -> System.out.println(m.getLogin() + " : " + m.getMsg()));
	}

	@Override
	public void close() throws Exception {
		socket.close();
	}

	public void sendMessage(String msg) {
		ChatMessage chatMessage = new ChatMessage("\033[36m" + login + "\033[0m", msg);
		try {
			this.sendMessage(chatMessage);
		} catch (ChatClientException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		ChatMessage msg = socket.readMessage();
		this.notifyObservers(msg);
		return msg;
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		socket.sendMessage(msg);
	}
}
