package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;

/**
 * This is the concrete hard mode factory. It produces harder, or, more difficult versions
 * of the standard type of objects. This includes all objects in the game, namely player, coins and obstacles.
 */
public class HardModeFactory implements ModeFactory{
    @Override
    public Player createPlayer() {
        return new PurplePlayer();
    }

    @Override
    public Gemstone createGemstone() {
        return new SmallGemstone();
    }

    @Override
    public Obstacle createObstacle(float spawnX,float spawnY) {
        return new DestroyableObstacle();
    }
}
