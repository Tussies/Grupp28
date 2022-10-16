package com.grupp28gdx.game.Model.Guns;

import com.grupp28gdx.game.Model.Body;

import java.util.ArrayList;

public class Bullet {
    private Body body;
    private Bullet tempBullet;

    /**
     * The Bullet object is shot from the
     *
     * @param xPos
     * @param yPos
     * @param speed
     */
    public Bullet(float xPos, float yPos, int speed) { //Speed should be int as soon as possible
        this.body = new Body(xPos, yPos);
       this.body.setMovementSpeed(speed);
    }

    /**
     * Updates all the instances of Bullet position on the X-axis and calls on method destroyBullets if they have collided with an obstacle.
     */
    public void positionUpdateBullet(ArrayList<Bullet> bullets) {
        for (int i = 0; i < bullets.size(); i++) {
            tempBullet = bullets.get(i);
            tempBullet.body.setXPosition(tempBullet.body.getXPosition() + tempBullet.body.getMovementSpeed());
            bullets.set(i, tempBullet);


            if (bulletCollision(bullets.get(i))) { //FIX THE PARAM
                destroyBullet(bullets, i);

            }
        }
    }

    /**
     * Checks if an instance of Bullet has collided with another object
     *
     * @param bullet
     * @return true if collision with object has occurred and false if it has not.
     */

    public boolean bulletCollision(Bullet bullet) {

        if (false) { //collisiondetector with obstacle and bullet, if statement
            return true;
        }

        return false;
    }

    /**
     * Removes an element from ArrayList Bullets when called upon.
     *
     * @param bullets
     * @param i
     */
    public void destroyBullet(ArrayList<Bullet> bullets, int i) {
        bullets.remove(i);
    }

}
