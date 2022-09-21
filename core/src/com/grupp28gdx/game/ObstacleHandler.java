package com.grupp28gdx.game;

//<<external>>
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.obstacles.*;

import java.io.ObjectStreamException;
import java.util.Random;

public class ObstacleHandler {
    private Random rand = new Random();
    private int numerOfSpawnableObstacles = 1;
    private Array<Obstacle> obstacleArray = new Array<>();
    public ObstacleHandler(){
        ;
    }

    public void generateObstacle(){
        int n = 1-numerOfSpawnableObstacles+1;
        int i = rand.nextInt() % n;
        int randomNum = 1 + i;
        switch (randomNum){
            case 1:System.out.println("Test"); obstacleArray.add(new Spike(0,0));
        }

        }
    public Array<Obstacle> getObstacles(){
        return obstacleArray;
    }

    }


