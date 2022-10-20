package com.grupp28gdx.game.Model.ObstacleGroup;

import com.grupp28gdx.game.Model.Body;

/**
 * This obstacle is destroyable and not permanent, which means that it will disappear if the player shoots it with a gun.
 */
public class DestroyableObstacle implements Obstacle {
    private ObstacleShape shape;
    private ObstacleColor color;
    private Body body;
    private int id;

    /**
     * This is the constructor for the destroyable objects, the color makes the destroyable obstacle distinguishable from the permanent obstacles.
     * @param spawnPosX
     * @param spawnPosY
     */
    public DestroyableObstacle(float spawnPosX, float spawnPosY,int id) {
        shape = ObstacleShape.SQUARE;
        color = ObstacleColor.BLUE;
        this.body = new Body(spawnPosX,spawnPosY);
        body.setHeight(1.9f);
        body.setWidth(1);

        this.id = id;

    }

    /**
     * This method will destroy the shape when the object has been destroyed by shooting at it.
     */


    @Override
    public Obstacle createObstacle(float spawnX, float spawnY,int id) {
        return new DestroyableObstacle(spawnX,spawnY,id);
    }

    /**
     * Returns the position of body.
     * @return body
     */
    public Body getBody(){ return body; }

    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Returns the shape of the destroyable obstacle.
     * @return shape
     */
    public ObstacleShape getShape() { return shape; }

    /**
     * Returns the shape of the destroyable obstacle.
     * @return color
     */
    public ObstacleColor getColor() { return color; }
}