package fr.pizzeria.model;

public enum Statut {
	ATTENTE("Attente"), LIVREE("Livree"), ANNULEE("Annulee");

	private String value;

	private Statut(String s) {
		value = s;
	}

	public String getValue() {
		return value;
	}
}
