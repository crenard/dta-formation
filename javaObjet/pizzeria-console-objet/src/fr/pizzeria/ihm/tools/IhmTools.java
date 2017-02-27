package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;

public class IhmTools {
	private Scanner sc = new Scanner(System.in);
	private IDao<Pizza> daoPizza;
	private IDao<Client> daoClient;

	public IhmTools() {
		this.daoPizza = new PizzaDaoFichiers();
	}

	public IDao<Pizza> getDaoPizza() {
		return daoPizza;
	}

	public IDao<Client> getDaoClient() {
		return daoClient;
	}

	public Scanner getSc() {
		return sc;
	}
}
