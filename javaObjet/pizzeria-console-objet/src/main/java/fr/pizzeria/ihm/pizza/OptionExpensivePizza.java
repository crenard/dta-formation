package fr.pizzeria.ihm.pizza;

import java.util.Comparator;

import fr.pizzeria.model.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

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
