package com.grupp28gdx.game.Model;

/**
 * All objects that have a position in the game(obstacles, player, coins) have a Position object that
 * updates as the game progresses.
 */
public class Position {

    private float x_position;
    private float y_position;

    public Position(float x, float y) {
        this.x_position = x;
        this.y_position = y;
    }

    public void setXPosition(float x) {
        this.x_position = x;
    }

    public void setYPosition(float y) {
        this.y_position = y;
    }

    public float getXPosition() {
        return this.x_position;
    }

    public float getYPosition() {
        return this.y_position;
    }
}
