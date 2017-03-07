package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.*;

public interface IDao<T> {
	List<T> findAll() throws StockageException;

	void save(T t) throws StockageException;

	void update(String codePizza, T t) throws StockageException;

	void delete(String codePizza) throws StockageException;
}
