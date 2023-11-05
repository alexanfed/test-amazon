package com.example.demo.service;

import com.example.demo.domain.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    List<Address> getAddressesByCity(String city);

    Iterable<Address> getAllAddresses();

    Address saveAddress(Address address);
}