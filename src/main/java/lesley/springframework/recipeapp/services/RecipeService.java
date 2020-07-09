package lesley.springframework.recipeapp.services;

import lesley.springframework.recipeapp.domain.Recipe;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService extends CrudService<Recipe> {
}

