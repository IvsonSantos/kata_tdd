package com.example.kata.entities;

import com.example.kata.entity.Game;
import com.example.kata.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class GameRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private GameRepository repository;
     
    @Test
    public void testCreateAndSaveGameWithId1() {

        entityManager.persist(new Game());

        Optional<Game> gameOptional = repository.findById(1);

        assertThat(gameOptional).isNotEmpty();
    }

}
