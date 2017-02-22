package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class OptionAddPizza extends OptionMenu {

	public OptionAddPizza(IPizzaDao dao, Scanner sc) {
		super(dao, sc);
	}

	@Override
	public String getLibelle() {
		return "Ajouter une pizza";
	}

	@Override
	public boolean execute() {
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez saisir le code");
		newPizza.code = sc.nextLine();
		System.out.println("Veuillez saisir le nom (sans espaces)");
		newPizza.nom = sc.nextLine();
		System.out.println("Veuillez saisir le prix");
		newPizza.prix = sc.nextDouble();
		return dao.saveNewPizza(newPizza);

	}

}
