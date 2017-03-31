package fr.pizzeria.console;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoFichiers;
import fr.pizzeria.dao.PizzaDaoJpaSpringData;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.model.Pizza;

@Configuration
@ComponentScan({ "fr.pizzeria.ihm", "fr.pizzeria.aspect" })
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.dao")
@EnableAspectJAutoProxy
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
	public DataSource dataSourceTest() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("scriptH2.sql").build();
	}

	@Bean
	@Qualifier("daoPizza")
	public IDao<Pizza> daoPizza() {
		return new PizzaDaoJpaSpringData();
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
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("fr.pizzeria.model");
		factory.setDataSource(dataSourceTest());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	// @Bean
	// public LocalEntityManagerFactoryBean localemFactory() {
	// return new LocalEntityManagerFactoryBean();
	// }
}
