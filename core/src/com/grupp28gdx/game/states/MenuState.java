package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grupp28gdx.game.input.InputHandler;
import com.grupp28gdx.game.input.MenuInputHandler;
import com.grupp28gdx.game.input.PlayInputHandler;

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
        setInputProcessor(menuInput);
        playButton = new Texture("New Game button.png");
        exitButton = new Texture("Exit button.png");
        optionButton = new Texture("Options button.png");
        background = new Texture("nebulaset1.png");
        playButtonPressed = new Texture("New Game button Pressed.png");
        exitButtonPressed = new Texture("Exit button Pressed.png");
        optionButtonPressed = new Texture("Options button Pressed.png");

    }

    public void hover(SpriteBatch sb, Texture texture,int y,int screenWidth,int buttonWidth, int screenHeight){
        int posX =(screenWidth/2) - (buttonWidth/2);
        int posY = screenHeight/y;
        this.rc.render(sb,texture,posX,posY);
    }

    @Override
    public void handleInput() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();
        int playButtonWidth = playButton.getWidth();
        int playButtonHeight = playButton.getHeight();
        int screenHeight = Gdx.graphics.getHeight();
        int x = Gdx.graphics.getWidth() / 2 - playButtonWidth/2;

        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/2 && screenHeight - inputY > screenHeight/2) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
                System.out.println("Play game button pressed");
                dispose();
            }
        }
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/3 && screenHeight - inputY > screenHeight/3) {
            if (Gdx.input.isTouched()){
                // gsm.set(new OptionState());
                System.out.println("Option button pressed");
                dispose();
            }
        }
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/6 && screenHeight - inputY > screenHeight/6) {
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
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();
        int playButtonWidth = playButton.getWidth();
        int playButtonHeight = playButton.getHeight();
        int screenHeight = Gdx.graphics.getHeight();
        int screenWidth = Gdx.graphics.getWidth();

        int x = screenWidth / 2 - playButtonWidth/2;

        rc.render(sb,background,0 ,0, screenWidth, screenHeight);
        rc.render(sb,playButton, (screenWidth/2) - (playButtonWidth/2), screenHeight/2);
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/2 && screenHeight - inputY > screenHeight/2) {
            hover(sb, playButtonPressed, 2,screenWidth,playButtonWidth,screenHeight);
        }
        rc.render(sb,optionButton,(screenWidth/2) - (playButtonWidth/2),screenHeight/3);
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/3 && screenHeight - inputY > screenHeight/3) {
            hover(sb, optionButtonPressed,3,screenWidth,playButtonWidth,screenHeight);
        }
        rc.render(sb,exitButton,(screenWidth/2) - (playButtonWidth/2),screenHeight/6);
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/6 && screenHeight - inputY > screenHeight/6) {
            hover(sb, exitButtonPressed,6,screenWidth,playButtonWidth,screenHeight);

        }
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        optionButton.dispose();
        exitButton.dispose();
    }
}
