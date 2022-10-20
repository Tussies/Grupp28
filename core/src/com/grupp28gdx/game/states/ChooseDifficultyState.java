package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.grupp28gdx.game.input.MenuInputHandler;

/**
 * This class is the state that comes after pressing "New Game" in the menu state.
 * It gives the user three options of what mode to play: easy, normal, or hard.
 */
public class ChooseDifficultyState extends State{
    private final Texture background;
    private final Texture easyButton;
    private final Texture easyButtonPressed;
    private final Texture normalButton;
    private final Texture normalButtonPressed;
    private final Texture hardButton;
    private final Texture hardButtonPressed;
    private final Texture bluePlayer;
    private final Texture greenPlayer;
    private final Texture redPlayer;
    private final int screenHeight;
    private final int screenWidth;
    private final int halfButtonHeight;
    private final int halfButtonWidth;
    private final int spriteWidth;
    private final int x;
    private final int y;

    protected ChooseDifficultyState(GameStateManager gsm){
        super(gsm);
        background = new Texture("Pick player.png");
        easyButton = new Texture("Easybutton.png");
        easyButtonPressed = new Texture("EasybuttonPressed.png");
        normalButton = new Texture("Normalbutton.png");
        normalButtonPressed = new Texture("NormalbuttonPressed.png");
        hardButton = new Texture("Hardbutton.png");
        hardButtonPressed = new Texture("HardbuttonPressed.png");
        bluePlayer = new Texture("blueplayer.png");
        greenPlayer = new Texture("greenplayer.png");
        redPlayer = new Texture("redplayer.png");

        this.screenWidth = Gdx.graphics.getWidth();
        this.screenHeight = Gdx.graphics.getHeight();
        this.halfButtonWidth = normalButton.getWidth()/2;
        this.halfButtonHeight = normalButton.getHeight()/2;
        this.spriteWidth = bluePlayer.getWidth();
        this.x = screenWidth/2;
        this.y = screenHeight/2;
    }


    private void hover(Texture texture, int x, int y){
        this.rv.render(texture, x, y);
    }

    /**
     * This is a method for handling mouse input of the user, and starting a new play state depending on what is clicked.
     * Can either start a new game on easy mode, normal mode, or hard mode.
     */
    @Override
    protected void handleInput() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();
        if (inputX < x + halfButtonWidth && inputX > x - halfButtonWidth && inputY > 4*y/3 + halfButtonHeight && inputY < 4*y/3 + 3* halfButtonHeight) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm,1));
                dispose();
            }
        }
        if (inputX < x/2 + halfButtonWidth && inputX > x/2 - halfButtonWidth && inputY > 4*y/3 + halfButtonHeight && inputY < 4*y/3 + 3* halfButtonHeight) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm,2));
                dispose();
            }
        }
        if (inputX < x*3/2 + halfButtonWidth && inputX > x*3/2 - halfButtonWidth && inputY > 4*y/3 + halfButtonHeight && inputY < 4*y/3 + 3* halfButtonHeight) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm,3));
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

        rv.render(background,0 ,0, screenWidth, screenHeight);

        rv.render(greenPlayer, x - spriteWidth/2, y*2/3);

        rv.render(redPlayer,x/2 - spriteWidth/2,y*2/3);

        rv.render(bluePlayer,x*3/2 - spriteWidth/2,y*2/3);

        rv.render(normalButton,x-halfButtonWidth,y/3);
        if (inputX < x + halfButtonWidth && inputX > x - halfButtonWidth && inputY > 4*y/3 + halfButtonHeight && inputY < 4*y/3 + 3* halfButtonHeight){
            hover(normalButtonPressed, x - halfButtonWidth, y/3);
        }

        rv.render(easyButton,x/2 - halfButtonWidth,y/3);
        if (inputX < x/2 + halfButtonWidth && inputX > x/2 - halfButtonWidth && inputY > 4*y/3 + halfButtonHeight && inputY < 4*y/3 + 3* halfButtonHeight){
            hover(easyButtonPressed, x/2 - halfButtonWidth, y/3);
        }

        rv.render(hardButton,x*3/2 - halfButtonWidth,y/3);
        if (inputX < x*3/2 + halfButtonWidth && inputX > x*3/2 - halfButtonWidth && inputY > 4*y/3 + halfButtonHeight && inputY < 4*y/3 + 3* halfButtonHeight){
            hover(hardButtonPressed, x*3/2 - halfButtonWidth, y/3);
        }
    }

    /**
     * Dispose-method for getting rid of Textures.
     */
    @Override
    public void dispose() {
        background.dispose();
        normalButton.dispose();
        normalButtonPressed.dispose();
        easyButton.dispose();
        easyButtonPressed.dispose();
        hardButton.dispose();
        hardButtonPressed.dispose();
        bluePlayer.dispose();
        redPlayer.dispose();
        greenPlayer.dispose();
    }
}
