package com.grupp28gdx.game;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Coin;
import com.grupp28gdx.game.obstacles.Obstacle;
import com.grupp28gdx.game.obstacles.Spike;

import java.util.Random;

//This could come from the in the same parent Handler as ObstacleHandler, I just need to create one.
public class CoinHandler {
    private Random rand = new Random();
    private int numberOfSpawnableCoins = 1;
    private Array<Coin> coinArray = new Array<>();

    public void generateCoin() {
        int n = 1 - numberOfSpawnableCoins + 1;
        int i = rand.nextInt() % n;
        int randomNum = 1 + i;
        switch (randomNum) {
            case 1:
                System.out.println("Test");
                coinArray.add(new Coin());
        }

    }
    }
