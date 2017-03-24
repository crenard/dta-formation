package fr.pizzeria.admin.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaResource {

	@EJB
	PizzaServiceEJB ejb;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> getPizzas() {
		return ejb.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void newPizza(Pizza pizza) {
		ejb.save(pizza);
	}

	@PUT
	@Path("/{code}")
	public void updatePizza(Pizza pizza, @PathParam("code") String code) {
		ejb.update(code, pizza);
	}

	@DELETE
	@Path("/{code}")
	public void deletePizza(@PathParam("code") String code) {
		ejb.delete(code);
	}
}
