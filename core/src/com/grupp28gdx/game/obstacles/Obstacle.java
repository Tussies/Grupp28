package com.grupp28gdx.game.obstacles;

import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.grupp28gdx.game.Actor;

public abstract class Obstacle extends Actor {
    private String typeOfObstacle;
    private int obstacleDifficutly;
    private PolygonShape body;
    private int posX;
    private int posY;
    public Obstacle(){
        posX = this.getX_position();
        posY = this.getY_position();
    }
    public PolygonShape getBody(){
        return body;
    }

    public String getTypeOfObstacle(){
        return typeOfObstacle;
    }

    public void setPosX(int value){
        this.posX = value;
    }

    public void setPosy(int value){
        this.posY = value;
    }

    }

