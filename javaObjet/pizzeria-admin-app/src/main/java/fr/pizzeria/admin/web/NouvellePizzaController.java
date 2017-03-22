package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.tools.ServletTools;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class NouvellePizzaController
 */
public class NouvellePizzaController extends HttpServlet {

	private static final String NEW_PIZZA_VIEW = "/WEB-INF/views/pizzas/nouvellePizza.jsp";
	private PizzaDaoImpl daoPizza;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NouvellePizzaController() {
		this.daoPizza = ServletTools.DAO_PIZZA;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher(NEW_PIZZA_VIEW);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		daoPizza.save(new Pizza(req.getParameter("code").toUpperCase(), req.getParameter("nom"),
				Double.parseDouble(req.getParameter("prix")), CategoriePizza.valueOf(req.getParameter("categorie"))));
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

}
