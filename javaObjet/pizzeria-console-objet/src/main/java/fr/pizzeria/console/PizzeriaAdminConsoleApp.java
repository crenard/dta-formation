package fr.pizzeria.console;

import fr.pizzeria.ihm.*;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		new Pizza(null, null, 0, null).hashCode();
		IhmTools ihmTools = new IhmTools();

		Menu menu = new MenuPrincipal("**** Pizzeria Administration ****", ihmTools);
		menu.executer();

		System.out.println("\nAu revoir, a bientot !");
		ihmTools.getSc().close();

	}
}