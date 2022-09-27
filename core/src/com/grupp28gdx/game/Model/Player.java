package com.grupp28gdx.game.Model;

/**
 * This is the common interface for the different type of players. There are three players in total in the game
 * to choose from.
 */
public interface Player {
    Player createPlayer();
    void jump();
    void run();
}