package fr.pizzeria.admin.event;

import java.time.LocalTime;

import fr.pizzeria.model.Pizza;

public class ModifierPizzaEvent {

	private Pizza pizza;
	private LocalTime date;

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public LocalTime getDate() {
		return date;
	}

	public void setDate(LocalTime date) {
		this.date = date;
	}

}
