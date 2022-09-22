package com.grupp28gdx.game.obstacles;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.grupp28gdx.game.Actor;

public abstract class Obstacle extends Actor {
    protected String typeOfObstacle;
    protected int obstacleDifficutly;
    protected PolygonShape bodyShape;
    protected float posX;
    protected float posY;
    protected BodyDef bodyDef;
    protected Body body;
    public Obstacle(){
        posX = this.getX_position();
        posY = this.getY_position();
    }
    public PolygonShape getBodyShape(){
        return bodyShape;
    }
    public BodyDef getBodyDef(){return bodyDef;}
    public Body getBody(){return body;}

    public String getTypeOfObstacle(){
        return typeOfObstacle;
    }

    public void setPosX(float value){
        this.posX = value;
    }

    public void setPosy(int value){
        this.posY = value;
    }

    public abstract void setBody(Body body);
}

