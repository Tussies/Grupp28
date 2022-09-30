package com.grupp28gdx.game.Model;

/**
 * This is the smallest coin. When the player catches this coin it gains 3x the amount of points as when the player
 * catches the medium coin. There are three types of coins in total in the game to catch.
 */
public class SmallCoin implements Coin{
    private Position position;
    private float radius;
    private int points;

    public SmallCoin() {
        points = 60;
        radius = 2;
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    @Override
    public Coin createCoin() {
        Coin coin = new SmallCoin();
        return coin;
    }

    public void setRadius(float x) {
        radius = x;
    }

    public float getRadius() {
        return this.radius;
    }
}
