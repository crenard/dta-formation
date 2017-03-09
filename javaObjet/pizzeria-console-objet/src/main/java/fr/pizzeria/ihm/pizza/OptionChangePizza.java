package fr.pizzeria.ihm.pizza;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionChangePizza extends OptionMenu {

	public OptionChangePizza(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Modifier une pizza";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez choisir le code de la pizza a modifier (99 pour abandonner)");
		String pizzaPick = ihmTools.getSc().nextLine();
		if (!"99".equals(pizzaPick)) {
			try {
				ihmTools.getDaoPizza().update(pizzaPick, ihmTools.saisirPizza());
			} catch (StockageException e) {
				throw new StockageException("\n!!! Code incorrect, cette pizza n'existe pas", e);
			}
		}
	}

}
