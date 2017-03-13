package fr.pizzeria.ihm.client;

import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.*;

public class OptionCommandePizza extends OptionMenu {

	private Client client;

	public OptionCommandePizza(IhmTools ihmTools, Client client) {
		super(ihmTools);
		this.client = client;
	}

	@Override
	public String getLibelle() {
		return "Commander une pizza";
	}

	@Override
	public void execute() {
		System.out.println(client.getNom() + " " + client.getPrenom());

	}

}
