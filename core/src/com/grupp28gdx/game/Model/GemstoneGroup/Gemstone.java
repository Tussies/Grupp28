package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;

public interface Gemstone {
    Gemstone createGemstone();
    void updateGemCounter();
    float getSideLength();
    Body getBody();
}
