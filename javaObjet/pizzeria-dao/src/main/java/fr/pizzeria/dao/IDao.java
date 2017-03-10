package fr.pizzeria.dao;

import java.util.List;

/**
 * Interface de gestion d'elements generiques
 * 
 * @author ETY 10
 *
 * @param <T>
 */
public interface IDao<T> {
	/**
	 * Obtenir la liste des elements
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * Ajouter un nouvel element
	 * 
	 * @param t
	 */
	void save(T t);

	/**
	 * Modifier un element existant
	 * 
	 * @param codePizza
	 * @param t
	 */
	void update(String codePizza, T t);

	/**
	 * Supprimer un element existant
	 * 
	 * @param codePizza
	 */
	void delete(String codePizza);

	/**
	 * Importer en BDD des elements depuis une source
	 * 
	 * @param source
	 */
	default void importBDD(IDao<T> source) {
		System.out.println("Invalide dans ce mode, veuillez configurer l’application en mode Base de donnees");
	}
}
