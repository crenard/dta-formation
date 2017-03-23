package fr.pizzeria.admin.metier;

import java.time.LocalTime;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.admin.event.CreerPizzaEvent;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SupprimerPizzaEvent;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	private IDao<Pizza> daoPizza;

	@Inject
	Event<CreerPizzaEvent> creerPizzaEvent;

	@Inject
	Event<ModifierPizzaEvent> modifierPizzaEvent;

	@Inject
	Event<SupprimerPizzaEvent> supprimerPizzaEvent;

	public List<Pizza> findAll() {
		return daoPizza.findAll();
	}

	public void save(Pizza t) {
		daoPizza.save(t);
		CreerPizzaEvent event = new CreerPizzaEvent();
		event.setDate(LocalTime.now());
		event.setPizza(t);
		creerPizzaEvent.fire(event);
	}

	public void update(String code, Pizza t) {
		daoPizza.update(code, t);
		ModifierPizzaEvent event = new ModifierPizzaEvent();
		event.setDate(LocalTime.now());
		event.setPizza(t);
		modifierPizzaEvent.fire(event);
	}

	public void delete(String code) {
		daoPizza.delete(code);
		SupprimerPizzaEvent event = new SupprimerPizzaEvent();
		event.setDate(LocalTime.now());
		event.setCode(code);
		supprimerPizzaEvent.fire(event);
	}

	public Pizza find(String code) {
		return daoPizza.find(code);
	}

}
