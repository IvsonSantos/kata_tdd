package com.example.kata.service;

import com.example.kata.entity.Movement;
import com.example.kata.service.response.GameResponse;

import javax.xml.bind.ValidationException;

public interface GameService {

    GameResponse createGame();

    GameResponse makeAMove(Movement movement) throws ValidationException;

}