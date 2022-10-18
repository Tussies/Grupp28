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
    private int buttonWidth;

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
        this.buttonWidth = normalButton.getWidth();
        this.x = screenWidth/2 - buttonWidth/2;
        this.y = screenHeight/2 + 140;
    }

    public void hover(Texture texture, int x){
    int posX = this.x + x;
    int posY = y;
        this.rc.render(texture, posX, posY);
    }

    @Override
    protected void handleInput() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();
        if (inputX < x + buttonWidth && inputX > x ) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }
        if (inputX < screenWidth/4+buttonWidth/2 && inputX > screenWidth/4-buttonWidth/2 ) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }
        if (inputX < screenWidth*3/4+buttonWidth/2 && inputX > screenWidth*3/4-buttonWidth/2) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
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
        rc.render(normalButton,x,y);        //&& inputY < y + 40 && inputY > y - 40
        if (inputX < x + buttonWidth && inputX > x ){
            hover(normalButtonPressed, 0);
        }
        rc.render(easyButton,screenWidth/4-buttonWidth/2,y);
        if (inputX < screenWidth/4+buttonWidth/2 && inputX > screenWidth/4-buttonWidth/2 ){
            hover(easyButtonPressed, -screenWidth/4);
        }
        rc.render(hardButton,screenWidth*3/4,y);
        if (inputX < screenWidth*3/4+buttonWidth/2 && inputX > screenWidth*3/4-buttonWidth/2){
            hover(hardButtonPressed, screenWidth/4+buttonWidth/2);
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        normalButton.dispose();
        normalButtonPressed.dispose();
        easyButton.dispose();
        easyButtonPressed.dispose();
        hardButton.dispose();
        hardButtonPressed.dispose();
    }
}
