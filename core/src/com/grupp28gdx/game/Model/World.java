package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Controller.handlers.GemstoneHandler;
import com.grupp28gdx.game.Controller.handlers.ObstacleHandler;
import com.grupp28gdx.game.Model.Factories.DefaultModeFactory;
import com.grupp28gdx.game.Model.Factories.EasyModeFactory;
import com.grupp28gdx.game.Model.Factories.HardModeFactory;
import com.grupp28gdx.game.Model.Factories.ModeFactory;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.Utils.CollisionDetector;

public class World {
    private ModeFactory modeFactory;

    private Player player;

    private ObstacleHandler obstacleHandler;
    private GemstoneHandler gemstoneHandler;

    private CollisionDetector collisionDetector;

    public World(int difficulty){
        setupGame(difficulty);
    }

    private void setupGame(int difficulty) {
        modeFactory = setFactories(difficulty);

        obstacleHandler = new ObstacleHandler(modeFactory);
        gemstoneHandler = new GemstoneHandler(modeFactory);

        player = modeFactory.createPlayer();

        collisionDetector = new CollisionDetector(obstacleHandler,gemstoneHandler,player.getGun(),player);
    }

    public void update(float delta){
        player.playerUpdate(delta);

        obstacleHandler.update(Math.round(player.getBody().getXPosition()),0.5f);
        gemstoneHandler.update(Math.round(player.getBody().getXPosition()),0.5f);

        collisionDetector.update();
    }

    private ModeFactory setFactories(int x){
        switch (x) {
            case 1:
                return new DefaultModeFactory();
            case 2:
                return new EasyModeFactory();
            case 3:
                return new HardModeFactory();
        }
        return null;
    }

    public Player getPlayer() {
        return player;
    }

    public ObstacleHandler getObstacleHandler() {
        return obstacleHandler;
    }

    public GemstoneHandler getGemstoneHandler() {
        return gemstoneHandler;
    }
}
