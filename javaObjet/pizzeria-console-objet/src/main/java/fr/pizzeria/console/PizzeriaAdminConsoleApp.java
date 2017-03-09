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

		String daoImpl = resourceBundle.getString("daoImpl");
		IDao<Pizza> daoImplInstance = (IDao<Pizza>) Class.forName(daoImpl).newInstance();
		IhmTools ihmTools = new IhmTools(daoImplInstance);

		Menu menu = new MenuPrincipal("**** Pizzeria Administration ****", ihmTools);
		menu.executer();

		System.out.println("\nAu revoir, a bientot !");
		ihmTools.getSc().close();
		daoImplInstance.close();

	}
}