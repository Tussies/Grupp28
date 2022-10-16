package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.PermanentObstacle;

import java.util.ArrayList;

/**
 * This is the medium coin. When the player catches this coin it gains the default amount of points.
 * There are three types of coins in total in the game to catch.
 */
public class MediumGemstone implements Gemstone {

    public Body body;
    private float sideLength;
    private int points;
    private int totalPoints;

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    public MediumGemstone(float x, float y) {
        points = 30;
        sideLength = 5;
        this.body = new Body(0,0);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
        this.totalPoints = 0;
        createShape();
    }

    /**
     * A method which creates an instance of the class SmallGemstone
     * @return SmallGemstone
     */
    @Override
    public Gemstone createGemstone(float x, float y) {
        return new MediumGemstone(x,y);
    }


    private void createShape(){
        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition());
        vectorListX.add((float) (body.getXPosition()+0.25));
        vectorListX.add((float) (body.getXPosition()+0.25));
        vectorListX.add((float) (body.getXPosition()+0.5));
        vectorListX.add((float) (body.getXPosition()+0.5));
        vectorListX.add((float) (body.getXPosition()+0.75));
        vectorListX.add((float) (body.getXPosition()+0.75));

        vectorListY.add(body.getYPosition());
        vectorListY.add(body.getYPosition());
        vectorListY.add((float) (body.getYPosition()+0.25));
        vectorListY.add((float) (body.getYPosition()+0.25));
        vectorListY.add((float) (body.getYPosition()+0.5));
        vectorListY.add((float) (body.getYPosition()+0.5));
        vectorListY.add((float) (body.getYPosition()+0.75));
        vectorListY.add((float) (body.getYPosition()+0.75));
    }

    /**
     * Method that updates the attribute GemCounter in the player class
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

    /**
     * Returns the body of medium gemstone.
     * @return body
     */
    @Override
    public Body getBody(){
        return body;
    }

    @Override
    public ArrayList<Float> getVectorListX() {
        return vectorListX;
    }

    @Override
    public ArrayList<Float> getVectorListY() {
        return vectorListY;
    }

    @Override
    public Body getPosition() {
        return body;
    }

}