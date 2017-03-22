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
 * Servlet implementation class EditerPizzaController
 */
public class EditerPizzaController extends HttpServlet {

	private PizzaDaoImpl daoPizza;
	private String oldCode;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerPizzaController() {
		this.daoPizza = ServletTools.DAO_PIZZA;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		oldCode = request.getParameter("code");
		Pizza pizza = daoPizza.find(oldCode);
		request.setAttribute("pizza", pizza);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		daoPizza.update(oldCode, new Pizza(req.getParameter("code"), req.getParameter("nom"),
				Double.parseDouble(req.getParameter("prix")), CategoriePizza.valueOf(req.getParameter("categorie"))));
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

}
