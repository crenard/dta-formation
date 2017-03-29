package fr.pizzeria.ihm.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuClientConnecte;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Client;

@Component
public class OptionConnect extends OptionMenu {

	private IDao<Client> daoClient;
	private IhmTools ihmTools;

	@Override
	public String getLibelle() {
		return "Se connecter";
	}

	@Override
	public void execute() {
		Client connectClient = ihmTools.saisirClient();
		List<Client> clients = daoClient.findAll();

		if (clients.contains(connectClient)) {
			// Menu menuClient = new MenuClientConnecte("**** Pizzeria Client
			// ****",
			// clients.get(clients.indexOf(connectClient)));
			// menuClient.executer();
		} else {
			System.out.println("Identification incorrecte");
		}
	}

	public void setDaoClient(IDao<Client> daoClient) {
		this.daoClient = daoClient;
	}

	@Autowired
	public void setIhmTools(IhmTools ihmTools) {
		this.ihmTools = ihmTools;
	}

}
