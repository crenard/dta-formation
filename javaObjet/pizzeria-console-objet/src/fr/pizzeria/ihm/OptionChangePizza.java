package fr.pizzeria.ihm;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

public class OptionChangePizza extends OptionMenu {

	public OptionChangePizza(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Modifier une pizza";
	}

	@Override
	public void execute() throws StockageException {
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez choisir le code de la pizza a modifier (99 pour abandonner)");
		String pizzaPick = ihmTools.getSc().nextLine();
		if (pizzaPick != "99") {
			System.out.println("Veuillez saisir le code");
			newPizza.code = ihmTools.getSc().nextLine();
			System.out.println("Veuillez saisir le nom (sans espaces)");
			newPizza.nom = ihmTools.getSc().nextLine();
			System.out.println("Veuillez saisir le prix");
			newPizza.prix = ihmTools.getSc().nextDouble();
			try {
				ihmTools.getDao().update(pizzaPick, newPizza);
			} catch (StockageException e) {
				throw new StockageException("\n!!! Code incorrect, cette pizza n'existe pas");
			}
		}
	}

}
