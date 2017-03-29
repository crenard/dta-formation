package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Menu item
 * 
 * @author ETY 10
 *
 */
public abstract class OptionMenu {

	@Autowired
	protected Scanner sc;

	/**
	 * Execute l'action du menu item
	 */
	public abstract void execute();

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public abstract String getLibelle();

}
