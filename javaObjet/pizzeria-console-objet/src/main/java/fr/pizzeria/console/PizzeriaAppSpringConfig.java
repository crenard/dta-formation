package fr.pizzeria.console;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoFichiers;
import fr.pizzeria.dao.PizzaDaoJpaSpring;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
@EnableTransactionManagement
public class PizzeriaAppSpringConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/pizzeria");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	@Qualifier("daoPizza")
	public IDao<Pizza> daoPizza() {
		return new PizzaDaoJpaSpring();
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

	@Bean
	public PlatformTransactionManager txManager() {
		return new JpaTransactionManager();
	}

	@Bean
	public LocalEntityManagerFactoryBean emFactory() {
		return new LocalEntityManagerFactoryBean();
	}
}
