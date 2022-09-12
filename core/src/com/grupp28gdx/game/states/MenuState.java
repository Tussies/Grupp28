package com.grupp28gdx.game.states;


import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
        background = new Texture("nebulaset1.png");


    }

    @Override
    public void handleInput() {
/*       if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }*/
        int x = Gdx.graphics.getWidth() / 2 - playButton.getWidth();
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/2 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/2) {
            if (Gdx.input.isTouched()){
                gsm.set(new PlayState(gsm));
                System.out.println("Play game button pressed");
                dispose();
            }
        }
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/3 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/3) {
            if (Gdx.input.isTouched()){
                // gsm.set(new OptionState());
                System.out.println("Option button pressed");
                dispose();
            }
        }
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/6 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/6) {
            if (Gdx.input.isTouched()){
                System.out.println("Exit game button pressed");
                Gdx.app.exit();
                dispose();
            }
        }
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

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        optionButton.dispose();
        exitButton.dispose();
    }
}
