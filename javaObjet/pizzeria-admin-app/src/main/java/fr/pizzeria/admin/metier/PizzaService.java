package fr.pizzeria.admin.metier;

import java.time.LocalTime;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.admin.event.CreerPizzaEvent;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SupprimerPizzaEvent;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	private PizzaServiceEJB ejbPizza;

	@Inject
	Event<CreerPizzaEvent> creerPizzaEvent;

	@Inject
	Event<ModifierPizzaEvent> modifierPizzaEvent;

	@Inject
	Event<SupprimerPizzaEvent> supprimerPizzaEvent;

	public List<Pizza> findAll() {
		return ejbPizza.findAll();
	}

	public void save(Pizza t) {
		ejbPizza.save(t);
		CreerPizzaEvent event = new CreerPizzaEvent();
		event.setDate(LocalTime.now());
		event.setPizza(t);
		creerPizzaEvent.fire(event);
	}

	public void update(String code, Pizza t) {
		ejbPizza.update(code, t);
		ModifierPizzaEvent event = new ModifierPizzaEvent();
		event.setDate(LocalTime.now());
		event.setPizza(t);
		modifierPizzaEvent.fire(event);
	}

	public void delete(String code) {
		ejbPizza.delete(code);
		SupprimerPizzaEvent event = new SupprimerPizzaEvent();
		event.setDate(LocalTime.now());
		event.setCode(code);
		supprimerPizzaEvent.fire(event);
	}

	public Pizza find(String code) {
		return ejbPizza.find(code);
	}

}
