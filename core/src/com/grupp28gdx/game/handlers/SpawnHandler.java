package com.grupp28gdx.game.handlers;

import java.util.Random;

public abstract class SpawnHandler {
    protected Random rand = new Random();

    protected abstract void generate(float posX,float posY);

    public abstract void update(float posX, float posY);

    public abstract void react(int id);
}
