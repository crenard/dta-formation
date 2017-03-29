package fr.pizzeria.ihm.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
@Component
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

	@Autowired
	@Qualifier("daoPizza")
	public void setDaoPizza(IDao<Pizza> daoPizza) {
		this.daoPizza = daoPizza;
	}

}
