package com.grupp28gdx.game.Model;

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
    public Gemstone createCoin() {
        return new SmallGemstone();
    }

    @Override
    public Obstacle createObstacle() {
        return new DestroyableObstacle();
    }
}
