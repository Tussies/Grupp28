package com.grupp28gdx.game.Model;

/**
 * This is the smallest coin. When the player catches this coin it gains 3x the amount of points as when the player
 * catches the medium coin.
 */
public class SmallCoin implements Coin{
    private float x_position;
    private float y_position;
    private float radius;

    public SmallCoin() {
        radius = 0;
        x_position = 0;
        y_position = 0;
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
