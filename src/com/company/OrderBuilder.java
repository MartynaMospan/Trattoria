package com.company;

import java.util.ArrayList;

public class OrderBuilder {

    private String username;
    private ArrayList<Pizza> orderedPizzas = new ArrayList<>();
    private Double cost;


    public void setUsername(String username) {
        this.username = username;
    }

    public void addPizzaToOrder(Pizza pizza){
        this.orderedPizzas.add(pizza);
    }

    public double setPrice() {
        double finalCost = 0.0;
        for(Pizza pizza : orderedPizzas){
            finalCost += pizza.getPrice();
        }
        this.cost = finalCost;
        return finalCost;
    }

    public Order getOrder() {
        Order order = new Order(username,orderedPizzas,cost);
        return order;

    }

}
