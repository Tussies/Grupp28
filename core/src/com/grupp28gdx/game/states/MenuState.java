package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grupp28gdx.game.input.InputHandler;
import com.grupp28gdx.game.input.MenuInputHandler;

public class MenuState extends State{
    private Texture background;
    private Texture playButton;
    private Texture optionButton;
    private Texture exitButton;
    private Texture playButtonPressed;
    private Texture optionButtonPressed;
    private Texture exitButtonPressed;
    private MenuInputHandler menuInput;
    private int playButtonWidth;
    private int playButtonHeight;
    private int screenHeight;
    private int screenWidth;
    private int x;

    public MenuState(GameStateManager gsm){
        super(gsm);
        this.menuInput = new MenuInputHandler();
        setInputProcessor(menuInput);
        playButton = new Texture("New Game button.png");
        exitButton = new Texture("Exit button.png");
        optionButton = new Texture("Options button.png");
        background = new Texture("nebulaset1.png");
        playButtonPressed = new Texture("New Game button Pressed.png");
        exitButtonPressed = new Texture("Exit button Pressed.png");
        optionButtonPressed = new Texture("Options button Pressed.png");

        this.playButtonWidth = playButton.getWidth();
        this.playButtonHeight = playButton.getHeight();
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();
        this.x = screenWidth/2 - playButtonWidth/2;
    }

    public void hover(Texture texture, int y, int screenWidth, int buttonWidth, int screenHeight){
        int posX = (screenWidth/2) - (buttonWidth/2);
        int posY = screenHeight/y;
        this.rc.render(texture, posX, posY);
    }

    @Override
    public void handleInput() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/2 && screenHeight - inputY > screenHeight/2) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/3 && screenHeight - inputY > screenHeight/3) {
            if (Gdx.input.isTouched()){
                // gsm.set(new OptionState());
                dispose();
            }
        }
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/6 && screenHeight - inputY > screenHeight/6) {
            if (Gdx.input.isTouched()){
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
    public void render() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();

        rc.render(background,0 ,0, screenWidth, screenHeight);
        rc.render(playButton, (screenWidth/2) - (playButtonWidth/2), screenHeight/2);
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/2 && screenHeight - inputY > screenHeight/2) {
            hover(playButtonPressed, 2,screenWidth,playButtonWidth,screenHeight);
        }
        rc.render(optionButton,(screenWidth/2) - (playButtonWidth/2),screenHeight/3);
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/3 && screenHeight - inputY > screenHeight/3) {
            hover(optionButtonPressed,3,screenWidth,playButtonWidth,screenHeight);
        }
        rc.render(exitButton,(screenWidth/2) - (playButtonWidth/2),screenHeight/6);
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/6 && screenHeight - inputY > screenHeight/6) {
            hover(exitButtonPressed,6,screenWidth,playButtonWidth,screenHeight);

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
