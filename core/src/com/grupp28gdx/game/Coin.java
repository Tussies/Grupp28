package com.grupp28gdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;

public class Coin implements Spawnable {
    private int posX;
    private int posY;
    private float x_position;
    private float y_position;
    private int x_direction;
    private int y_direction;

    CircleShape coin;

    public Coin(){
        posX = (int) this.getX_position();
        posY = (int) this.getY_position();
        coin = new CircleShape();
        coin.setRadius(0.4f);
    }

    public void  setPosition(Vector2 v2){
        x_position = v2.x;
        y_position = v2.y;
    }

    public float getX_position(){return this.x_position;}
    public float getY_position(){return this.y_position;}
    public int getX_direction(){return this.x_direction;}
    public int getY_direction(){return this.y_direction;}

    public Shape getCoinBody(){
        return coin;
    }


}
