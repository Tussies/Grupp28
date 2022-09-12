package com.grupp28gdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

public class PlayState extends State{

    Box2DDebugRenderer debugRenderer;
    private World world;
    private Body ground;
    private Texture background;
    private Vector2 backgroundPosition1, backgroundPosition2;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("nebulaset1.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0, 0);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
