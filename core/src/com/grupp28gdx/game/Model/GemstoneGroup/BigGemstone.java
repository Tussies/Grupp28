package com.grupp28gdx.game.Model.GemstoneGroup;


import com.grupp28gdx.game.Model.Player;
import com.grupp28gdx.game.Model.Position;

/**
 * This is the big coin. When the player catches this coin it gains x/3 the amount of points as when the player
 * catches the medium coin. There are three types of coins in total in the game to catch.
 */
public class BigGemstone implements Gemstone {
    private Position position;
    private float sideLength;
    private int points;

    public BigGemstone() {
        this.points = 10;
        this.sideLength = 10;
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
    }

    @Override
    public Gemstone createGemstone() {
        Gemstone gemstone = new BigGemstone();
        return gemstone;
    }
    @Override
    public void updateGemCounter(Player player){
        player.setGemCounter(player.getGemCounter() + this.points);

    }

    public void setSideLength(float x) {
        sideLength = x;
    }

    @Override
    public float getSideLength() {
        return this.sideLength;
    }
}
