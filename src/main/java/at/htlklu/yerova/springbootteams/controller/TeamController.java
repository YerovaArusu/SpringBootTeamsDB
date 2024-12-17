package at.htlklu.yerova.springbootteams.controller;


import at.htlklu.yerova.springbootteams.entities.Player;
import at.htlklu.yerova.springbootteams.entities.Team;
import at.htlklu.yerova.springbootteams.repositories.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamRepo teamRepo;


    @GetMapping("/list")
    public List<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    @GetMapping("listOrderedByStadium")
    public List<Team> getAllTeamsOrderedByStadium() {
        return teamRepo.findAllByOrderByStadium();
    }

    @GetMapping("/{id}")
    public Team getTeamsById(@PathVariable int id) {
        return teamRepo.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable int id) {
        teamRepo.deleteById(id);
    }

    @PutMapping("{id}")
    public Team updateTeam(@PathVariable int id,
                               @RequestBody Team student) {
        Team s = teamRepo.findById(student.getId()).get();

        s.setName(student.getName());
        s.setStadium(student.getStadium());

        return teamRepo.save(s);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team student) {
        return teamRepo.save(student);
    }

}
