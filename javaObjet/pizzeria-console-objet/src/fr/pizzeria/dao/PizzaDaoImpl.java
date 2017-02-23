package fr.pizzeria.dao;

import java.util.Arrays;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	private Pizza[] pizzas;

	public PizzaDaoImpl(Pizza[] pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
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
	public void updatePizza(String codePizza, Pizza newPizza) throws UpdatePizzaException {
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
	public void deletePizza(String codePizza) throws DeletePizzaException {
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
