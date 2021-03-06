package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/new")
public class NouvellePizzaController extends HttpServlet {

	private static final String NEW_PIZZA_VIEW = "/WEB-INF/views/pizzas/nouvellePizza.jsp";

	@Inject
	private PizzaService pServ;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(NEW_PIZZA_VIEW);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pServ.save(new Pizza(req.getParameter("code").toUpperCase(), req.getParameter("nom"),
				Double.parseDouble(req.getParameter("prix")), CategoriePizza.valueOf(req.getParameter("categorie"))));
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

}
