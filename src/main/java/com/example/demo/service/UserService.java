package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    List<User> getUsersByCity(String city);

    User saveUser(User user);
}
