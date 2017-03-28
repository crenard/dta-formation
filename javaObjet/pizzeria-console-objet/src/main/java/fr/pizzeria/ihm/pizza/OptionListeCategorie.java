package fr.pizzeria.ihm.pizza;

import java.util.stream.Collectors;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Menu item pour lister les pizzas par categories
 * 
 * @author ETY 10
 *
 */
public class OptionListeCategorie extends OptionMenu {

	private IDao<Pizza> daoPizza;

	@Override
	public String getLibelle() {
		return "Pizzas par categories";
	}

	@Override
	public void execute() {
		daoPizza.findAll().stream().collect(Collectors.groupingBy(Pizza::getCategorie)).forEach((k, v) -> {
			System.out.println(k);
			v.stream().forEach(System.out::println);
			System.out.println();
		});

	}

	public void setDaoPizza(IDao<Pizza> daoPizza) {
		this.daoPizza = daoPizza;
	}

}
