package fr.pizzeria.dao;

import org.junit.*;
import static org.hamcrest.CoreMatchers.*;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

import static org.junit.Assert.*;

import java.util.List;

public class PizzaDaoImplTest {
	PizzaDaoImpl dao;

	@Before
	public void setUp() {
		dao = new PizzaDaoImpl();
	}

	@Test
	public void testFindAll() {
		List<Pizza> pizzas = dao.findAll();
		assertThat(pizzas.size(), anyOf(is(8), is(9)));
	}

	// @Test(expected = StockageException.class)
	public void testSaveValidData() throws StockageException {
		Pizza pizza = new Pizza("", "", 0, null);
		dao.save(pizza);
		List<Pizza> all = dao.findAll();
		assertThat(all.size(), anyOf(is(8), is(9)));
	}

	@Test
	public void testEquals() {
		Pizza p1 = new Pizza("GRE", "gredue", 0, CategoriePizza.VIANDE);
		Pizza p2 = new Pizza("GRE", "grebel", 4.5, CategoriePizza.VEGETARIEN);
		Pizza p3 = new Pizza("GAB", "gabrie", 0, CategoriePizza.VIANDE);
		assertTrue(p1.equals(p1));
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));
	}

}
