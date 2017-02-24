package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IDao<Pizza> {

	private List<Pizza> pizzas = new ArrayList<>();

	public PizzaDaoImpl() {
		pizzas.add(new Pizza("PEP", "Peperoni", 12.50));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00));
		pizzas.add(new Pizza("REI", "La Reine", 11.50));
		pizzas.add(new Pizza("FRO", "La 4 fromage", 12.00));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00));
	}

	@Override
	public List<Pizza> findAll() {
		return pizzas;
	}

	@Override
	public void save(Pizza pizza) throws StockageException {
		try {
			pizzas.add(pizza);
		} catch (Exception e) {
			throw new SavePizzaException(e.getCause());
		}
	}

	private int findPizza(String code) {
		for (Pizza pizza : pizzas) {
			if (code.equals(pizza.getCode())) {
				return pizzas.indexOf(pizza);
			}
		}
		return -1;
	}

	@Override
	public void update(String codePizza, Pizza newPizza) throws StockageException {
		int index = findPizza(codePizza);
		if (index > -1) {
			pizzas.set(index, newPizza);
		} else {
			throw new UpdatePizzaException();
		}
	}

	@Override
	public void delete(String codePizza) throws StockageException {
		int index = findPizza(codePizza);
		if (index > -1) {
			pizzas.remove(index);
		} else {
			throw new DeletePizzaException();
		}
	}

}
