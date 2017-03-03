package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza implements Comparable<Pizza> {
	@ToString(uppercase = true)
	private String code;
	@ToString
	private String nom;
	@ToString
	private double prix;
	private CategoriePizza categorie;

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza category) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = category;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		try {
			for (Field field : this.getClass().getDeclaredFields()) {
				if (field.isAnnotationPresent(ToString.class)) {
					String fieldValue = field.get(this).toString();
					if (field.getAnnotation(ToString.class).uppercase()) {
						fieldValue = fieldValue.toUpperCase();
					}
					sb.append(fieldValue).append(";");
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return sb.toString();

	}

	public int compareTo(Pizza pizza) {
		return this.code.compareTo(pizza.getCode());
	}
}
