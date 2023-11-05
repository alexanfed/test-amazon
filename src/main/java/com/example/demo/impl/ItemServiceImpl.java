package com.example.demo.impl;

import com.example.demo.domain.Address;
import com.example.demo.domain.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Transactional
    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

}
