package lesley.springframework.recipeapp.controllers;

import lesley.springframework.recipeapp.domain.Category;
import lesley.springframework.recipeapp.domain.Recipe;
import lesley.springframework.recipeapp.domain.UnitOfMeasure;
import lesley.springframework.recipeapp.repositories.CategoryRepository;
import lesley.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import lesley.springframework.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeService recipeServiceImpl;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeServiceImpl) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index(Model model) {
        Optional<Category> cR = categoryRepository.findCategoriesByCategoryName("American");
        Optional<UnitOfMeasure> uR = unitOfMeasureRepository.findUnitOfMeasureByUom("Pinch");
        System.out.println(cR.get().getId());
        System.out.println(uR.get().getId());

        System.out.println(recipeServiceImpl.findALl());
        model.addAttribute("recipes", recipeServiceImpl.findALl());
        return "index";
    }
}