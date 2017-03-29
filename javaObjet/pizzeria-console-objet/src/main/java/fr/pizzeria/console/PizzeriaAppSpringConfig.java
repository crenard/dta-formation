package fr.pizzeria.console;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoFichiers;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoJDBCSpring;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig {

	@Bean
	@Qualifier("daoPizza")
	public IDao<Pizza> daoPizza() {
		// DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		// dataSource.setUrl("jdbc:mariadb://localhost:3306/pizzeria");
		// dataSource.setUsername("root");
		// dataSource.setPassword("");
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("scriptH2.sql")
				.build();
		return new PizzaDaoJDBCSpring(dataSource);
	}

	@Bean
	@Qualifier("daoSource")
	public IDao<Pizza> daoSource() {
		return new PizzaDaoFichiers();
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public IhmTools ihmTools() {
		return new IhmTools();
	}
}
