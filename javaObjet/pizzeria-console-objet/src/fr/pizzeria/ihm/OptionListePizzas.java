package fr.pizzeria.ihm;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

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
		for (Pizza pizza : ihmTools.getDao().findAll()) {
			System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + " €)");
		}
		System.out.println(Pizza.nbPizzas + " pizzas ont été créées\n");
	}

}
