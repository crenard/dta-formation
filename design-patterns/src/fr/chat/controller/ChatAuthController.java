package fr.chat.controller;

@FunctionalInterface
public interface ChatAuthController {
	void authenticate(String login);
}
