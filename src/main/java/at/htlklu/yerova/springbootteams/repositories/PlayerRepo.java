package at.htlklu.yerova.springbootteams.repositories;

import at.htlklu.yerova.springbootteams.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Integer> {

}
