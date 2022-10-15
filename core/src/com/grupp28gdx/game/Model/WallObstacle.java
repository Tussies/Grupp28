package com.grupp28gdx.game.Model;

import java.util.ArrayList;

/**
 * This obstacle is like the permanent obstacle, but its height is longer.
 * This obstacle will not disappear, much like the permanent obstacle, if the player shoots it with a gun.
 */
public class WallObstacle implements Obstacle{

/*    private final String shape;
    private ObstacleShape shape;*/

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    private final Body body;

    public WallObstacle(float spawnPosX, float spawnPosY){
/*        shape = ObstacleShape.RECTANGLE;
        shape = "wall";*/
        body = new Body(spawnPosX,spawnPosY);
        createShape();
    }

    private void createShape() {
        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition()+1);
        vectorListX.add(body.getXPosition()+1);

        vectorListY.add(body.getXPosition());
        vectorListY.add(body.getXPosition()+1);
        vectorListY.add(body.getXPosition()+1);
        vectorListY.add(body.getXPosition());
    }

    @Override
    public ArrayList<Float> getVectorListX(){
        return vectorListX;
    }

    @Override
    public ArrayList<Float> getVectorListY(){
        return vectorListY;
    }

    @Override
    public Body getPosition(){
        return body;
    }

    @Override
    public Obstacle createObstacle(float spawnX, float spawnY) {
        return new WallObstacle(spawnX,spawnY);
    }

/*    public ObstacleShape getShape() {
        return shape;
    }
    public String getShape(){
        return shape;
    }*/
}
