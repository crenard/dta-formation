package fr.pizzeria.ihm.client;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionAddClient extends OptionMenu {

	public OptionAddClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Ajouter un nouveau client";
	}

	@Override
	public void execute() throws StockageException {
		// TODO Auto-generated method stub

	}

}
