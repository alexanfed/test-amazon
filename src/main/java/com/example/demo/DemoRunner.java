package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseDetailsService purchaseDetailsService;

    @Override
    public void run(String... args) throws Exception {
        // Populate the Address entities
        Address address1 = Address.builder()
                .street("123 Main St")
                .city("New York")
                .build();

        Address address2 = Address.builder()
                .street("456 Elm St")
                .city("Los Angeles")
                .build();

        // Save Address entities to the database
        addressService.saveAddress(address1);
        addressService.saveAddress(address2);

        // Populate the User entities
        User user1 = User.builder()
                .username("user1")
                .email("user1@example.com")
                .address(address1) // Assign an address to the user
                .build();

        User user2 = User.builder()
                .username("user2")
                .email("user2@example.com")
                .address(address2) // Assign a different address to the user
                .build();

        // Save User entities to the database
        userService.saveUser(user1);
        userService.saveUser(user2);

        // Create and save Item objects
        Item item1 = Item.builder()
                .name("Item 1")
                .price(10.99)
                .build();

        Item item2 = Item.builder()
                .name("Item 2")
                .price(19.99)
                .build();

        // Save Item entities to the database
        itemService.saveItem(item1);
        itemService.saveItem(item2);

        // ... Add more items as needed

        // Create a Purchase object
        Purchase purchase = Purchase.builder()
                .user(user1)
                .build();

        // Save the purchase to the database
        purchaseService.savePurchase(purchase);

        // Create an instance of PurchaseDetails
        PurchaseDetails purchaseDetails = PurchaseDetails.builder()
                .purchase(purchase)  // Replace 'purchase' with an actual Purchase object
                .item(item1)  // Replace 'item' with an actual Item object
                .quantity(2)  // Set the quantity as needed
                .build();

        // Save the PurchaseDetails
        purchaseDetailsService.savePurchaseDetails(purchaseDetails);
    }
}
