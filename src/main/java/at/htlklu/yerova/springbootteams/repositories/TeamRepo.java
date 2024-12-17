package at.htlklu.yerova.springbootteams.repositories;

import at.htlklu.yerova.springbootteams.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Integer> {

    public List<Team> findAllByOrderByStadium();
}

