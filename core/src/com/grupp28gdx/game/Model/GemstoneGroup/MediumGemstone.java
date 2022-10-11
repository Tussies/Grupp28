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
    private int totalPoints;

    public MediumGemstone() {
        points = 30;
        sideLength = 5;
        this.body = new Body(0,0);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
        this.totalPoints = 0;
    }

    /**
     * A method which creates an instance of the class SmallGemstone
     * @return SmallGemstone
     */
    @Override
    public Gemstone createGemstone() {
        Gemstone gemstone = new MediumGemstone();
        return gemstone;
    }


    /**
     * Method that updates the attribute GemCounter in the player class
     *
     */
    public void updateGemCounter(){
        this.totalPoints += this.points;

    }


    /**
     * Returns the side length of the gemstone instance
     * @return sideLength
     */
    public float getSideLength() {
        return this.sideLength;
    }


    /**
     * Returns the point value that an instance of BigGemstone is worth
     * @return points
     */

    public int getPoints() {
        return points;
    }


}