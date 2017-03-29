package fr.pizzeria.ihm.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuClient;
import fr.pizzeria.ihm.MenuPizza;
import fr.pizzeria.ihm.OptionMenu;

/**
 * Menu item pour la gestion des pizzas
 * 
 * @author ETY 10
 *
 */
@Component
public class OptionPizza extends OptionMenu {

	@Autowired
	private ApplicationContext context;

	@Override
	public String getLibelle() {
		return "Gerer les pizzas";
	}

	@Override
	public void execute() {
		Menu menuPizza = context.getBean(MenuPizza.class);
		menuPizza.executer();
	}

}
