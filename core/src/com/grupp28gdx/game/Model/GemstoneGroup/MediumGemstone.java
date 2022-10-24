package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;

import java.util.ArrayList;

/**
 * This is the medium gemstone. When the player catches this gemstone it gains the default amount of points.
 * There are three types of gemstones in total in the game to catch.
 */
public class MediumGemstone implements Gemstone {

    private Body body;
    private float sideLength;
    private int points;
    private int id;
    private int value;

    /**
     * An ArrayList of X positions for creating vectors.
     */
    ArrayList<Float> vectorListX = new ArrayList<Float>();
    /**
     * An ArrayList of Y positions for creating vectors.
     */
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    /**
     * Constructor for medium gemstone.
     * @param x the X-position of gemstone body.
     * @param y the Y-position of gemstone body.
     * @param id the Id of the medium gemstone.
     */
    public MediumGemstone(float x, float y, int id) {
        value = 5;
        points = 30;
        sideLength = 5;
        this.body = new Body(x,y);
        body.setHeight(0.45f);
        body.setWidth(0.45f);
        this.id = id;
        createShape();
    }

    /**
     * A method which creates an instance of the class MediumGemstone
     * @return MediumGemstone, a medium gemstone.
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
     * Getter for id of medium gemstone.
     * @return id of medium gemstone.
     */
    @Override
    public int getId(){
        return id;
    }

    /**
     * Getter for value of gemstone.
     * @return value of medium gemstone.
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * Gets the ArrayList of X Positions for creating vectors.
     * @return vectorListX, an ArrayList of X positions.
     */
    @Override
    public ArrayList<Float> getVectorListX() {
        return vectorListX;
    }

    /**
     * Returns an ArrayList of Y Positions for creating vectors.
     * @return vectorListY, an ArrayList of X positions.
     */
    @Override
    public ArrayList<Float> getVectorListY() {
        return vectorListY;
    }

    /**
     * Getter for obtaining a body and its position.
     * @return body which stores position.
     */
    @Override
    public Body getPosition() {
        return body;
    }
}