package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SimplePizzaFactory {

    IngredientsSource ingredientsRepository = new IngredientsSource();

    public Pizza createPizza(String pizzaTypeInputString, ArrayList<String> addedIngredients, ArrayList<String> removedIngredients) throws EnumConstantNotPresentException, NoSuchElementException{

        PossiblePizzaTypes foundedPizzaType = findPizzaTypeByName(pizzaTypeInputString);
        ArrayList<String> customisedIngredients = customiseIngredients(foundedPizzaType, addedIngredients, removedIngredients);
        return new Pizza(foundedPizzaType, customisedIngredients);
    }

    PossiblePizzaTypes findPizzaTypeByName(String pizzaTypeInputString) throws EnumConstantNotPresentException{
        for(PossiblePizzaTypes pizzaType: PossiblePizzaTypes.values()){
            if (pizzaType.name().equals(pizzaTypeInputString)){
                return pizzaType;
            }
        }
        throw new EnumConstantNotPresentException(PossiblePizzaTypes.class, pizzaTypeInputString);
    }

    ArrayList<String> customiseIngredients(PossiblePizzaTypes pizzaType, ArrayList<String> addedIngredients, ArrayList<String> removedIngredients){

        ArrayList<String> customisedIngredients = pizzaType.getIngredients();

        for (String addedOne: addedIngredients){
            if (ingredientsRepository.allPossibleIngredients.contains(addedOne)){
                customisedIngredients.add(addedOne);
            }else{
                throw new NoSuchElementException("We are sorry, but " + addedOne + " is not available.");
            }
        }

        for (String removedOne: removedIngredients){
            if (customisedIngredients.contains(removedOne)){
                customisedIngredients.remove(removedOne);
            }else{
                throw new NoSuchElementException("We can not remove " + removedOne + " , because it is not included in your pizza.");
            }
        }

        return customisedIngredients;

    }
}
