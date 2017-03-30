package fr.pizzeria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Pizza;

public interface IPizzaRepository extends JpaRepository<Pizza, String> {

	Pizza findByCode(String code);

	default void deleteByCode(String code) {
		delete(findByCode(code));
	}

	default void updateByCode(String code, Pizza pizza) {
		deleteByCode(code);
		save(pizza);
	}
}
