package com.grupp28gdx.game.Model.GemstoneGroup;


import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.Player;
import com.grupp28gdx.game.Model.Position;

/**
 * This is the big coin. When the player catches this coin it gains x/3 the amount of points as when the player
 * catches the medium coin. There are three types of coins in total in the game to catch.
 */
public class BigGemstone implements Gemstone {
    public Body body;
    private float sideLength;
    private int points;

    public BigGemstone() {
        this.points = 10;
        this.sideLength = 10;
        this.body = new Body(0,0);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
    }

    @Override
    public Gemstone createGemstone() {
        Gemstone gemstone = new BigGemstone();
        return gemstone;
    }
    @Override
    public void updateGemCounter(){
        /*player.setGemCounter(player.getGemCounter() + this.points);*/

    }
    public int getPoints() {
        return points;
    }


    @Override
    public float getSideLength() {
        return this.sideLength;
    }
}
