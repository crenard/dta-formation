package fr.pizzeria.model;

import fr.pizzeria.exception.*;

public class Client implements Comparable<Client> {
	private int id;
	private String nom;
	private String prenom;
	private double solde;

	public Client(int id, String prenom, String nom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = 0.0;
	}

	public int getId() {
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
		return id + " -> " + prenom + " " + nom + " (" + solde + " �)";
	}

	public int compareTo(Client client) {
		Integer cli1 = new Integer(this.id), cli2 = new Integer(client.getId());
		return cli1.compareTo(cli2);
	}
}
