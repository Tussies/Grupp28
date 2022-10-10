package com.grupp28gdx.game.Model;

/**
 * This player is the default player.
 */
public class GreenPlayer implements Player{
    private int movementSpeed;

    private float forceX;
    private float forceY;
    private float velocityY;

    private Position position;

    private int numberOfJumps;

    private String stateOfPlayer;
    private Player player;
    private int lives;
    private int gemCounter;

    enum States{idle,walking,jumping, falling, running}
    enum Directions{left,right}

    States playerState = States.idle;
    Directions playerDirection = Directions.right;

    boolean onGround = true;

    public GreenPlayer() {
        this.position = new Position(0,0);
        this.position.setMovementSpeed(700);
        lives = 3;

        this.position.setXPosition(0);
        this.position.setYPosition(0);
        this.position.setForceX(0);
        this.position.setForceY(0);
        stateOfPlayer = "walking";

        this.gemCounter = 0;
    }

    private void positionUpdate() {
        if (position.y<1)collisionGroundBegin();
        if(position.y>1)collisionGroundEnd();
        if (playerState == States.jumping || playerState == States.falling) jump();
        else{
            position.x += forceX;
            position.y += velocityY;
        }
    }

    @Override
    public Player createPlayer() {
        if(player == null){
            player = new GreenPlayer();
        }
        return player;
    }

    public void collisionGroundBegin() {
        forceY = 0;
        position.y = 1;
        onGround = true;
        playerState = States.idle;
        velocityY = 0;
    }

    public void collisionGroundEnd() {
        onGround = false;
    }


    @Override
    public void jump() {
        position.x += forceX;
        if (velocityY < 0.3 && playerState == States.jumping){
            velocityY += 0.07;
        }else{
            playerState = States.falling;
            velocityY -=0.0098;
        }
        position.y += velocityY;
    }

    @Override
    public void run() {

    }


    public void inputKeyDown(int key){
        switch (key){
            case 51: // w
                if (onGround){
                    playerState = States.jumping;
                }
                velocityY = 0.1f;
                break;
            case 47: // s
                break;
            case 29: // ad
                if (onGround){
                    playerDirection = Directions.left;}
                forceX = -0.1f;
                break;
            case 32: //d
                if (onGround){
                    playerDirection = Directions.right;}
                forceX = 0.1f;
                break;
        }
    }

    public void inputKeyUp(int key){
        switch (key){
            case 51:
                velocityY = 0;
                break;// w
            case 47: // s
                velocityY = -0.01f;
                break;
            case 29: // a
            case 32: //d
                if (onGround){
                    playerState = States.idle;}
                forceX = 0;
                break;
        }
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

