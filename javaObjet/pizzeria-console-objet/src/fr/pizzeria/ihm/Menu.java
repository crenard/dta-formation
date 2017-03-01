package fr.pizzeria.ihm;

import java.util.*;
import java.util.Map.Entry;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.tools.IhmTools;

public abstract class Menu {
	protected String titre;
	protected Map<Integer, OptionMenu> actions;
	protected IhmTools ihmTools;

	public Menu(String titre, IhmTools ihmTools) {
		this.titre = titre;
		this.ihmTools = ihmTools;
		actions = new HashMap<>();
	}

	public void afficher() {
		System.out.println("\n" + titre);
		System.out.println("Veuillez choisir une action :");
		for (Entry<Integer, OptionMenu> entrySet : actions.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue().getLibelle());
		}
		System.out.println(actions.size() + 1 + " : Quitter");
	}

	public void executer() {
		int choix = 0;
		while (choix != actions.size() + 1) {
			afficher();
			choix = ihmTools.getSc().nextInt();
			ihmTools.getSc().nextLine();

			while (choix > actions.size() + 1) {
				System.out.println("\n!!! Entrez une valeur autorisée !!!\n");
				afficher();
				choix = ihmTools.getSc().nextInt();
				ihmTools.getSc().nextLine();
			}
			if (choix != actions.size() + 1) {
				try {
					actions.get(choix).execute();
				} catch (StockageException | SoldeException e) {
					System.out.println(e.getMessage() + "\n");
				}
			}
		}
	}
}
