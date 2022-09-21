package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.grupp28gdx.game.input.InputHandler;
import com.grupp28gdx.game.input.MenuInputHandler;
import com.grupp28gdx.game.input.PlayInputHandler;
import com.grupp28gdx.game.render.RenderController;

import java.awt.*;

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;
    protected RenderController rc;
    protected MenuInputHandler menuInput;
    protected PlayInputHandler playInput;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
        rc = new RenderController();;
        menuInput = new MenuInputHandler();
    }

    protected void setInputProcessor(InputHandler inputHandler){
        Gdx.input.setInputProcessor(inputHandler);
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void sendToRenderController(SpriteBatch sb);
    public abstract void dispose();
}
