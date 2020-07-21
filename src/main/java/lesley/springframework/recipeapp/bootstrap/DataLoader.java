package lesley.springframework.recipeapp.bootstrap;

import lesley.springframework.recipeapp.domain.Ingredient;
import lesley.springframework.recipeapp.domain.Notes;
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
        pg.setDirections("THE BEST WAY TO CUT AN AVOCADO\n" +
                "To slice open an avocado, cut it in half lengthwise with a sharp chef’s knife and twist apart the sides. One side will have the pit. To remove it, you can do one of two things:\n" +
                "\n" +
                "Method #1: Gently tap the pit with your chef’s knife so the knife gets wedged into the pit. Twist your knife slightly to dislodge the pit and lift to remove. If you use this method, first protect your hand with a thick kitchen towel before proceeding.\n" +
                "Method #2: Cut the side with the pit in half again, exposing more of the pit. Use your fingers or a spoon to remove the pit\n" +
                "Once the pit is removed, just cut the avocado into chunks right inside the peel and use a spoon to scoop them out." +
                "HOW TO STORE GUACAMOLE\n" +
                "Guacamole is best eaten right after it’s made. Like apples, avocados start to oxidize and turn brown once they’ve been cut. That said, the acid in the lime juice you add to guacamole can help slow down that process, and if you store the guacamole properly, you can easily make it a few hours ahead if you are preparing for a party.\n" +
                "\n" +
                "The trick to keeping guacamole green is to make sure air doesn’t touch it! Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This will keep the amount of browning to a minimum.\n" +
                "\n" +
                "You can store the guacamole in the fridge this way for up to three days.\n" +
                "\n" +
                "If you leave the guacamole exposed to air, it will start to brown and discolor. That browning isn’t very appetizing, but the guacamole is still good. You can either scrape off the brown parts and discard, or stir them into the rest of the guacamole.");
        Notes notes = new Notes();
        notes.setRecipeNotes(
                "1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n");

        notes.setRecipe(pg);
        pg.setNote(notes);
        recipeRepository.save(pg);
        iglist.forEach(pg::addIngredient);
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
        sgcTacos.setDirections("First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\nThe ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\n" +
                "\n" +
                "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
                "\n" +
                "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that’s living!");
        Notes notes2 = new Notes();
        notes2.setRecipeNotes("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        notes2.setRecipe(sgcTacos);
        sgcTacos.setNote(notes2);
        recipeRepository.save(sgcTacos);
        iglist.forEach(sgcTacos::addIngredient);
        recipeRepository.save(sgcTacos);
    }
}
