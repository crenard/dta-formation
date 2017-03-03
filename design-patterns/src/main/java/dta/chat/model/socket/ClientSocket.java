package dta.chat.model.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket extends Socket {

	private ObjectInputStream serverInput;
	private ObjectOutputStream serverOuput;

	public ClientSocket(String hostname, Integer port) throws IOException {
		super(hostname, port);
		this.serverInput = new ObjectInputStream(this.getInputStream());
		this.serverOuput = new ObjectOutputStream(this.getOutputStream());
	}

	public Object readObject() throws ClassNotFoundException, IOException {
		return this.serverInput.readObject();
	}

	public void sendObject(Object obj) throws IOException {
		this.serverOuput.writeObject(obj);
	}

	// Pour demo

	// public static void main(String[] args) throws Exception {
	// ChatSocket client = new ChatSocketImpl("localhost", 1800);
	// client.sendMessage(new ChatMessage("Rocky", "Bonjour"));
	// client.readMessage(); // pour recevoir un message du serveur
	// client.close();
	//
	// }
}
