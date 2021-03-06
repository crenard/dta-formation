package fr.pizzeria.dao;

import java.sql.*;
import java.util.*;
import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Implementation BDD du stockage des pizzas
 * 
 * @author ETY 10
 *
 */
public class PizzaDaoJdbc implements IDao<Pizza> {
	/**
	 * Constructeur du dao qui charge le driver de BDD
	 */
	public PizzaDaoJdbc() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		try {
			Class.forName(resourceBundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			throw new ConnectionException(e);
		}
	}

	private static Connection connect() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		try {
			return DriverManager.getConnection(resourceBundle.getString("url"), resourceBundle.getString("user"),
					resourceBundle.getString("password"));
		} catch (SQLException e) {
			throw new ConnectionException("Erreur de connection a la base", e);
		}
	}

	@Override
	public List<Pizza> findAll() {
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

	@FunctionalInterface
	private interface Exec {
		void execute(PreparedStatement request) throws SQLException;
	}

	private void executeUpdate(String sqlRequest, Exec ex, String exceptionMessage) {
		try (Connection conn = connect(); PreparedStatement request = conn.prepareStatement(sqlRequest)) {
			ex.execute(request);
			request.executeUpdate();
		} catch (SQLException e) {
			throw new ConnectionException(exceptionMessage, e);
		}
	}

	@Override
	public void save(Pizza newPizza) {
		executeUpdate("INSERT INTO pizza (code, description, prix, categorie) VALUES (?,?,?,?)", request -> {
			request.setString(1, newPizza.getCode());
			request.setString(2, newPizza.getNom());
			request.setDouble(3, newPizza.getPrix());
			request.setString(4, newPizza.getCategorie().toString());
		}, "Sauvegarde impossible");
	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		executeUpdate("UPDATE pizza SET code=?, description=?, prix=?, categorie=? WHERE code LIKE ?", request -> {
			request.setString(1, newPizza.getCode());
			request.setString(2, newPizza.getNom());
			request.setDouble(3, newPizza.getPrix());
			request.setString(4, newPizza.getCategorie().toString());
			request.setString(5, codePizza);
		}, "Mise a jour impossible");
	}

	@Override
	public void delete(String codePizza) {
		try (Connection conn = connect();
				PreparedStatement request = conn.prepareStatement("DELETE FROM pizza WHERE code LIKE ?")) {
			request.setString(1, codePizza);
			request.executeUpdate();
		} catch (SQLException e) {
			throw new ConnectionException("Suppression impossible", e);
		}
	}

	@Override
	public void importBDD(IDao<Pizza> daoSource) {
		List<List<Pizza>> parts = ListUtils.partition(daoSource.findAll(), 3);

		try (Connection conn = connect();
				PreparedStatement request = conn
						.prepareStatement("INSERT INTO pizza (code, description, prix, categorie) VALUES (?,?,?,?)")) {
			for (List<Pizza> part : parts) {
				conn.setAutoCommit(false);
				for (Pizza pizza : part) {
					request.setString(1, pizza.getCode());
					request.setString(2, pizza.getNom());
					request.setDouble(3, pizza.getPrix());
					request.setString(4, pizza.getCategorie().toString());
				}
				conn.commit();
			}
		} catch (SQLException e) {
			throw new ConnectionException("Erreur durant l'import", e);
		}
	}
}
