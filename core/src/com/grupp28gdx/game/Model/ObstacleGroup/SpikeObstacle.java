package com.grupp28gdx.game.Model.ObstacleGroup;

import com.grupp28gdx.game.Model.Body;

public class SpikeObstacle implements Obstacle{
    private int id;
    private final Body body;

    /**
     * This is the constructor for the spike obstacle.
     * @param spawnPosX spawning X position
     * @param spawnPosY spawning Y position
     * @param id id of th obstacle
     */
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

    /**
     * Getetr for the body.
     * @return body
     */
    @Override
    public Body getBody(){
        return body;
    }

    /**
     * Creates a new destroyable obstacle.
     * @param spawnX spawning X position
     * @param spawnY spawning Y position
     * @param id id of the obstacle.
     * @return new spike obstacle.
     */
    @Override
    public Obstacle createObstacle(float spawnX, float spawnY,int id) {
        return new SpikeObstacle(spawnX,spawnY,id);
    }
}
