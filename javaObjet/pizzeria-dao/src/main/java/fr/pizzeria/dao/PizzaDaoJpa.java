package fr.pizzeria.dao;

import java.util.List;

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
		return emFactory.createEntityManager().createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
	}

	@Override
	public void save(Pizza newPizza) {
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(newPizza);
		et.commit();
		em.close();
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE code LIKE :code", Pizza.class);
		query.setParameter("code", codePizza);

		Pizza oldPizza = query.getSingleResult();
		if (oldPizza != null) {
			Pizza newPizza = pizza;
			newPizza.setId(oldPizza.getId());
			em.merge(newPizza);
		} else {
			throw new StockageException("Mise a jour de la pizza impossible");
		}
		et.commit();
		em.close();
	}

	@Override
	public void delete(String codePizza) {
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE code LIKE :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza oldPizza = query.getSingleResult();
		if (oldPizza != null) {
			em.remove(oldPizza);
		} else {
			throw new StockageException("Suppression de la pizza impossible");
		}
		et.commit();
		em.close();
	}

}
