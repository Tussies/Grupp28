package com.grupp28gdx.game.Model;

import java.util.ArrayList;

/**
 * This obstacle is destroyable and not permanent, which means that it will disappear if the player shoots it with a gun.
 */
public class DestroyableObstacle implements Obstacle {
    private ObstacleShape shape;
    private ObstacleColor color;
    private Body body;
    private boolean destroyObstacle;
    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    /**
     * This is the constructor for the destroyable objects, the color makes the destroyable obstacle distinguishable from the permanent obstacles.
     * @param spawnPosX
     * @param spawnPosY
     */
    public DestroyableObstacle(float spawnPosX, float spawnPosY) {
        shape = ObstacleShape.SQUARE;
        color = ObstacleColor.BLUE;
        this.body = new Body(spawnPosX,spawnPosY);
        this.body.setXPosition(0);
        this.body.setYPosition(0);

        createShape();
        if (destroyObstacle){
            destroyShape();
        };
    }

    /**
     * This method will create the shape for the destroyable object, which is a square;
     */
    private void createShape() {
        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition()+1);
        vectorListX.add(body.getXPosition()+1);

        vectorListY.add(body.getXPosition());
        vectorListY.add(body.getXPosition()+2);
        vectorListY.add(body.getXPosition()+2);
        vectorListY.add(body.getXPosition());
    }

    /**
     * This method will destroy the shape when the object has been destroyed by shooting at it.
     */
    private void destroyShape() {
        vectorListX.clear();
        vectorListY.clear();
    }


    @Override
    public Obstacle createObstacle(float spawnX, float spawnY) {
        return new DestroyableObstacle(spawnX,spawnY);
    }

    public ArrayList<Float> getVectorListX(){
        return vectorListX;
    }

    public ArrayList<Float> getVectorListY(){
        return vectorListY;
    }

    public Body getPosition(){ return body; }


    public ObstacleShape getShape() { return shape; }

    public ObstacleColor getColor() { return color; }
}