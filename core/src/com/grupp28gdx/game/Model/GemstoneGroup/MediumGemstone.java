package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;

import java.util.ArrayList;

/**
 * This is the medium gemstone. When the player catches this gemstone it gains the default amount of points.
 * There are three types of gemstones in total in the game to catch.
 */
public class MediumGemstone implements Gemstone {

    private Body body;
    private int id;
    private int value;

    /**
     * Constructor for medium gemstone.
     * @param x the X-position of gemstone body.
     * @param y the Y-position of gemstone body.
     * @param id the Id of the medium gemstone.
     */
    public MediumGemstone(float x, float y, int id) {
        value = 5;
        this.body = new Body(x,y);
        body.setHeight(0.45f);
        body.setWidth(0.45f);
        this.id = id;
    }

    /**
     * A method which creates an instance of the class MediumGemstone
     * @return MediumGemstone, a medium gemstone.
     */
    @Override
    public Gemstone createGemstone(float x, float y,int id) {
        return new MediumGemstone(x,y,id);
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

    /**
     * Getter for obtaining a body and its position.
     * @return body which stores position.
     */
    @Override
    public Body getBody() {
        return body;
    }
}