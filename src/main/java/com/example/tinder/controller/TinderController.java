package com.example.tinder.controller;

import com.example.tinder.entity.User;
import com.example.tinder.service.match.MatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TinderController {

    private final MatchService matchService;

    @Autowired
    public TinderController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping(value = "/new-match")
    public User getNewMatch() {
        return matchService.getNewMatch();
    }
}
