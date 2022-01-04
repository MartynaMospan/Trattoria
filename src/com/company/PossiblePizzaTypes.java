package com.company;

import java.util.ArrayList;

public enum PossiblePizzaTypes implements Ingredients, Price{

    MARGHERITA (){
        @Override
        public ArrayList<String> getIngredients(){
            ArrayList<String> ingredients = new ArrayList<String>();
            ingredients.add("dough");
            ingredients.add("tomato sauce");
            ingredients.add("mozzarella");
            return ingredients;
        }
        @Override
        public Double getPrice(){
            return 20.0;
        }
    },
    CAPRICIOSA (){
        @Override
        public ArrayList<String> getIngredients(){
            ArrayList<String> ingredients = new ArrayList<String>();
            ingredients.add("dough");
            ingredients.add("tomato sauce");
            ingredients.add("mozzarella");
            ingredients.add("ham");
            ingredients.add("mushrooms");
            return ingredients;
        }
        @Override
        public Double getPrice(){
            return 23.0;
        }
    },
    CALZONE (){
        @Override
        public ArrayList<String> getIngredients(){
            ArrayList<String> ingredients = new ArrayList<String>();
            ingredients.add("dough");
            ingredients.add("tomato sauce");
            ingredients.add("mozzarella");
            ingredients.add("olives");
            ingredients.add("ham");
            ingredients.add("tomatoes");
            return ingredients;
        }
        @Override
        public Double getPrice(){
            return 25.0;
        }
    }

}
