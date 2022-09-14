package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
        playButton = new Texture("New Game button.png");
        exitButton = new Texture("Exit button.png");
        optionButton = new Texture("Options button.png");
        background = new Texture("nebulaset1.png");
        playButtonPressed = new Texture("New Game button Pressed.png");
        exitButtonPressed = new Texture("Exit button Pressed.png");
        optionButtonPressed = new Texture("Options button Pressed.png");

    }

    public void hover(SpriteBatch sb, Texture x,int y){
        sb.draw(x,(Gdx.graphics.getWidth()/2) - (playButton.getWidth()/2), Gdx.graphics.getHeight()/y);
    }

    @Override
    public void handleInput() {
        int x = Gdx.graphics.getWidth() / 2 - playButton.getWidth();
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/2 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/2) {
            if (Gdx.input.isTouched()) {
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
        int x = Gdx.graphics.getWidth() / 2 - playButton.getWidth();

        sb.begin();
        sb.draw(background,0 ,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(playButton, (Gdx.graphics.getWidth()/2) - (playButton.getWidth()/2), Gdx.graphics.getHeight()/2);
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/2 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/2) {
            hover(sb, playButtonPressed, 2);
        }
        sb.draw(optionButton,(Gdx.graphics.getWidth()/2) - (optionButton.getWidth()/2),Gdx.graphics.getHeight()/3);
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/3 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/3) {
            hover(sb, optionButtonPressed,3);
        }
            sb.draw(exitButton,(Gdx.graphics.getWidth()/2) - (optionButton.getWidth()/2),Gdx.graphics.getHeight()/6);
        if (Gdx.input.getX() < x + playButton.getWidth() && Gdx.input.getX() > x && Gdx.graphics.getHeight() - Gdx.input.getY() < playButton.getHeight() + Gdx.graphics.getHeight()/6 && Gdx.graphics.getHeight() - Gdx.input.getY() > Gdx.graphics.getHeight()/6) {
            hover(sb, exitButtonPressed,6);

        }
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
