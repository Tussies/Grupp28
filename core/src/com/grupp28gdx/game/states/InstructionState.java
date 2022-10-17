package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class InstructionState extends State {
    private Texture background;
    private int screenHeight;
    private int screenWidth;

    protected InstructionState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("nebulaset1.png");
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render() {
        rc.render(background,0 ,0, screenWidth, screenHeight);

    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
