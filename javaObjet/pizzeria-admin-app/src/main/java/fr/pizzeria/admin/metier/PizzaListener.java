package fr.pizzeria.admin.metier;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import fr.pizzeria.admin.event.CreerPizzaEvent;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SupprimerPizzaEvent;

@ApplicationScoped
public class PizzaListener {

	@Inject
	PizzaStatistiqueService pServ;

	public void ecouteCreer(@Observes CreerPizzaEvent event) {
		pServ.creer(event);
	}

	public void ecouteModifier(@Observes ModifierPizzaEvent event) {
		pServ.modifier(event);
	}

	public void ecouteSupprimer(@Observes SupprimerPizzaEvent event) {
		pServ.supprimer(event);
	}

}
