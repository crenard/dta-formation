package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IDao<Pizza> {

	private List<Pizza> pizzas = new ArrayList<>();

	public PizzaDaoImpl() {
		pizzas.add(new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromage", 12.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza("SAU", "La saumonette", 14.00, CategoriePizza.POISSON));
		Collections.sort(pizzas);
	}

	@Override
	public List<Pizza> findAll() {
		return pizzas;
	}

	@Override
	public void save(Pizza pizza) {
		try {
			pizzas.add(pizza);
			Collections.sort(pizzas);
		} catch (Exception e) {
			throw new SaveException(e);
		}
	}

	private int findPizza(String code) {
		for (Pizza pizza : pizzas) {
			if (code.equalsIgnoreCase(pizza.getCode())) {
				return pizzas.indexOf(pizza);
			}
		}
		return -1;
	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		int index = findPizza(codePizza);
		if (index > -1) {
			pizzas.set(index, newPizza);
			Collections.sort(pizzas);
		} else {
			throw new UpdateException();
		}

	}

	@Override
	public void delete(String codePizza) {
		int index = findPizza(codePizza);
		if (index > -1) {
			pizzas.remove(index);
		} else {
			throw new DeleteException();
		}
	}

}
