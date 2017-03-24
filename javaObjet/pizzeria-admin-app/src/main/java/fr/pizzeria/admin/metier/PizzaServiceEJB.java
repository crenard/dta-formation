package fr.pizzeria.admin.metier;

import java.util.List;
import java.util.function.Consumer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext(unitName = "pizzeria-admin-app")
	private EntityManager em;

	public List<Pizza> findAll() {
		return em.createNamedQuery("Pizza.findAll", Pizza.class).getResultList();
	}

	public Pizza find(String code) {
		return em.createNamedQuery("Pizza.find", Pizza.class).setParameter("code", code).getSingleResult();
	}

	public void save(Pizza newData) {
		em.persist(newData);
	}

	private void queryExec(String code, String exceptionMsg, Consumer<Pizza> exec) {
		Pizza oldData = em.createNamedQuery("Pizza.find", Pizza.class).setParameter("code", code).getSingleResult();
		if (oldData != null) {
			exec.accept(oldData);
		} else {
			throw new StockageException(exceptionMsg);
		}
	}

	public void update(String code, Pizza data) {
		queryExec(code, "Mise a jour impossible", oldData -> {
			Pizza newData = data;
			newData.setId(oldData.getId());
			em.merge(newData);
		});
	}

	public void delete(String code) {
		queryExec(code, "Suppression impossible", oldData -> em.remove(oldData));
	}

}
