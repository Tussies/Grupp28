package com.grupp28gdx.game.Model;

/**
 * This obstacle is destroyable and not permanent, which means that it will disappear if the player shoots it with a gun.
 */
public class DestroyableObstacle implements Obstacle {
    private ObstacleShape shape;
    private ObstacleColor color; //this color makes the destroyable obstacle distinguishable from the permanent obstacles
    private Body body;
    private float[] vectorListX;
    private float[] vectorListY;
    private boolean destroyObstacle;


    public DestroyableObstacle(float spawnPosX, float spawnPosY) {
        shape = ObstacleShape.SQUARE;
        color = ObstacleColor.BLUE;
        this.body = new Body(spawnPosX,spawnPosY);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
        createShape();
        if (destroyObstacle){
            destroyShape();
        };
    }

    private void createShape() {
        vectorListX = new float[]{
                body.getXPosition(),
                body.getXPosition(),
                body.getXPosition() + 1,
                body.getXPosition() + 1
        };
        vectorListY = new float[]{
                body.getXPosition(),
                body.getXPosition()+2,
                body.getXPosition()+2,
                body.getXPosition()
        };
    }

    private void destroyShape() {

    }


    @Override
    public Obstacle createObstacle(float spawnX, float spawnY) {
        return new DestroyableObstacle(spawnX,spawnY);
    }

    public Body getPosition(){
        return body;
    }


    public ObstacleShape getShape() {
        return shape;
    }

    public ObstacleColor getColor() {
        return color;
    }
}