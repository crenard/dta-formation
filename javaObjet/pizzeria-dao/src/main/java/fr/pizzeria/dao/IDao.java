package fr.pizzeria.dao;

import java.util.List;

public interface IDao<T> {
	List<T> findAll();

	void save(T t);

	void update(String codePizza, T t);

	void delete(String codePizza);

	default void importBDD(IDao<T> source) {
		System.out.println("Invalide dans ce mode, veuillez configurer l’application en mode Base de donnees");
	}
}
