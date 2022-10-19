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

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    public SmallGemstone(float x, float y) {
        this.points = 60;
        this.sideLength = 2;
        this.body = new Body(x,y);
        this.totalPoints = 0;
        createShape();
    }

    /**
     * A method which creates an instance of the class SmallGemstone
     *
     * @return SmallGemstone
     */
    @Override
    public Gemstone createGemstone(float x, float y) {
        Gemstone gemstone = new SmallGemstone(x,y);
        return gemstone;
    }

    private void createShape(){

        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition());
        vectorListX.add((float) (body.getXPosition()+0.06));
        vectorListX.add((float) (body.getXPosition()+0.12));
        vectorListX.add((float) (body.getXPosition()+0.18));
        vectorListX.add((float) (body.getXPosition()+0.18));
        vectorListX.add((float) (body.getXPosition()+0.12));
        vectorListX.add((float) (body.getXPosition()+0.06));

        vectorListY.add((float) (body.getYPosition()+0.06));
        vectorListY.add((float) (body.getYPosition()+0.12));
        vectorListY.add((float) (body.getYPosition()+0.18));
        vectorListY.add((float) (body.getYPosition()+0.18));
        vectorListY.add((float) (body.getYPosition()+0.12));
        vectorListY.add((float) (body.getYPosition()+0.06));
        vectorListY.add(body.getYPosition());
        vectorListY.add(body.getYPosition());
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
     * Returns an ArrayList of x-points for creating vectors.
     * @return vectorListX.
     */
    @Override
    public ArrayList<Float> getVectorListX() {
        return vectorListX;
    }

    /**
     * Returns an ArrayList of y-points for creating vectors.
     * @return vectorListY.
     */
    @Override
    public ArrayList<Float> getVectorListY() {
        return vectorListY;
    }

    /**
     * Getter for obtaining a body and its position.
     * @return body.
     */
    @Override
    public Body getPosition() {
        return body;
    }
}
