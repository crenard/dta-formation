package fr.pizzeria.ihm;

import fr.pizzeria.ihm.principal.*;
import fr.pizzeria.ihm.tools.IhmTools;

public class MenuPrincipal extends Menu {

	public MenuPrincipal(String titre, IhmTools ihmTools) {
		super(titre, ihmTools);
		actions.put(1, new OptionPizza(ihmTools));
		actions.put(2, new OptionClient(ihmTools));
	}

}
