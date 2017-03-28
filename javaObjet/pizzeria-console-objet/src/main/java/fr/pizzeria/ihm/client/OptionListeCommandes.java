package fr.pizzeria.ihm.client;

import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Client;

public class OptionListeCommandes extends OptionMenu {

	private Client client;

	public OptionListeCommandes(Client client) {
		this.client = client;
	}

	@Override
	public String getLibelle() {
		return "Lister ses commandes";
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
