package com.grupp28gdx.game.Model.PlayerGroup;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.Weapon.Gun;

/**
 * This is the common interface for the different type of players. There are three players in total in the game
 * to choose from. The method createPlayer is implemented as a singleton in all player classes.
 */
public interface Player {
    PlayerStates getStateOfPlayer();

    void playerUpdate(float deltaTime);

    void createPlayer();

    void jump();

    void inputKeyDown(int key);

    void inputKeyUp(int key);

    Body getBody();

    void collisionGroundBegin();

    Gun getGun();

    void addCollectedGem(int score);

    int getGemScore();

    void react();

    float getWidth();
    float getHeight();
}
