package fr.pizzeria.ihm;

import fr.pizzeria.ihm.client.*;
import fr.pizzeria.ihm.tools.IhmTools;

public class MenuClient extends Menu {

	public MenuClient(String titre, IhmTools ihmTools) {
		super(titre, ihmTools);
		actions.put(1, new OptionListeClients(ihmTools));
		actions.put(2, new OptionAddClient(ihmTools));
		actions.put(3, new OptionCreditClient(ihmTools));
		actions.put(4, new OptionDebitClient(ihmTools));
	}

}
