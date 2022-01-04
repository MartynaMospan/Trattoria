package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public void save(Order currentOrder) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        //String json = gson.toJson(currentOrder);



        try {

            FileReader fileReader = new FileReader("orders.json");
            List<Order> orders = gson.fromJson(fileReader, new TypeToken<List<Order>>() {}.getType());
            fileReader.close();

            Integer idx;

            if (orders == null){
                idx = 0;
                orders = new ArrayList<>();
            }else {
               idx = orders.size();
            }
            orders.add(idx,currentOrder);

            String json = gson.toJson(orders);
            FileWriter fileWriter = new FileWriter("orders.json");
            fileWriter.write(json);
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
