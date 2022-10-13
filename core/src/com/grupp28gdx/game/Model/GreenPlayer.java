package com.grupp28gdx.game.Model;

/**
 * This player is the default player. How fast this player runs, how high it jumps and how many
 * lives it has is the original and default settings for a Player.
 * The body variable is a Body object put in the GreenPlayer class by composition, determines all
 * movement, force, speed, etc. of the Player object.
 * @see Body
 *
 */
public class GreenPlayer implements Player{
    private Body body;
    private Player player;
    private int lives;
    private int speedX;
    private int speedY;

    StateOfPlayer playerState;
    StateOfPlayerDirection playerDirection;

    boolean onGround = true;

    public GreenPlayer() {
        lives = 3;
        speedX = 2;
        speedY = 0;
        createPlayer();
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

    /**
     * The playerUpdate method should be put in the step, cycle, update e.g. method of the game.
     * It updates a player's movement, with gravity acting upon it.
     * @param deltaTime is the time between each update of the movement of Player.
     */
    @Override
    public void playerUpdate(float deltaTime) {
        body.speedY += body.gravity * deltaTime;
        body.move(speedX, speedY);
        body.accelerate(0, -body.gravity);
    }

    /**
     * kommentera här, fråga Isak
     */
    public void collisionGroundBegin() {
        body.y = 1;
        onGround = true;
        playerState = StateOfPlayer.IDLE;
        body.forceY = 0;
    }

    public void collisionGroundEnd() {
        onGround = false;
    }

    /**
     * kommentera här, fråga Isak
     * wasd-layout on keyboard
     */
    public void inputKeyDown(int key){
        switch (key){
            case 51: // w
                if (onGround){
                    playerState = StateOfPlayer.JUMPING;
                }
                //body.forceY = 0.1f; skriv om till speed här
                break;
            case 47: // s
                break;
            case 29: // ad
                if (onGround){
                    playerDirection = StateOfPlayerDirection.LEFT;}
                //body.forceX = -0.1f;
                break;
            case 32: //d
                if (onGround){
                    playerDirection = StateOfPlayerDirection.RIGHT;}
                //body.forceX = 0.1f;
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
}

