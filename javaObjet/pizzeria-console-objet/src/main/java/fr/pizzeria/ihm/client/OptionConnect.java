package fr.pizzeria.ihm.client;

import java.util.List;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuClientConnecte;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Client;

public class OptionConnect extends OptionMenu {

	public OptionConnect(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Se connecter";
	}

	@Override
	public void execute() {
		Client connectClient = ihmTools.saisirClient();
		List<Client> clients = ihmTools.getDaoClient().findAll();

		if (clients.contains(connectClient)) {
			Menu menuClient = new MenuClientConnecte("**** Pizzeria Client ****", ihmTools,
					clients.get(clients.indexOf(connectClient)));
			menuClient.executer();
		} else {
			System.out.println("Identification incorrecte");
		}
	}

}
