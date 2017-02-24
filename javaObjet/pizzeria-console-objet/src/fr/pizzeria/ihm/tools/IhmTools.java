package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.Pizza;

public class IhmTools {
	private Scanner sc = new Scanner(System.in);
	private IDao<Pizza> dao;

	public IhmTools() {
		this.dao = new PizzaDaoImpl();
	}

	public IDao<Pizza> getDao() {
		return dao;
	}

	public Scanner getSc() {
		return sc;
	}
}
