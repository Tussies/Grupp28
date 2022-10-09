package com.grupp28gdx.game.Model;

/**
 * This is the easiest player. It runs slower than the default player.
 */
public class OrangePlayer extends GreenPlayer implements Player{
    private Body body;
    private Player player;
    private int lives;
    private int speedX;
    private int speedY;

    StateOfPlayer playerState;
    StateOfPlayerDirection playerDirection;

    boolean onGround = true;

    public OrangePlayer() {
        lives = 5;
        speedX = 1;
        speedY = 0;
        createPlayer();
    }

    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

}