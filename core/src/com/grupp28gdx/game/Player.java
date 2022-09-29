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
    private int forceX = 0;
    private int forceY = 0;
    private float x_position;
    private float y_position;
    private GameStateManager gsm;
    private int jumps = 0;
    private long lastTap = 0;
    private String playerState;

    private int xVelocity;
    private int yVelocity;

    //Removed world from parameters
    public Player() {
        //bodyDef = new BodyDef();
        //bodyDef.type = BodyDef.BodyType.DynamicBody;
        //bodyDef.position.set(0,1);
        //bodyDef.fixedRotation = true;
        //player = world.createBody(bodyDef);
        movementSpeed = 700;
        //bodyShape = new PolygonShape();
        //bodyShape.setAsBox(30/pixelsPerMeter, 30/pixelsPerMeter);
        //player.createFixture(bodyShape, 1.0f);
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
                    this.forceY = 200;

                    if (this.getY_position() == 0) {
                        jumps = 0;
                    }
                }
                playerState = "jumping";
                break;
            case 22:
                forceX += 1;
                break;
            case 20:
                forceY = -60;
                break;
        }
    }

    public void inputActionUp(int key) {
        switch (key) {
            case 19:
                this.forceY = 0;
                break;
            case 20:
                forceY = 0;

                break;
            case 111:
                gsm.set(new MenuState(gsm));
        }
    }

    public Body getPlayerBody() {
        return player;
    }

    public PolygonShape getBodyShape() {
        return bodyShape;
    }

    public void playerMovementUpdate(float delta) {
        //player.applyForceToCenter(movementSpeed, forceY, false);
        this.setXVelocity(forceX * 5);
        this.setYVelocity(getYVelocity());
        /* Code used to check is velocity and position work properly
        System.out.println("X vel is " + this.getXVelocity() + " Y vel is " + this.getYVelocity());
        System.out.println("X pos is " + this.getX_position() + " Y pos is " + this.getY_position());
        */

        this.setPosition(this.getX_position()+this.getXVelocity(), this.getY_position()+this.getYVelocity());
        if (forceY > 0) {
            forceY += -10;

        }
        if (this.getYVelocity() <= -2) {
            playerState = "walking";
        }
        this.setPosition(this.getX_position(), this.getY_position());

    }

    public String getPlayerState() {
        return playerState;
    }

    public int getForceY() {
        return forceY;
    }

    public void setXVelocity(int velocity) {
        this.xVelocity = velocity;
    }

    public void setYVelocity(int velocity) {
        this.yVelocity = velocity;
    }

    public int getXVelocity() {
        return this.xVelocity;
    }

    public int getYVelocity() {
        return this.yVelocity;
    }

    public float getX_position() {
        return this.x_position;
    }

    public float getY_position() {
        return this.y_position;
    }


}