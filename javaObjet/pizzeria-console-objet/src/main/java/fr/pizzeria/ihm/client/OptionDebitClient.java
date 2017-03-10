package fr.pizzeria.ihm.client;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionDebitClient extends OptionMenu {
	/**
	 * Creation du menu item pour debiter des clients
	 * 
	 * @param ihmTools
	 */
	public OptionDebitClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Debiter le compte d'un client";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez saisir l'id du client a debiter");
		int clientId = ihmTools.getSc().nextInt();

		System.out.println("Veuillez saisir le montant");
		double ajout = ihmTools.getSc().nextDouble();

		try {
			ihmTools.getDaoClient().debiter(clientId, ajout);
		} catch (DebitException e) {
			throw new DebitException("\n!!! Pas assez d'argent sur le compte", e);
		} catch (StockageException e) {
			throw new DebitException("\n!!! Code incorrect, ce client n'existe pas", e);
		}

	}

}
