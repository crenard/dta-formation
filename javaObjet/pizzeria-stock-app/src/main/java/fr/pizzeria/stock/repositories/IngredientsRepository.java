package fr.pizzeria.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.stock.model.Ingredient;

public interface IngredientsRepository extends JpaRepository<Ingredient, String> {

}
