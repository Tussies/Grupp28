package com.grupp28gdx.game.Model;

/**
 * This obstacle is like the permanent obstacle, but its height is longer.
 * This obstacle will not disappear, much like the permanent obstacle, if the player shoots it with a gun.
 */
public class WallObstacle implements Obstacle{

/*    private final String shape;
    private ObstacleShape shape;*/

    private float[] vectorListX;
    private float[] vectorListY;

    private final Body body;

    public WallObstacle(float spawnPosX, float spawnPosY){
/*        shape = ObstacleShape.RECTANGLE;
        shape = "wall";*/
        body = new Body(spawnPosX,spawnPosY);
        createShape();
    }

    private void createShape() {
        vectorListX = new float[]{
                body.getXPosition(),
                body.getXPosition(),
                body.getXPosition()+1,
                body.getXPosition()+1
        };
        vectorListY = new float[]{
                body.getXPosition(),
                body.getXPosition()+1,
                body.getXPosition()+1,
                body.getXPosition()
        };
    }

    @Override
    public float[] getVectorListX(){
        return vectorListX;
    }

    @Override
    public float[] getVectorListY(){
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
