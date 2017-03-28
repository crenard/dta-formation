package fr.pizzeria.ihm.pizza;

import java.util.Comparator;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Menu item pour obtenir la pizza la plus chere
 * 
 * @author ETY 10
 *
 */
public class OptionExpensivePizza extends OptionMenu {

	private IDao<Pizza> daoPizza;

	@Override
	public String getLibelle() {
		return "Pizza la plus chere";
	}

	@Override
	public void execute() {
		daoPizza.findAll().stream().max(Comparator.comparingDouble(Pizza::getPrix)).ifPresent(System.out::println);
	}

	public void setDaoPizza(IDao<Pizza> daoPizza) {
		this.daoPizza = daoPizza;
	}

}
