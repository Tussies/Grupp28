package com.grupp28gdx.game.Model;

/**
 * This is the medium coin. When the player catches this coin it gains the default amount of points.
 * There are three types of coins in total in the game to catch.
 */
public class MediumCoin implements Coin{
    private Position position;
    private float radius;
    private int points;

    public MediumCoin() {
        points = 30;
        radius = 5;
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    @Override
    public Coin createCoin() {
        Coin coin = new MediumCoin();
        return coin;
    }

    public void setRadius(float x) {
        radius = x;
    }

    public float getRadius() {
        return this.radius;
    }
}