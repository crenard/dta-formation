package dta.chat.model.socket;

import dta.chat.exception.ChatClientException;
import dta.chat.history.HistoryFacade;
import dta.chat.model.ChatMessage;

public class ChatSocketProxy implements ChatSocket {

	private ChatSocket socket;
	HistoryFacade facade = new HistoryFacade();

	public ChatSocketProxy(String hostname, Integer port) {
		socket = new ChatSocketImpl(hostname, port);
	}

	@Override
	public void close() throws Exception {
		socket.close();
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		socket.sendMessage(msg);
		if (!msg.getMsg().equals("")) {
			facade.saveMessage(msg);
		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		ChatMessage msg = socket.readMessage();
		if (!msg.getMsg().equals("")) {
			facade.saveMessage(msg);
		}
		return msg;
	}

}
