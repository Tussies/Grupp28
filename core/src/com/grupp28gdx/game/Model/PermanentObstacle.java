package com.grupp28gdx.game.Model;

import java.util.ArrayList;

/**
 * This obstacle is permanent, which means that it will not disappear if the player shoots it with a gun.
 */
public class PermanentObstacle implements Obstacle {

    private final String shapeName;
    private ObstacleShape shape;

    private int id;

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    private final Body body;

    public PermanentObstacle(float spawnPosX, float spawnPosY,int id){
        shape = ObstacleShape.SQUARE;
        shapeName = "PermanentObstacle";
        body = new Body(spawnPosX,spawnPosY);
        createShape();
        this.id = id;
    }

    private void createShape() {
        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition()+1);
        vectorListX.add(body.getXPosition()+1);

        vectorListY.add(body.getYPosition());
        vectorListY.add(body.getYPosition()+3);
        vectorListY.add(body.getYPosition()+3);
        vectorListY.add(body.getYPosition());
    }

    @Override
    public int getId(){
        return this.id;
    }

    public ArrayList<Float> getVectorListX(){
        return vectorListX;
    }

    public ArrayList<Float> getVectorListY(){
        return vectorListY;
    }

    @Override
    public Body getPosition(){
        return body;
    }

    @Override
    public Obstacle createObstacle(float spawnX, float spawnY,int id) {
        return new PermanentObstacle(spawnX,spawnY,id);
    }

    public ObstacleShape getShape() {
        return shape;
    }
}
