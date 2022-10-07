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

    private final Position position;

    public WallObstacle(float spawnPosX, float spawnPosY){
/*        shape = ObstacleShape.RECTANGLE;
        shape = "wall";*/
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
                position.getXPosition()+1,
                position.getXPosition()+1,
                position.getXPosition()
        };
    }

    public float[] getVectorListX(){
        return vectorListX;
    }

    public float[] getVectorListY(){
        return vectorListY;
    }

    public Position getPosition(){
        return position;
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
