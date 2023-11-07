package com.example.demo.util;

import java.time.LocalDateTime;

public class DataService {
    private Long userId;
    private String username;
    private String email;
    private String street;
    private String city;
    private int quantity;
    private String itemName;
    private double itemPrice;
    private LocalDateTime timestamp;

    public DataService(Long userId, String username, String email, String street, String city, int quantity, String itemName, double itemPrice, LocalDateTime timestamp) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.street = street;
        this.city = city;
        this.quantity = quantity;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.timestamp = timestamp;
    }
}
