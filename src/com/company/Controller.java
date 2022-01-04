package com.company;

import java.util.*;

public class Controller {

    private Service service = new Service();
    private Scanner scanner = new Scanner(System.in);

    public void start(){
        String username = getUsername();
        service.openNewOrder(username);
        Boolean isNextPizzaOrdered = true;
        while (isNextPizzaOrdered){
            Boolean isPizzaAdded = addPizzaToOrder();
            if(isPizzaAdded){
                System.out.println("Success! Pizza added to your order.");
            }else{
                System.out.println("Something went wrong, we did not add this pizza to your order.");
            }
            System.out.println("Do you want to add another pizza to your order? Please, answer with yes or no.");
            isNextPizzaOrdered = yesNoToBoolean(scanner.nextLine());
        }
        service.buildOrder();
        System.out.println();
        System.out.println("Summary of your order: " + service.getOrderSummary());
        System.out.println();
        double finalCost = service.calculateCostOfOrder();
        System.out.println("Final cost of your order:" + finalCost);

    }

    private Boolean yesNoToBoolean(String yesOrNo) throws RuntimeException{
        String input = yesOrNo.toLowerCase();
        if("yes".equals(input)){
            return true;
        }
        if("no".equals(input)){
            return false;
        }else{
            throw new RuntimeException("Wrong answer to yes/no question.");
        }
    }


    public String getUsername(){
        //TODO authentication system
        //this is simple mock just to get username

        System.out.println("Welcome to Trattoria Marina. Please, log in to make an order.");
        System.out.println("username:");
        String username = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();
        System.out.println("You are logged in.");
        return username;
    }


    private boolean addPizzaToOrder() {
        System.out.println("Menu");
        printMenu();
        System.out.println("Please, write name of your pizza:");
        String chosenType = scanner.nextLine();
        System.out.println("List ingredients that you want to remove. If non, press Enter.");
        String removedIngredientsString = scanner.nextLine();
        System.out.println("List ingredients that you want to add. If non, press Enter.");
        String addedIngredientsString = scanner.nextLine();

        ArrayList<String> addedIngredients = extractIngredientsFormInputString(addedIngredientsString);
        ArrayList<String> removedIngredients = extractIngredientsFormInputString(removedIngredientsString);

        return service.addPizzaToOrder(chosenType, addedIngredients, removedIngredients);

    }

    private ArrayList<String> extractIngredientsFormInputString(String addedOrRemovedIngredients){
        String prepared = addedOrRemovedIngredients.toLowerCase().trim();
        List<String> items = Arrays.asList(prepared.split("\\s*,\\s*"));
        ArrayList<String> filteredItems  = new ArrayList<>(items);
        filteredItems.remove("");
        return filteredItems;
    }

    private void printMenu() {
        ArrayList<String> possiblePizzaNames = service.getPossiblePizzaNames();
        ArrayList<ArrayList<String>> ingredientsOfEachPizza = service.getIngredientsOfEachPizza();
        for (int i=0; i<possiblePizzaNames.size(); i++){
            System.out.println(possiblePizzaNames.get(i));
            System.out.println(ingredientsOfEachPizza.get(i));
        }

    }

}
