package com.grupp28gdx.game.Model.Guns;

import com.grupp28gdx.game.Model.Body;

import java.util.ArrayList;

public class  Bullet {
    private Body body;
    private Bullet tempBullet;

    /**
     * The Bullet object is shot from the
     *
     * @param xPos
     * @param yPos
     * @param speed
     */
    public Bullet(float xPos, float yPos, float speed) { //Speed should be int as soon as possible
        this.body = new Body(xPos, yPos);
        this.body.setMovementSpeed(speed);
        body.setHeight(0.2f);
        body.setWidth(0.2f);
    }

    /**
     * Updates all the instances of Bullet position on the X-axis and calls on method destroyBullets if they have collided with an obstacle.
     */
    public void positionUpdateBullet(ArrayList<Bullet> bullets, float deltaTime) {
        for (int i = 0; i < bullets.size(); i++) {
            tempBullet = bullets.get(i);
            tempBullet.body.setXPosition(tempBullet.body.getXPosition() + tempBullet.body.getMovementSpeed()*deltaTime);
            bullets.set(i, tempBullet);

        }
    }


    public Body getBody(){
        return body;
    }

    public float getXPosition(){
        return this.body.getXPosition();
    }
    public float getYPosition(){
        return this.body.getYPosition();
    }

}

