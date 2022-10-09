package com.grupp28gdx.game.Model;

/**
 * This is the most difficult player. It runs faster than the default player.
 */
public class PurplePlayer extends GreenPlayer implements Player{
    private Body body;
    private Player player;
    private int lives;
    private int speedX;
    private int speedY;

    StateOfPlayer playerState;
    StateOfPlayerDirection playerDirection;

    boolean onGround = true;

    public PurplePlayer() {
        lives = 1;
        speedX = 3;
        speedY = 0;
        createPlayer();
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

}