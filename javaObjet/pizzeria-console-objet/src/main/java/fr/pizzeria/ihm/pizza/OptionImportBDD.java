package fr.pizzeria.ihm.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
@Component
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

	@Autowired
	@Qualifier("daoPizza")
	public void setDaoPizza(IDao<Pizza> daoPizza) {
		this.daoPizza = daoPizza;
	}

	@Autowired
	@Qualifier("daoSource")
	public void setDaoSource(IDao<Pizza> daoSource) {
		this.daoSource = daoSource;
	}

}
