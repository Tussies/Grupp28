package com.grupp28gdx.game.Model;


/**
 * This is the big coin. When the player catches this coin it gains x/3 the amount of points as when the player
 * catches the medium coin. There are three types of coins in total in the game to catch.
 */
public class BigCoin implements Coin{
    public Position position;
    private float radius;
    private int points;

    public BigCoin() {
        points = 10;
        radius = 10;
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    @Override
    public Coin createCoin() {
        Coin coin = new BigCoin();
        return coin;
    }

    public void setRadius(float x) {
        radius = x;
    }

    public float getRadius() {
        return this.radius;
    }

    public int getPoints() {return this.points;}
}
