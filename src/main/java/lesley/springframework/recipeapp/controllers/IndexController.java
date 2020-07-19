package lesley.springframework.recipeapp.controllers;

import lesley.springframework.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private RecipeService recipeServiceImpl;


    public IndexController(RecipeService recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("recipes", recipeServiceImpl.getRecipes());
        return "index";
    }
}