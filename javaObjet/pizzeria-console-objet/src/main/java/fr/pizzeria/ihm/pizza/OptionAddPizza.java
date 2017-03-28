package fr.pizzeria.ihm.pizza;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

/**
 * Menu item pour ajouter des pizzas
 * 
 * @author ETY 10
 *
 */
public class OptionAddPizza extends OptionMenu {

	private IhmTools ihmTools;
	private IDao<Pizza> daoPizza;

	@Override
	public String getLibelle() {
		return "Ajouter une pizza";
	}

	@Override
	public void execute() {
		try {
			daoPizza.save(ihmTools.saisirPizza());
		} catch (StockageException e) {
			throw new StockageException("\n!!! Une erreur a ete enregistree : " + e);
		}

	}

	public void setIhmTools(IhmTools ihmTools) {
		this.ihmTools = ihmTools;
	}

	public void setDaoPizza(IDao<Pizza> daoPizza) {
		this.daoPizza = daoPizza;
	}

}
