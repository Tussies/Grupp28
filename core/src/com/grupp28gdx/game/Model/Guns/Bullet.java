package com.grupp28gdx.game.Model.Guns;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.CollisionDetector;
import com.grupp28gdx.game.Model.DestroyableObstacle;
import com.grupp28gdx.game.Model.Obstacle;

import java.util.ArrayList;

public class  Bullet {
    private Body body;
    private Bullet tempBullet;
    private CollisionDetector detector;


    ArrayList<Float> vectorListX = new ArrayList<Float>();
    ArrayList<Float> vectorListY = new ArrayList<Float>();

    /**
     * The Bullet object is shot from the
     *
     * @param xPos
     * @param yPos
     * @param speed
     */
    public Bullet(float xPos, float yPos, int speed) { //Speed should be int as soon as possible
        this.body = new Body(xPos, yPos);
        this.detector = new CollisionDetector();

        this.body.setMovementSpeed(speed);
    }

    /**
     * Updates all the instances of Bullet position on the X-axis and calls on method destroyBullets if they have collided with an obstacle.
     */
    public void positionUpdateBullet(ArrayList<Bullet> bullets, ArrayList<Obstacle> obstacles, float deltaTime) {
        for (int i = 0; i < bullets.size(); i++) {
            tempBullet = bullets.get(i);
            tempBullet.body.setXPosition(tempBullet.body.getXPosition() + tempBullet.body.getMovementSpeed()*deltaTime);
            bullets.set(i, tempBullet);

            if(obstacles.isEmpty()){
                break;
            }
            else{
            for (int j = 0; j < obstacles.size(); j++)
            if (detector.hasCollided(bullets.get(i), obstacles.get(j))) { //FIX THE PARAM
                destroyBullet(bullets, i);
            }
            }
        }
    }

    /**
     * Checks if an instance of Bullet has collided with another object
     *
     * @param bullet
     * @return true if collision with object has occurred and false if it has not.
     */




    /**
     * Removes an element from ArrayList Bullets when called upon.
     *
     * @param bullets
     * @param i
     */
    public void destroyBullet(ArrayList<Bullet> bullets, int i) {
        bullets.remove(i);
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
    public float getMovementspeed(){return this.body.getMovementSpeed();}

}

