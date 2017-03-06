package fr.pizzeria.ihm.pizza;

import java.util.stream.Collectors;

import fr.pizzeria.model.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionListeCategorie extends OptionMenu {

	public OptionListeCategorie(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Pizzas par categories";
	}

	@Override
	public void execute() {
		ihmTools.getDaoPizza().findAll().stream().collect(Collectors.groupingBy(Pizza::getCategorie))
				.forEach((k, v) -> {
					System.out.println(k);
					v.stream().forEach(System.out::println);
					System.out.println();
				});

	}

}
