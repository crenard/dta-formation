package fr.pizzeria.console;

import java.util.logging.Level;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuPrincipal;

/**
 * Main class de gestion d'une pizzeria
 * 
 * @author ETY 10
 *
 */
public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {
		throw new IllegalAccessError("Utility class");
	}

	/**
	 * Point d'entree du programme
	 * 
	 * @param args
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml")) {
			Menu menu = context.getBean(MenuPrincipal.class);
			menu.afficher();
		}
	}
}