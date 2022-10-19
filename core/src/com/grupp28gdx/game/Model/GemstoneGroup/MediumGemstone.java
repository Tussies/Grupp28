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
    private int id;

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    public MediumGemstone(float x, float y, int id) {
        points = 30;
        sideLength = 5;
        this.body = new Body(x,y);
        this.totalPoints = 0;
        this.id = id;
        createShape();
    }

    /**
     * A method which creates an instance of the class SmallGemstone
     * @return SmallGemstone
     */
    @Override
    public Gemstone createGemstone(float x, float y,int id) {
        return new MediumGemstone(x,y,id);
    }


    private void createShape(){

        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition());
        vectorListX.add((float) (body.getXPosition()+0.15));
        vectorListX.add((float) (body.getXPosition()+0.3));
        vectorListX.add((float) (body.getXPosition()+0.45));
        vectorListX.add((float) (body.getXPosition()+0.45));
        vectorListX.add((float) (body.getXPosition()+0.3));
        vectorListX.add((float) (body.getXPosition()+0.15));

        vectorListY.add((float) (body.getYPosition()+0.15));
        vectorListY.add((float) (body.getYPosition()+0.3));
        vectorListY.add((float) (body.getYPosition()+0.45));
        vectorListY.add((float) (body.getYPosition()+0.45));
        vectorListY.add((float) (body.getYPosition()+0.3));
        vectorListY.add((float) (body.getYPosition()+0.15));
        vectorListY.add(body.getYPosition());
        vectorListY.add(body.getYPosition());
    }

    /**
     * Method that updates the attribute GemCounter in the player class
     */
    public void updateGemCounter(){
        this.totalPoints += this.points;
    }


    @Override
    public int getId(){
        return id;
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