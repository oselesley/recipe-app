package lesley.springframework.recipeapp.services;

import lesley.springframework.recipeapp.domain.Recipe;
import lesley.springframework.recipeapp.repositories.RecipeRepository;
import lesley.springframework.recipeapp.services.serviceImpl.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {
    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks
    RecipeServiceImpl recipeService;

    Set<Recipe> recipes = new HashSet<>();

    @BeforeEach
    void setUp() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);

        recipes.add(recipe);
        recipes.add(recipe2);

    }

    @Test
    void getRecipes() {
        when(recipeRepository.findAll()).thenReturn(recipes);

        Set<Recipe> returnedRecipes = recipeService.getRecipes();

        assertNotNull(returnedRecipes);
        assertEquals(2, returnedRecipes.size());
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void findRecipeByID() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        ArgumentCaptor<Long> ac = ArgumentCaptor.forClass(Long.class);

        Recipe foundRecipe = recipeService.findById(1L);
        assertNotNull(foundRecipe);
        assertEquals(1L, foundRecipe.getId());

        verify(recipeRepository).findById(ac.capture());

    }

}