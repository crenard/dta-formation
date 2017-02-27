package fr.pizzeria.console;

import java.util.*;

import fr.pizzeria.ihm.*;
import fr.pizzeria.ihm.pizza.*;
import fr.pizzeria.ihm.client.*;
import fr.pizzeria.ihm.tools.IhmTools;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		IhmTools ihmTools = new IhmTools();

		Map<Integer, OptionMenu> optionsPizza = new HashMap<>();
		optionsPizza.put(1, new OptionListePizzas(ihmTools));
		optionsPizza.put(2, new OptionAddPizza(ihmTools));
		optionsPizza.put(3, new OptionChangePizza(ihmTools));
		optionsPizza.put(4, new OptionRemovePizza(ihmTools));
		optionsPizza.put(5, new OptionListeCategorie(ihmTools));
		optionsPizza.put(6, new OptionExpensivePizza(ihmTools));

		Menu menuPizza = new Menu("**** Pizzeria Administration ****", optionsPizza);

		Map<Integer, OptionMenu> optionsClient = new HashMap<>();
		optionsClient.put(1, new OptionAddClient(ihmTools));
		optionsClient.put(2, new OptionCreditClient(ihmTools));
		optionsClient.put(3, new OptionDebitClient(ihmTools));

		Menu menuClient = new Menu("**** Pizzeria Administration ****", optionsClient);

		int choix = 0;
		while (choix != optionsPizza.size() + 1) {
			menuPizza.afficher();
			choix = ihmTools.getSc().nextInt();
			ihmTools.getSc().nextLine();

			while (choix > optionsPizza.size() + 1) {
				System.out.println("\n!!! Entrez une valeur autorisée !!!\n");
				menuPizza.afficher();
				choix = ihmTools.getSc().nextInt();
				ihmTools.getSc().nextLine();
			}
			if (choix != optionsPizza.size() + 1) {
				menuPizza.executer(choix);
			}
		}
		System.out.println("\nAu revoir, a bientot !");
		ihmTools.getSc().close();

	}
}