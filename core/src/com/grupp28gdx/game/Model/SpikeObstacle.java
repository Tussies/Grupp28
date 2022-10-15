package com.grupp28gdx.game.Model;

import java.util.ArrayList;

public class SpikeObstacle implements Obstacle{

    private final String shape;

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    private final Body body;

    public SpikeObstacle(float spawnPosX, float spawnPosY){
        shape = "spike";
        body = new Body(spawnPosX,spawnPosY);
        createSpikeShape();
    }

    private void createSpikeShape() {

        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition()+2);
        vectorListX.add(body.getXPosition()+1);

        vectorListY.add(body.getXPosition()+1);
        vectorListY.add(body.getXPosition()+1);
        vectorListY.add(body.getXPosition()+2);
    }

    @Override
    public  ArrayList<Float> getVectorListX(){
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
        return new SpikeObstacle(spawnX,spawnY);
    }
}
