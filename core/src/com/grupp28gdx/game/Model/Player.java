package com.grupp28gdx.game.Model;

public class Player implements Spawnable {
    private int movementSpeed;
    private int forceX;
    private int forceY;
    private float x_position;
    private float y_position;
    private int numberOfJumps;
    private String stateOfPlayer;

    public Player() {
        movementSpeed = 700;
        forceX = 0;
        forceY = 0;
        x_position = 0;
        y_position = 0;
        numberOfJumps = 0;
        stateOfPlayer = "walking";
    }

    public void setXPosition(float x) {
        x_position = x;
    }
    public void setYPosition(float y) {
        y_position = y;
    }
    public float getXPosition() {
        return this.x_position;
    }
    public float getYPosition() {
        return this.y_position;
    }
}
