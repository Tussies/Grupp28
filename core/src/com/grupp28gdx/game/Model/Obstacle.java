package com.grupp28gdx.game.Model;

/**
 * This is the common interface for the different type of objects. There are three types of objects in the game
 * in total for the player to maneuver. If the player makes contact with an obstacle the game is over.
 */
public interface Obstacle {
    Obstacle createObstacle(float x,float y);
}
