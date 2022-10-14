package com.grupp28gdx.game.Model.Guns;

import com.grupp28gdx.game.Model.Body;

public class Bullet {
    private Body body;


    public Bullet(float xPos, float yPos, float speed){ //Speed should be int as soon as possible
        this.body = new Body(xPos, yPos);
        this.body.setMovementSpeed(speed);

    }

    /**
     * Updates the instance of Bullet position on the X-axis
     */
    public void positionUpdateBullet(){
        this.body.setXPosition(this.body.getXPosition() + this.body.getMovementSpeed());

    }
}
