package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class OptionChangePizza extends OptionMenu {

	public OptionChangePizza(IPizzaDao dao, Scanner sc) {
		super(dao, sc);
	}

	@Override
	public String getLibelle() {
		return "Modifier une pizza";
	}

	@Override
	public void execute() throws StockageException {
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez choisir le code de la pizza a modifier (99 pour abandonner)");
		String pizzaPick = sc.nextLine();
		if (pizzaPick != "99") {
			System.out.println("Veuillez saisir le code");
			newPizza.code = sc.nextLine();
			System.out.println("Veuillez saisir le nom (sans espaces)");
			newPizza.nom = sc.nextLine();
			System.out.println("Veuillez saisir le prix");
			newPizza.prix = sc.nextDouble();
			try {
				dao.updatePizza(pizzaPick, newPizza);
			} catch (StockageException e) {
				throw new StockageException("Code incorrect, cette pizza n'existe pas");
			}
		}
	}

}
