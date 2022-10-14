package com.grupp28gdx.game.Model;

/**
 * This is the common interface for the different type of players. There are three players in total in the game
 * to choose from. The method createPlayer is implemented as a singleton in all player classes.
 */
public interface Player {
    void setStateOfPlayer(PlayerStates stateOfPlayer);
    PlayerStates getStateOfPlayer();
    int getLives();
    void setLives(int lives);

    void playerUpdate(float deltaTime);

    void createPlayer();

    void jump();

    void inputKeyDown(int key);

    void inputKeyUp(int key);

    Body getBody();

    void collisionGroundBegin();
    void collisionGroundEnd();
}
