package com.company;

import java.util.ArrayList;

public class Pizza implements Price{

    PossiblePizzaTypes pizzaType;
    ArrayList<String> customizedIngredients;

    public Pizza(PossiblePizzaTypes type, ArrayList<String> customizedIngredients){
        this.pizzaType = type;
        this.customizedIngredients = customizedIngredients;
    }

    @Override
    public Double getPrice(){
        int numberOfStandardIngredients = pizzaType.getIngredients().size();
        int numberOfCustomisedIngredients = customizedIngredients.size();
        if (numberOfCustomisedIngredients <= numberOfStandardIngredients){
            return pizzaType.getPrice();
        }else{
            IngredientsSource ingredientsRepository = new IngredientsSource();
            return pizzaType.getPrice() + (numberOfCustomisedIngredients - numberOfStandardIngredients)*ingredientsRepository.priceOfOneIngredient;
        }

    }

    @Override
    public String toString() {
        return pizzaType + " " + customizedIngredients;
    }
}
