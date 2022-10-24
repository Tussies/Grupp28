package com.grupp28gdx.game.View.states;

import com.badlogic.gdx.Gdx;
import com.grupp28gdx.game.Controller.input.InputHandler;
import com.grupp28gdx.game.View.render.RenderView;

/**
 * This is the state class that creates the basis of states in the game
 */
public abstract class State {
    protected GameStateManager gsm;
    protected RenderView rv;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
        rv = new RenderView();
    }

    protected void setInputProcessor(InputHandler inputHandler){
        Gdx.input.setInputProcessor(inputHandler);
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();
}
