package fr.pizzeria.ihm.pizza;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.ConnectionException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Menu item pour lister les pizzas
 * 
 * @author ETY 10
 *
 */
public class OptionListePizzas extends OptionMenu {

	private IDao<Pizza> daoPizza;

	@Override
	public String getLibelle() {
		return "Liste des pizzas";
	}

	@Override
	public void execute() {
		try {
			daoPizza.findAll().stream().forEach(System.out::println);
		} catch (ConnectionException e) {
			throw new ConnectionException("\n!!! Une erreur a ete enregistree : " + e);
		}
	}

	public void setDaoPizza(IDao<Pizza> daoPizza) {
		this.daoPizza = daoPizza;
	}

}
