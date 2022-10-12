package com.grupp28gdx.game.Model;

/**
 * All objects that have a position in the game(obstacles, player, coins) have a Position object that
 * updates as the game progresses, x and y are the vector positions of an object.
 *
 * The less the float of gravity variable is, the stronger it is.
 * Both speed and force can be manipulated in the horizontal and vertical axis.
 */
public class Body {

    protected float gravity = -1.0f;
    protected float x;
    protected float y;
    protected int speedX;
    protected int speedY;
    protected float forceX;
    protected float forceY;

    public Body(float x, float y) {
        this.speedX = 0;
        this.speedY = 0;
        this.x = x;
        this.y = y;
        this.forceX = 0;
        this.forceY = 0;
    }

    /**
     * This method accelerates and object when put in to an update method with each tick(deltaTime).
     *
     * @param accelerationX is the acceleration in the horizontal axis.
     * @param accelerationY is the acceleration in the vertical axis.
     */
    public void accelerate(double accelerationX, double accelerationY) {
        speedX += accelerationX;
        speedY += accelerationY;
    }

    /**
     * This method moves an object when put in to an update method with each tick(deltaTime).
     *
     * @param xDelta is the difference in x-position.
     * @param yDelta is the difference in y-position.
     */
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
    public float getYPosition(){
        return  this.y;
    }

    public void setForceX(int forceX) {
        this.forceX = forceX;
    } //forceX är en float men metoden ber om en int

    public void setForceY(int forceY) {
        this.forceY = forceY;
    } //forceY är en float men metoden ber om int

    public float getForceX(){return this.forceX; }

    public float getForceY(){return this.forceY; }


    public void setMovementSpeed(int speed) {
        this.speedX = speed;
    }

    public int getMovementSpeed() { //Confusing name
        return this.speedX;
    }


    public int getSpeedY(){ //setter?
        return this.speedY;
    }
}

