package fr.pizzeria.ihm.principal;

import fr.pizzeria.ihm.*;
import fr.pizzeria.ihm.tools.IhmTools;

/**
 * Menu item pour la gestion des clients
 * 
 * @author ETY 10
 *
 */
public class OptionClient extends OptionMenu {
	/**
	 * Creation du menu item pour la gestion des clients
	 * 
	 * @param ihmTools
	 */
	public OptionClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Gerer les clients";
	}

	@Override
	public void execute() {
		Menu menuClient = new MenuClient("**** Pizzeria Client ****", ihmTools);
		menuClient.executer();
	}

}
