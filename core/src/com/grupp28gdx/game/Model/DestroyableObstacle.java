package com.grupp28gdx.game.Model;

/**
 * This obstacle is destroyable and not permanent, which means that it will disappear if the player shoots it with a gun.
 */
public class DestroyableObstacle implements Obstacle {
    private ObstacleShape shape;
    private ObstacleColor color;
    private Body body;
    private float[] vectorListX;
    private float[] vectorListY;
    private boolean destroyObstacle;

    /**
     * This is the constructor for the destroyable objects, the color makes the destroyable obstacle distinguishable from the permanent obstacles.
     * @param spawnPosX
     * @param spawnPosY
     */
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

    /**
     * This method will create the shape for the destroyable object, which is a square;
     */
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

    /**
     * Thid method will destroy the shape when the object has been destroyed by shooting at it.
     */
    private void destroyShape() {
        vectorListX[0] = 0;
        vectorListX[1] = 0;
        vectorListX[2] = 0;
        vectorListX[3] = 0;

        vectorListY[0] = 0;
        vectorListY[1] = 0;
        vectorListY[2] = 0;
        vectorListY[3] = 0;
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