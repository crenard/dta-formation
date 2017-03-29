package fr.pizzeria.ihm;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import fr.pizzeria.ihm.client.OptionConnect;
import fr.pizzeria.ihm.client.OptionInscription;

@Component
public class MenuClient extends Menu {

	@Autowired
	private ApplicationContext context;

	@Autowired
	public MenuClient(@Value("**** Pizzeria Client ****") String titre) {
		this.titre = titre;
	}

	@PostConstruct
	public void init() {
		actions = new HashMap<>();
		this.actions.put(1, context.getBean(OptionConnect.class));
		this.actions.put(2, context.getBean(OptionInscription.class));
	}

}
