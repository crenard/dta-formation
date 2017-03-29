package fr.pizzeria.ihm;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import fr.pizzeria.ihm.pizza.OptionAddPizza;
import fr.pizzeria.ihm.pizza.OptionChangePizza;
import fr.pizzeria.ihm.pizza.OptionExpensivePizza;
import fr.pizzeria.ihm.pizza.OptionImportBDD;
import fr.pizzeria.ihm.pizza.OptionListeCategorie;
import fr.pizzeria.ihm.pizza.OptionListePizzas;
import fr.pizzeria.ihm.pizza.OptionRemovePizza;

/**
 * Menu de gestion des pizzas
 * 
 * @author ETY 10
 *
 */
@Component
public class MenuPizza extends Menu {

	@Autowired
	private ApplicationContext context;

	/**
	 * Creation du menu de gestion des pizzas
	 * 
	 * @param titre
	 */
	@Autowired
	public MenuPizza(@Value("**** Administration des pizzas ****") String titre) {
		this.titre = titre;
	}

	@PostConstruct
	public void init() {
		actions = new HashMap<>();
		this.actions.put(1, context.getBean(OptionListePizzas.class));
		this.actions.put(2, context.getBean(OptionAddPizza.class));
		this.actions.put(3, context.getBean(OptionChangePizza.class));
		this.actions.put(4, context.getBean(OptionRemovePizza.class));
		this.actions.put(5, context.getBean(OptionImportBDD.class));
		this.actions.put(6, context.getBean(OptionExpensivePizza.class));
		this.actions.put(7, context.getBean(OptionListeCategorie.class));
	}

}
