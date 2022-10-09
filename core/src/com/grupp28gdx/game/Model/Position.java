package com.grupp28gdx.game.Model;

/**
 * All objects that have a position in the game(obstacles, player, coins) have a Position object that
 * updates as the game progresses.
 */
public class Position {

    protected float x;
    protected float y;
    private float x_position;
    private float y_position;
    private int forceX;
    private int forceY;
    private int movementSpeed;


    public Position(float x, float y) {
        this.movementSpeed = 0;
        this.x_position = x;
        this.y_position = y;
        this.forceX = 0;
        this.forceY = 0;
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


    public void setForceX(int forceX) {
        this.forceX = forceX;
    }

    public int getForceX() {
        return forceX;
    }

    public void setForceY(int forceY) {
        this.forceY = forceY;
    }

    public int getForceY() {
        return this.forceY;
    }

    public void setMovementSpeed(int newSpeed) {
        this.movementSpeed = newSpeed;
    }

    public int getMovementSpeed() {
        return this.movementSpeed;
    }
}

