package com.grupp28gdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.states.GameStateManager;
import com.grupp28gdx.game.states.MenuState;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

public class Player implements Spawnables {

    private Body player;
    private BodyDef bodyDef;
    private PolygonShape bodyShape;
    private int movementSpeed;
    private float forceX = 0.2f;
    private int forceY = 0;
    private float x_position;
    private float y_position;
    private GameStateManager gsm;
    private int jumps = 0;
    private long lastTap = 0;
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
                if (this.getYVelocity() == 0 || jumps < 1) {
                    jumps++;
                    this.setYVelocity(0.0001f);

                    if (this.getY_position() == 0) {
                        jumps = 0;
                    }
                }
                playerState = "jumping";
                break;
            case 22:
                forceX += 0.2;
                break;
            case 20:
                if(this.getY_position() == 0){
                    break;
                }
                forceY = -60;
                break;
        }
    }

    public void inputActionUp(int key) {
        switch (key) {
            case 19:
                this.setYVelocity(0.5f);
                break;
            case 20:
                forceY = 0;

                break;

            case 22:
                //this.setXVelocity();
            case 111:
                gsm.set(new MenuState(gsm));
        }
    }

    public Body getPlayerBody() {
        return player;
    }


    public void playerMovementUpdate(float delta) {

        this.setPosition(this.getX_position() + this.getXVelocity(), this.getY_position()+this.getYVelocity());



        if(this.getY_position() > 0){
            this.setYVelocity(this.getYVelocity()-0.02f);
            System.out.println(this.getYVelocity());
        }
        if(this.getY_position() <=0){
            this.playerState = "walking";
            this.setYVelocity(0);
            this.setPosition(this.getX_position(), 0f);
        }

        //System.out.println(this.getXVelocity() + " left Xvel right Xpos " + this.getX_position());
        if(this.getY_position() > 0 || this.getYVelocity()>0) {
            System.out.println((this.getYVelocity() + " left is Yvel right is Ypos " + this.getY_position()));
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