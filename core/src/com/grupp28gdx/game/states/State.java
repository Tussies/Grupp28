package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.grupp28gdx.game.input.InputHandler;
import com.grupp28gdx.game.render.RenderController;

/**
 * This is the state class that creates the basis of states in the game
 */
public abstract class State {
    protected GameStateManager gsm;
    protected RenderController rc;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
        rc = new RenderController();;
    }

    protected void setInputProcessor(InputHandler inputHandler){
        Gdx.input.setInputProcessor(inputHandler);
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();
}
