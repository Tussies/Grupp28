package com.grupp28gdx.game.Controller.handlers;

import java.util.Random;

public abstract class SpawnHandler {
    /**
     * Random for creating random numbers.
     */
    protected Random rand = new Random();

    /**
     * This method is used for generating objects that are spawnable, such as gemstones and obstacles.
     * @param posX, given place to spawn object on X position
     * @param posY, given place to spawn object on Y position
     */
    protected abstract void generate(float posX,float posY);

    /**
     * This method is called on each update tick from the main game to update and handle all objects.
     * To spawn at a good distance from the player the players position is sent over.
     * @param posX, given place to determine where to add and remove objects based on x
     * @param posY, given place to determine where to add and remove objects based on y
     */
    public abstract void update(float posX, float posY);

    /**
     * When a collision is detected this class will react with the specified object with matching id.
     * @param id, used to locate a specific object
     */
    public abstract void react(int id);
}
