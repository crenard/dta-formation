package fr.pizzeria.ihm.pizza;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionImportBDD extends OptionMenu {

	public OptionImportBDD(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "(Base de donnees) Importer les donnees";
	}

	@Override
	public void execute() throws StockageException {

	}

}
