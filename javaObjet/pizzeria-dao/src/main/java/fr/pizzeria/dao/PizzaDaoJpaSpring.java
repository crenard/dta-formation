package fr.pizzeria.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoJpaSpring implements IDao<Pizza> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Pizza> findAll() {
		List<Pizza> dataList = em.createNamedQuery("Pizza.findAll", Pizza.class).getResultList();
		return dataList;
	}

	@Override
	@Transactional
	public void save(Pizza newData) {
		em.persist(newData);
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
	@Transactional
	public void update(String code, Pizza data) {
		queryExec(em, code, "Mise a jour impossible", oldData -> {
			Pizza newData = data;
			newData.setId(oldData.getId());
			em.merge(newData);
		});
	}

	@Override
	@Transactional
	public void delete(String code) {
		queryExec(em, code, "Suppression impossible", oldData -> em.remove(oldData));
	}

}
