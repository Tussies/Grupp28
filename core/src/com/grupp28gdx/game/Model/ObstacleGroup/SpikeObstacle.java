package com.grupp28gdx.game.Model.ObstacleGroup;

import com.grupp28gdx.game.Model.Body;

public class SpikeObstacle implements Obstacle{
    private int id;
    private final Body body;

    public SpikeObstacle(float spawnPosX, float spawnPosY,int id){
        body = new Body(spawnPosX,spawnPosY);
        body.setHeight(1f);
        body.setWidth(2f);
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
}
