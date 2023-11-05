package com.example.demo.impl;

import com.example.demo.domain.Address;
import com.example.demo.domain.Purchase;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.service.PurchaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    @Override
    public List<Purchase> getPurchasesDeliveredToCitySortedByTime(String city) {
        return null;
    }

    @Transactional
    @Override
    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    // Implement other methods as needed
}
