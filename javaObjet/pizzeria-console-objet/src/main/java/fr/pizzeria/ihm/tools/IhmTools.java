package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.Pizza;

public class IhmTools {
	private Scanner sc = new Scanner(System.in);
	private IDao<Pizza> daoPizza;
	private IClientDao daoClient;

	public IhmTools(IDao<Pizza> dao) {
		this.daoPizza = dao;
		this.daoClient = new ClientDaoImpl();
	}

	public IDao<Pizza> getDaoPizza() {
		return daoPizza;
	}

	public IClientDao getDaoClient() {
		return daoClient;
	}

	public Scanner getSc() {
		return sc;
	}
}
