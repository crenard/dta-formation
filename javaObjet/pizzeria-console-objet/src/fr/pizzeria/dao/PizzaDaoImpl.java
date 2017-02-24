package fr.pizzeria.dao;

import java.util.Arrays;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IDao<Pizza> {

	Pizza pep = new Pizza(0, "PEP", "Peperoni", 12.50);
	Pizza mar = new Pizza(1, "MAR", "Margherita", 14.00);
	Pizza rei = new Pizza(2, "REI", "La Reine", 11.50);
	Pizza fro = new Pizza(3, "FRO", "La 4 fromage", 12.00);
	Pizza can = new Pizza(4, "CAN", "La cannibale", 12.50);
	Pizza sav = new Pizza(5, "SAV", "La savoyarde", 13.00);
	Pizza ori = new Pizza(6, "ORI", "L'orientale", 13.50);
	Pizza ind = new Pizza(7, "IND", "L'indienne", 14.00);
	private Pizza[] pizzas = { pep, mar, rei, fro, can, sav, ori, ind };

	@Override
	public Pizza[] findAll() {
		return pizzas;
	}

	@Override
	public void save(Pizza pizza) throws StockageException {
		try {
			int size = pizzas.length;
			Pizza[] newPizzas = Arrays.copyOf(pizzas, size + 1);
			newPizzas[size] = pizza;
			pizzas = newPizzas;
			Pizza.nbPizzas++;
		} catch (Exception e) {
			throw new SavePizzaException(e.getCause());
		}
	}

	@Override
	public void update(String codePizza, Pizza newPizza) throws StockageException {
		int index = 0;
		boolean found = false;
		for (Pizza pizza : pizzas) {
			if (codePizza.equals(pizza.code)) {
				pizzas[index] = newPizza;
				found = true;
				break;
			}
			index++;
		}
		if (!found) {
			throw new UpdatePizzaException();
		}
	}

	@Override
	public void delete(String codePizza) throws StockageException {
		int index = 0;
		int size = pizzas.length;
		boolean found = false;
		for (Pizza pizza : pizzas) {
			if (codePizza.equals(pizza.code)) {
				Pizza[] newPizzas = new Pizza[size - 1];
				System.arraycopy(pizzas, 0, newPizzas, 0, index);
				System.arraycopy(pizzas, index + 1, newPizzas, index, size - index - 1);
				pizzas = newPizzas;
				Pizza.nbPizzas--;
				found = true;
				break;
			}
			index++;
		}
		if (!found) {
			throw new DeletePizzaException();
		}
	}

}
