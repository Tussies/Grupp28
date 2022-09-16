package com.grupp28gdx.game.handlers;

import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Coin;
import com.grupp28gdx.game.obstacles.*;

import java.io.ObjectStreamException;
import java.util.Random;

public class ObstacleHandler extends SpawnHandler{
    protected Array<Obstacle> itemArray = new Array<>();

    public ObstacleHandler(){
        ;
    }

    public Array<Obstacle> getObstacles(){
        return itemArray;
    }

    @Override
    protected void generate() {
        int n = 1-numberOfSpawnableItems+1;
        int i = rand.nextInt() % n;
        int randomNum = 1 + i;
        switch (randomNum){
            case 1:System.out.println("Test"); itemArray.add(new Spike(0,0));
        }
    }
}


