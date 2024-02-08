package com.example.tinder.service.match.impl;

import com.example.tinder.entity.User;
import com.example.tinder.service.database.UsersDatabaseService;
import com.example.tinder.service.match.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighestScoreMatchService implements MatchService {

    private UsersDatabaseService usersDatabaseService;

    public HighestScoreMatchService(UsersDatabaseService usersDatabaseService) {
        this.usersDatabaseService = usersDatabaseService;
    }

    @Override
    public User getNewMatch() {
        List<User> users = usersDatabaseService.getUserList();
        int maxPoint = 0;
        User highestRangUser = null;

        for (User user : users) {
            if (user.getPoint() > maxPoint) {
                maxPoint = user.getPoint();
                highestRangUser = user;
            }
        }

//        System.out.println("Найпопулярніша людина");
        return highestRangUser;
    }
}
