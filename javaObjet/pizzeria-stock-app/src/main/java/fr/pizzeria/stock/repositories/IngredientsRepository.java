package fr.pizzeria.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.stock.model.Ingredient;

public interface IngredientsRepository extends JpaRepository<Ingredient, Integer> {
	default void deleteById(Integer id) {
		delete(findById(id));
	}

	Ingredient findById(Integer id);

	default void updateById(Integer id, Ingredient ingredient) {
		deleteById(id);
		save(ingredient);
	}
}
