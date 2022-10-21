package com.grupp28gdx.game.Model.Factories;

import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.Obstacles.DestroyableObstacle;
import com.grupp28gdx.game.Model.Obstacles.Obstacle;
import com.grupp28gdx.game.Model.Obstacles.PermanentObstacle;
import com.grupp28gdx.game.Model.Obstacles.SpikeObstacle;
import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.Utils.Random;

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
    public Gemstone createGemstone(float spawnX,float spawnY,int id) {
        Random rand = new Random(100);
        switch (rand.nextInt()%5){
            case 0:
                return new BigGemstone(spawnX,spawnY,id);
            case 1:
            case 2:
            case 3:
            case 4:
                return new MediumGemstone(spawnX,spawnY,id);
        }
        return null;

    }

    /**
     * This method implements the skeleton method of an obstacle in ModeFactory.
     * @param spawnX decides the x-position the wall obstacle will appear.
     * @param spawnY decides the y-position the wall obstacle will appear.
     * @return WallObstacle is a rectangular obstacle, the default obstacle in the game.
     * This obstacle cannot be destroyed.
     */
    @Override
    public Obstacle createObstacle(float spawnX, float spawnY, int id) {
        Random rand = new Random(100);
        switch (rand.nextInt()%5){
            case 0:
                return new DestroyableObstacle(spawnX,spawnY+1,id);
            case 1:
            case 2:
                return new SpikeObstacle(spawnX,spawnY,id);
            case 3:
            case 4:
                return new PermanentObstacle(spawnX,spawnY+1,id);
        }
        return null;

    }
}
