package fr.pizzeria.ihm.principal;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuPizza;
import fr.pizzeria.ihm.OptionMenu;

/**
 * Menu item pour la gestion des pizzas
 * 
 * @author ETY 10
 *
 */
public class OptionPizza extends OptionMenu {

	@Override
	public String getLibelle() {
		return "Gerer les pizzas";
	}

	@Override
	public void execute() {
		Menu menuPizza = new MenuPizza("**** Administration des pizzas ****");
		menuPizza.executer();
	}

}
