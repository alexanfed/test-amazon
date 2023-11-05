package com.example.demo.impl;

import com.example.demo.domain.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAddressesByCity(String city) {
        return null;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Transactional
    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}