package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Implementation fichier du stockage des pizzas
 * 
 * @author ETY 10
 *
 */
public class PizzaDaoFichiers implements IDao<Pizza> {

	@Override
	public List<Pizza> findAll() {
		List<Pizza> pizzas = new ArrayList<>();
		try {
			Files.list(Paths.get("data")).forEach(path -> pizzas.add(extractPizzaFromFile(path)));
		} catch (IOException e) {
			throw new StockageException(e);
		}
		return pizzas;
	}

	private static Pizza extractPizzaFromFile(Path path) {
		try {
			String[] pizzaStr = Files.readAllLines(path).get(0).split(";");
			return new Pizza(pizzaStr[0], pizzaStr[1], Double.parseDouble(pizzaStr[2]), CategoriePizza.VIANDE);
		} catch (IOException e) {
			throw new StockageException(e);
		}
	}

	@Override
	public void save(Pizza newPizza) {
		try {
			Files.write(Paths.get(newPizza.getCode(), ".txt"), newPizza.toString().getBytes(),
					StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			throw new SaveException(e);
		}

	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		delete(codePizza);
		save(newPizza);
	}

	@Override
	public void delete(String codePizza) {
		try {
			Files.delete(Paths.get("data", codePizza + ".txt"));
		} catch (IOException e) {
			throw new DeleteException(e);
		}
	}
}
