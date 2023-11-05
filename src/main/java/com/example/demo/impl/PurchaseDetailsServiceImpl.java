package com.example.demo.impl;

import com.example.demo.domain.Purchase;
import com.example.demo.domain.PurchaseDetails;
import com.example.demo.repository.PurchaseDetailsRepository;
import com.example.demo.service.PurchaseDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseDetailsServiceImpl implements PurchaseDetailsService {

    private final PurchaseDetailsRepository purchaseDetailsRepository;

    @Autowired
    public PurchaseDetailsServiceImpl(PurchaseDetailsRepository purchaseDetailsRepository) {
        this.purchaseDetailsRepository = purchaseDetailsRepository;
    }

    @Override
    public PurchaseDetails getPurchaseDetailsById(Long id) {
        return null;
    }

    @Override
    public List<PurchaseDetails> getAllPurchaseDetails() {
        return purchaseDetailsRepository.findAll();
    }

    @Transactional
    @Override
    public PurchaseDetails savePurchaseDetails(PurchaseDetails purchaseDetails) {
        return purchaseDetailsRepository.save(purchaseDetails);
    }

    @Override
    public void deletePurchaseDetails(Long id) {

    }

    // You can implement other service methods for PurchaseDetails here

}
