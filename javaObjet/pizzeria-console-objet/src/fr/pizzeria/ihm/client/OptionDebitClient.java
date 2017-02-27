package fr.pizzeria.ihm.client;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionDebitClient extends OptionMenu {

	public OptionDebitClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Debiter le compte d'un client";
	}

	@Override
	public void execute() throws StockageException {

	}

}
