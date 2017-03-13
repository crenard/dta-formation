package fr.pizzeria.ihm.client;

import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Client;

public class OptionInscription extends OptionMenu {

	public OptionInscription(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "S'inscrire";
	}

	@Override
	public void execute() {

		System.out.println("Veuillez saisir le prenom");
		String prenom = ihmTools.getSc().nextLine();

		System.out.println("Veuillez saisir le nom");
		String nom = ihmTools.getSc().nextLine();

		Client newClient = ihmTools.saisirClient();
		newClient.setNom(nom);
		newClient.setPrenom(prenom);
		ihmTools.getDaoClient().save(newClient);

	}

}
