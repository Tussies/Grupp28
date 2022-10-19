package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;

import java.util.ArrayList;

/**
 * This is the medium coin. When the player catches this coin it gains the default amount of points.
 * There are three types of coins in total in the game to catch.
 */
public class MediumGemstone implements Gemstone {

    public Body body;
    private float sideLength;
    private int points;
    private float height;
    private float width;
    private int id;
    private int value;

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    public MediumGemstone(float x, float y, int id) {
        value = 5;
        height = 0.45f;
        width = 0.45f;
        points = 30;
        sideLength = 5;
        this.body = new Body(x,y);
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

    @Override
    public int getId(){
        return id;
    }

    @Override
    public int getValue() {
        return value;
    }

    /**
     * Returns the side length of the gemstone instance
     * @return sideLength
     */
    public float getSideLength() {
        return this.sideLength;
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

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

}