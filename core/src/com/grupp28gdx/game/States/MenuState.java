package com.grupp28gdx.game.States;

import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grupp28gdx.game.Grupp28GDX;

public class MenuState extends State{
    private Texture background;
    private Texture playButton;
    private Texture optionButton;
    private Texture exitButton;
    public MenuState(GameStateManager gsm){
        super(gsm);
        background =  new Texture("Background.png");
        playButton = new Texture("New Game button.png");
        exitButton = new Texture("Exit button.png");
        optionButton = new Texture("Options button.png");


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
        //if(Gdx.input.justTouched()){
        //    gsm.set(new Grupp28GDX(gsm));
        //}
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0 ,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(playButton, (Gdx.graphics.getWidth()/2) - (playButton.getWidth()/2), Gdx.graphics.getHeight()/2);
        sb.draw(optionButton,(Gdx.graphics.getWidth()/2) - (optionButton.getWidth()/2),Gdx.graphics.getHeight()/3);
        sb.draw(exitButton,(Gdx.graphics.getWidth()/2) - (optionButton.getWidth()/2),Gdx.graphics.getHeight()/6);
        sb.end();
    }
}
