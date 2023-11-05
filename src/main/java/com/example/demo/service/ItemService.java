package com.example.demo.service;

import com.example.demo.domain.Item;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> getAllItems();

    Item saveItem(Item item);
}
