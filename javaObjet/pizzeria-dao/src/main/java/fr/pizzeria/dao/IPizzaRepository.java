package fr.pizzeria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Pizza;

public interface IPizzaRepository extends JpaRepository<Pizza, String> {

	Pizza findByCodeLike(String code);

	default void deleteByCodeLike(String code) {
		delete(findByCodeLike(code));
	}

	default void updateByCode(String code, Pizza pizza) {
		deleteByCodeLike(code);
		save(pizza);
	}
}
