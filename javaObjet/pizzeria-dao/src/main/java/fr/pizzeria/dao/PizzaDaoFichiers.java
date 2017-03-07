package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.*;

public class PizzaDaoFichiers implements IDao<Pizza> {

	@Override
	public List<Pizza> findAll() {
		List<Pizza> pizzas = new ArrayList<>();
		try {
			Files.list(Paths.get("data")).forEach(path -> {
				try {
					String[] pizzaStr = Files.readAllLines(path).get(0).split(";");
					pizzas.add(new Pizza(pizzaStr[0], pizzaStr[1], Double.parseDouble(pizzaStr[2]),
							CategoriePizza.VIANDE));
				} catch (IOException e) {
				}
			});
		} catch (IOException e) {
		}
		return pizzas;
	}

	@Override
	public void save(Pizza newPizza) throws StockageException {
		try {
			Files.write(Paths.get(newPizza.getCode(), ".txt"), newPizza.toString().getBytes(),
					StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			throw new SaveException(e);
		}

	}

	@Override
	public void update(String codePizza, Pizza newPizza) throws StockageException {
		delete(codePizza);
		save(newPizza);
	}

	@Override
	public void delete(String codePizza) throws StockageException {
		try {
			Files.delete(Paths.get("data", codePizza + ".txt"));
		} catch (IOException e) {
			throw new DeleteException(e);
		}

	}
}
