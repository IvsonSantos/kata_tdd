package com.example.kata.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.kata.entity.Player;
import com.example.kata.repository.PlayerRepository;

@DataJpaTest
public class PlayerRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private PlayerRepository repository;
     
    @Test
    public void testCreateAndSaveTwoPlayers() {   	
    	
        entityManager.persist(new Player(Player.TYPE_X, true));
        entityManager.persist(new Player(Player.TYPE_O, false));
        
        List<Player> players = repository.findAll();
        
        assertThat(players.size()).isEqualTo(2) ;
    }

}
