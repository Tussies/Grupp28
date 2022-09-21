package com.grupp28gdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Actor {
    private float x_position;
    private float y_position;
    private int x_direction;
    private int y_direction;

    public void  setPosition(Vector2 v2){
        x_position = v2.x;
        y_position = v2.y;
    }

    public float getX_position(){return this.x_position;}
    public float getY_position(){return this.y_position;}
    public int getX_direction(){return this.x_direction;}
    public int getY_direction(){return this.y_direction;}


    }
