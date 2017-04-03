package dta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dta.model.Ingredient;

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
