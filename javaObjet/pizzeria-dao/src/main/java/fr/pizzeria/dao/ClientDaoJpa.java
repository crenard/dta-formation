package fr.pizzeria.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.*;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

public class ClientDaoJpa implements IDao<Client> {

	private EntityManagerFactory emFactory;

	public ClientDaoJpa() {
		emFactory = Persistence.createEntityManagerFactory("pizzeria-console-objet");
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = emFactory.createEntityManager();
		List<Client> dataList = em.createNamedQuery("Client.findAll", Client.class).getResultList();
		em.close();
		return dataList;
	}

	private void emCreation(Consumer<EntityManager> exec) {
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		exec.accept(em);
		et.commit();
		em.close();
	}

	@Override
	public void save(Client newData) {
		emCreation(em -> em.persist(newData));
	}

	private void queryExec(EntityManager em, String code, String exceptionMsg, Consumer<Client> exec) {
		Client oldData = em.createNamedQuery("Client.find", Client.class).setParameter("code", code).getSingleResult();
		if (oldData != null) {
			exec.accept(oldData);
		} else {
			throw new StockageException(exceptionMsg);
		}
	}

	@Override
	public void update(String code, Client data) {
		emCreation(em -> queryExec(em, code, "Mise a jour impossible", oldData -> {
			Client newData = data;
			newData.setId(oldData.getId());
			em.merge(newData);
		}));
	}

	@Override
	public void delete(String code) {
		emCreation(em -> queryExec(em, code, "Suppression impossible", oldData -> em.remove(oldData)));
	}

}
