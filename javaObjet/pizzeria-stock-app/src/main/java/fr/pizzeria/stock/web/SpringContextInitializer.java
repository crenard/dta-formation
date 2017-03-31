package fr.pizzeria.stock.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringContextInitializer implements WebApplicationInitializer {

	private static final Logger LOG = Logger.getLogger(SpringContextInitializer.class.getName());

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LOG.log(Level.INFO, "demarrage du serveur");
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(PizzeriaSpringConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);

		dispatcher.addMapping("/mvc/*");

		servletContext.addListener(new ContextLoaderListener(webContext));
	}

}
