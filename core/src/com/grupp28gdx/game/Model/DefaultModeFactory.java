package com.grupp28gdx.game.Model;

/**
 * This is the concrete default mode factory. It produces all standard versions of objects, namely player,
 * obstacles and coins.
 */
public class DefaultModeFactory implements ModeFactory{
    @Override
    public Player createPlayer() {
        return new GreenPlayer();
    }

    @Override
    public Gemstone createCoin() {
        return new MediumGemstone();
    }

    @Override
    public Obstacle createObstacle(float spawnX,float spawnY) {
        return new WallObstacle(spawnX,spawnY);
    }
}
