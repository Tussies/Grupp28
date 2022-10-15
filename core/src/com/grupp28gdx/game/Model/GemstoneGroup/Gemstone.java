package com.grupp28gdx.game.Model.GemstoneGroup;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.Player;

/**
 * This is the common interface for the different type of objects. There are three types of gem objects in the game
 * in total for the player to collect. If the player makes contact with a gem the point counter goes up.
 */
public interface Gemstone {
    Gemstone createGemstone();
    void updateGemCounter();
    float getSideLength();
    Body getBody();
}
