package com.grupp28gdx.game.Model.Factories;

import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.Obstacles.DestroyableObstacle;
import com.grupp28gdx.game.Model.Obstacles.Obstacle;
import com.grupp28gdx.game.Model.Obstacles.SpikeObstacle;
import com.grupp28gdx.game.Model.PlayerGroup.OrangePlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.Utils.Random;

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
    public Gemstone createGemstone(float spawnX,float spawnY,int id) {
                return new BigGemstone(spawnX,spawnY,id);

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
    public Obstacle createObstacle(float spawnX, float spawnY, int id) {
        Random rand = new Random(100);
        switch (rand.nextInt()%5){
            case 0:
            case 3:
            case 4:
                return new DestroyableObstacle(spawnX,spawnY+1,id);
            case 1:
            case 2:
                return new SpikeObstacle(spawnX,spawnY,id);
        }
        return null;

    }
}
