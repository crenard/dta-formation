package fr.pizzeria.ihm.pizza;

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
		ihmTools.getDaoPizza().findAll().stream().forEach(System.out::println);
	}

}
