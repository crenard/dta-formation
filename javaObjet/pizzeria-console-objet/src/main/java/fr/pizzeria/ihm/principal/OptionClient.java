package fr.pizzeria.ihm.principal;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuClient;
import fr.pizzeria.ihm.OptionMenu;

/**
 * Menu item pour la gestion des clients
 * 
 * @author ETY 10
 *
 */
public class OptionClient extends OptionMenu {

	@Override
	public String getLibelle() {
		return "Gerer les clients";
	}

	@Override
	public void execute() {
		Menu menuClient = new MenuClient("**** Pizzeria Client ****");
		menuClient.executer();
	}

}
