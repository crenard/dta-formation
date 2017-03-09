package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.model.Client;

public interface IClientDao {
	List<Client> findAll();

	void newClient(Client c);

	void crediter(int clientId, double ajout);

	void debiter(int clientId, double retrait);
}
