package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	private static final long serialVersionUID = 1L;

	private PizzaDaoImpl daoPizza;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerPizzaController() {
		this.daoPizza = ServletTools.daoPizza;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		daoPizza.delete(request.getParameter("code"));
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/pizzas/list");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
