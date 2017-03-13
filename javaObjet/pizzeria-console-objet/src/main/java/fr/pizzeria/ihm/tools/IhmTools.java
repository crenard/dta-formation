package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.*;

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
	private IDao<Client> daoClient;
	private IDao<Commande> daoCommande;

	/**
	 * Creation de l'outil pour aider l'ihm
	 * 
	 * @param dao
	 * @param source
	 */
	public IhmTools(IDao<Pizza> source) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");
		this.daoPizza = new DaoJpa<Pizza>(Pizza.class, emf);
		this.daoClient = new DaoJpa<Client>(Client.class, emf);
		this.daoCommande = new DaoJpa<Commande>(Commande.class, emf);
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

	public Client saisirClient() {
		System.out.println("Veuillez saisir l'email");
		String mail = sc.nextLine();

		System.out.println("Veuillez saisir le mot de passe");
		String password = sc.nextLine();

		return new Client(null, null, mail, password);
	}

	public IDao<Pizza> getDaoPizza() {
		return daoPizza;
	}

	public IDao<Client> getDaoClient() {
		return daoClient;
	}

	public IDao<Pizza> getDaoSource() {
		return daoSource;
	}

	public IDao<Commande> getDaoCommande() {
		return daoCommande;
	}

	public Scanner getSc() {
		return sc;
	}

}
