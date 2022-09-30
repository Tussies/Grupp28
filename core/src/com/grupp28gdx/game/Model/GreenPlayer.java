package com.grupp28gdx.game.Model;

/**
 * This player is the default player.
 */
public class GreenPlayer implements Player{
    private Position position;
    private String stateOfPlayer;
    private Player player;
    private int lives;

    public GreenPlayer() {
        this.position.setMovementSpeed(700);
        lives = 3;
        this.position = new Position(0,0);
        this.position.setXPosition(0);
        this.position.setYPosition(0);
        this.position.setForceX(0);
        this.position.setForceY(0);
        stateOfPlayer = "walking";
    }

    @Override
    public Player createPlayer() {
        if(player == null){
            player = new GreenPlayer();
        }
        return player;
    }

    @Override
    public void jump() {

    }

    @Override
    public void run() {

    }

    public void setStateOfPlayer(String stateOfPlayer) {
        this.stateOfPlayer = stateOfPlayer;
    }

    public String getStateOfPlayer() {
        return stateOfPlayer;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}

