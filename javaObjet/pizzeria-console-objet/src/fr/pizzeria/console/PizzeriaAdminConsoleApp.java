package fr.pizzeria.console;

import fr.pizzeria.ihm.*;
import fr.pizzeria.ihm.tools.IhmTools;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		IhmTools ihmTools = new IhmTools();
		OptionMenu optionList = new OptionListePizzas(ihmTools);
		OptionMenu optionAdd = new OptionAddPizza(ihmTools);
		OptionMenu optionChange = new OptionChangePizza(ihmTools);
		OptionMenu optionRemove = new OptionRemovePizza(ihmTools);

		OptionMenu[] options = { optionList, optionAdd, optionChange, optionRemove };

		Menu menu = new Menu("**** Pizzeria Administration ****", options);

		int choix = 0;
		while (choix != 5) {
			menu.afficher();
			choix = ihmTools.getSc().nextInt();
			ihmTools.getSc().nextLine();

			while (choix > options.length + 1) {
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