package fr.pizzeria.ihm.pizza;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.ConnectionException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Menu item pour importer des pizzas depuis une source
 * 
 * @author ETY 10
 *
 */
public class OptionImportBDD extends OptionMenu {

	private IDao<Pizza> daoPizza;
	private IDao<Pizza> daoSource;

	@Override
	public String getLibelle() {
		return "(Base de donnees) Importer les donnees";
	}

	@Override
	public void execute() {
		try {
			daoPizza.importBDD(daoSource);
		} catch (StockageException e) {
			throw new ConnectionException("\n!!! Une erreur a ete enregistree : " + e);
		}
	}

	public void setDaoPizza(IDao<Pizza> daoPizza) {
		this.daoPizza = daoPizza;
	}

	public void setDaoSource(IDao<Pizza> daoSource) {
		this.daoSource = daoSource;
	}

}
