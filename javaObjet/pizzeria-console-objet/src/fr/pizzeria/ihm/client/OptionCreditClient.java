package fr.pizzeria.ihm.client;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionCreditClient extends OptionMenu {

	public OptionCreditClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Crediter le compte d'un client";
	}

	@Override
	public void execute() throws SoldeException {
		System.out.println("Veuillez saisir l'id du client a crediter");
		int clientId = ihmTools.getSc().nextInt();

		System.out.println("Veuillez saisir le montant");
		double ajout = ihmTools.getSc().nextDouble();

		try {
			ihmTools.getDaoClient().crediter(clientId, ajout);
		} catch (CreditException e) {
			throw new CreditException("\n!!! Le montant ne peux pas exceder 5000€");
		} catch (StockageException e) {
			throw new CreditException("\n!!! Code incorrect, ce client n'existe pas");
		}
	}

}
