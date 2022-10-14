package com.grupp28gdx.game.Model.Guns;

import com.grupp28gdx.game.Model.Body;

public class Gun {
    public Body body;
    private Bullet bullet;

    public Gun(){ //Send in player coordinates
        this.body.setXPosition(0);
        this.body.setYPosition(0);
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
    }



}
