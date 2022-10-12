package com.grupp28gdx.game.Model;

/**
 * This obstacle is permanent, which means that it will not disappear if the player shoots it with a gun.
 */
public class PermanentObstacle implements Obstacle {

    private final String shapeName;
    private ObstacleShape shape;
    private ObstacleColor color;

    private float[] vectorListX;
    private float[] vectorListY;

    private final Body body;

    public PermanentObstacle(float spawnPosX, float spawnPosY){
        shape = ObstacleShape.SQUARE;
        this.color = ObstacleColor.RED;
        shapeName = "PermanentObstacle";
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
                body.getXPosition()+2,
                body.getXPosition()+2,
                body.getXPosition()
        };

    }

    public float[] getVectorListX(){
        return vectorListX;
    }

    public float[] getVectorListY(){
        return vectorListY;
    }

    public String getShapeName(){
        return shapeName;
    }

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

    @Override
    public ObstacleColor getColor() {
        return this.color;
    }
}
