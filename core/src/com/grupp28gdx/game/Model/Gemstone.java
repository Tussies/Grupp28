package com.grupp28gdx.game.Model;

public interface Gemstone {
    Gemstone createGemstone();
    void updateGemCounter(Player player);
    float getSideLength();
}
