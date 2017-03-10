package fr.pizzeria.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

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

	private void execute(Consumer<EntityManager> exec) {
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		exec.accept(em);
		et.commit();
		em.close();
	}

	@Override
	public void save(Pizza newPizza) {
		execute(em -> em.persist(newPizza));
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		execute(em -> {
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
		});
	}

	@Override
	public void delete(String codePizza) {
		execute(em -> {
			TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE code LIKE :code", Pizza.class);
			query.setParameter("code", codePizza);
			Pizza oldPizza = query.getSingleResult();
			if (oldPizza != null) {
				em.remove(oldPizza);
			} else {
				throw new StockageException("Suppression de la pizza impossible");
			}
		});
	}

}
