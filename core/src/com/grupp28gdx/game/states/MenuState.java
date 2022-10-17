package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.grupp28gdx.game.input.MenuInputHandler;

/**
 * This class is the menu state, which is used for showing the menu in the view.
 * The menu shows a set of options for the player to choose: New game, Options, and Exit game.
 */
public class MenuState extends State{
    private Texture background;
    private Texture playButton;
    private Texture instructionsButton;
    private Texture exitButton;
    private Texture playButtonPressed;
    private Texture instructionsButtonPressed;
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
        instructionsButton = new Texture("Instructions button.png");
        background = new Texture("nebulaset1.png");
        playButtonPressed = new Texture("New Game button Pressed.png");
        exitButtonPressed = new Texture("Exit button Pressed.png");
        instructionsButtonPressed = new Texture("Instructions button Pressed.png");

        this.playButtonWidth = playButton.getWidth();
        this.playButtonHeight = playButton.getHeight();
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();
        this.x = screenWidth/2 - playButtonWidth/2;
    }

    /**
     * This is a method for when the user hovers over a specific coordinate.
     * @param texture
     * @param y
     * @param screenWidth
     * @param buttonWidth
     * @param screenHeight
     */
    public void hover(Texture texture, int y, int screenWidth, int buttonWidth, int screenHeight){
        int posX = (screenWidth/2) - (buttonWidth/2);
        int posY = screenHeight/y;
        this.rc.render(texture, posX, posY);
    }

    /**
     * This is a method for handling mouse input of the user, and calling new states in the GameStateManager.
     * If the user presses new game-button it will start a new game.
     * If the user presses options-button, options will be shown.
     * If the user presses exit-button the programme will quit.
     */
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
                gsm.set(new InstructionState(gsm));
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

    /**
     * Render method used to render Textures.
     * If the user hovers, a new Texture will be called to create a hover-effect.
     */
    @Override
    public void render() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();

        rc.render(background,0 ,0, screenWidth, screenHeight);
        rc.render(playButton, (screenWidth/2) - (playButtonWidth/2), screenHeight/2);
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/2 && screenHeight - inputY > screenHeight/2) {
            hover(playButtonPressed, 2,screenWidth,playButtonWidth,screenHeight);
        }
        rc.render(instructionsButton,(screenWidth/2) - (playButtonWidth/2),screenHeight/3);
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/3 && screenHeight - inputY > screenHeight/3) {
            hover(instructionsButtonPressed,3,screenWidth,playButtonWidth,screenHeight);
        }
        rc.render(exitButton,(screenWidth/2) - (playButtonWidth/2),screenHeight/6);
        if (inputX < x + playButtonWidth && inputX > x && screenHeight - inputY < playButtonHeight + screenHeight/6 && screenHeight - inputY > screenHeight/6) {
            hover(exitButtonPressed,6,screenWidth,playButtonWidth,screenHeight);

        }
    }

    /**
     * Dispose-method for getting rid of Textures.
     */
    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        instructionsButton.dispose();
        exitButton.dispose();
    }
}
