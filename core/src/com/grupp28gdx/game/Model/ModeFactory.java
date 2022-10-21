package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.Obstacles.Obstacle;
import com.grupp28gdx.game.Model.PlayerGroup.Player;

/**
 * This is an abstract factory that knows of all abstract types of the objects of type
 * Player, Gemstone and Obstacle in the game.
 */
public interface ModeFactory {
    Player createPlayer();
    Gemstone createGemstone(float spawnX, float spawnY,int id);
    Obstacle createObstacle(float spawnX, float spawnY, int id);
}
