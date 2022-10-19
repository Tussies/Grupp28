package com.grupp28gdx.game.Model.Guns;

import com.grupp28gdx.game.Model.Body;

import java.util.ArrayList;

public class Gun {
    public Body body;
    public Bullet bullet;
    public ArrayList<Bullet> bulletsFired = new ArrayList<>();

    public Gun(){ //Send in player coordinates
        this.body = new Body(0,0);
        this.bullet = new Bullet(0, 0, 5);
    }


    /**
     * Updates the position of Gun.
     * @param xPos
     * @param yPos
     */
    public void positionUpdateGunAndBullets(float xPos, float yPos, float deltaTime){ //Updates the guns position with the players x and y position. (Should be sent in)
        this.body.setXPosition(xPos);
        this.body.setYPosition(yPos);
        bullet.positionUpdateBullet(bulletsFired, deltaTime);

    }
    public void destroyBullet(int i) {
        bulletsFired.remove(i);
    }

    public void shootGun(float xPos, float yPos, float speed) {
        bulletsFired.add(new Bullet(xPos, yPos, speed));
    }

    public ArrayList<Bullet> getBulletsFired(){return this.bulletsFired;}


}
