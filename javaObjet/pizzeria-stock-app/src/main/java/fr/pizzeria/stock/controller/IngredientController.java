package fr.pizzeria.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.stock.model.Ingredient;
import fr.pizzeria.stock.repositories.IngredientsRepository;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	@Autowired
	private IngredientsRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIngredients() {
		System.out.println("GET INGREDIENTS");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ingredients");
		List<Ingredient> listeIngredients = repo.findAll();
		mav.addObject("ingredients", listeIngredients);
		return mav;
	}
}
