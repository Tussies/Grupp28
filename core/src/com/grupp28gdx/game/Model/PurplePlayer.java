package com.grupp28gdx.game.Model;

/**
 * This is the most difficult player. It runs faster than the default player.
 */
public class PurplePlayer implements Player{
    private String stateOfPlayer;
    private Position position;
    private Player player;
    private int lives;
    private int gemCounter;

    public PurplePlayer() {
        this.position = new Position(0,0);
        this.position.setMovementSpeed(900);
        lives = 0;
        this.position.setXPosition(0);
        this.position.setYPosition(0);
        this.position.setForceX(0);
        this.position.setForceY(0);
        stateOfPlayer = "walking";

        this.gemCounter = 0;
    }

    @Override
    public Player createPlayer() {
        if(player == null){
            player = new PurplePlayer();
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

    public void setGemCounter(int points){
        this.gemCounter=points;
    }
    public int getGemCounter(){
        return this.gemCounter;
    }
}