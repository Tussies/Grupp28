package com.grupp28gdx.game.Model;

/**
 * This obstacle is not permanent, which means that it will disappear if the player shoots it with a gun.
 */
public class DestroyableObstacle implements Obstacle {
    private ObstacleShape shape;
    private ObstacleColor color; //this color makes the destroyable obstacle distinguishable from the permanent obstacles
    private Position position;

    public DestroyableObstacle() {
        shape = ObstacleShape.SQUARE;
        color = ObstacleColor.BLUE;
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    @Override
    public Obstacle createObstacle() {
        return new PermanentObstacle();
    }

    public ObstacleShape getShape() {
        return shape;
    }

    public ObstacleColor getColor() {
        return color;
    }
}