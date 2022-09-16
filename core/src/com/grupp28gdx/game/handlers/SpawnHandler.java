package com.grupp28gdx.game.handlers;

import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Coin;

import java.util.Random;

public abstract class SpawnHandler {
    protected Random rand = new Random();
    protected int numberOfSpawnableItems = 1;

    protected abstract void generate();


}
