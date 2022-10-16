package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;
import java.util.ArrayList;

/**
 * This is the smallest gemstone. When the player catches this gemstone it gains 3x the amount of points as when the player
 * catches the medium gemstone There are three types of gemstone in total in the game to catch.
 */
public class SmallGemstone implements Gemstone {

    public Body body;
    private float sideLength;
    private int points;
    private int totalPoints;


    public SmallGemstone() {
        this.points = 60;
        this.sideLength = 2;
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
        Gemstone gemstone = new SmallGemstone();
        return gemstone;
    }


    /**
     * Method that updates the attribute GemCounter in the player class
     */
    @Override
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
     * Returns the point value that an instance of SmallGemstone is worth
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns the body of big gemstone.
     * @return body
     */
    @Override
    public Body getBody(){
        return body;
    }

    @Override
    public ArrayList<Float> getVectorListX() {
        return null;
    }

    @Override
    public ArrayList<Float> getVectorListY() {
        return null;
    }

    @Override
    public Body getPosition() {
        return body;
    }
}
