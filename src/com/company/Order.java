package com.company;

import java.util.ArrayList;

public class Order implements Price{

    final String username;
    final ArrayList<Pizza> orderedPizzas;

    public Order(String username, ArrayList<Pizza> orderedPizzas) {
        this.username = username;
        this.orderedPizzas = orderedPizzas;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Pizza> getOrderedPizzas() {
        return orderedPizzas;
    }

    @Override
    public Double getPrice() {
        Double finalCost = 0.0;
        for(Pizza pizza : orderedPizzas){
            finalCost += pizza.getPrice();
        }
        return finalCost;
    }


    @Override
    public String toString() {
        return "Order{" +
                "username='" + username + '\'' +
                ", orderedPizzas=" + orderedPizzas +
                '}';
    }
}
