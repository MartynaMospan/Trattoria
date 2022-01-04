package com.company;

import java.util.Set;

public class IngredientsSource {
    final Set<String> allPossibleIngredients;
    final Double priceOfOneIngredient = 2.0;

    public IngredientsSource(){
        String[] ingredients = {"dough", "tomato sauce", "mozzarella", "ham", "mushrooms", "olives", "tomatoes"};
        this.allPossibleIngredients = Set.of(ingredients);
    }
}
