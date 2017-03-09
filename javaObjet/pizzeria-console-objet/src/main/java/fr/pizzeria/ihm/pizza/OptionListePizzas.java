package fr.pizzeria.ihm.pizza;

import fr.pizzeria.exception.ConnectionException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionListePizzas extends OptionMenu {

	public OptionListePizzas(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Liste des pizzas";
	}

	@Override
	public void execute() {
		try {
			ihmTools.getDaoPizza().findAll().stream().forEach(System.out::println);
		} catch (ConnectionException e) {
			System.out.println(e.getMessage());
		}
	}
}
