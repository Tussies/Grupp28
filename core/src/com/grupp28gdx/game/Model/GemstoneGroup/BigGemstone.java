package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;
import java.util.ArrayList;

/**
 * This is the big gemstone. When the player catches this gemstone it gains x/3 the amount of points as when the player
 * catches the medium gemstone. There are three types of gems in total in the game to catch.
 */
public class BigGemstone implements Gemstone {

    private Body body;
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
     * Constructor for gemstone.
     * @param x the X-position of gemstone body.
     * @param y the Y-position of gemstone body.
     * @param id the Id of the big gemstone.
     */
    public BigGemstone(float x, float y,int id) {
        value = 1;
        this.body = new Body(x,y);
        body.setHeight(0.75f);
        body.setWidth(0.75f);
        this.id = id;
        createShape();
    }

    /**
     * A method which creates an instance of the class BigGemstone
     *
     * @return BigGemstone, a big gemstone.
     */
    @Override
    public Gemstone createGemstone(float x, float y,int id) {
        return new BigGemstone(x, y, id);
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
     * Getter for Id of big gemstone.
     * @return id of big gemstone.
     */
    @Override
    public int getId(){return id;}

    /**
     * Getter for value of gemstone.
     * @return value of big gemstone.
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
    public Body getPosition()
        {
            return body;
        }
}
