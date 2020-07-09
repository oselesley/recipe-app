package lesley.springframework.recipeapp.bootstrap;

import lesley.springframework.recipeapp.domain.Ingredient;
import lesley.springframework.recipeapp.domain.Recipe;
import lesley.springframework.recipeapp.repositories.CategoryRepository;
import lesley.springframework.recipeapp.repositories.IngredientRepository;
import lesley.springframework.recipeapp.repositories.RecipeRepository;
import lesley.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;

    public DataLoader(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
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
        List<Ingredient> iglist = new ArrayList<>(Arrays.asList(igs));


        Recipe pg = new Recipe();
        pg.setDescription("Perfect Guacamole");
        pg.setPrepTime(10);
        pg.setCookTime(5);
        pg.setServings(4);
        pg.setSource("");
        pg.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        pg.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. ");
        pg.getIngredients().addAll(iglist);
        recipeRepository.save(pg);


        ig1 = new Ingredient();
        ig1.setDescription("ripe avocados");
        ig1.setAmount(new BigDecimal(2));

        ig2 = new Ingredient();
        ig2.setDescription("salt");
        ig2.setAmount(new BigDecimal(1/ 4));
        ig2.setUom(unitOfMeasureRepository.findById(1L).get());

        ig3 = new Ingredient();
        ig3.setDescription("fresh lime juice");
        ig3.setAmount(new BigDecimal(1));
        ig3.setUom(unitOfMeasureRepository.findById(2L).get());

        ig4 = new Ingredient();
        ig4.setDescription("minced red onion");
        ig4.setAmount(new BigDecimal(2));
        ig4.setUom(unitOfMeasureRepository.findById(2L).get());

        ig5 = new Ingredient();
        ig5.setDescription("serano chiles (stems and seeds removed)");
        ig5.setAmount(new BigDecimal(2));

        ig6 = new Ingredient();
        ig6.setDescription("cilantro leaves and tender stems");
        ig6.setAmount(new BigDecimal(2));
        ig6.setUom(unitOfMeasureRepository.findById(2L).get());

        ig7 = new Ingredient();
        ig7.setDescription("freshly grated black pepper");
        ig7.setAmount(new BigDecimal(1));
        ig7.setUom(unitOfMeasureRepository.findById(6L).get());

        ig8 = new Ingredient();
        ig8.setDescription("ripe tomato, seeds and pulp removed");
        ig8.setAmount(new BigDecimal(1/ 2));

        ig9 = new Ingredient();
        ig9.setDescription("red radishes or jicana, to garnish");

        ig10 = new Ingredient();
        ig10.setDescription("tortilla chips, to serve");


        Ingredient[] igs2 = {ig1, ig2, ig3, ig4, ig5, ig6, ig7, ig8, ig9, ig10};
        iglist = new ArrayList<>(Arrays.asList(igs2));


        Recipe sgcTacos = new Recipe();
        sgcTacos.setDescription("Spicy Grilled Chicken Tacos");
        sgcTacos.setPrepTime(20);
        sgcTacos.setCookTime(15);
        sgcTacos.setServings(6);
        sgcTacos.setSource("");
        sgcTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos");
        sgcTacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        sgcTacos.getIngredients().addAll(iglist);
        recipeRepository.save(sgcTacos);

    }
}
