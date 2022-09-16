package com.grupp28gdx.game.handlers;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Coin;

import java.util.Random;

public class CoinHandler extends SpawnHandler{

    protected Array<Coin> itemArray = new Array<>();


    @Override
    protected void generate() {
        int n = 1 - numberOfSpawnableItems + 1;
        int i = rand.nextInt() % n;
        int randomNum = 1 + i;
        switch (randomNum) {
            case 1:
                System.out.println("Coin added to array");
                itemArray.add(new Coin());
        }
    }
}
