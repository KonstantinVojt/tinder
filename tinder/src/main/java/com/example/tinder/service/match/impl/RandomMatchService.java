package com.example.tinder.service.match.impl;

import com.example.tinder.entity.User;
import com.example.tinder.service.database.UsersDatabaseService;
import com.example.tinder.service.match.MatchService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Primary
public class RandomMatchService implements MatchService {

    private UsersDatabaseService usersDatabaseService;

    public RandomMatchService(UsersDatabaseService usersDatabaseService) {
        this.usersDatabaseService = usersDatabaseService;
    }

    @Override
    public User getNewMatch() {
        List<User> users = usersDatabaseService.getUserList();
        Random random = new Random();
        int i = random.nextInt(users.size());

//        System.out.println("Людина навмання");
        return users.get(i);
    }
}
