package fr.pizzeria.dao;

import java.util.List;

public interface IDao<T> {
	List<T> findAll();

	void save(T t);

	void update(String codePizza, T t);

	void delete(String codePizza);

	void closeConnection();
}
