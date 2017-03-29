package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoFichiers;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig {

	@Bean
	@Qualifier("daoPizza")
	public IDao<Pizza> daoPizza() {
		return new PizzaDaoImpl();
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
