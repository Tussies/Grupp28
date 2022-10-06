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
    public Gemstone createCoin() {
        return new BigGemstone();
    }

    @Override
    public Obstacle createObstacle() {
        return new PermanentObstacle();
    }
}
