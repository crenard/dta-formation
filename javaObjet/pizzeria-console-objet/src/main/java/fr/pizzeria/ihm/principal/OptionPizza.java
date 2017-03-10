package fr.pizzeria.ihm.principal;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuPizza;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

/**
 * Menu item pour la gestion des pizzas
 * 
 * @author ETY 10
 *
 */
public class OptionPizza extends OptionMenu {
	/**
	 * Creation du menu item pour la gestion des pizzas
	 * 
	 * @param ihmTools
	 */
	public OptionPizza(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Gerer les pizzas";
	}

	@Override
	public void execute() {
		Menu menuPizza = new MenuPizza("**** Administration des pizzas ****", ihmTools);
		menuPizza.executer();
	}

}
