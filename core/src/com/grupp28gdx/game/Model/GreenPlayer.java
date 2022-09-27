package com.grupp28gdx.game.Model;

/**
 * This player is the default player.
 */
public class GreenPlayer implements Player{
    private int movementSpeed;
    private int forceX;
    private int forceY;
    private Position position;
    private int numberOfJumps;
    private String stateOfPlayer;

    public GreenPlayer() {
        movementSpeed = 700;
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
        forceX = 0;
        forceY = 0;
        numberOfJumps = 0;
        stateOfPlayer = "walking";
    }

    @Override
    public Player createPlayer() {
        Player player = new PurplePlayer();
        return player;
    }

    @Override
    public void jump() {

    }

    @Override
    public void run() {

    }
}

