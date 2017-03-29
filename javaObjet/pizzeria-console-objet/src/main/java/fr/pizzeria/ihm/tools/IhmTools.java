package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

/**
 * Outil pour aider l'ihm
 * 
 * @author ETY 10
 *
 */
@Component
public class IhmTools {
	private Scanner sc;

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

		int choixCategory = sc.nextInt();
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

	@Autowired
	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
