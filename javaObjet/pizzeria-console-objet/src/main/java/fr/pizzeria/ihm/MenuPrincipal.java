package fr.pizzeria.ihm;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import fr.pizzeria.ihm.principal.OptionClient;
import fr.pizzeria.ihm.principal.OptionPizza;

/**
 * Menu principal
 * 
 * @author ETY 10
 *
 */
@Component
public class MenuPrincipal extends Menu {

	@Autowired
	private ApplicationContext context;

	/**
	 * Creation du menu principal
	 * 
	 * @param titre
	 */
	@Autowired
	public MenuPrincipal(@Value("**** Administration des pizzas ****") String titre) {
		this.titre = titre;
	}

	@PostConstruct
	public void init() {
		actions = new HashMap<>();
		this.actions.put(1, context.getBean(OptionClient.class));
		this.actions.put(2, context.getBean(OptionPizza.class));
	}

}
