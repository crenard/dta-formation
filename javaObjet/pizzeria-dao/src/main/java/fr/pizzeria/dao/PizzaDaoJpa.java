package fr.pizzeria.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		return emFactory.createEntityManager().createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
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
	public void save(Pizza newPizza) {
		emCreation(em -> em.persist(newPizza));
	}

	private void queryExec(EntityManager em, String codePizza, String exceptionMsg, Consumer<Pizza> exec) {
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE code LIKE :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza oldPizza = query.getSingleResult();
		if (oldPizza != null) {
			exec.accept(oldPizza);
		} else {
			throw new StockageException(exceptionMsg);
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		emCreation(em -> queryExec(em, codePizza, "Mise a jour de la pizza impossible", oldPizza -> {
			Pizza newPizza = pizza;
			newPizza.setId(oldPizza.getId());
			em.merge(newPizza);
		}));
	}

	@Override
	public void delete(String codePizza) {
		emCreation(
				em -> queryExec(em, codePizza, "Suppression de la pizza impossible", oldPizza -> em.remove(oldPizza)));
	}

}
