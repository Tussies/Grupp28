package com.grupp28gdx.game.Model;

public class SpikeObstacle implements Obstacle{

    private final ObstacleShape shape;
    private ObstacleColor color;

    private float[] vectorListX;
    private float[] vectorListY;

    private final Body body;

    public SpikeObstacle(float spawnPosX, float spawnPosY){
        shape = ObstacleShape.TRIANGLE;
        this.color = ObstacleColor.GREEN;
        body = new Body(spawnPosX,spawnPosY);
        createSpikeShape();
    }

    private void createSpikeShape() {
        vectorListX = new float[]{
                body.getXPosition(),
                body.getXPosition()+2,
                body.getXPosition()+1
        };
        vectorListY = new float[]{
                body.getXPosition()+1,
                body.getXPosition()+1,
                body.getXPosition()+2,
        };
    }

    public float[] getVectorListX(){
        return vectorListX;
    }

    public float[] getVectorListY(){
        return vectorListY;
    }

    @Override
    public ObstacleShape getShape(){
        return shape;
    }

    @Override
    public ObstacleColor getColor() {
        return this.color;
    }

    public Body getPosition(){
        return body;
    }

    @Override
    public Obstacle createObstacle(float spawnX, float spawnY) {
        return new SpikeObstacle(spawnX,spawnY);
    }
}
