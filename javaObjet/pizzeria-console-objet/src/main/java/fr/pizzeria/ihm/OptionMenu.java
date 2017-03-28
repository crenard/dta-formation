package fr.pizzeria.ihm;

import java.util.Scanner;

/**
 * Menu item
 * 
 * @author ETY 10
 *
 */
public abstract class OptionMenu {

	protected Scanner sc;

	public abstract String getLibelle();

	/**
	 * Execute l'action du menu item
	 */
	public abstract void execute();

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
