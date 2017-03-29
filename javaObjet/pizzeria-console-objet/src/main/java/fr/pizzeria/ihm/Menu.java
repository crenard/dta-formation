package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.exception.SoldeException;
import fr.pizzeria.exception.StockageException;

/**
 * Menu generique
 * 
 * @author ETY 10
 *
 */
public abstract class Menu {
	protected String titre;
	protected Map<Integer, OptionMenu> actions;
	@Autowired
	protected Scanner sc;

	/**
	 * Affichage du menu
	 */
	public void afficher() {
		System.out.println("\n" + titre);
		System.out.println("Veuillez choisir une action :");
		for (Entry<Integer, OptionMenu> entrySet : actions.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue().getLibelle());
		}
		System.out.println(actions.size() + 1 + " : Quitter");
	}

	/**
	 * Execution du menu
	 */
	public void executer() {
		int choix = 0;
		while (choix != actions.size() + 1) {
			afficher();
			choix = sc.nextInt();
			sc.nextLine();

			while (choix > actions.size() + 1) {
				System.out.println("\n!!! Entrez une valeur autorisee !!!\n");
				afficher();
				choix = sc.nextInt();
				sc.nextLine();
			}
			if (choix != actions.size() + 1) {
				try {
					actions.get(choix).execute();
				} catch (StockageException | SoldeException e) {
					System.out.println(e + "\n");
				}
			}
		}
	}

	public void setActions(Map<Integer, OptionMenu> actions) {
		this.actions = actions;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
