package fr.pizzeria.model;

import java.lang.reflect.Field;

import javax.persistence.*;

import org.apache.commons.lang3.builder.*;

import fr.pizzeria.exception.StockageException;

/**
 * Modele de gestion de pizzas
 * 
 * @author ETY 10
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p"),
		@NamedQuery(name = "Pizza.find", query = "SELECT p FROM Pizza p WHERE code LIKE :code") })
@Table(name = "pizza")
public class Pizza implements Comparable<Pizza>, GenericData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ToString(uppercase = true)
	@Column(name = "code", length = 3, nullable = false, unique = true)
	private String code;
	@ToString
	@Column(name = "description", length = 30)
	private String nom;
	@ToString
	@Column(name = "prix")
	private double prix;
	@Enumerated(EnumType.STRING)
	@Column(name = "categorie", nullable = false)
	private CategoriePizza categorie;
	@Column(name = "url_image")
	private String url_image;

	/**
	 * Creation d'une nouvelle pizza
	 * 
	 */
	public Pizza() {
		this.code = "GRE";
		this.nom = null;
		this.prix = 0;
		this.categorie = CategoriePizza.VIANDE;

	}

	/**
	 * Creation d'une nouvelle pizza
	 * 
	 * @param code
	 * @param nom
	 * @param prix
	 * @param category
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza category) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = category;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (Field field : this.getClass().getDeclaredFields()) {
			appendIfAnnoted(field, sb);
		}
		return sb.toString();
	}

	private StringBuilder appendIfAnnoted(Field field, StringBuilder sb) {
		if (field.isAnnotationPresent(ToString.class)) {
			String fieldValue;
			try {
				fieldValue = field.get(this).toString();

				if (field.getAnnotation(ToString.class).uppercase()) {
					fieldValue = fieldValue.toUpperCase();
				}
				sb.append(fieldValue).append(";");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.out.println("ToString error");
				throw new StockageException(e);
			}
		}
		return sb;
	}

	@Override
	public int compareTo(Pizza pizza) {
		return this.code.compareTo(pizza.getCode());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(23, 31).append(code).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return new EqualsBuilder().append(code, other.code).isEquals();
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

}
