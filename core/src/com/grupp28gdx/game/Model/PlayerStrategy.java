package com.grupp28gdx.game.Model;

public interface PlayerStrategy {
    void jump();
    void setLives(int lives);
    void setHorizontalSpeed(int x);
    void inputKeyDown(int key);
}
