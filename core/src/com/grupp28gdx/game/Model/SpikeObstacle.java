package com.grupp28gdx.game.Model;

import java.util.ArrayList;

public class SpikeObstacle implements Obstacle{

    private final String shape;

    private int id;

    private float height;
    private float width;

    private final Body body;

    public SpikeObstacle(float spawnPosX, float spawnPosY,int id){
        shape = "spike";
        height = 1f;
        width = 2f;
        body = new Body(spawnPosX,spawnPosY);
        this.id = id;
    }

    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public Body getBody(){
        return body;
    }

    @Override
    public Obstacle createObstacle(float spawnX, float spawnY,int id) {
        return new SpikeObstacle(spawnX,spawnY,id);
    }

    /**
     * This getter is used to get the X offset for collisions with this object
     * @return width
     */

    public float getWidth() {
        return width;
    }

    /**
     * This getter is used to get the Y offset for collisions with this object
     * @return height
     */
    public float getHeight() {
        return height;
    }
}
