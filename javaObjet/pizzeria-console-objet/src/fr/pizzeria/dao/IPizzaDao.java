package fr.pizzeria.dao;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	Pizza[] findAllPizzas();

	void saveNewPizza(Pizza pizza) throws StockageException;

	void updatePizza(String codePizza, Pizza pizza) throws StockageException;

	void deletePizza(String codePizza) throws StockageException;
}
