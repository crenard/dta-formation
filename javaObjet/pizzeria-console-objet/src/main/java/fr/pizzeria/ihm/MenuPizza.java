package fr.pizzeria.ihm;

import fr.pizzeria.ihm.pizza.*;
import fr.pizzeria.ihm.tools.IhmTools;

public class MenuPizza extends Menu {

	public MenuPizza(String titre, IhmTools ihmTools) {
		super(titre, ihmTools);
		actions.put(1, new OptionListePizzas(ihmTools));
		actions.put(2, new OptionAddPizza(ihmTools));
		actions.put(3, new OptionChangePizza(ihmTools));
		actions.put(4, new OptionRemovePizza(ihmTools));
		actions.put(5, new OptionListeCategorie(ihmTools));
		actions.put(6, new OptionExpensivePizza(ihmTools));
	}

}
