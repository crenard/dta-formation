package dta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dta.model.Ingredient;
import dta.repositories.IngredientsRepository;

@Controller
@RequestMapping("ingredients")
public class AppController {

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
	public String getNew(Model m) {
		m.addAttribute("ingredient", new Ingredient());
		return "ajouterIngredient";
	}

	@RequestMapping(method = RequestMethod.POST, value = "new")
	public String postNew(@ModelAttribute("ingredient") Ingredient ingredient) {
		repo.save(ingredient);
		return "redirect:/ingredients";
	}

	@RequestMapping(method = RequestMethod.GET, value = "edit/{id}")
	public String getEdit(Model m, @PathVariable Integer id) {
		m.addAttribute("ingredient", repo.findById(id));
		return "modifierIngredient";
	}

	@RequestMapping(method = RequestMethod.POST, value = "edit/{id}")
	public String postEdit(@ModelAttribute("ingredient") Ingredient ingredient, @PathVariable Integer id) {
		repo.updateById(id, ingredient);
		return "redirect:/ingredients";
	}

}
