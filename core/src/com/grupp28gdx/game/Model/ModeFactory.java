package com.grupp28gdx.game.Model;

/**
 * This is an abstract factory that knows of all abstract types of the objects of type
 * Player, Gemstone and Obstacle in the game.
 */
public interface ModeFactory {
    Player createPlayer();
    Gemstone createCoin();
    Obstacle createObstacle(float spawnX,float spawnY);
}
