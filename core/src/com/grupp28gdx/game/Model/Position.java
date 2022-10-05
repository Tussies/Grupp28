package com.grupp28gdx.game.Model;

/**
 * All objects that have a position in the game(obstacles, player, coins) have a Position object that
 * updates as the game progresses.
 */
public class Position {

    protected float x;
    protected float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setXPosition(float x) {
        this.x = x;
    }

    public void setYPosition(float y) {
        this.y = y;
    }

    public float getXPosition() {
        return this.x;
    }

    public float getYPosition() {
        return this.y;
    }
}
