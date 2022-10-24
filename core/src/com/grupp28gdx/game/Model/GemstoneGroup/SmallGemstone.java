package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;
import java.util.ArrayList;

/**
 * This is the smallest gemstone. When the player catches this gemstone it gains 3x the amount of points as when the player
 * catches the medium gemstone There are three types of gemstone in total in the game to catch.
 */
public class SmallGemstone implements Gemstone {

    public Body body;
    private int id;
    private int value;

    /**
     * Constructor for small gemstone.
     * @param x the X-position of gemstone body.
     * @param y the Y-position of gemstone body.
     * @param id the Id of the small gemstone.
     */
    public SmallGemstone(float x, float y,int id) {
        value = 10;
        this.body = new Body(x,y);
        body.setHeight(0.18f);
        body.setWidth(0.18f);
        this.id = id;
    }

    /**
     * A method which creates an instance of the class SmallGemstone
     * @return SmallGemstone, a small gemstone.
     */
    @Override
    public Gemstone createGemstone(float x, float y,int id) {
        Gemstone gemstone = new SmallGemstone(x,y,id);
        return gemstone;
    }


    /**
     * Getter for id of small gemstone.
     * @return id of small gemstone.
     */
    @Override
    public int getId(){return id;}

    /**
     * Getter for value of gemstone.
     * @return value of small gemstone.
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * Getter for obtaining a body and its position.
     * @return body which stores position.
     */
    @Override
    public Body getBody() {
        return body;
    }

}
