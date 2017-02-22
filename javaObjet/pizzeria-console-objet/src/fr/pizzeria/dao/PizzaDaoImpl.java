package fr.pizzeria.dao;

import java.util.Arrays;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	private Pizza[] pizzas;
	
	public PizzaDaoImpl(Pizza[] pizzas){
		this.pizzas = pizzas;
	}
	
	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {

		int size = pizzas.length;
		Pizza[] newPizzas = Arrays.copyOf(pizzas, size+1);
		newPizzas[size] = pizza;
		pizzas = newPizzas;
		Pizza.nbPizzas++;
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza newPizza) {
		int index = 0;
		for (Pizza pizza : pizzas){
			if (codePizza.equals(pizza.code)){
				pizzas[index] = newPizza;
				return true;
			}
			index++;
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		int index = 0;
		int size = pizzas.length;
		for (Pizza pizza : pizzas){
			if (codePizza.equals(pizza.code)){
				Pizza[] newPizzas = new Pizza[size-1];
				System.arraycopy(pizzas, 0, newPizzas, 0, index);
				System.arraycopy(pizzas, index + 1, newPizzas, index, size - index - 1);
				pizzas = newPizzas;
				Pizza.nbPizzas--;
				return true;
			}
			index++;
		}
		return false;
	}

}
