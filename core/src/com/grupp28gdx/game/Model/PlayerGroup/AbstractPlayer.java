package com.grupp28gdx.game.Model.PlayerGroup;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.Guns.Gun;

/**
 * This is an abstract player, no instances of this player can be made but OrangePlayer,
 * GreenPlayer and PurplePlayer all derive their functionality from this class.
 * The body variable is a Body object put in the class by composition, determines all
 * movement, force, speed, etc. of the Player object.
 * @see Body
 */
public abstract class AbstractPlayer implements Player{

    public Body body;
    private int lives;
    private float friction;
    private Gun gun;


    public PlayerStates playerState;

    boolean onGround = true;

    public AbstractPlayer() {
        lives = 0;
        friction = 0.0f;
        createPlayer();
    }

    public void createPlayer() {
        this.body = new Body(0,0);
        this.body.setMovementSpeed(0);
        this.body.setXPosition(0);
        this.body.setYPosition(0);
        this.body.setForceX(0);
        this.body.setForceY(0);

        this.gun = new Gun();

        playerState = PlayerStates.IDLE;
    }

    /**
     * The playerUpdate method should be put in the step, cycle, update e.g. method of the game.
     * It updates a player's movement, with gravity acting upon it.
     * @param deltaTime is the time between each update of the movement of Player.
     */

    public void playerUpdate(float deltaTime) {
        body.speedY += body.gravity * deltaTime;
        playerMove(deltaTime);
        body.accelerate(0, body.gravity);
        playerState();
        gun.positionUpdateGunAndBullets(this.body.getXPosition(), this.body.getYPosition());
    }

    public void playerState() {
        if(body.y <= 0){
            playerState = PlayerStates.WALKING;
        }
    }

    public void playerMove(float deltaTime) {
        body.move(body.getMovementSpeed()*deltaTime, body.speedY*deltaTime*friction);
    }

    public abstract void jump();

    /**
     * kommentera här, fråga Isak
     */

    public void collisionGroundBegin() {
        body.y = 1;
        onGround = true;
        playerState();
        body.forceY = 0;
        body.speedY = 0;
    }

    public void collisionGroundEnd() {
        onGround = false;
    }

    /**
     * kommentera här, fråga Isak DEN SKA BORT
     */

    public void inputKeyDown(int key){
        switch (key){
            case 51: // w
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
            case 62:
                gun.shootGun(this.body.getXPosition(), this.body.getYPosition(), this.body.getMovementSpeed()*2) ;
        }
    }

    //DEN SKA VA KVAR
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

    public Gun getGun(){return this.gun;}
}
