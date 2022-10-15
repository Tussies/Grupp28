package com.grupp28gdx.game.Model.GemstoneGroup;


import com.grupp28gdx.game.Model.Body;

/**
 * This is the big coin. When the player catches this coin it gains x/3 the amount of points as when the player
 * catches the medium coin. There are three types of coins in total in the game to catch.
 */
public class BigGemstone implements Gemstone {
    public Body body;
    private float sideLength;
    private int points;
    private int totalPoints;

    public BigGemstone() {
        this.points = 10;
        this.sideLength = 10;
        this.body = new Body(0, 0);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
        this.totalPoints = 0;
    }

    /**
     * A method which creates an instance of the class SmallGemstone
     *
     * @return SmallGemstone
     */
    @Override
    public Gemstone createGemstone() {
        Gemstone gemstone = new BigGemstone();
        return gemstone;
    }

    /**
     * Method that updates the attribute GemCounter in the player class
     */
    @Override
    public void updateGemCounter() {
        this.totalPoints += this.points;
    }

    /**
     * Returns the side length of the gemstone instance
     *
     * @return sideLength
     */

    @Override
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


    @Override
    public Body getBody(){
        return body;
    }
}
