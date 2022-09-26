package com.grupp28gdx.game.Model;

/**
 * This is the medium coin. When the player catches this coin it gains the default amount of points.
 */
public class MediumCoin implements Coin{
    private Position position;
    private float radius;

    public MediumCoin() {
        radius = 0;
        position = new Position(0,0);
        position.setXPosition(0);
        position.setYPosition(0);
    }

    public void setRadius(float x) {
        radius = x;
    }

    public float getRadius() {
        return this.radius;
    }

    @Override
    public Coin createCoin() {
        Coin coin = new MediumCoin();
        return coin;
    }
}