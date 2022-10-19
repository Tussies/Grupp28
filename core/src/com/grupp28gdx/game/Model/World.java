package com.grupp28gdx.game.Model;


import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;

import java.util.ArrayList;

/**
 * This is where all objects of the world will be placed and updated.
 */
public class World{
    /**
     * This is the gravity in the x-direction and y-direction.
     * DeltaTime is the amount of time it takes for our game
     * to step forward, in this case 1/60 of a second or 60Hz.
     */
    protected static Player player;
    protected static final float UPDATE_RATE = 60.0f;
    protected final float deltaTime = 1.0f/UPDATE_RATE;
    protected static ArrayList<Obstacle> obstacles= new ArrayList();


    public World() {
        player = new GreenPlayer();

        /**
         * A separate thread is started from LibGDX.
         * While the program is running it will update a step every 1/60 of a second.
         * Time, velocity and position is responsible for the physics
         * of the game.
         *
         * The player moves with the speedX every step.
         *
         * The render method is responsible for updating the graphics.
         *
         */
        Thread gameThread = new Thread() {
            public void run() {
                while (true) {
                    player.playerUpdate(deltaTime, obstacles);

                    //render();
                    try {
                        Thread.sleep((long) (1000 / UPDATE_RATE));
                    } catch (InterruptedException ex) { }
                }
            }
        };
        gameThread.start();
    }
}

