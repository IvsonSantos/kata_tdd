package com.example.kata.services;

import com.example.kata.entity.Game;
import com.example.kata.repository.GameRepository;
import com.example.kata.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @InjectMocks
    private GameServiceImpl service;

    @Mock
    private GameRepository repository;

    @Test
    public void create_a_new_game() {
       service.createGame();
       List<Game> game = repository.findAll();
       assertNotNull(game);
    }


}
