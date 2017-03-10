package fr.pizzeria.ihm.client;

import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

/**
 * Menu item pour lister les clients
 * 
 * @author ETY 10
 *
 */
public class OptionListeClients extends OptionMenu {
	/**
	 * Creation du menu item pour lister les clients
	 * 
	 * @param ihmTools
	 */
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
