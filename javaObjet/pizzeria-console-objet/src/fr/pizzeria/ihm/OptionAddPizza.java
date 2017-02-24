package fr.pizzeria.ihm;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

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
		try {
			ihmTools.getDao().save(new Pizza(code, nom, prix));
		} catch (StockageException e) {
			throw new StockageException("\n!!! Une erreur a été enregistrée : " + e.getCause());
		}

	}

}
