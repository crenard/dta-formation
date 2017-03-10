package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Outil pour aider l'ihm
 * 
 * @author ETY 10
 *
 */
public class IhmTools {
	private Scanner sc = new Scanner(System.in);
	private IDao<Pizza> daoPizza;
	private IDao<Pizza> daoSource;
	private IClientDao daoClient;

	/**
	 * Creation de l'outil pour aider l'ihm
	 * 
	 * @param dao
	 * @param source
	 */
	public IhmTools(IDao<Pizza> dao, IDao<Pizza> source) {
		this.daoPizza = dao;
		this.daoClient = new ClientDaoImpl();
		this.daoSource = source;
	}

	/**
	 * Demander a l'utilisateur la saisie d'une pizza
	 * 
	 * @return
	 */
	public Pizza saisirPizza() {
		System.out.println("Veuillez saisir le code");
		String code = sc.nextLine();

		System.out.println("Veuillez saisir le nom (sans espaces)");
		String nom = sc.nextLine();

		System.out.println("Veuillez saisir le prix");
		Double prix = sc.nextDouble();

		System.out.println("Veuillez saisir la categorie :");
		CategoriePizza[] categories = CategoriePizza.values();
		for (int i = 0; i < categories.length; i++) {
			System.out.println(i + 1 + " : " + categories[i].getLibelle());
		}

		int choixCategory = getSc().nextInt();
		sc.nextLine();
		CategoriePizza category = categories[choixCategory - 1];

		return new Pizza(code, nom, prix, category);
	}

	public IDao<Pizza> getDaoPizza() {
		return daoPizza;
	}

	public IClientDao getDaoClient() {
		return daoClient;
	}

	public IDao<Pizza> getDaoSource() {
		return daoSource;
	}

	public Scanner getSc() {
		return sc;
	}

}
