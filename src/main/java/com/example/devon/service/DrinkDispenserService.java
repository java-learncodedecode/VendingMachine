package com.example.devon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.devon.model.Coin;
import com.example.devon.model.Drink;

@Service
public class DrinkDispenserService {
	
	private List<Drink> drinks;
    private Map<Coin, Integer> coinInventory;
    private Map<Drink, Integer> drinkInventory;
    private double currentBalance;
    
    

    public void DrinkDispenser() {
        // Initialize inventories and available drinks
        drinks = new ArrayList<>();
        drinkInventory = new HashMap<>();
        coinInventory = new HashMap<>();
        currentBalance = 0.0;

        // Adding initial drinks and their quantities
        addDrink(new Drink("Coca", 1.0), 10);
        addDrink(new Drink("Redbull", 1.25), 8);
        addDrink(new Drink("Water", 0.5), 15);
        addDrink(new Drink("Orange juice", 1.95), 5);

        // Initialize coin inventory
        coinInventory.put(Coin.CENTS_5, 10);
        coinInventory.put(Coin.CENTS_10, 10);
        coinInventory.put(Coin.CENTS_20, 10);
        coinInventory.put(Coin.CENTS_50, 10);
        coinInventory.put(Coin.DOLLAR_1, 10);
        coinInventory.put(Coin.DOLLAR_2, 10);
    }

    public void addDrink(Drink drink, int quantity) {
        drinks.add(drink);
        drinkInventory.put(drink, quantity);
    }

    public void insertCoin(Coin coin) {
        // Update current balance and coin inventory
        currentBalance += getCoinValue(coin);
        coinInventory.put(coin, coinInventory.get(coin) + 1);
    }

    public void selectDrink(String drinkCode) {
        // Find the selected drink by code
        for (Drink drink : drinks) {
            if (drink.getName().equalsIgnoreCase(drinkCode)) {
                processDrinkSelection(drink);
                return;
            }
        }
        System.out.println("Drink not found.");
    }

    private void processDrinkSelection(Drink drink) {
        if (currentBalance >= drink.getPrice() && drinkInventory.get(drink) > 0) {
            // Dispense drink and return change if necessary
            System.out.println("Dispensing: " + drink.getName());
            double change = currentBalance - drink.getPrice();
            if (change > 0) {
                returnChange(change);
            }
            drinkInventory.put(drink, drinkInventory.get(drink) - 1);
            currentBalance = 0.0;
        } else {
            System.out.println("Insufficient balance or out of stock.");
        }
    }

    private void returnChange(double change) {
        // Logic to return change using available coins
        // Implement logic here to calculate and return the change using the coin inventory
        // Display the returned change
        System.out.println("Returning change: " + change);
    }

    public void cancelOrder() {
        // Return inserted coins
        // Update current balance to zero
        // Implement logic here to cancel the order and return coins
        System.out.println("Order canceled. Returning balance: " + currentBalance);
        currentBalance = 0.0;
    }

    public void checkStock() {
        // Display current drink inventory
        for (Drink drink : drinks) {
            System.out.println(drink.getName() + " - Quantity: " + drinkInventory.get(drink));
        }
    }

    public void checkStatus() {
        // Display machine status
        // Implement logic here to display machine status like current balance, coin inventory, etc.
        System.out.println("Current balance: " + currentBalance);
    }

    private double getCoinValue(Coin coin) {
        switch (coin) {
            case CENTS_5:
                return 0.05;
            case CENTS_10:
                return 0.10;
            case CENTS_20:
                return 0.20;
            case CENTS_50:
                return 0.50;
            case DOLLAR_1:
                return 1.0;
            case DOLLAR_2:
                return 2.0;
            default:
                return 0.0;
        }
    }

}
