package com.example.devon.model;

//Coin enum representing different coin denominations

//Drink class representing different drink types
public class Drink {
 private String name;
 private double price;
 private int quantity;

 public Drink(String name, double price) {
     this.name = name;
     this.price = price;
 }

 public String getName() {
     return name;
 }

 public double getPrice() {
     return price;
 }

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}
 
}

