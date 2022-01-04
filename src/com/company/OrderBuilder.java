package com.company;

import java.util.ArrayList;

public class OrderBuilder {

    private String username;
    private ArrayList<Pizza> orderedPizzas = new ArrayList<>();


    public void setUsername(String username) {
        this.username = username;
    }

    public void addPizzaToOrder(Pizza pizza){
        this.orderedPizzas.add(pizza);
    }

    public Order getOrder() {
        Order order = new Order(username,orderedPizzas);
        return order;

    }
}
