package fr.pizzeria.ihm.pizza;

import fr.pizzeria.exception.ConnectionException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

/**
 * Menu item pour importer des pizzas depuis une source
 * 
 * @author ETY 10
 *
 */
public class OptionImportBDD extends OptionMenu {
	/**
	 * Creation du menu item pour importer des pizzas depuis une source
	 * 
	 * @param ihmTools
	 */
	public OptionImportBDD(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "(Base de donnees) Importer les donnees";
	}

	@Override
	public void execute() {
		try {
			ihmTools.getDaoPizza().importBDD(ihmTools.getDaoSource());
		} catch (StockageException e) {
			throw new ConnectionException("\n!!! Une erreur a ete enregistree : " + e);
		}
	}

}
