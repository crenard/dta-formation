package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.model.Client;

public interface IClientDao {
	List<Client> findAll();

	void newClient(Client c);

	void crediter(Client c, double ajout) throws CreditException;

	void debiter(Client c, double retrait) throws DebitException;
}
