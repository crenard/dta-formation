package fr.pizzeria.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.*;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.GenericData;

public class DaoJpa<D extends GenericData> implements IDao<D> {

	private EntityManagerFactory emFactory;

	private Class<D> classe;

	public DaoJpa(Class<D> classe, EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
		this.classe = classe;
	}

	@Override
	public List<D> findAll() {
		EntityManager em = emFactory.createEntityManager();
		List<D> dataList = em.createNamedQuery(classe.getSimpleName() + ".findAll", classe).getResultList();
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
	public void save(D newData) {
		emCreation(em -> em.persist(newData));
	}

	private void queryExec(EntityManager em, String code, String exceptionMsg, Consumer<D> exec) {
		D oldData = em.createNamedQuery(classe.getSimpleName() + ".find", classe).setParameter("code", code)
				.getSingleResult();
		if (oldData != null) {
			exec.accept(oldData);
		} else {
			throw new StockageException(exceptionMsg);
		}
	}

	@Override
	public void update(String code, D data) {
		emCreation(em -> queryExec(em, code, "Mise a jour impossible", oldData -> {
			D newData = data;
			newData.setId(oldData.getId());
			em.merge(newData);
		}));
	}

	@Override
	public void delete(String code) {
		emCreation(em -> queryExec(em, code, "Suppression impossible", oldData -> em.remove(oldData)));
	}

}
