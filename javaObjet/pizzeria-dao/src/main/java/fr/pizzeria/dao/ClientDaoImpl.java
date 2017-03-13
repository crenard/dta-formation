package fr.pizzeria.dao;

import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.ClientAdmin;

/**
 * Implementation memoire du stockage des clients
 * 
 * @author ETY 10
 *
 */
public class ClientDaoImpl implements IClientDao {

	private List<ClientAdmin> clients = new ArrayList<>();

	/**
	 * Creation du dao client et peuplement de la base memoire
	 */
	public ClientDaoImpl() {
		super();
		clients.add(new ClientAdmin(1, "Marcel", "Gris"));
		clients.add(new ClientAdmin(2, "Francis", "Rapiere"));
		clients.add(new ClientAdmin(3, "Rosa", "Spark"));
		clients.add(new ClientAdmin(4, "Richard", "Rahl"));
	}

	@Override
	public List<ClientAdmin> findAll() {
		return clients;
	}

	@Override
	public void newClient(ClientAdmin client) {
		clients.add(client);
		Collections.sort(clients);
	}

	@Override
	public void crediter(int clientId, double ajout) {
		Optional<ClientAdmin> optClient = clients.stream().filter(c -> c.getId() == clientId).findFirst();
		if (optClient.isPresent()) {
			optClient.get().crediterCompte(ajout);
		} else {
			throw new StockageException();
		}
	}

	@Override
	public void debiter(int clientId, double retrait) {
		Optional<ClientAdmin> optClient = clients.stream().filter(c -> c.getId() == clientId).findFirst();
		if (optClient.isPresent()) {
			optClient.get().debiterCompte(retrait);
		} else {
			throw new StockageException();
		}
	}

}
