package com.grupp28gdx.game.Model;

/**
 * This is the most difficult player. It runs faster than the default player.
 */
public class PurplePlayer implements Player{
    private int movementSpeed;
    private int forceX;
    private int forceY;
    private int numberOfJumps;
    private String stateOfPlayer;
    private Position position;

    public PurplePlayer() {
        movementSpeed = 900;
        position = new Position(0,0);
        position.setXPosition(0);
        position.setYPosition(0);
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