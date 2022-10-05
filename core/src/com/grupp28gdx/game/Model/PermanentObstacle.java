package com.grupp28gdx.game.Model;

/**
 * This obstacle is permanent, which means that it will not disappear if the player shoots it with a gun.
 */
public class PermanentObstacle implements Obstacle {

    private final String shape;

    private float[] vectorListX;
    private float[] vectorListY;

    private final Position position;

    public PermanentObstacle(float spawnPosX, float spawnPosY){
        shape = "PermanentObstacle";
        position = new Position(spawnPosX,spawnPosY);
        createShape();
    }

    private void createShape() {
        vectorListX = new float[]{
                position.getXPosition(),
                position.getXPosition(),
                position.getXPosition()+1,
                position.getXPosition()+1
        };
        vectorListY = new float[]{
                position.getXPosition(),
                position.getXPosition()+2,
                position.getXPosition()+2,
                position.getXPosition()
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
        return new PermanentObstacle(spawnX,spawnY);
    }
}
