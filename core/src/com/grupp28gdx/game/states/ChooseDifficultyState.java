package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.grupp28gdx.game.input.MenuInputHandler;

public class ChooseDifficultyState extends State{
    private Texture background;
    private Texture easyButton;
    private Texture easyButtonPressed;
    private Texture normalButton;
    private Texture normalButtonPressed;
    private Texture hardButton;
    private Texture hardButtonPressed;
    private int screenHeight;
    private int screenWidth;

    private int x;
    private int y;

    protected ChooseDifficultyState(GameStateManager gsm){
        super(gsm);
        background = new Texture("Pick player.png");
        easyButton = new Texture("EASY.png");
        easyButtonPressed = new Texture("EASY pressed.png");
        normalButton = new Texture("NORMAL.png");
        normalButtonPressed = new Texture("NORMAL pressed.png");
        hardButton = new Texture("HARD.png");
        hardButtonPressed = new Texture("HARD pressed.png");

        this.screenWidth = Gdx.graphics.getWidth();
        this.screenHeight = Gdx.graphics.getHeight();

        this.x = screenWidth/2;
        this.y = screenHeight/2;
    }

    public void hover(Texture texture, int x, int y){
        this.rc.render(texture, x, y);
    }

    @Override
    protected void handleInput() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();
        if (inputX < x + 20 && inputX > x - 20 && inputY < screenHeight + 40 && inputY > screenHeight - 40) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }
        if (inputX < x + 80 && inputX > x + 60 && inputY < screenHeight + 40 && inputY > screenHeight - 40) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }
        if (inputX < x - 80 && inputX > x - 60 && inputY < screenHeight + 40 && inputY > screenHeight - 40) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();

        rc.render(background,0 ,0, screenWidth, screenHeight);
    }

    @Override
    public void dispose() {

    }
}
