package com.example.tinder.service.database.impl;

import com.example.tinder.entity.User;
import com.example.tinder.repository.UserRepository;
import com.example.tinder.service.database.UsersDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UsersDatabaseRealServiceImpl implements UsersDatabaseService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
