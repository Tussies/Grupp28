package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;

/**
 * This is the concrete default mode factory. It produces all standard versions of almost all objects, namely player,
 * obstacles and coins.
 */
public class DefaultModeFactory implements ModeFactory{

    /**
     * This method implements the skeleton method of a player in ModeFactory.
     * @return a GreenPlayer, which is the default player.
     */
    @Override
    public Player createPlayer() {
        return new GreenPlayer();
    }

    /**
     * This method implements the skeleton method of a gemstone in ModeFactory.
     * @return a MediumGemstome, which is the default gemstone.
     */
    @Override
    public Gemstone createGemstone(float spawnX,float spawnY) {
        return new MediumGemstone(spawnX, spawnY);
    }

    /**
     * This method implements the skeleton method of an obstacle in ModeFactory.
     * @param spawnX decides the x-position the wall obstacle will appear.
     * @param spawnY decides the y-position the wall obstacle will appear.
     * @return WallObstacle is a rectangular obstacle, the default obstacle in the game.
     * This obstacle cannot be destroyed.
     */
    @Override
    public Obstacle createObstacle(float spawnX,float spawnY) {
        return new WallObstacle(spawnX,spawnY);
    }
}
