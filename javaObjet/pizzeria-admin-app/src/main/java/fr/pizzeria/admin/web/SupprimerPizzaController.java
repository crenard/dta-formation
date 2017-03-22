package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.tools.ServletTools;
import fr.pizzeria.dao.PizzaDaoImpl;

/**
 * Servlet implementation class SupprimerPizzaController
 */
public class SupprimerPizzaController extends HttpServlet {

	private PizzaDaoImpl daoPizza;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerPizzaController() {
		this.daoPizza = ServletTools.DAO_PIZZA;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		daoPizza.delete(request.getParameter("code"));
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}
}
