package fr.pizzeria.ihm;

import fr.pizzeria.ihm.client.OptionCommandePizza;
import fr.pizzeria.ihm.client.OptionListeCommandes;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Client;

public class MenuClientConnecte extends Menu {

	public MenuClientConnecte(String titre, IhmTools ihmTools, Client client) {
		super(titre, ihmTools);
		actions.put(1, new OptionCommandePizza(ihmTools, client));
		actions.put(2, new OptionListeCommandes(ihmTools, client));
	}

}
