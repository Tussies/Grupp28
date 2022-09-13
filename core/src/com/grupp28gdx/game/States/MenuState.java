package com.grupp28gdx.game.States;

import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grupp28gdx.game.Grupp28GDX;
import org.w3c.dom.Text;

public class MenuState extends State{
    private Texture background;
    private Texture playButton;
    private Texture optionButton;
    private Texture exitButton;
    private Texture playButtonPressed;
    private Texture optionButtonPressed;
    private Texture exitButtonPressed;
    public MenuState(GameStateManager gsm){
        super(gsm);
        background =  new Texture("Background.png");
        playButton = new Texture("New Game button.png");
        exitButton = new Texture("Exit button.png");
        optionButton = new Texture("Options button.png");
        playButtonPressed = new Texture("New Game button Pressed.png");
        exitButtonPressed = new Texture("Exit button Pressed.png");
        optionButtonPressed = new Texture("Options button Pressed.png");


    }

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

        int x = Gdx.graphics.getWidth() / 2 - playButton.getWidth();
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/2 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/2) {
            sb.draw(playButtonPressed,(Gdx.graphics.getWidth()/2) - (playButton.getWidth()/2), Gdx.graphics.getHeight()/2);
            if (Gdx.input.isTouched()){
                //gsm.set(new Grupp28GDX());
                System.out.println("Play game button pressed");
            }
        }
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/3 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/3) {
            sb.draw(optionButtonPressed,(Gdx.graphics.getWidth()/2) - (optionButton.getWidth()/2),Gdx.graphics.getHeight()/3);
            if (Gdx.input.isTouched()){
                // gsm.set(new OptionState());
                System.out.println("Option button pressed");
            }
        }
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/6 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/6) {
            sb.draw(exitButtonPressed,(Gdx.graphics.getWidth()/2) - (optionButton.getWidth()/2),Gdx.graphics.getHeight()/6);
            if (Gdx.input.isTouched()){
                System.out.println("Exit game button pressed");
                Gdx.app.exit();
            }
        }
        sb.end();
    }
}
