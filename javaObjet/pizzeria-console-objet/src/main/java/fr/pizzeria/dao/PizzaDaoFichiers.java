package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.*;

public class PizzaDaoFichiers implements IDao<Pizza> {

	public PizzaDaoFichiers() {
	}

	@Override
	public List<Pizza> findAll() {
		List<Pizza> pizzas = new ArrayList<Pizza>();
		try {
			Files.list(Paths.get("data")).forEach(path -> {
				try {
					String[] PizzaStr = Files.readAllLines(path).get(0).split(";");
					pizzas.add(new Pizza(PizzaStr[0], PizzaStr[1], Double.parseDouble(PizzaStr[2]),
							CategoriePizza.VIANDE));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pizzas;
	}

	@Override
	public void save(Pizza newPizza) throws StockageException {
		try {
			Files.write(Paths.get(newPizza.getCode(), ".txt"), newPizza.toString().getBytes(),
					StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			throw new SaveException(e.getCause());
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
			throw new DeleteException();
		}

	}
}
