package com.grupp28gdx.game.handlers;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Coin;

public class CoinHandler extends SpawnHandler{

    protected Array<Coin> itemArray = new Array<>();

    public Array<Coin> getCoin(){
        return itemArray;
    }

    @Override
    public void generate(float posX, float posY) {
        int n = 1 - numberOfSpawnableItems + 1;
        int i = rand.nextInt() % n;
        int randomNum = 1 + i;
        switch (randomNum) {
            case 1:
                System.out.println("Coin added to array");
                itemArray.add(new Coin());
        }
    }

    @Override
    public void update(float posX, float posY) {

    }
}
