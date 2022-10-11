package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.Player;

/**
 * This is the medium coin. When the player catches this coin it gains the default amount of points.
 * There are three types of coins in total in the game to catch.
 */
public class MediumGemstone implements Gemstone {

    public Body body;
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
    public Gemstone createGemstone() {
        Gemstone gemstone = new MediumGemstone();
        return gemstone;
    }



    public void updateGemCounter(){
        /*player.setGemCounter(player.getGemCounter() + this.points);*/

    }

    public int getPoints() {
        return points;
    }

    public float getSideLength() {
        return this.sideLength;
    }
}