package com.grupp28gdx.game.Model;

/**
 * This is the easiest player. It runs slower, jumps higher and has more lives
 * than the default GreenPlayer. It inherits the rest of its functionality from GreenPlayer.
 */
public class OrangePlayer extends GreenPlayer implements Player{
    public Body body;
    private Player player;
    private int lives;
    private int speedX;
    private int speedY;

    public OrangePlayer() {
        this.body = new Body(0,0);
        this.body.setMovementSpeed(1);
        lives = 5;
        this.body.setXPosition(0);
        this.body.setYPosition(0);
        this.body.setForceX(0);
        this.body.setForceY(0);
        //stateOfPlayer = "walking";
    }

    /*@Override
    public Player createPlayer() {
        if(player == null){
            player = new OrangePlayer();
        }
        return player;
    }*/

    @Override
    public void jump() {

    }
    StateOfPlayer playerState;
    StateOfPlayerDirection playerDirection;

    boolean onGround = true;

/*    public OrangePlayer() {
        lives = 5;
        speedX = 1;
        speedY = 0;
        createPlayer();
    }
*/
    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

}