package fr.pizzeria.ihm.pizza;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

/**
 * Menu item pour mettre a jour des pizzas
 * 
 * @author ETY 10
 *
 */
public class OptionChangePizza extends OptionMenu {

	private IhmTools ihmTools;
	private IDao<Pizza> daoPizza;

	@Override
	public String getLibelle() {
		return "Modifier une pizza";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez choisir le code de la pizza a modifier (99 pour abandonner)");
		String pizzaPick = sc.nextLine();
		if (!"99".equals(pizzaPick)) {
			try {
				daoPizza.update(pizzaPick, ihmTools.saisirPizza());
			} catch (StockageException e) {
				throw new StockageException("\n!!! Code incorrect, cette pizza n'existe pas", e);
			}
		}
	}

	public void setIhmTools(IhmTools ihmTools) {
		this.ihmTools = ihmTools;
	}

	public void setDaoPizza(IDao<Pizza> daoPizza) {
		this.daoPizza = daoPizza;
	}

}
