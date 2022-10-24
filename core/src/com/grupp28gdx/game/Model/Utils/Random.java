package com.grupp28gdx.game.Model.utils;

public class Random {
    private int max;
    private int last;

    // constructor that takes the max int
    public Random(int max){
        this.max = max;
        last = (int) (System.currentTimeMillis() % max);
    }

    // Note that the result can not be bigger then 32749
    public int nextInt(){
        last *= 5843;
        return last % max;
    }
}
