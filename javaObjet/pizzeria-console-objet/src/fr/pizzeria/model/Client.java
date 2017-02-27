package fr.pizzeria.model;

import fr.pizzeria.exception.*;

public class Client implements Comparable<Client> {
	private String id;
	private String nom;
	private String prenom;
	private double solde;

	public Client(String id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = 0.0;
	}

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public double getSolde() {
		return solde;
	}

	public void crediterCompte(double montant) throws CreditException {
		double tempSolde = solde + montant;
		if (tempSolde > 5000.0) {
			throw new CreditException();
		} else {
			solde = tempSolde;
		}
	}

	public void debiterCompte(double montant) throws DebitException {
		double tempSolde = solde - montant;
		if (tempSolde < 0.0) {
			throw new DebitException();
		} else {
			solde = tempSolde;
		}
	}

	@Override
	public String toString() {
		return id + " -> " + prenom + nom + " (" + solde + " €)";
	}

	public int compareTo(Client client) {
		return this.id.compareTo(client.getId());
	}
}
