package fr.pizzeria.ihm.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Client;

@Component
public class OptionInscription extends OptionMenu {

	private IhmTools ihmTools;
	private IDao<Client> daoClient;

	@Override
	public String getLibelle() {
		return "S'inscrire";
	}

	@Override
	public void execute() {

		System.out.println("Veuillez saisir le prenom");
		String prenom = sc.nextLine();

		System.out.println("Veuillez saisir le nom");
		String nom = sc.nextLine();

		Client newClient = ihmTools.saisirClient();
		newClient.setNom(nom);
		newClient.setPrenom(prenom);
		daoClient.save(newClient);

	}

	@Autowired
	public void setIhmTools(IhmTools ihmTools) {
		this.ihmTools = ihmTools;
	}

	public void setDaoClient(IDao<Client> daoClient) {
		this.daoClient = daoClient;
	}

}
