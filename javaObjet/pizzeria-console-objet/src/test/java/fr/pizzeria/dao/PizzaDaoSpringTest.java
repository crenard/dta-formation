package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.console.PizzeriaAppSpringConfig;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzeriaAppSpringConfig.class)
public class PizzaDaoSpringTest {

	@Autowired
	@Qualifier("daoPizza")
	private IDao<Pizza> pizzaDao;

	@Test
	public void testCrud() {
		pizzaDao.save(new Pizza("GRE", "Gredue", 12, CategoriePizza.VIANDE));
		pizzaDao.save(new Pizza("GRA", "Gradouble", 12, CategoriePizza.VEGETARIEN));
		List<Pizza> listPizzas = pizzaDao.findAll();

		assertTrue(listPizzas.stream().anyMatch(p -> "GRE".equals(p.getCode())));
		assertTrue(listPizzas.stream().anyMatch(p -> "GRA".equals(p.getCode())));

		pizzaDao.delete("GRE");
		pizzaDao.delete("GRA");
	}

}
