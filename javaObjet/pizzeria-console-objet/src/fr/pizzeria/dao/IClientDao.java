package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

public interface IClientDao {
	List<Client> findAll();

	void newClient(Client c);

	void crediter(int clientId, double ajout) throws CreditException, StockageException;

	void debiter(int clientId, double retrait) throws DebitException, StockageException;
}
