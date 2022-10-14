package com.grupp28gdx.game.Model;

/**
 * This is the hardest player a user can choose. It runs faster and has less lives
 * than the default GreenPlayer. It inherits the rest of its functionality from GreenPlayer.
 */
public class PurplePlayer extends GreenPlayer implements Player {
    private Body body;
    private Player player;
    private int lives;
    private int speedX;
    private int speedY;

    public PurplePlayer() {
        this.body = new Body(0, 0);
        this.body.setMovementSpeed(900);
        lives = 0;
        this.body.setXPosition(0);
        this.body.setYPosition(0);
        this.body.setForceX(0);
        this.body.setForceY(0);
        //stateOfPlayer = "walking";

        //this.gemCounter = 0;
    }

    /*@Override
    public Player createPlayer() {
        if (player == null) {
            player = new PurplePlayer();
        }
        return player;
    }*/


    @Override
    public void jump() {

    }
    /*
    @Override
    public void run() {

    }*/

    boolean onGround = true;
/*
    public PurplePlayer() {
        lives = 1;
        speedX = 3;
        speedY = 0;
        createPlayer();
    }*/

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

}