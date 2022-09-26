package com.grupp28gdx.game.Model;

public class Coins implements Spawnable {
    private float x_position;
    private float y_position;
    private float radius;

    public Coins() {
        radius = 0;
        x_position = 0;
        y_position = 0;
    }

    public void setRadius(float x) {
        radius = x;
    }

    public float getRadius() {
        return this.radius;
    }

    @Override
    public void setXPosition(float x) {
        x_position = x;
    }

    @Override
    public void setYPosition(float y) {
        y_position = y;
    }

    @Override
    public float getXPosition() {
        return this.x_position;
    }

    @Override
    public float getYPosition() {
        return this.y_position;
    }
}
