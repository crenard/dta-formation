package fr.pizzeria.ihm;

import java.util.*;
import java.util.Map.Entry;

import fr.pizzeria.exception.StockageException;

public class Menu {
	private String titre;
	private Map<Integer, OptionMenu> actions;

	public Menu(String titre, Map<Integer, OptionMenu> actions) {
		this.titre = titre;
		this.actions = actions;
	}

	public void afficher() {
		System.out.println(titre);
		System.out.println("Veuillez choisir une action (99 pour abandonner)");
		for (Entry<Integer, OptionMenu> entrySet : actions.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue().getLibelle());
		}
		System.out.println("5 : Quitter");
	}

	public void executer(int choix) {
		try {
			actions.get(choix).execute();
		} catch (StockageException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}
}
