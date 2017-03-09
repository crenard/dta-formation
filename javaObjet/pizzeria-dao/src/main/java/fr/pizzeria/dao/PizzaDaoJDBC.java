package fr.pizzeria.dao;

import java.sql.*;
import java.util.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.*;

public class PizzaDaoJDBC implements IDao<Pizza> {

	private Connection conn;
	private String user;
	private String password;

	public PizzaDaoJDBC() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		user = resourceBundle.getString("user");
		password = resourceBundle.getString("password");

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ConnectionException(e);
		}
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzeria", user, password);
		} catch (SQLException e) {
			throw new ConnectionException("Erreur de connection a la base", e);
		}
	}

	@Override
	public List<Pizza> findAll() {
		List<Pizza> pizzas = new ArrayList<>();

		try {
			PreparedStatement request = conn.prepareStatement("SELECT * FROM pizza");
			ResultSet resultSet = request.executeQuery();
			while (resultSet.next()) {
				String code = resultSet.getString("code");
				String descript = resultSet.getString("description");
				double prix = resultSet.getDouble("prix");
				CategoriePizza categorie = CategoriePizza.valueOf(resultSet.getString("categorie").toUpperCase());
				pizzas.add(new Pizza(code, descript, prix, categorie));
			}
			request.close();

		} catch (SQLException e) {
			throw new ConnectionException("Requete impossible", e);
		}
		return pizzas;
	}

	@Override
	public void save(Pizza newPizza) {
		try {
			PreparedStatement request = conn
					.prepareStatement("INSERT INTO pizza (code, description, prix, categorie) VALUES (?,?,?,?)");
			request.setString(1, newPizza.getCode());
			request.setString(2, newPizza.getNom());
			request.setDouble(3, newPizza.getPrix());
			request.setString(4, newPizza.getCategorie().toString());

			request.executeUpdate();
			request.close();

		} catch (SQLException e) {
			throw new ConnectionException("Sauvegarde impossible", e);
		}
	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		try {
			PreparedStatement request = conn
					.prepareStatement("UPDATE pizza SET code=?, description=?, prix=?, categorie=? WHERE code = ?");
			request.setString(1, newPizza.getCode());
			request.setString(2, newPizza.getNom());
			request.setDouble(3, newPizza.getPrix());
			request.setString(4, newPizza.getCategorie().toString());
			request.setString(5, codePizza);

			request.executeUpdate();
			request.close();

		} catch (SQLException e) {
			throw new ConnectionException("Mise a jour impossible", e);
		}
	}

	@Override
	public void delete(String codePizza) {
		try {
			PreparedStatement request = conn.prepareStatement("DELETE FROM pizza WHERE code = ?");
			request.setString(1, codePizza);

			request.executeUpdate();
			request.close();

		} catch (SQLException e) {
			throw new ConnectionException("Suppression impossible", e);
		}
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new ConnectionException("Impossible de fermer la connexion a la base", e);
		}
	}
}
