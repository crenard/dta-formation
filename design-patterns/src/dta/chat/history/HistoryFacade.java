package dta.chat.history;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import dta.chat.exception.ChatClientException;
import dta.chat.model.ChatMessage;

public class HistoryFacade {

	public List<ChatMessage> findLastMessages() throws ChatClientException {
		List<ChatMessage> result = new ArrayList<>();
		try {
			Files.readAllLines(Paths.get("data", "history.txt")).forEach(s -> {
				String[] split = s.split(" l:m ");
				result.add(new ChatMessage(split[0], split[1]));
			});
		} catch (IOException e) {
			throw new ChatClientException("Impossible de recuperer l'historique", e);
		}
		return result;
	}

	public void saveMessage(ChatMessage message) throws ChatClientException {
		try {
			Files.write(Paths.get("data", "history.txt"),
					(message.getLogin() + " l:m " + message.getMsg() + "\n").getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new ChatClientException("Impossible de sauvegarder l'historique", e);
		}
	}

}
