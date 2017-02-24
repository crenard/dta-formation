package fr.pizzeria.dao;

import fr.pizzeria.exception.*;

public interface IDao<T> {
	T[] findAll();

	void save(T t) throws StockageException;

	void update(String codePizza, T t) throws StockageException;

	void delete(String codePizza) throws StockageException;
}
