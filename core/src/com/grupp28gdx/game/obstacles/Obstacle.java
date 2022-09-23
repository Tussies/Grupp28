package com.grupp28gdx.game.obstacles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public abstract class Obstacle {
    protected String typeOfObstacle;
    protected int obstacleDifficutly;
    protected PolygonShape bodyShape;
    protected float posX;
    protected float posY;
    protected BodyDef bodyDef;
    protected Body body;
    private float x_position;
    private float y_position;
    private int x_direction;
    private int y_direction;

    public Obstacle(){
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

    public void  setPosition(Vector2 v2){
        x_position = v2.x;
        y_position = v2.y;
    }

    public float getX_position(){return this.x_position;}
    public float getY_position(){return this.y_position;}
    public int getX_direction(){return this.x_direction;}
    public int getY_direction(){return this.y_direction;}

    public abstract void setBody(Body body);
}

