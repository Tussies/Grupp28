package com.grupp28gdx.game.Model;


/**
 * This is the big coin. When the player catches this coin it gains x/3 the amount of points as when the player
 * catches the medium coin.
 */
public class BigCoin implements Coin{
    private Position position;
    private float radius;

    public BigCoin() {
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
        Coin coin = new BigCoin();
        return coin;
    }
}
