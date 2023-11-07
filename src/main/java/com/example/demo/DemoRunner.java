package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.*;
import com.example.demo.util.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

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

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    private final PurchaseRepository purchaseRepository;

    private final DataService dataService;

    @Autowired
    public DemoRunner(UserRepository userRepository, ItemRepository itemRepository, PurchaseRepository purchaseRepository, DataService dataService) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.purchaseRepository = purchaseRepository;
        this.dataService = dataService;
    }

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

        // Populate the Item entities
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


        // Populate the Purchase entity
        Purchase purchase = Purchase.builder()
                .user(user1)
                .timestamp(LocalDateTime.now())
                .build();

        // Save the purchase to the database
        purchaseService.savePurchase(purchase);

        // Populate the PurchaseDetails
        PurchaseDetails purchaseDetails = PurchaseDetails.builder()
                .purchase(purchase)  // Replace 'purchase' with an actual Purchase object
                .item(item1)  // Replace 'item' with an actual Item object
                .quantity(2)  // Set the quantity as needed
                .build();

        // Save the PurchaseDetails to the database
        purchaseDetailsService.savePurchaseDetails(purchaseDetails);

        // Select all Users
        List<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            System.out.println("User: " + user.getUsername() + user.getEmail() + user.getAddress());
        }

        // Select all Users in a specific city
        String cityToSearch = "New York";  // Replace with the city you want to search for
        List<User> usersInCity = userRepository.findUsersByAddressCity(cityToSearch);

        System.out.println("Users in " + cityToSearch + ":");
        for (User user : usersInCity) {
            System.out.println("User: " + user.getUsername() + user.getAddress());
        }

        // Select items purchased by user by ID
        Long userId = 914539563502436353L;  // Replace with the user's ID you're interested in

        List<Item> itemsPurchasedByUser = itemRepository.findItemsPurchasedByUserId(userId);

        System.out.println("Items purchased by the user with ID " + userId + ":");
        for (Item item : itemsPurchasedByUser) {
            System.out.println("Item Name: " + item.getName());
        }

        // Replace 'city' with the desired city name (e.g., "New York")
        String city = "New York";

        List<Purchase> purchasesInNewYork = purchaseRepository.findPurchasesDeliveredToCityOrderByTimestampDesc(city);

        System.out.println("Purchases delivered to " + city + " (sorted by timestamp in descending order):");
        for (Purchase purchase1 : purchasesInNewYork) {
            System.out.println("Purchase ID: " + purchase1.getId() + ", Timestamp: " + purchase.getTimestamp());
        }
    }
}
