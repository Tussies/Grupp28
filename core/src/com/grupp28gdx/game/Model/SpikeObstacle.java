package com.grupp28gdx.game.Model;

public class SpikeObstacle implements Obstacle{

    private final String shape;

    private float[] vectorListX;
    private float[] vectorListY;

    private final Position position;

    public SpikeObstacle(float spawnPosX, float spawnPosY){
        shape = "spike";
        position = new Position(spawnPosX,spawnPosY);
        createSpikeShape();
    }

    private void createSpikeShape() {
        vectorListX = new float[]{
                position.getXPosition(),
                position.getXPosition()+2,
                position.getXPosition()+1
        };
        vectorListY = new float[]{
                position.getXPosition()+1,
                position.getXPosition()+1,
                position.getXPosition()+2,
        };
    }

    public float[] getVectorListX(){
        return vectorListX;
    }

    public float[] getVectorListY(){
        return vectorListY;
    }

    public String getShape(){
        return shape;
    }

    public Position getPosition(){
        return position;
    }

    @Override
    public Obstacle createObstacle(float spawnX, float spawnY) {
        return new SpikeObstacle(spawnX,spawnY);
    }
}
