package com.grupp28gdx.game.Model.ObstacleGroup;

import com.grupp28gdx.game.Model.Body;

/**
 * This obstacle is permanent, which means that it will not disappear if the player shoots it with a gun.
 */
public class PermanentObstacle implements Obstacle {
    private int id;

    private final Body body;

    /**
     * This is the constructor for the permanent obstacles.
     * @param spawnPosX spawning X position
     * @param spawnPosY spawning Y position
     * @param id id of th obstacle
     */
    public PermanentObstacle(float spawnPosX, float spawnPosY,int id){
        body = new Body(spawnPosX,spawnPosY);
        body.setHeight(1.9f);
        body.setWidth(1);
        this.id = id;
    }

    @Override
    public int getId(){
        return this.id;
    }

    /**
     * Getter for the body.
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
     * @return new permanent obstacle.
     */
    @Override
    public Obstacle createObstacle(float spawnX, float spawnY,int id) {
        return new PermanentObstacle(spawnX,spawnY,id);
    }

}
