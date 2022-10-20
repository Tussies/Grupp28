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
    private float friction;
    private Gun gun;

    private int gemScore;
    public PlayerStates playerState;

    boolean onGround = true;

    public AbstractPlayer() {
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
        body.setHeight(2.75f);
        body.setWidth(1f);

        this.gun = new Gun();

        gemScore = 0;

        playerState = PlayerStates.IDLE;
    }

    /**
     * The playerUpdate method should be put in the step, cycle, update e.g. method of the game.
     * It updates a player's movement, with gravity acting upon it.
     * @param deltaTime is the time between each update of the movement of Player.
     */


    public void playerUpdate(float deltaTime) {
        if(playerState != PlayerStates.DEAD){
            body.speedY += body.gravity * deltaTime;
            playerMove(deltaTime);
            body.accelerate(0, body.gravity);
            playerState();
            gun.positionUpdateGunAndBullets(this.body.getXPosition(), this.body.getYPosition(), deltaTime);
        }
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
     * Locks the players Y position to the defiend value given
     * @param y is the Ground value
     */

    public void collisionGroundBegin(float y) {
        body.y = y;
        onGround = true;
        playerState();
        body.forceY = 0;
        body.speedY = 0;
    }

    /**
     * Sets the onGround state to false indicating that the player is no longer touching the ground.
     */
    public void collisionGroundEnd() {
        onGround = false;
    }

    /**
     * A method used to interpret a keypress as a certain action.
     * @param key one of the constants in libGDX Input.KEYS
     */

    public void inputKeyDown(int key){
        switch (key){
            case 19: // up
                if (playerState != PlayerStates.DEAD) this.jump();
                break;
            case 51 : //w
                if (playerState != PlayerStates.DEAD) this.jump();
                break;
            case 20: // down
                this.body.speedY = -60;
                break;
            case 47: // s
                this.body.speedY = -60;
                break;
            case 29: // a
                break;
            case 32: //d
                break;
            case 62:
                gun.shootGun(this.body.getXPosition(), this.body.getYPosition()+0.4f, this.body.getMovementSpeed()+1) ;
        }
    }

    /**
     * A method used to interpret a key release as a certain action.
     * @param key one of the constants in libGDX Input.KEYS
     */
    public void inputKeyUp(int key){
        switch (key){
            case 51:
                break;// w

            case 47: // s
                break;
            case 29: // a
                break;
            case 32: //d

                break;
        }
    }

    public void setStateOfPlayer(PlayerStates stateOfPlayer) {
        playerState = stateOfPlayer;
    }

    public PlayerStates getStateOfPlayer() {
        return playerState;
    }

    public Body getBody() {
        return this.body;
    }

    public Gun getGun(){return this.gun;}

    public void addCollectedGem(int score){
        gemScore += score;
    }

    public int getGemScore(){
        return gemScore;
    }

    public void react() {
        body.setMovementSpeed(0);
        playerState = PlayerStates.DEAD;
    }

}
