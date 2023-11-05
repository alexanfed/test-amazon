package com.example.demo.service;

import com.example.demo.domain.PurchaseDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseDetailsService {
    PurchaseDetails savePurchaseDetails(PurchaseDetails purchaseDetails);
    PurchaseDetails getPurchaseDetailsById(Long id);
    List<PurchaseDetails> getAllPurchaseDetails();
    void deletePurchaseDetails(Long id);
}