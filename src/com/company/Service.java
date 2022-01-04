package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Service {

    SimplePizzaFactory pizzaFactory = new SimplePizzaFactory();
    OrderBuilder orderBuilder;
    OrderRepository orderRepository = new OrderRepository();
    Order currentOrder;



    Boolean addPizzaToOrder(String pizzaTypeInputString, ArrayList<String> addedIngredients, ArrayList<String> removedIngredients){
        try{
            Pizza newPizza = pizzaFactory.createPizza(pizzaTypeInputString, addedIngredients, removedIngredients);
            orderBuilder.addPizzaToOrder(newPizza);
            return true;
        }catch (EnumConstantNotPresentException e){
            System.err.println("We are sorry, but we do not have " + pizzaTypeInputString + " in our offer.");
            return false;
        }catch (NoSuchElementException ee){
            return false;
        }

    }


    public void openNewOrder(String username) {
        orderBuilder = new OrderBuilder();
        orderBuilder.setUsername(username);
    }

    public ArrayList<String> getPossiblePizzaNames() {
        ArrayList<String> possiblePizzaNames = new ArrayList<>();
        for (PossiblePizzaTypes pizzaType : PossiblePizzaTypes.values()){
            possiblePizzaNames.add(pizzaType.name());
        }
        return possiblePizzaNames;
    }

    public ArrayList<ArrayList<String>> getIngredientsOfEachPizza() {
        ArrayList<ArrayList<String>> ingredientsOfEachPizza = new ArrayList<>();
        for (PossiblePizzaTypes pizzaType : PossiblePizzaTypes.values()){
            ingredientsOfEachPizza.add(pizzaType.getIngredients());
        }
        return ingredientsOfEachPizza;
    }


    public double calculateCostOfOrder() {
        return orderBuilder.setPrice();
    }

    public void buildOrder() {
        currentOrder = orderBuilder.getOrder();
        orderRepository.save(currentOrder);
    }

    public String getOrderSummary() {
       return currentOrder.toString();
    }
}
