package fr.pizzeria.ihm.client;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionCreditClient extends OptionMenu {

	public OptionCreditClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Crediter le compte d'un client";
	}

	@Override
	public void execute() throws StockageException {
		// TODO Auto-generated method stub

	}

}
