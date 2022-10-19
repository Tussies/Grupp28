package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;
import java.util.ArrayList;

/**
 * This is the big coin. When the player catches this coin it gains x/3 the amount of points as when the player
 * catches the medium coin. There are three types of coins in total in the game to catch.
 */
public class BigGemstone implements Gemstone {

    public Body body;
    private float sideLength;
    private int points;
    private int totalPoints;
    private int id;
    private int value;

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    public BigGemstone(float x, float y,int id) {
        value = 1;
        this.points = 10;
        this.sideLength = 10;
        this.body = new Body(x,y);
        this.totalPoints = 0;
        this.id = id;
        createShape();
    }

    /**
     * A method which creates an instance of the class SmallGemstone
     *
     * @return SmallGemstone
     */
    @Override
    public Gemstone createGemstone(float x, float y,int id) {
        Gemstone gemstone = new BigGemstone(x, y, id);
        return gemstone;
    }

    private void createShape(){

        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition());
        vectorListX.add((float) (body.getXPosition()+0.25));
        vectorListX.add((float) (body.getXPosition()+0.5));
        vectorListX.add((float) (body.getXPosition()+0.75));
        vectorListX.add((float) (body.getXPosition()+0.75));
        vectorListX.add((float) (body.getXPosition()+0.5));
        vectorListX.add((float) (body.getXPosition()+0.25));

        vectorListY.add((float) (body.getYPosition()+0.25));
        vectorListY.add((float) (body.getYPosition()+0.5));
        vectorListY.add((float) (body.getYPosition()+0.75));
        vectorListY.add((float) (body.getYPosition()+0.75));
        vectorListY.add((float) (body.getYPosition()+0.5));
        vectorListY.add((float) (body.getYPosition()+0.25));
        vectorListY.add(body.getYPosition());
        vectorListY.add(body.getYPosition());

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
    public int getId(){return id;}

    @Override
    public int getValue() {
        return value;
    }

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
    public ArrayList<Float> getVectorListX() {
        return vectorListX;
    }

    @Override
    public ArrayList<Float> getVectorListY() {
        return vectorListY;
    }

    @Override
    public Body getPosition()
        {
            return body;
        }
}
