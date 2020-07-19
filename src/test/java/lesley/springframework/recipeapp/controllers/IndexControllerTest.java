package lesley.springframework.recipeapp.controllers;

import lesley.springframework.recipeapp.domain.Recipe;
import lesley.springframework.recipeapp.repositories.RecipeRepository;
import lesley.springframework.recipeapp.services.RecipeService;
import lesley.springframework.recipeapp.services.serviceImpl.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {
    @Mock
    RecipeService recipeService;

    IndexController indexController;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().is(200))
                .andExpect(view().name("index"));
    }

    @Test
    void indexTest() {
        // given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        Recipe recipe = new Recipe();
        recipe.setId(2L);
        recipes.add(recipe);


        // when recipeService.getRecipes is called in the IndexController.index method
        // (in model.getAttributes("name", recipeService.getRecipes())
        // our mock recipeService.getRecipes method is invoked, and we return recipes
        // (line 53) to the model.getAttributes
        when(recipeService.getRecipes()).thenReturn(recipes);

        // ArgumentCaptor captures the arguments passed to method while a test case was run
        // and can be used to very the correct arguments were passed in. We set the
        // type to a Set<Recipe> below, since we are expecting a Set of Recipes to be
        // passed in. It is used with the verify static method.
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        // when
        String viewName = indexController.index(model);

        // then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}