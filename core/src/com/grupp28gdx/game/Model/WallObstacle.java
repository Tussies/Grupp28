package com.grupp28gdx.game.Model;

/**
 * This obstacle is like the permanent obstacle, but its height is longer.
 * This obstacle will not disappear, much like the permanent obstacle, if the player shoots it with a gun.
 */
public class WallObstacle implements Obstacle{

//   private final String shape;
    private ObstacleShape shape;
    private ObstacleColor color;

    private float[] vectorListX;
    private float[] vectorListY;

    private final Body body;

    public WallObstacle(float spawnPosX, float spawnPosY){
        shape = ObstacleShape.RECTANGLE;
        this.color = ObstacleColor.PURPLE;
     //   shape = "wall";
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

    public float[] getVectorListX(){
        return vectorListX;
    }

    public float[] getVectorListY(){
        return vectorListY;
    }

    public Body getPosition(){
        return body;
    }

    @Override
    public Obstacle createObstacle(float spawnX, float spawnY) {
        return new WallObstacle(spawnX,spawnY);
    }

    @Override
    public ObstacleShape getShape() {
        return null;
    }

    @Override
    public ObstacleColor getColor() {
        return null;
    }

/*    public ObstacleShape getShape() {
        return shape;
    }
    public String getShape(){
        return shape;
    }*/
}
