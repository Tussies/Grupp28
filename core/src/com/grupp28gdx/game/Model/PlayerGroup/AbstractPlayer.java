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

    private float height;
    private float width;

    public PlayerStates playerState;

    boolean onGround = true;

    public AbstractPlayer() {
        friction = 0.0f;
        height = 2.75f;
        width = 1f;
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
     * kommentera här
     */

    public void inputKeyDown(int key){
        switch (key){
            case 51: //w
                if (playerState != PlayerStates.DEAD) this.jump();
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

    //DEN SKA VA KVAR
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

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void react() {
        body.setMovementSpeed(0);
        playerState = PlayerStates.DEAD;
    }

}
