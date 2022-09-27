package com.grupp28gdx.game.Model;

/**
 * This obstacle is not permanent, which means that it will disappear if the player shoots it with a gun.
 */
public class DestroyableObstacle implements Obstacle {
    private String shape;
    private Position position;

    public DestroyableObstacle() {
        shape = "circle";
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    @Override
    public Obstacle createObstacle() {
        return new PermanentObstacle();
    }
}