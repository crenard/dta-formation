package fr.pizzeria.dao;

import java.util.Arrays;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IDao<Pizza> {

	Pizza pep = new Pizza("PEP", "Peperoni", 12.50);
	Pizza mar = new Pizza("MAR", "Margherita", 14.00);
	Pizza rei = new Pizza("REI", "La Reine", 11.50);
	Pizza fro = new Pizza("FRO", "La 4 fromage", 12.00);
	Pizza can = new Pizza("CAN", "La cannibale", 12.50);
	Pizza sav = new Pizza("SAV", "La savoyarde", 13.00);
	Pizza ori = new Pizza("ORI", "L'orientale", 13.50);
	Pizza ind = new Pizza("IND", "L'indienne", 14.00);
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
			if (codePizza.equals(pizza.getCode())) {
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
			if (codePizza.equals(pizza.getCode())) {
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
