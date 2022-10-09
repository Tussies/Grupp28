package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;

/**
 * This is an abstract factory that knows of all abstract types of objects in the game.
 */
public interface ModeFactory {
    Player createPlayer();
    Gemstone createGemstone();
    Obstacle createObstacle(float spawnX,float spawnY);
}
