package com.grupp28gdx.game.Model;

public class VectorPosition {
    private float xPos;
    private float yPos;

    public VectorPosition(float x, float y){
        xPos = x;
        yPos = y;

    }

    public void setPos(float newXPos, float newYPos){
        this.xPos = newXPos;
        this.yPos = newYPos;
    }
    public float getxPos(){return this.xPos;}
    public float getyPos() {return this.yPos;}
}
