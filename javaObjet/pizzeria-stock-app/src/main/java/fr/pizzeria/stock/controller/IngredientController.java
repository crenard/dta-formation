package fr.pizzeria.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.stock.model.Ingredient;
import fr.pizzeria.stock.repositories.IngredientsRepository;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

	@Autowired
	private IngredientsRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listerIngredients");
		List<Ingredient> listeIngredients = repo.findAll();
		mav.addObject("liste", listeIngredients);
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "new")
	public ModelAndView getNew(Model model) {
		model.addAttribute("ingredient", new Ingredient());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ajouterIngredient");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "new")
	public String postNew(@ModelAttribute("ingredient") Ingredient ingredient) {
		repo.save(ingredient);
		return "redirect:/mvc/ingredients";
	}

	@RequestMapping(method = RequestMethod.GET, value = "suppr/{id}")
	public String delete(@PathVariable Integer id) {
		repo.deleteById(id);
		return "redirect:/mvc/ingredients";
	}

	@RequestMapping(method = RequestMethod.GET, value = "edit/{id}")
	public ModelAndView getEdit(Model model, @PathVariable Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modifierIngredient");
		mav.addObject("ingredient", repo.findById(id));
		model.addAttribute("newIngredient", new Ingredient());
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "edit/{id}")
	public String postEdit(@PathVariable Integer id, @ModelAttribute("ingredient") Ingredient ingredient) {
		repo.updateById(id, ingredient);
		return "redirect:/mvc/ingredients";
	}
}
