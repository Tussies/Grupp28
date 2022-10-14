package com.grupp28gdx.game.Model.Guns;

import com.grupp28gdx.game.Model.Body;

public class Bullet {
    private Body body;

    public Bullet(float xPos, float yPos, float speed){ //Speed should be int as soon a
        this.body.setXPosition(xPos);
        this.body.setYPosition(yPos);
        this.body.setMovementSpeed(speed);
    }
}
