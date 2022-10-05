package com.grupp28gdx.game.Model;

/**
 * This is the smallest coin. When the player catches this coin it gains 3x the amount of points as when the player
 * catches the medium coin. There are three types of coins in total in the game to catch.
 */
public class SmallGemstone implements Gemstone {
    private Position position;
    private float sideLength;
    private int points;


    public SmallGemstone() {
        this.points = 60;
        this.sideLength = 2;
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    @Override
    public Gemstone createCoin() {
        Gemstone gemstone = new MediumGemstone();
        return gemstone;
    }



    @Override
    public void updateGemCounter(Player player){
        player.setGemCounter(player.getGemCounter() + this.points);

    }

    public void setSideLength(float x) {
        sideLength = x;
    }

    public float getSideLength() {
        return this.sideLength;
    }
}
