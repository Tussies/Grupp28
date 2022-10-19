package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.grupp28gdx.game.input.MenuInputHandler;

public class ChooseDifficultyState extends State{
    private final Texture background;
    private final Texture easyButton;
    private final Texture easyButtonPressed;
    private final Texture normalButton;
    private final Texture normalButtonPressed;
    private final Texture hardButton;
    private final Texture hardButtonPressed;
    private final Texture blueplayer;
    private final Texture greenplayer;
    private final Texture redplayer;
    private final int screenHeight;
    private final int screenWidth;
    private final int buttonHeight;
    private final int buttonWidth;
    private final int spriteWidth;
    private final int x;
    private final int y;
    private PlayState playstate;

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
        this.rc.render(texture, x, y);
    }

    @Override
    protected void handleInput() {
        int inputX = MenuInputHandler.checkInputX();
        int inputY = MenuInputHandler.checkInputY();
        if (inputX < x + buttonWidth/2 && inputX > x - buttonWidth/2 && inputY > 4*y/3 + buttonHeight/2 && inputY < 4*y/3 + 3*buttonHeight/2) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm,1));
                dispose();
            }
        }
        if (inputX < x/2 + buttonWidth/2 && inputX > x/2 - buttonWidth/2 && inputY > 4*y/3 + buttonHeight/2 && inputY < 4*y/3 + 3*buttonHeight/2) {
            if (Gdx.input.isTouched()) {
                gsm.set(new PlayState(gsm,2));
                dispose();
            }
        }
        if (inputX < x*3/2 + buttonWidth/2 && inputX > x*3/2 - buttonWidth/2 && inputY > 4*y/3 + buttonHeight/2 && inputY < 4*y/3 + 3*buttonHeight/2) {
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
        blueplayer.dispose();
        redplayer.dispose();
        greenplayer.dispose();
    }
}
