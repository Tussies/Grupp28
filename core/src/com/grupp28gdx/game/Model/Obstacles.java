package com.grupp28gdx.game.Model;

public class Obstacles implements Spawnable{
    private String typeOfObstacle;
    private int obstacleDifficulty;
    private float x_position;
    private float y_position;

    public Obstacles() {
        obstacleDifficulty = 1;
        x_position = 0;
        y_position = 0;
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
