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
    private int lives;
    private int jumps = 0;

    public PlayerStates playerState;
    //private StateOfPlayerDirection playerDirection;

    boolean onGround = true;

    public GreenPlayer() {
        lives = 3;
        createPlayer();
    }

    public void createPlayer() {
        this.body = new Body(0,0);
        this.body.setMovementSpeed(2);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
        this.body.setForceX(0);
        this.body.setForceY(0);
        playerState = PlayerStates.IDLE;
        //playerDirection = StateOfPlayerDirection.RIGHT;
        }

    /**
     * The playerUpdate method should be put in the step, cycle, update e.g. method of the game.
     * It updates a player's movement, with gravity acting upon it.
     * @param deltaTime is the time between each update of the movement of Player.
     */
    @Override
    public void playerUpdate(float deltaTime) {
        body.speedY += body.gravity * deltaTime;
        body.move(body.getMovementSpeed()*deltaTime, body.speedY*deltaTime);
        body.accelerate(0, body.gravity);

        if(body.y <= 0){
            playerState = PlayerStates.WALKING;
        }
    }

    @Override
    public void jump (){
/*        if (body.speedY == 0 || this.jumps < 2) {
            this.jumps++;*/
            body.speedY = 30;

/*            if (body.y == 0) {
                this.jumps = 0;
            }
        }*/

    }

    /**
     * kommentera här, fråga Isak
     */

    @Override
    public void collisionGroundBegin() {
        body.y = 1;
        onGround = true;
        //playerState = PlayerStates.IDLE;
        body.forceY = 0;
        body.speedY = 0;
    }

    @Override
    public void collisionGroundEnd() {
        onGround = false;
    }

    /**
     * kommentera här, fråga Isak
     */
    @Override
    public void inputKeyDown(int key){
        switch (key){
            case 51: // w
                if (onGround){
                    playerState = PlayerStates.JUMPING;
                }
                jump();
                break;
            case 47: // s
                break;
            case 29: // ad
                /*if (onGround){
                    playerDirection = StateOfPlayerDirection.LEFT;}*/
                    break;
                    case 32: //d
                        /*if (onGround){
                            playerDirection = StateOfPlayerDirection.RIGHT;}*/
                            break;
                        }
                }

    public void inputKeyUp(int key){
        switch (key){
            case 51:
                //body.forceY = 0;
                break;// w
            case 47: // s
                //body.forceY = -0.01f;
                break;
            case 29: // a
            case 32: //d
                /*if (onGround){
                    playerState = StateOfPlayer.IDLE;}
                body.forceX = 0;*/
                break;
        }
    }

    public void setStateOfPlayer(PlayerStates stateOfPlayer) {
        playerState = stateOfPlayer;
    }

    public PlayerStates getStateOfPlayer() {
        return playerState;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Body getBody() {
        return this.body;
    }
}

