package fr.pizzeria.admin.metier;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class DaoProducer {

	@Produces
	@ApplicationScoped
	public static IDao<Pizza> getDao() {
		return new PizzaDaoImpl();
	}
}
