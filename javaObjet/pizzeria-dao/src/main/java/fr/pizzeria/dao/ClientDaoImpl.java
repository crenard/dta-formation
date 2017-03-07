package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Client;

public class ClientDaoImpl implements IClientDao {

	private List<Client> clients = new ArrayList<>();

	public ClientDaoImpl() {
		super();
		clients.add(new Client(1, "Marcel", "Gris"));
		clients.add(new Client(2, "Francis", "Rapiere"));
		clients.add(new Client(3, "Rosa", "Spark"));
		clients.add(new Client(4, "Richard", "Rahl"));
	}

	@Override
	public List<Client> findAll() {
		return clients;
	}

	@Override
	public void newClient(Client client) {
		clients.add(client);
		Collections.sort(clients);
	}

	@Override
	public void crediter(int clientId, double ajout) {
		Optional<Client> optClient = clients.stream().filter(c -> c.getId() == clientId).findFirst();
		if (optClient.isPresent()) {
			optClient.get().crediterCompte(ajout);
		} else {
			throw new StockageException();
		}
	}

	@Override
	public void debiter(int clientId, double retrait) {
		Optional<Client> optClient = clients.stream().filter(c -> c.getId() == clientId).findFirst();
		if (optClient.isPresent()) {
			optClient.get().debiterCompte(retrait);
		} else {
			throw new StockageException();
		}
	}

}
