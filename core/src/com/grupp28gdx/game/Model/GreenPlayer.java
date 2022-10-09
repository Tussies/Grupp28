package com.grupp28gdx.game.Model;

/**
 * This player is the default player.
 */
public class GreenPlayer implements Player{
    private Body body;
    private Player player;
    private int lives;
    private int speedX;
    private int speedY;
    //private int gemCounter; det ska finnas ett gemcounter-objekt istället

    StateOfPlayer playerState;
    StateOfPlayerDirection playerDirection;

    boolean onGround = true;

    public GreenPlayer() {
        lives = 3;
        speedX = 2;
        speedY = 0;
        createPlayer();
        //this.gemCounter = 0;
    }

    public void createPlayer() {
        this.body = new Body(0,0);
        this.body.setMovementSpeed(1);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
        this.body.setForceX(0);
        this.body.setForceY(0);
        playerState = StateOfPlayer.IDLE;
        playerDirection = StateOfPlayerDirection.RIGHT;
    }

    private void positionUpdate() {
        if (body.y<1) collisionGroundBegin();
        if(body.y>1)collisionGroundEnd();
        if (playerState == StateOfPlayer.JUMPING|| playerState == StateOfPlayer.FALLING) jump();
        else{
            body.x += body.forceX;
            body.y += body.forceY;
        }
    }

    @Override
    public void playerUpdate(float deltaTime) {
        body.x += body.speedX * deltaTime;
        body.y += body.speedY * deltaTime;
        body.speedY += body.gravity * deltaTime;

        body.move(speedX, speedY);

        body.accelerate(0, -body.gravity);
    }

    public void collisionGroundBegin() {
        body.y = 1;
        onGround = true;
        playerState = StateOfPlayer.IDLE;
        body.forceY = 0;
    }

    public void collisionGroundEnd() {
        onGround = false;
    }


    @Override
    public void jump() {
        body.x += body.forceX;
        if (body.forceY < 0.3 && playerState == StateOfPlayer.JUMPING){
            body.forceY += 0.07;
        }else{
            playerState = StateOfPlayer.FALLING;
            body.forceY -=0.0098;
        }
        body.y += body.forceY;
    }

    public void inputKeyDown(int key){
        switch (key){
            case 51: // w
                if (onGround){
                    playerState = StateOfPlayer.JUMPING;
                }
                body.forceY = 0.1f;
                break;
            case 47: // s
                break;
            case 29: // ad
                if (onGround){
                    playerDirection = StateOfPlayerDirection.LEFT;}
                body.forceX = -0.1f;
                break;
            case 32: //d
                if (onGround){
                    playerDirection = StateOfPlayerDirection.RIGHT;}
                body.forceX = 0.1f;
                break;
        }
    }

    public void inputKeyUp(int key){
        switch (key){
            case 51:
                body.forceY = 0;
                break;// w
            case 47: // s
                body.forceY = -0.01f;
                break;
            case 29: // a
            case 32: //d
                if (onGround){
                    playerState = StateOfPlayer.IDLE;}
                body.forceX = 0;
                break;
        }
    }

    public void setStateOfPlayer(StateOfPlayer stateOfPlayer) {
        playerState = stateOfPlayer;
    }

    public StateOfPlayer getStateOfPlayer() {
        return playerState;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }


/*    public void setGemCounter(int points){
        this.gemCounter=points;
    }
    public int getGemCounter(){
        return this.gemCounter;
    }*/
}

