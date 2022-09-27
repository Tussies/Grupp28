package com.grupp28gdx.game.Model;

/**
 * This obstacle is like the permanent obstacle, but its height is longer.
 * This obstacle will not disappear, much like the permanent obstacle, if the player shoots it with a gun.
 */
public class WallObstacle implements Obstacle{
    private String shape;
    private Position position;

    public WallObstacle() {
        shape = "rectangle";
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    @Override
    public Obstacle createObstacle() {
        return new WallObstacle();
    }
}
