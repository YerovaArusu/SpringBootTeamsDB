package at.htlklu.yerova.springbootteams.controller;

import at.htlklu.yerova.springbootteams.entities.Player;
import at.htlklu.yerova.springbootteams.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepo playerRepo;


    @GetMapping
    public List<Player> getAllPlayer() {
        return playerRepo.findAll();
    }

    @GetMapping("/team/{id}")
    public List<Player> getPlayersByTeamId(@PathVariable int id) {
        return playerRepo.findByTeamId(id);
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return playerRepo.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable int id) {
        playerRepo.deleteById(id);
    }

    @PutMapping("{id}")
    public Player updatePlayer(@PathVariable int id,
                                 @RequestBody Player student) {
        Player s = playerRepo.findById(student.getId()).get();

        s.setName(student.getName());
        s.setTeam(student.getTeam());
        s.setHeight(student.getHeight());
        s.setDob(student.getDob());


        return playerRepo.save(s);
    }

    // TODO create remaining endpoints
    @PostMapping
    public Player createPlayer(@RequestBody Player student) {
        return playerRepo.save(student);
    }

}
