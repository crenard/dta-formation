package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.model.Client;

/**
 * Interface pour la gestion des clients
 * 
 * @author ETY 10
 *
 */
public interface IClientDao {

	/**
	 * Obtenir la liste des clients
	 * 
	 * @return
	 */
	List<Client> findAll();

	/**
	 * Ajouter un client
	 * 
	 * @param c
	 */
	void newClient(Client c);

	/**
	 * Crediter un client d'une somme
	 * 
	 * @param clientId
	 * @param ajout
	 */
	void crediter(int clientId, double ajout);

	/**
	 * Debiter un client d'une somme
	 * 
	 * @param clientId
	 * @param retrait
	 */
	void debiter(int clientId, double retrait);
}
