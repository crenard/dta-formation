package fr.pizzeria.ihm.pizza;

import fr.pizzeria.model.*;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionAddPizza extends OptionMenu {

	public OptionAddPizza(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Ajouter une pizza";
	}

	@Override
	public void execute() throws StockageException {
		System.out.println("Veuillez saisir le code");
		String code = ihmTools.getSc().nextLine();

		System.out.println("Veuillez saisir le nom (sans espaces)");
		String nom = ihmTools.getSc().nextLine();

		System.out.println("Veuillez saisir le prix");
		Double prix = ihmTools.getSc().nextDouble();

		System.out.println("Veuillez saisir la cat�gorie :");
		CategoriePizza[] categories = CategoriePizza.values();

		for (int i = 0; i < categories.length; i++) {
			System.out.println(i + 1 + " : " + categories[i].getLibelle());
		}

		int choixCategory = ihmTools.getSc().nextInt();
		ihmTools.getSc().nextLine();
		CategoriePizza category = categories[choixCategory - 1];
		try {
			ihmTools.getDaoPizza().save(new Pizza(code, nom, prix, category));
		} catch (StockageException e) {
			throw new StockageException("\n!!! Une erreur a �t� enregistr�e : " + e);
		}

	}

}
