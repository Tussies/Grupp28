package com.grupp28gdx.game.Model;

public class Position {

    private float x_position;
    private float y_position;

    public Position(float x, float y) {
        this.x_position = x;
        this.y_position = y;
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
