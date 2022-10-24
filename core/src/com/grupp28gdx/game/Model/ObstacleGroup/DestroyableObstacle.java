
package com.grupp28gdx.game.Model.ObstacleGroup;

import com.grupp28gdx.game.Model.Body;

/**
 * This obstacle is destroyable and not permanent, which means that it will disappear if the player shoots it with a gun.
 */
public class DestroyableObstacle implements Obstacle {
    private Body body;
    private int id;

    /**
     * This is the constructor for the destroyable objects.
     * @param spawnPosX spawning X position
     * @param spawnPosY spawning Y position
     * @param id id of th obstacle
     */
    public DestroyableObstacle(float spawnPosX, float spawnPosY,int id) {
        this.body = new Body(spawnPosX,spawnPosY);
        body.setHeight(1.9f);
        body.setWidth(1);

        this.id = id;

    }

    /**
     * Creates a new destroyable obstacle.
     * @param spawnX spawning X position
     * @param spawnY spawning Y position
     * @param id id of the obstacle.
     * @return new destroyable obstacle.
     */
    @Override
    public Obstacle createObstacle(float spawnX, float spawnY,int id) {
        return new DestroyableObstacle(spawnX,spawnY,id);
    }

    /**
     * Getetr for the body.
     * @return body
     */
    public Body getBody(){ return body; }

    @Override
    public int getId() {
        return this.id;
    }
}