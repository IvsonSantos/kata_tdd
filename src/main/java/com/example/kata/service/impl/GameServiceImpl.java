package com.example.kata.service.impl;

import com.example.kata.entity.Game;
import com.example.kata.entity.Movement;
import com.example.kata.repository.GameRepository;
import com.example.kata.service.GameService;
import com.example.kata.service.exception.BaseException;
import com.example.kata.service.helper.GameHelper;
import com.example.kata.service.helper.MessageHelper;
import com.example.kata.service.response.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameResponse createGame() {
        Game game = new Game();
        game.setBoard(GameHelper.newBoard());
        gameRepository.save(game);
        return new GameResponse(game.getId(), game.getPlayerOne().getType());
    }

    @Override
    public GameResponse makeAMove(Movement movement) throws ValidationException {

        Game game = this.gameRepository.findById(movement.getId())
                .orElseThrow(() -> new BaseException("log.game.notFound").userMessage("game.notFound"));

        GameResponse gameResponse = new GameResponse();
        GameHelper.doMovement(game, movement);

        if (GameHelper.checkWinner(game.getBoard())) {
            game.setWinner(movement.getPlayer().toString());
            gameResponse.setWinner(movement.getPlayer().toString());
            gameResponse.setMsg(MessageHelper.get("game.finished"));

        } else if (GameHelper.isDraw(game.getBoard())) {
            game.setWinner("Draw");
            gameResponse.setWinner("Draw");
            gameResponse.setMsg(MessageHelper.get("game.finished"));

        } else {
            GameHelper.changePlayer(game);
        }

        this.gameRepository.save(game);

        return gameResponse;
    }
}
