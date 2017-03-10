package fr.pizzeria.ihm;

import fr.pizzeria.ihm.tools.IhmTools;

/**
 * Menu item
 * 
 * @author ETY 10
 *
 */
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

	/**
	 * Execute l'action du menu item
	 */
	public abstract void execute();
}
