package fr.pizzeria.ihm;

import fr.pizzeria.ihm.principal.*;
import fr.pizzeria.ihm.tools.IhmTools;

/**
 * Menu principal
 * 
 * @author ETY 10
 *
 */
public class MenuPrincipal extends Menu {
	/**
	 * Creation du menu principal
	 * 
	 * @param titre
	 * @param ihmTools
	 */
	public MenuPrincipal(String titre, IhmTools ihmTools) {
		super(titre, ihmTools);
		actions.put(1, new OptionPizza(ihmTools));
		actions.put(2, new OptionClient(ihmTools));
	}

}
