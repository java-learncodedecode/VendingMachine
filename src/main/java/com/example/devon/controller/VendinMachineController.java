package com.example.devon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.devon.model.Drink;
import com.example.devon.service.DrinkDispenserService;

@RestController
public class VendinMachineController {
	
	@GetMapping("/hello")
	public String Hello() {
		return "Hello VendingMachine";
	}
	
	@Autowired
    private DrinkDispenserService vendingMachineService;
	
	@PostMapping("/adddrink")
	public ResponseEntity<String> addDrink(@RequestBody Drink drink){
		int quantity = drink.getQuantity();
		vendingMachineService.addDrink(drink, quantity);
		
		return ResponseEntity.ok("Drink Added Successfully");
		
	}

    @PostMapping("/insert-coin/{coinValue}")
    public ResponseEntity<String> insertCoin(@PathVariable double coinValue) {
        // Logic to handle inserting coins
        return ResponseEntity.ok("Coin inserted: " + coinValue);
    }

    @PostMapping("/select-drink/{drinkCode}")
    public ResponseEntity<String> selectDrink(@PathVariable String drinkCode) {
        // Logic to handle selecting drinks
        return ResponseEntity.ok("Drink selected: " + drinkCode);
    }

    @PostMapping("/cancel-order")
    public ResponseEntity<String> cancelOrder() {
        // Logic to handle canceling the order and returning coins
        return ResponseEntity.ok("Order canceled. Coins returned.");
    }

}
