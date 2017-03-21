package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IDao<Pizza> daoPizza;

	/**
	 * Default constructor.
	 */
	public PizzaServletWebApi() {
		this.daoPizza = new PizzaDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		daoPizza.findAll().forEach(pizza -> writer.append(pizza.toString()).append("\n"));
		response.setStatus(200);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		double prix = Double.parseDouble(request.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(request.getParameter("categorie").toUpperCase());
		daoPizza.save(new Pizza(code, nom, prix, categorie));
		response.setStatus(201);

		doGet(request, response);
	}

}
