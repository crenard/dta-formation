package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Client;

public interface IClientDao {
	List<Client> findAll();

	void newClient(Client c);

	void crediter(int clientId, double ajout) throws CreditException, StockageException;

	void debiter(int clientId, double retrait) throws DebitException, StockageException;
}
