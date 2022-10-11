package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.Player;


/**
 * This is the smallest coin. When the player catches this coin it gains 3x the amount of points as when the player
 * catches the medium coin. There are three types of coins in total in the game to catch.
 */
public class SmallGemstone implements Gemstone {

    public Body body;
    private float sideLength;
    private int points;


    public SmallGemstone() {
        this.points = 60;
        this.sideLength = 2;
        this.body = new Body(0,0);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
    }

    @Override
    public Gemstone createGemstone() {
        Gemstone gemstone = new SmallGemstone();
        return gemstone;
    }



    @Override
    public void updateGemCounter(){
/*        player.setGemCounter(player.getGemCounter() + this.points);*/

    }


    public int getPoints() {
        return points;
    }

    public float getSideLength() {
        return this.sideLength;
    }
}
