package fr.pizzeria.ihm;

import fr.pizzeria.ihm.client.*;
import fr.pizzeria.ihm.tools.IhmTools;

public class MenuClient extends Menu {

	public MenuClient(String titre, IhmTools ihmTools) {
		super(titre, ihmTools);
		actions.put(1, new OptionInscription(ihmTools));
		actions.put(2, new OptionConnect(ihmTools));
	}

}
