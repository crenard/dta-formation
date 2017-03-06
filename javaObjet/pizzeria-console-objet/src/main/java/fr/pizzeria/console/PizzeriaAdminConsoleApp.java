package fr.pizzeria.console;

import fr.pizzeria.ihm.*;
import fr.pizzeria.ihm.tools.IhmTools;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		IhmTools ihmTools = new IhmTools();

		Menu menu = new MenuPrincipal("**** Pizzeria Administration ****", ihmTools);
		menu.executer();

		System.out.println("\nAu revoir, a bientot !");
		ihmTools.getSc().close();

	}
}