package com.grupp28gdx.game;


import com.grupp28gdx.game.states.GameStateManager;
import com.grupp28gdx.game.states.MenuState;


public class Player implements Spawnables {


    private float forceX = 0.2f;
    private int forceY = 0;
    private float x_position;
    private float y_position;
    private GameStateManager gsm;
    private int jumps = 0;
    private String playerState;

    private float xVelocity = 0.2f;
    private float yVelocity;

    //Removed world from parameters
    public Player() {

        gsm = new GameStateManager();

        playerState = "walking";
    }

    public void setPosition(float xPos, float yPos) {
        x_position = xPos;
        y_position = yPos;
    }


    public void inputActionDown(int key) {
        switch (key) {
            case 19:
                this.jump();
                playerState = "jumping";
                break;
            case 22:
                this.setXVelocity(0.4f);
                break;
            case 20:
                if(this.getY_position() == 0){
                    break;
                }

                this.setYVelocity(-0.3f);

                break;
        }
    }

    public void inputActionUp(int key) {
        switch (key) {
            case 19:
               //this.setYVelocity(0.5f);

                break;
            case 20:
                forceY = 0;

                break;

            case 22:
                this.setXVelocity(0.2f);
                break;
            case 111:
                gsm.set(new MenuState(gsm));
        }
    }


    public void jump (){
        if (this.getYVelocity() == 0 || this.jumps < 2) {
            this.jumps++;
            this.setYVelocity(0.5f);

            if (this.getY_position() == 0) {
                this.jumps = 0;
            }
        }

    }


    public void playerMovementUpdate(float delta) {

        this.setPosition(this.getX_position() + this.getXVelocity(), this.getY_position()+this.getYVelocity());

        if(this.getY_position() > 0){
            this.setYVelocity(this.getYVelocity()-0.02f);
        }
        if(this.getY_position() <=0){
            this.playerState = "walking";
            this.setYVelocity(0);
            this.setPosition(this.getX_position(), 0f);

        }


    }

    public String getPlayerState() {
        return playerState;
    }

    public int getForceY() {
        return forceY;
    }

    public void setXVelocity(float velocity) {
        this.xVelocity = velocity;
    }

    public void setYVelocity(float velocity) {
        this.yVelocity = velocity;
    }

    public float getXVelocity() {
        return this.xVelocity;
    }

    public float getYVelocity() {
        return this.yVelocity;
    }

    public float getX_position() {
        return this.x_position;
    }

    public float getY_position() {
        return this.y_position;
    }


}