package fr.pizzeria.console;

import java.util.ResourceBundle;

import fr.pizzeria.dao.*;
import fr.pizzeria.ihm.*;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {
		throw new IllegalAccessError("Utility class");
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

		IDao<Pizza> daoImplInstance = (IDao<Pizza>) Class.forName(resourceBundle.getString("daoImpl")).newInstance();
		IDao<Pizza> daoSourceImports = (IDao<Pizza>) Class.forName(resourceBundle.getString("daoSource")).newInstance();
		IhmTools ihmTools = new IhmTools(daoImplInstance, daoSourceImports);

		Menu menu = new MenuPrincipal("**** Pizzeria Administration ****", ihmTools);
		menu.executer();

		System.out.println("\nAu revoir, a bientot !");
		ihmTools.getSc().close();
	}
}