package com.grupp28gdx.game.Model;

/**
 * This is the medium coin. When the player catches this coin it gains the default amount of points.
 * There are three types of coins in total in the game to catch.
 */
public class MediumGemstone implements Gemstone {
    private Body body;
    private float sideLength;
    private int points;

    public MediumGemstone() {
        points = 30;
        sideLength = 5;
        this.body = new Body(0,0);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
    }

    @Override
    public Gemstone createCoin() {
        Gemstone gemstone = new MediumGemstone();
        return gemstone;
    }



    public void updateGemCounter(Player player){
        /*player.setGemCounter(player.getGemCounter() + this.points);*/

    }

    public void setSideLength(float x) {
        sideLength = x;
    }

    public float getSideLength() {
        return this.sideLength;
    }
}