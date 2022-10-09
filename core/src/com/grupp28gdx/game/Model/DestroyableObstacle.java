package com.grupp28gdx.game.Model;

/**
 * This obstacle is not permanent, which means that it will disappear if the player shoots it with a gun.
 */
public class DestroyableObstacle implements Obstacle {
    private ObstacleShape shape;
    private ObstacleColor color; //this color makes the destroyable obstacle distinguishable from the permanent obstacles
    private Body body;

    public DestroyableObstacle() {
        shape = ObstacleShape.SQUARE;
        color = ObstacleColor.BLUE;
        this.body = new Body(0,0);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
    }

    @Override
    public Obstacle createObstacle(float spawnX, float spawnY) {
        return new PermanentObstacle(spawnX,spawnY);
    }

    public ObstacleShape getShape() {
        return shape;
    }

    public ObstacleColor getColor() {
        return color;
    }
}