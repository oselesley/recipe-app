package lesley.springframework.recipeapp.controllers;

import lesley.springframework.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = {"/recipes/{id}"}, method = RequestMethod.GET)
    public String getRecipe(Model model, @PathVariable("id") long id) {
        model.addAttribute("recipe", recipeService.findById(id));
        return "recipe/recipe.html";
    }
}
