package com.grupp28gdx.game.Model;
/**
 * This is the concrete easy mode factory. It produces easier versions of the standard type of objects.
 * This includes all objects in the game, namely player, coins and obstacles.
 */
public class EasyModeFactory implements ModeFactory{
    @Override
    public Player createPlayer() {
        return new OrangePlayer();
    }

    @Override
    public Coin createCoin() {
        return new BigCoin();
    }

    @Override
    public Obstacle createObstacle(float spawnX,float spawnY) {
        return new PermanentObstacle(spawnX,spawnY);
    }
}
