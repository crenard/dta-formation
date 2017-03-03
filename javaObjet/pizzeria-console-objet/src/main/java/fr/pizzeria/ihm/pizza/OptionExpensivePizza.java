package fr.pizzeria.ihm.pizza;

import java.util.Comparator;

import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

public class OptionExpensivePizza extends OptionMenu {

	public OptionExpensivePizza(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Pizza la plus chere";
	}

	@Override
	public void execute() {
		ihmTools.getDaoPizza().findAll().stream().max(Comparator.comparingDouble(Pizza::getPrix))
				.ifPresent(System.out::println);
	}

}
