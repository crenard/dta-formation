package fr.pizzeria.ihm;

import fr.pizzeria.ihm.tools.IhmTools;

public abstract class OptionMenu {

	protected IhmTools ihmTools;

	/**
	 * Creation du menu item
	 * 
	 * @param ihmTools
	 */
	public OptionMenu(IhmTools ihmTools) {
		this.ihmTools = ihmTools;
	}

	public abstract String getLibelle();

	public abstract void execute();
}
