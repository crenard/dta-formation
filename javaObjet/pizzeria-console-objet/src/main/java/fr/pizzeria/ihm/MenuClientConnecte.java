package fr.pizzeria.ihm;

import java.util.HashMap;

import fr.pizzeria.ihm.client.OptionCommandePizza;
import fr.pizzeria.ihm.client.OptionListeCommandes;
import fr.pizzeria.model.Client;

public class MenuClientConnecte extends Menu {

	public MenuClientConnecte(String titre, Client client) {
		this.titre = titre;
		actions = new HashMap<>();
		actions.put(1, new OptionCommandePizza(client));
		actions.put(2, new OptionListeCommandes(client));
	}

}
