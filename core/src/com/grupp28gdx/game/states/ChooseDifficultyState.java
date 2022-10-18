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
    private Texture blueplayer;
    private Texture greenplayer;
    private Texture redplayer;
    private int screenHeight;
    private int screenWidth;
    private int buttonHeight;
    private int buttonWidth;
    private int spriteWidth;

    private int x;
    private int y;

    protected ChooseDifficultyState(GameStateManager gsm){
        super(gsm);
        background = new Texture("Pick player.png");
        easyButton = new Texture("Easybutton.png");
        easyButtonPressed = new Texture("EasybuttonPressed.png");
        normalButton = new Texture("Normalbutton.png");
        normalButtonPressed = new Texture("NormalbuttonPressed.png");
        hardButton = new Texture("Hardbutton.png");
        hardButtonPressed = new Texture("HardbuttonPressed.png");
        blueplayer = new Texture("blueplayer.png");
        greenplayer = new Texture("greenplayer.png");
        redplayer = new Texture("redplayer.png");

        this.screenWidth = Gdx.graphics.getWidth();
        this.screenHeight = Gdx.graphics.getHeight();
        this.buttonWidth = normalButton.getWidth();
        this.buttonHeight = normalButton.getHeight();
        this.spriteWidth = blueplayer.getWidth();
        this.x = screenWidth/2;
        this.y = screenHeight/2;
    }

    public void hover(Texture texture, int x, int y){
    int posX = x;
    int posY = y;
    this.rc.render(texture, posX, posY);
    }

    @Override
    protected void handleInput() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();
        if (inputX < x + buttonWidth/2 && inputX > x - buttonWidth/2 && inputY > 4*y/3 + buttonHeight/2 && inputY < 4*y/3 + 3*buttonHeight/2) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }
        if (inputX < x/2 + buttonWidth/2 && inputX > x/2 - buttonWidth/2 && inputY > 4*y/3 + buttonHeight/2 && inputY < 4*y/3 + 3*buttonHeight/2) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm));
                dispose();
            }
        }
        if (inputX < x*3/2 + buttonWidth/2 && inputX > x*3/2 - buttonWidth/2 && inputY > 4*y/3 + buttonHeight/2 && inputY < 4*y/3 + 3*buttonHeight/2) {
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

        rc.render(greenplayer, x - spriteWidth/2, y*2/3);

        rc.render(redplayer,x/2 - spriteWidth/2,y*2/3);

        rc.render(blueplayer,x*3/2 - spriteWidth/2,y*2/3);

        rc.render(normalButton,x-buttonWidth/2,y/3);
        if (inputX < x + buttonWidth/2 && inputX > x - buttonWidth/2 && inputY > 4*y/3 + buttonHeight/2 && inputY < 4*y/3 + 3*buttonHeight/2){
            hover(normalButtonPressed, x - buttonWidth/2, y/3);
        }

        rc.render(easyButton,x/2 - buttonWidth/2,y/3);
        if (inputX < x/2 + buttonWidth/2 && inputX > x/2 - buttonWidth/2 && inputY > 4*y/3 + buttonHeight/2 && inputY < 4*y/3 + 3*buttonHeight/2){
            hover(easyButtonPressed, x/2 - buttonWidth/2, y/3);
        }

        rc.render(hardButton,x*3/2 - buttonWidth/2,y/3);
        if (inputX < x*3/2 + buttonWidth/2 && inputX > x*3/2 - buttonWidth/2 && inputY > 4*y/3 + buttonHeight/2 && inputY < 4*y/3 + 3*buttonHeight/2){
            hover(hardButtonPressed, x*3/2 - buttonWidth/2, y/3);
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
