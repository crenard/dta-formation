package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.*;

@Repository
public class PizzaDaoJdbcSpring implements IDao<Pizza> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PizzaDaoJdbcSpring(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	private class PizzaMapper implements RowMapper<Pizza> {
		@Override
		public Pizza mapRow(ResultSet list, int rn) throws SQLException {
			return new Pizza(list.getString("code"), list.getString("description"), list.getDouble("prix"),
					CategoriePizza.valueOf(list.getString("categorie")));
		}
	}

	@Override
	public List<Pizza> findAll() {
		String sql = "SELECT * FROM pizza";
		return jdbcTemplate.query(sql, new PizzaMapper());
	}

	public Pizza find(String code) {
		String sql = "SELECT * FROM pizza WHERE code LIKE ?";
		return jdbcTemplate.queryForObject(sql, new PizzaMapper(), code);
	}

	@Override
	public void save(Pizza t) {
		String sql = "INSERT INTO pizza (code,description,prix,categorie) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, t.getCode(), t.getNom(), t.getPrix(), t.getCategorie().toString());
	}

	@Override
	public void update(String code, Pizza t) {
		String sql = "UPDATE pizza SET code = ?, description = ?, prix = ?, categorie = ? WHERE code LIKE ?";
		jdbcTemplate.update(sql, t.getCode(), t.getNom(), t.getPrix(), t.getCategorie().toString(), code);
	}

	@Override
	public void delete(String code) {
		String sql = "DELETE FROM pizza WHERE code LIKE ?";
		jdbcTemplate.update(sql, code);

	}

}
