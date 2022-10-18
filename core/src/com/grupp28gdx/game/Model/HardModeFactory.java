package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.PlayerGroup.PurplePlayer;

/**
 * This is the concrete hard mode factory. It produces harder, or, more difficult versions
 * of the standard type of objects. This includes almost all objects in the game, namely player, coins and obstacles.
 */
public class HardModeFactory implements ModeFactory{

    /**
     * This method implements the skeleton method of a player in ModeFactory.
     * @return a PurplePlayer, which is a harder version of the default GreenPlayer.
     */
    @Override
    public Player createPlayer() {
        return new PurplePlayer();
    }

    /**
     * This method implements the skeleton method of a gemstone in ModeFactory.
     * @return a SmallGemstone, this gemstone returns more points and is harder
     * to gather than MediumGemstone.
     */
    @Override
    public Gemstone createGemstone(float spawnX, float spawnY) {
        return new SmallGemstone(spawnX,spawnY);
    }
    
    /**
     * This method implements the skeleton method of an obstacle in ModeFactory.
     * @param spawnX decides the x-position the destroyable obstacle will appear.
     * @param spawnY decides the y-position the destroyable obstacle will appear.
     * @return DestroyableObject is the most difficult version of an obstacle to maneuver.
     * It can be destroyed if shot by a projectile of a gun.
     */
    @Override
    public Obstacle createObstacle(float spawnX,float spawnY) {
        return new DestroyableObstacle(spawnX,spawnY);
    }
}
