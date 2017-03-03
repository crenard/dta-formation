package fr.pizzeria.ihm.client;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionDebitClient extends OptionMenu {

	public OptionDebitClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Debiter le compte d'un client";
	}

	@Override
	public void execute() throws SoldeException {
		System.out.println("Veuillez saisir l'id du client a debiter");
		int clientId = ihmTools.getSc().nextInt();

		System.out.println("Veuillez saisir le montant");
		double ajout = ihmTools.getSc().nextDouble();

		try {
			ihmTools.getDaoClient().debiter(clientId, ajout);
		} catch (DebitException e) {
			throw new DebitException("\n!!! Pas assez d'argent sur le compte");
		} catch (StockageException e) {
			throw new CreditException("\n!!! Code incorrect, ce client n'existe pas");
		}

	}

}
