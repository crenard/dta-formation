package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class OptionRemovePizza extends OptionMenu {

	public OptionRemovePizza(IPizzaDao dao, Scanner sc) {
		super(dao, sc);
	}

	@Override
	public String getLibelle() {
		return "Supprimer une pizza";
	}

	@Override
	public boolean execute() {
		System.out.println("Veuillez choisir le code de la pizza a supprimer (99 pour abandonner)");
		String pizzaPick = sc.nextLine();
		if (pizzaPick != "99"){
			boolean result = dao.deletePizza(pizzaPick);
			if (!result){
				System.out.println("\nCette pizza n'existe pas\n");
				return false;
			}
			return true;
		}
		return false;
	}

}
