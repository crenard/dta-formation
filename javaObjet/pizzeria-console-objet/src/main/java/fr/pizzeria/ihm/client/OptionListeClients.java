package fr.pizzeria.ihm.client;

import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionListeClients extends OptionMenu {

	public OptionListeClients(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Lister les clients";
	}

	@Override
	public void execute() {
		ihmTools.getDaoClient().findAll().stream().forEach(System.out::println);

	}

}
