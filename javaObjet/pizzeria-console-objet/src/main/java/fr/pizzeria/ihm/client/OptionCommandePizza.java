package fr.pizzeria.ihm.client;

import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Client;

public class OptionCommandePizza extends OptionMenu {

	private Client client;

	public OptionCommandePizza(Client client) {
		this.client = client;
	}

	@Override
	public String getLibelle() {
		return "Commander une pizza";
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
