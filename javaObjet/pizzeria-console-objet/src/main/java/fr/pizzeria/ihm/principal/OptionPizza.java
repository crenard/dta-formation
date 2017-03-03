package fr.pizzeria.ihm.principal;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuPizza;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionPizza extends OptionMenu {

	public OptionPizza(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Gerer les pizzas";
	}

	@Override
	public void execute() throws StockageException {
		Menu menuPizza = new MenuPizza("**** Administration des pizzas ****", ihmTools);
		menuPizza.executer();
	}

}
