package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.PlayerGroup.OrangePlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;

/**
 * This is the concrete easy mode factory. It produces easier versions of the standard type of objects.
 * This includes almost all objects in the game, namely player, coins and obstacles.
 */
public class EasyModeFactory implements ModeFactory {

    /**
     * This method implements the skeleton method of a player in ModeFactory.
     *
     * @return an OrangePlayer, which is an easier version of the default GreenPlayer.
     */
    @Override
    public Player createPlayer() {
        return new OrangePlayer();
    }

    /**
     * This method implements the skeleton method of a gemstone in ModeFactory.
     *
     * @return a BigGemstone, this gemstone returns lesser points and is
     * easier to gather than MediumGemstone.
     */
    @Override
    public Gemstone createGemstone() {
        return new BigGemstone();
    }

    /**
     * This method implements the skeleton method of an obstacle in ModeFactory.
     *
     * @param spawnX decides the x-position the wall obstacle will appear.
     * @param spawnY decides the y-position the wall obstacle will appear.
     * @return PermanentObstacle is the simplest version of an obstacle.
     * It is square shaped and cannot be destroyed.
     */
    @Override
    public Obstacle createObstacle(float spawnX, float spawnY) {
        return new PermanentObstacle(spawnX, spawnY);
    }
}
