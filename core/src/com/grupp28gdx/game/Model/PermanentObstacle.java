package com.grupp28gdx.game.Model;

/**
 * This obstacle is permanent, which means that it will not disappear if the player shoots it with a gun.
 */
public class PermanentObstacle implements Obstacle {
    private String shape;
    private Position position;

    public PermanentObstacle() {
        shape = "square";
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    @Override
    public Obstacle createObstacle() {
        return new PermanentObstacle();
    }
}
