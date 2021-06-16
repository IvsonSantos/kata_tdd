package com.example.kata.services;

import com.example.kata.entity.Game;
import com.example.kata.entity.Player;
import com.example.kata.service.helper.GameHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameHelperTest {

    @Test
    public void createBoard() {
        Character[][] board = GameHelper.newBoard();
        assertNotNull(board);
    }

    @Test
    public void findTurnOfPlayer() {
        Game game = new Game();
        Player player = GameHelper.findTurnPlayer(game);
        assertTrue(player.getIsTurn());
    }

    @Test
    public void checkNoWinnerOnANewBoard() {
        Character[][] board = GameHelper.newBoard();
        assertFalse(GameHelper.checkWinner(board));
    }

}
