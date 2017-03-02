package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket {

	private ClientSocket clientSocket;

	public ChatSocketImpl(String hostname, Integer port) throws ChatClientException {
		try {
			clientSocket = new ClientSocket(hostname, port);
		} catch (IOException e) {
			throw new ChatClientException("Probleme a la connection", e);
		}
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			clientSocket.sendObject(msg);
		} catch (IOException e) {
			throw new ChatClientException("Probleme a l'envoi", e);
		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		try {
			return (ChatMessage) clientSocket.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new ChatClientException("Probleme a la lecture", e);
		}
	}

	@Override
	public void close() throws Exception {
		clientSocket.close();

	}

}
