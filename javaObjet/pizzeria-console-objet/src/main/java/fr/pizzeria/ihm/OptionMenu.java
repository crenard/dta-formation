package fr.pizzeria.ihm;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.tools.IhmTools;

public abstract class OptionMenu {

	protected IhmTools ihmTools;

	public OptionMenu(IhmTools ihmTools) {
		this.ihmTools = ihmTools;
	}

	public abstract String getLibelle();

	public abstract void execute() throws StockageException;
}
