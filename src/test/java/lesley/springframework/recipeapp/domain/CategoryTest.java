package lesley.springframework.recipeapp.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp () {
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @Test
    void setId() {
    }

    @Test
    void getCategoryName() {
    }

    @Test
    void setCategoryName() {
    }

    @Test
    void getRecipes() {
    }

    @Test
    void setRecipes() {
    }
}