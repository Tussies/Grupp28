package com.grupp28gdx.game.Controller.handlers;

import java.util.Random;

public abstract class SpawnHandler {
    protected Random rand = new Random();

    protected abstract void generate(float posX,float posY);

    /**
     * This method is called on each update tick from the main game to update and handle all objects.
     * To spawn at a good distance from the player the players position is sent over.
     * @param posX
     * @param posY
     */

    public abstract void update(float posX, float posY);

    /**
     * When a collision is detected this class will react with the specified object with matching id.
     * @param id
     */
    public abstract void react(int id);
}
