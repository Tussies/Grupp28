package com.grupp28gdx.game.Model;

/**
 * All objects that have a position in the game(obstacles, player, coins) have a Position object that
 * updates as the game progresses.
 */
public class Body {

    protected float gravity = -1.0f;
    protected float x;
    protected float y;
    protected int speedX;
    protected int speedY;
    protected float forceX;
    protected float forceY;
    private int movementSpeed;

    public Body(float x, float y) {
        this.speedX = 0;
        this.speedY = 0;
        this.x = x;
        this.y = y;
        this.forceX = 0;
        this.forceY = 0;
    }

    private void positionUpdate(Body body) {
            body.x += forceX;
            body.y += forceY;
    }

    public void accelerate(double accelerationX, double accelerationY) {
        speedX += accelerationX;
        speedY += accelerationY;
    }

    public void move(double xDelta, double yDelta) {
        x += xDelta;
        y += yDelta;
    }

    public void setXPosition(float x) {
        this.x = x;
    }

    public void setYPosition(float y) {
        this.y = y;
    }


    public float getXPosition() {
        return this.x;
    }


    public void setForceX(int forceX) {
        this.forceX = forceX;
    }


    public void setForceY(int forceY) {
        this.forceY = forceY;
    }


    public void setMovementSpeed(int newSpeed) {
        this.speedY = newSpeed;
    }

    public int getMovementSpeed() {
        return this.speedY;
    }
}

