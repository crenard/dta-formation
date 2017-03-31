package fr.pizzeria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.model.Pizza;

public class PizzaDaoJpaSpringData implements IDao<Pizza> {

	@Autowired
	private IPizzaRepository pizzaRepository;

	@Override
	public List<Pizza> findAll() {
		return pizzaRepository.findAll();
	}

	public Pizza find(String code) {
		return pizzaRepository.findByCodeLike(code);
	}

	@Override
	public void save(Pizza pizza) {
		pizzaRepository.save(pizza);
	}

	@Override
	public void update(String code, Pizza pizza) {
		pizzaRepository.updateByCode(code, pizza);
	}

	@Override
	public void delete(String code) {
		pizzaRepository.deleteByCodeLike(code);
	}

}
