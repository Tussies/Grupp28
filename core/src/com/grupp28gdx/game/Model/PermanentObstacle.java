package com.grupp28gdx.game.Model;

import java.util.ArrayList;

/**
 * This obstacle is permanent, which means that it will not disappear if the player shoots it with a gun.
 */
public class PermanentObstacle implements Obstacle {

    private final String shapeName;
    private ObstacleShape shape;

    private float height;
    private float width;

    private int id;


    private final Body body;

    public PermanentObstacle(float spawnPosX, float spawnPosY,int id){
        shape = ObstacleShape.SQUARE;
        shapeName = "PermanentObstacle";
        height = 1.9f;
        width = 1f;
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
        return new PermanentObstacle(spawnX,spawnY,id);
    }

    public ObstacleShape getShape() {
        return shape;
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
