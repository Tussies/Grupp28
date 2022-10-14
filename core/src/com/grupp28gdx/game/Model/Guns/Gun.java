package com.grupp28gdx.game.Model.Guns;

import com.grupp28gdx.game.Model.Body;

public class Gun {
    public Body body;
    private Bullet bullet;
    private int bulletCounter;

    public Gun(){ //Send in player coordinates
        this.body = new Body(0,0);
    }


    /**
     * Updates the position of Gun.
     * @param xPos
     * @param yPos
     */
    public void positionUpdateGun(float xPos, float yPos){ //Updates the guns position with the players x and y position. (Should be sent in)
        this.body.setXPosition(xPos);
        this.body.setYPosition(yPos);

    }

    public void shootGun(float xPos, float yPos, float speed) {
     bullet = new Bullet(xPos, yPos, speed);

        this.bulletCounter++;
        System.out.println("Bullet nr " + bulletCounter);
    }



}
