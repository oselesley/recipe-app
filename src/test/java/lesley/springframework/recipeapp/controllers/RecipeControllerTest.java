package lesley.springframework.recipeapp.controllers;

import lesley.springframework.recipeapp.domain.Recipe;
import lesley.springframework.recipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @InjectMocks
    RecipeController recipeController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    void recipeMockMVC () throws Exception {
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setDescription("Fish Peppersoup");

        when(recipeService.findById(anyLong())).thenReturn(recipe1);
        mockMvc.perform(get("/recipes/1")).andExpect(status().isOk())
                .andExpect(view().name("recipe/recipe.html"))
                .andExpect(model().attribute("recipe", notNullValue()));
    }

    @Test
    void getRecipe() {
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipe2.setDescription("Omebe");

        when(recipeService.findById(anyLong())).thenReturn(recipe2);

        ArgumentCaptor<Recipe> ac = ArgumentCaptor.forClass(Recipe.class);

        assertEquals("recipe/recipe.html", recipeController.getRecipe(model, 2L));
        verify(model, times(1)).addAttribute(eq("recipe"), ac.capture());

        assertEquals("Omebe", ac.getValue().getDescription());
        assertEquals(2L, ac.getValue().getId());
    }
}