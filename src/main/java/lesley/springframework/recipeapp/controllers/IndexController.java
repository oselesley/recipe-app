package lesley.springframework.recipeapp.controllers;

import lesley.springframework.recipeapp.domain.Category;
import lesley.springframework.recipeapp.domain.UnitOfMeasure;
import lesley.springframework.recipeapp.repositories.CategoryRepository;
import lesley.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index(Model model) {
        Optional<Category> cR = categoryRepository.findCategoriesByCategoryName("American");
        Optional<UnitOfMeasure> uR = unitOfMeasureRepository.findUnitOfMeasureByUom("Pinch");
        System.out.println(cR.get().getId());
        System.out.println(uR.get().getId());
        return "index";
    }
}