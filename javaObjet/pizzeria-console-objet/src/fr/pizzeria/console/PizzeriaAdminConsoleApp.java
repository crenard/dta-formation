package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.OptionAddPizza;
import fr.pizzeria.ihm.OptionChangePizza;
import fr.pizzeria.ihm.OptionListePizzas;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.OptionRemovePizza;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pizza pep = new Pizza(0, "PEP", "Peperoni", 12.50);
		Pizza mar = new Pizza(1, "MAR", "Margherita", 14.00);
		Pizza rei = new Pizza(2, "REI", "La Reine", 11.50);
		Pizza fro = new Pizza(3, "FRO", "La 4 fromage", 12.00);
		Pizza can = new Pizza(4, "CAN", "La cannibale", 12.50);
		Pizza sav = new Pizza(5, "SAV", "La savoyarde", 13.00);
		Pizza ori = new Pizza(6, "ORI", "L'orientale", 13.50);
		Pizza ind = new Pizza(7, "IND", "L'indienne", 14.00);
		Pizza[] listePizzas = { pep, mar, rei, fro, can, sav, ori, ind };

		IPizzaDao dao = new PizzaDaoImpl(listePizzas);
		OptionMenu optionList = new OptionListePizzas(dao, sc);
		OptionMenu optionAdd = new OptionAddPizza(dao, sc);
		OptionMenu optionChange = new OptionChangePizza(dao, sc);
		OptionMenu optionRemove = new OptionRemovePizza(dao, sc);

		OptionMenu[] options = { optionList, optionAdd, optionChange, optionRemove };

		Menu menu = new Menu("**** Pizzeria Administration ****", options);

		int choix = 0;
		while (choix != 5) {
			menu.afficher();
			choix = sc.nextInt();
			sc.nextLine();

			while (choix > options.length + 1) {
				System.out.println("\n!!! Entrez une valeur autorisée !!!\n");
				menu.afficher();
				choix = sc.nextInt();
				sc.nextLine();
			}
			if (choix != 5) {
				menu.executer(choix);
			}
		}
		System.out.println("\nAu revoir, a bientot !");
		sc.close();

	}
}