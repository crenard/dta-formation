package fr.pizzeria.console;

import java.util.*;

import fr.pizzeria.ihm.*;
import fr.pizzeria.ihm.tools.IhmTools;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		IhmTools ihmTools = new IhmTools();

		Map<Integer, OptionMenu> options = new HashMap<>();
		options.put(1, new OptionListePizzas(ihmTools));
		options.put(2, new OptionAddPizza(ihmTools));
		options.put(3, new OptionChangePizza(ihmTools));
		options.put(4, new OptionRemovePizza(ihmTools));

		Menu menu = new Menu("**** Pizzeria Administration ****", options);

		int choix = 0;
		while (choix != 5) {
			menu.afficher();
			choix = ihmTools.getSc().nextInt();
			ihmTools.getSc().nextLine();

			while (choix > options.size() + 1) {
				System.out.println("\n!!! Entrez une valeur autorisée !!!\n");
				menu.afficher();
				choix = ihmTools.getSc().nextInt();
				ihmTools.getSc().nextLine();
			}
			if (choix != 5) {
				menu.executer(choix);
			}
		}
		System.out.println("\nAu revoir, a bientot !");
		ihmTools.getSc().close();

	}
}