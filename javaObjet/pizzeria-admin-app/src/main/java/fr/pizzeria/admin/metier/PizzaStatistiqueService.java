package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import fr.pizzeria.admin.event.CreerPizzaEvent;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SupprimerPizzaEvent;

@ApplicationScoped
public class PizzaStatistiqueService {

	private List<CreerPizzaEvent> creerPizzas = new ArrayList<>();
	private List<ModifierPizzaEvent> modifierPizzas = new ArrayList<>();
	private List<SupprimerPizzaEvent> supprimerPizzas = new ArrayList<>();

	public void creer(CreerPizzaEvent event) {
		creerPizzas.add(event);
	}

	public void modifier(ModifierPizzaEvent event) {
		modifierPizzas.add(event);
	}

	public void supprimer(SupprimerPizzaEvent event) {
		supprimerPizzas.add(event);
	}

	public List<CreerPizzaEvent> getCreerPizzas() {
		return creerPizzas;
	}

	public List<ModifierPizzaEvent> getModifierPizzas() {
		return modifierPizzas;
	}

	public List<SupprimerPizzaEvent> getSupprimerPizzas() {
		return supprimerPizzas;
	}

}
