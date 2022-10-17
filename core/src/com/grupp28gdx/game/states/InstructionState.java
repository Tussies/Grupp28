package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.grupp28gdx.game.input.MenuInputHandler;

/**
 * State for Instructions, shows the player how to play the game, as well as the sprites and their corresponding difficulties.
 * Backbutton can be pressed to go back to menuState.
 */
public class InstructionState extends State {
    private Texture background;
    private Texture backbutton;
    private Texture backbuttonPressed;
    private int screenHeight;
    private int screenWidth;
    private int backButtonWidth;
    private int backButtonHeight;
    private int x;
    private int y;


    protected InstructionState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("Instruction.png");
        backbutton = new Texture("Backbutton.png");
        backbuttonPressed = new Texture("BackbuttonPressed.png");
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();
        this.backButtonWidth = backbutton.getWidth();
        this.backButtonHeight = backbutton.getHeight();
        this.x = 1092;
        this.y = 890;
    }

    public void hover(Texture texture, int x, int y){
        this.rc.render(texture, x, y);
    }

    /**
     * This is a method for handling mouse input of the user, and calling new states in the GameStateManager.
     * If the user presses Back-button, the programme will run menustate instead.
     */
    @Override
    protected void handleInput() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();
        if (inputX < x + backButtonWidth && inputX > x && screenHeight - inputY < backButtonHeight + 88/2 && screenHeight - inputY > 88/2) {
            if (Gdx.input.isTouched()){
                gsm.set(new MenuState(gsm));
                dispose();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    /**
     * Render method used to render Textures.
     * If the user hovers, a new Texture will be called to create a hover-effect.
     */
    @Override
    public void render() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();

        rc.render(background,0 ,0, screenWidth, screenHeight);
        rc.render(backbutton, 1092,30);
        if (inputX < x + backButtonWidth && inputX > x && screenHeight - inputY < backButtonHeight + 88/2 && screenHeight - inputY > 88/2) {
            hover(backbuttonPressed, 1092,30);
        }

    }

    /**
     * Dispose-method for getting rid of Textures.
     */
    @Override
    public void dispose() {
        background.dispose();
        backbutton.dispose();
        backbuttonPressed.dispose();
    }
}
