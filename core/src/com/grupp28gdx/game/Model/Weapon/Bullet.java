package com.grupp28gdx.game.Model.Weapon;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.CollisionDetector;

import java.util.ArrayList;

public class  Bullet {
    private Body body;
    private Bullet tempBullet;
    private CollisionDetector detector;

    private float height;
    private float width;

    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    /**
     * The Bullet object is shot from the
     *
     * @param xPos
     * @param yPos
     * @param speed
     */
    public Bullet(float xPos, float yPos, float speed) { //Speed should be int as soon as possible
        this.body = new Body(xPos, yPos);
        height = 0.2f;
        width = 0.2f;
        this.body.setMovementSpeed(speed);
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

    private void createShape() {
        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition());
        vectorListX.add(body.getXPosition()+1);
        vectorListX.add(body.getXPosition()+1);

        vectorListY.add(body.getYPosition());
        vectorListY.add(body.getYPosition()+2);
        vectorListY.add(body.getYPosition()+2);
        vectorListY.add(body.getYPosition());
    }

    public ArrayList<Float> getVectorListX(){
        return vectorListX;
    }

    public ArrayList<Float> getVectorListY(){
        return vectorListY;
    }

    public float getXPosition(){
        return this.body.getXPosition();
    }
    public float getYPosition(){
        return this.body.getYPosition();
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

}

