package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public class OptionRemovePizza extends OptionMenu {

	public OptionRemovePizza(IPizzaDao dao, Scanner sc) {
		super(dao, sc);
	}

	@Override
	public String getLibelle() {
		return "Supprimer une pizza";
	}

	@Override
	public void execute() throws StockageException {
		System.out.println("Veuillez choisir le code de la pizza a supprimer (99 pour abandonner)");
		String pizzaPick = sc.nextLine();
		if (pizzaPick != "99") {
			try {
				dao.deletePizza(pizzaPick);
			} catch (StockageException e) {
				throw new StockageException("\n!!! Code incorrect, cette pizza n'existe pas");
			}
		}
	}

}
