package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.Player;

public interface Gemstone {
    Gemstone createGemstone();
    void updateGemCounter();
    float getSideLength();
    Body getBody();
}
