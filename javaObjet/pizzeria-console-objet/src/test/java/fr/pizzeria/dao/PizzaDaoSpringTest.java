package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

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
	private IDao<Pizza> daoPizza;

	@Autowired
	private IPerformanceRepository repo;

	@Test
	public void testCrud() {
		daoPizza.save(new Pizza("", "Gredue", 12, CategoriePizza.VIANDE));
		daoPizza.save(new Pizza("GRA", "Gradouble", 12, CategoriePizza.VEGETARIEN));

		List<Pizza> listPizzas = daoPizza.findAll();
		System.out.println(listPizzas);
		assertTrue(listPizzas.stream().anyMatch(p -> "GRE".equals(p.getCode())));
		assertTrue(listPizzas.stream().anyMatch(p -> "GRA".equals(p.getCode())));

		daoPizza.delete("GRE");
		daoPizza.delete("GRA");

		System.out.println(repo.findAll().stream().map(p -> p.getExecTime()).collect(Collectors.toList()));
	}

}
