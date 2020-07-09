package lesley.springframework.recipeapp.bootstrap;

import lesley.springframework.recipeapp.domain.Ingredient;
import lesley.springframework.recipeapp.domain.Recipe;
import lesley.springframework.recipeapp.repositories.CategoryRepository;
import lesley.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class DataLoader implements CommandLineRunner {
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;

    public DataLoader(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Ingredient ig1 = new Ingredient();
        ig1.setDescription("ripe avocados");
        ig1.setAmount(new BigDecimal(2));

        Ingredient ig2 = new Ingredient();
        ig2.setDescription("salt");
        ig2.setAmount(new BigDecimal(1/ 4));
        ig2.setUom(unitOfMeasureRepository.findById(1L).get());

        Ingredient ig3 = new Ingredient();
        ig3.setDescription("fresh lime juice");
        ig3.setAmount(new BigDecimal(1));
        ig3.setUom(unitOfMeasureRepository.findById(2L).get());

        Ingredient ig4 = new Ingredient();
        ig4.setDescription("minced red onion");
        ig4.setAmount(new BigDecimal(2));
        ig4.setUom(unitOfMeasureRepository.findById(2L).get());

        Ingredient ig5 = new Ingredient();
        ig5.setDescription("serano chiles (stems and seeds removed)");
        ig5.setAmount(new BigDecimal(2));

        Ingredient ig6 = new Ingredient();
        ig6.setDescription("cilantro leaves and tender stems");
        ig6.setAmount(new BigDecimal(2));
        ig6.setUom(unitOfMeasureRepository.findById(2L).get());

        Ingredient ig7 = new Ingredient();
        ig7.setDescription("freshly grated black pepper");
        ig7.setAmount(new BigDecimal(1));
        ig7.setUom(unitOfMeasureRepository.findById(6L).get());

        Ingredient ig8 = new Ingredient();
        ig8.setDescription("ripe tomato, seeds and pulp removed");
        ig8.setAmount(new BigDecimal(1/ 2));

        Ingredient ig9 = new Ingredient();
        ig9.setDescription("red radishes or jicana, to garnish");

        Ingredient ig10 = new Ingredient();
        ig10.setDescription("tortilla chips, to serve");


        Ingredient[] igs = {ig1, ig2, ig3, ig4, ig5, ig6, ig7, ig8, ig9, ig10};
        Recipe pg = new Recipe();
        pg.setDescription("Perfect Guacamole");
        pg.setPrepTime(10);
        pg.setCookTime(5);
        pg.setServings(4);
        pg.setSource("");
        pg.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        pg.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. ");
        pg.getIngredients().addAll(Arrays.asList(igs));
    }
}
