package com.company;

import java.util.ArrayList;

public class Order{

    final String username;
    final ArrayList<Pizza> orderedPizzas;

    final Double cost;

    public Order(String username, ArrayList<Pizza> orderedPizzas, Double cost) {
        this.username = username;
        this.orderedPizzas = orderedPizzas;
        this.cost = cost;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Pizza> getOrderedPizzas() {
        return orderedPizzas;
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "username='" + username + '\'' +
                ", orderedPizzas=" + orderedPizzas +
                '}';
    }
}
