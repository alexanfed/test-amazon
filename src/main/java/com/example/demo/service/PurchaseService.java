package com.example.demo.service;

import com.example.demo.domain.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {
    List<Purchase> getAllPurchases();

    List<Purchase> getPurchasesDeliveredToCitySortedByTime(String city);

    Purchase savePurchase(Purchase purchase);
}
