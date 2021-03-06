package fr.pizzeria.dao;

import java.util.List;
import java.util.function.*;

import javax.persistence.*;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IDao<Pizza> {

	private EntityManagerFactory emFactory;

	public PizzaDaoJpa() {
		emFactory = Persistence.createEntityManagerFactory("pizzeria-console-objet");
	}

	@Override
	public List<Pizza> findAll() {
		EntityManager em = emFactory.createEntityManager();
		List<Pizza> dataList = em.createNamedQuery("Pizza.findAll", Pizza.class).getResultList();
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
	public void save(Pizza newData) {
		emCreation(em -> em.persist(newData));
	}

	private void queryExec(EntityManager em, String code, String exceptionMsg, Consumer<Pizza> exec) {
		Pizza oldData = em.createNamedQuery("Pizza.find", Pizza.class).setParameter("code", code).getSingleResult();
		if (oldData != null) {
			exec.accept(oldData);
		} else {
			throw new StockageException(exceptionMsg);
		}
	}

	@Override
	public void update(String code, Pizza data) {
		emCreation(em -> queryExec(em, code, "Mise a jour impossible", oldData -> {
			Pizza newData = data;
			newData.setId(oldData.getId());
			em.merge(newData);
		}));
	}

	@Override
	public void delete(String code) {
		emCreation(em -> queryExec(em, code, "Suppression impossible", oldData -> em.remove(oldData)));
	}

}
