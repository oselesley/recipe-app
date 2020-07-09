package lesley.springframework.recipeapp.services.serviceImpl;

import lesley.springframework.recipeapp.domain.Recipe;
import lesley.springframework.recipeapp.repositories.RecipeRepository;
import lesley.springframework.recipeapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe findById(Long id) {
        return recipeRepository.findById(id).get();
    }

    @Override
    public Recipe save(Recipe obj) {
        return recipeRepository.save(obj);
    }

    @Override
    public Set<Recipe> findALl() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipe -> recipes.add(recipe));
        return recipes;
    }
}
