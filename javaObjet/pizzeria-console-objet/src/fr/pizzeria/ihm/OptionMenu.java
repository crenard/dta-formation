package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public abstract class OptionMenu {
	
	protected IPizzaDao dao;
	public Scanner sc;
	public OptionMenu(IPizzaDao dao, Scanner sc){
		this.dao = dao;
		this.sc = sc;
	}
	
	public abstract String getLibelle();
	public abstract boolean execute();
}
