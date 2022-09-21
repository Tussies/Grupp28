package com.grupp28gdx.game;

import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;

public class Coin extends Actor{
    private int posX;
    private int posY;
    CircleShape coin;

    public Coin(){
        posX = this.getX_position();
        posY = this.getY_position();
        coin = new CircleShape();
        coin.setRadius(0.4f);
    }

    public Shape getCoinBody(){
        return coin;
    }


}
