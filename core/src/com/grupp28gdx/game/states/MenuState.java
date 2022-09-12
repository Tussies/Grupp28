package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State{
    private Texture playButton;
    private Texture optionButton;
    private Texture exitButton;
    private Texture background;
    public MenuState(GameStateManager gsm){
        super(gsm);
        playButton = new Texture("New Game button.png");
        exitButton = new Texture("Exit button.png");
        optionButton = new Texture("Options button.png");
        background = new Texture("nebulaset1.png");


    }
    //private Texture playbutton;

    //private static final int NEW_GAME_BUTTON_WIDTH = 300;
    //private static final int NEW_GAME_BUTTON_HEIGHT = 150;
    //Texture playButtonInactive;

    //public MenuState () {
    //    playButtonInactive = new Texture("New Game button.png");
    //}

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(playButton,0,330);
        sb.draw(optionButton,0,180);
        sb.draw(exitButton,0,30);
        sb.end();
    }
}
