package com.grupp28gdx.game.Model;

import java.util.ArrayList;

/**
 * This obstacle is destroyable and not permanent, which means that it will disappear if the player shoots it with a gun.
 */
public class DestroyableObstacle implements Obstacle {
    private ObstacleShape shape;
    private ObstacleColor color;
    private float height;
    private float width;
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
        height = 1.9f;
        width = 1f;
        this.body = new Body(spawnPosX,spawnPosY);

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