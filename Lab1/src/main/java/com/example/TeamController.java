package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Vít on 11. 12. 2016.
 */
//@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping("/teams")
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @RequestMapping("/teams/{id}")
    public Team getTeam(@PathVariable long id) {
        return teamRepository.findOne(id);
    }
}
