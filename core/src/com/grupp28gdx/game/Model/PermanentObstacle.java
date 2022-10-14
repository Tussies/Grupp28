package com.grupp28gdx.game.Model;

import java.util.ArrayList;

/**
 * This obstacle is permanent, which means that it will not disappear if the player shoots it with a gun.
 */
public class PermanentObstacle implements Obstacle {

    private final String shapeName;
    private ObstacleShape shape;

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    private final Body body;

    public PermanentObstacle(float spawnPosX, float spawnPosY){
        shape = ObstacleShape.SQUARE;
        shapeName = "PermanentObstacle";
        body = new Body(spawnPosX,spawnPosY);
        createShape();
    }

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
    public Obstacle createObstacle(float spawnX, float spawnY) {
        return new PermanentObstacle(spawnX,spawnY);
    }

    public ObstacleShape getShape() {
        return shape;
    }
}
