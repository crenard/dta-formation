package fr.pizzeria.ihm;

import fr.pizzeria.exception.StockageException;

public class Menu {
	private String titre;
	private OptionMenu[] actions;

	public Menu(String titre, OptionMenu[] actions) {
		this.titre = titre;
		this.actions = actions;
	}

	public void afficher() {
		System.out.println(titre);
		System.out.println("Veuillez choisir une action (99 pour abandonner)");
		for (int i = 0; i < actions.length; i++) {
			System.out.println((i + 1) + " : " + actions[i].getLibelle());
		}
		System.out.println("5 : Quitter");
	}

	public void executer(int choix) {
		try {
			actions[choix - 1].execute();
		} catch (StockageException e) {
			System.err.println("\n" + e.getMessage());
		}
	}
}
