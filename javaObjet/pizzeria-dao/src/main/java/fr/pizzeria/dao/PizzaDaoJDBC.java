package fr.pizzeria.dao;

import java.sql.*;
import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.*;

public class PizzaDaoJDBC implements IDao<Pizza> {

	public PizzaDaoJDBC() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ConnectionException(e);
		}
	}

	private Connection connect() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		try {
			return DriverManager.getConnection(resourceBundle.getString("user"), resourceBundle.getString("password"),
					resourceBundle.getString("url"));
		} catch (SQLException e) {
			throw new ConnectionException("Erreur de connection a la base", e);
		}
	}

	@Override
	public List<Pizza> findAll() {
		this.connect();
		List<Pizza> pizzas = new ArrayList<>();

		try (Connection conn = connect();
				PreparedStatement request = conn.prepareStatement("SELECT * FROM pizza");
				ResultSet resultSet = request.executeQuery()) {
			while (resultSet.next()) {
				pizzas.add(new Pizza(resultSet.getString("code"), resultSet.getString("description"),
						resultSet.getDouble("prix"),
						CategoriePizza.valueOf(resultSet.getString("categorie").toUpperCase())));
			}
			return pizzas;
		} catch (SQLException e) {
			throw new ConnectionException("Requete impossible", e);
		}
	}

	@Override
	public void save(Pizza newPizza) {
		this.connect();
		try (Connection conn = connect();
				PreparedStatement request = conn
						.prepareStatement("INSERT INTO pizza (code, description, prix, categorie) VALUES (?,?,?,?)")) {
			request.setString(1, newPizza.getCode());
			request.setString(2, newPizza.getNom());
			request.setDouble(3, newPizza.getPrix());
			request.setString(4, newPizza.getCategorie().toString());
			request.executeUpdate();
		} catch (SQLException e) {
			throw new ConnectionException("Sauvegarde impossible", e);
		}
	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		this.connect();
		try (Connection conn = connect();
				PreparedStatement request = conn.prepareStatement(
						"UPDATE pizza SET code=?, description=?, prix=?, categorie=? WHERE code = ?")) {
			request.setString(1, newPizza.getCode());
			request.setString(2, newPizza.getNom());
			request.setDouble(3, newPizza.getPrix());
			request.setString(4, newPizza.getCategorie().toString());
			request.setString(5, codePizza);
			request.executeUpdate();
		} catch (SQLException e) {
			throw new ConnectionException("Mise a jour impossible", e);
		}
	}

	@Override
	public void delete(String codePizza) {
		this.connect();
		try (Connection conn = connect();
				PreparedStatement request = conn.prepareStatement("DELETE FROM pizza WHERE code = ?")) {
			request.setString(1, codePizza);
			request.executeUpdate();
		} catch (SQLException e) {
			throw new ConnectionException("Suppression impossible", e);
		}
	}
}
