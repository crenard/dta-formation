package fr.pizzeria.ihm.client;

import fr.pizzeria.model.Client;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionAddClient extends OptionMenu {
	/**
	 * Creation du menu item pour ajouter des clients
	 * 
	 * @param ihmTools
	 */
	public OptionAddClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Ajouter un nouveau client";
	}

	@Override
	public void execute() {
		int size = ihmTools.getDaoClient().findAll().size();

		System.out.println("Veuillez saisir le prenom");
		String prenom = ihmTools.getSc().nextLine();

		System.out.println("Veuillez saisir le nom");
		String nom = ihmTools.getSc().nextLine();

		ihmTools.getDaoClient().newClient(new Client(size + 1, prenom, nom));
	}

}
