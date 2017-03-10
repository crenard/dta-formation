package fr.pizzeria.ihm.pizza;

import java.util.Comparator;

import fr.pizzeria.model.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

/**
 * Menu item pour obtenir la pizza la plus chere
 * 
 * @author ETY 10
 *
 */
public class OptionExpensivePizza extends OptionMenu {
	/**
	 * Creation du menu item pour obtenir la pizza la plus chere
	 * 
	 * @param ihmTools
	 */
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
