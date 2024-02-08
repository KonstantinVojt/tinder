package com.example.tinder.service.database.impl;

import com.example.tinder.entity.Sex;
import com.example.tinder.entity.User;
import com.example.tinder.service.database.UsersDatabaseService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersDatabaseFakeServiceImpl implements UsersDatabaseService {

    private List<User> userList;

    @PostConstruct
    public void init() {
        System.out.println("Users Repository Init Method Stars");
        User user = new User();
        user.setName("James");
        user.setSex(Sex.MALE);
        user.setPoint(10);

        User user1 = new User();
        user1.setName("Maria");
        user1.setSex(Sex.FEMALE);
        user1.setPoint(10);

        User user2 = new User();
        user2.setName("Steve");
        user2.setSex(Sex.MALE);
        user2.setPoint(10);

        userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);

    }


    public List<User> getUserList(){
        return userList;
    }

}
