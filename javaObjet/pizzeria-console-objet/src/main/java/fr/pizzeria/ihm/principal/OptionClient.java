package fr.pizzeria.ihm.principal;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.MenuClient;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class OptionClient extends OptionMenu {

	public OptionClient(IhmTools ihmTools) {
		super(ihmTools);
	}

	@Override
	public String getLibelle() {
		return "Gerer les clients";
	}

	@Override
	public void execute() throws StockageException {
		Menu menuClient = new MenuClient("**** Administration des clients ****", ihmTools);
		menuClient.executer();
	}

}
