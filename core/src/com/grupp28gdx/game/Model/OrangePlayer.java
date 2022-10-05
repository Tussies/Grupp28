package com.grupp28gdx.game.Model;

/**
 * This is the easiest player. It runs slower than the default player.
 */
public class OrangePlayer implements Player{
    private Position position;
    private String stateOfPlayer;
    private Player player;
    private int lives;
    private int gemCounter;

    public OrangePlayer() {
        this.position.setMovementSpeed(700);
        lives = 5;
        this.position = new Position(0,0);
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
            player = new OrangePlayer();
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