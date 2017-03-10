package fr.pizzeria.ihm.client;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

/**
 * Menu item pour crediter des clients
 * 
 * @author ETY 10
 *
 */
public class OptionCreditClient extends OptionMenu {
	/**
	 * Creation du menu item pour crediter des clients
	 * 
	 * @param ihmTools
	 */
	public OptionCreditClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Crediter le compte d'un client";
	}

	@Override
	public void execute() {
		System.out.println("Veuillez saisir l'id du client a crediter");
		int clientId = ihmTools.getSc().nextInt();

		System.out.println("Veuillez saisir le montant");
		double ajout = ihmTools.getSc().nextDouble();

		try {
			ihmTools.getDaoClient().crediter(clientId, ajout);
		} catch (CreditException e) {
			throw new CreditException("\n!!! Le montant ne peux pas exceder 5000€", e);
		} catch (StockageException e) {
			throw new CreditException("\n!!! Code incorrect, ce client n'existe pas", e);
		}
	}

}
