package fr.pizzeria.ihm.pizza;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionRemovePizza extends OptionMenu {

	public OptionRemovePizza(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Supprimer une pizza";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez choisir le code de la pizza a supprimer (99 pour abandonner)");
		String pizzaPick = ihmTools.getSc().nextLine();
		if (!"99".equals(pizzaPick)) {
			try {
				ihmTools.getDaoPizza().delete(pizzaPick);
			} catch (StockageException e) {
				throw new StockageException("\n!!! Code incorrect, cette pizza n'existe pas", e);
			}
		}
	}

}
