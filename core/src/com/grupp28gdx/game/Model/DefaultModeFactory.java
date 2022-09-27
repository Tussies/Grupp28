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
    public Coin createCoin() {
        return new MediumCoin();
    }

    @Override
    public Obstacle createObstacle() {
        return new WallObstacle();
    }
}
