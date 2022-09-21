package com.grupp28gdx.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.grupp28gdx.game.handlers.CoinHandler;
import com.grupp28gdx.game.Player;
import com.grupp28gdx.game.input.PlayInputHandler;
import com.grupp28gdx.game.render.RenderController;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

public class PlayState extends State {

    Box2DDebugRenderer debugRenderer;
    private World world;
    private Body ground;
    private Player player;
    private Body playerBody;
    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private Texture background;
    private Vector2 backgroundPosition1, backgroundPosition2;
    private boolean isPaused = false;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("nebulaset1.png");
        backgroundPosition1 = new Vector2(cam.position.x - cam.viewportWidth/2 - 500, -300);
        backgroundPosition2 = new Vector2((cam.position.x - cam.viewportWidth/2) - 500 + w, -300);
        world = new World(new Vector2(0, -9.8f), true);
        player = new Player(this.world);
        this.playInput = new PlayInputHandler(player);
        playerBody = player.getPlayerBody();
        ground = createGround();
        debugRenderer = new Box2DDebugRenderer();

        cam.setToOrtho(false, w/2, h/2);

        setInputProcessor(playInput);
    }


    private void updateBackground() {
        if(cam.position.x - (cam.viewportWidth / 2) > backgroundPosition1.x + w)
            backgroundPosition1.add(w * 2, 0);
        if(cam.position.x - (cam.viewportWidth / 2) > backgroundPosition2.x + w)
            backgroundPosition2.add(w * 2, 0);
    }

    public Body createGround() {
        BodyDef definition = new BodyDef();
        definition.type = BodyDef.BodyType.StaticBody;
        definition.position.set(0,0);
        definition.fixedRotation = true;
        ground = world.createBody(definition);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(10000/pixelsPerMeter, 30/pixelsPerMeter);

        ground.createFixture(shape, 1.0f);
        shape.dispose();

        return ground;
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float delta) {
        world.step(1/60f, 6,2);
        updateBackground();
        player.playerMovementUpdate(delta);
        cameraUpdate(delta);
    }

    public void cameraUpdate(float delta) {
        Vector3 position = cam.position;
        position.x = playerBody.getPosition().x * pixelsPerMeter;
        position.y = playerBody.getPosition().y * pixelsPerMeter;

        rc.updateCamera(cam,position);
    }

    @Override
    public void render(SpriteBatch sb) {
        if (!isPaused) {
            Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            update(Gdx.graphics.getDeltaTime());
            sb.setProjectionMatrix(cam.combined);
            rc.render(sb, background, backgroundPosition1.x, backgroundPosition1.y, w, h);
            rc.render(sb, background, backgroundPosition1.x, backgroundPosition1.y, w, h);
            rc.render(sb, background, backgroundPosition2.x, backgroundPosition2.y, w, h);
            rc.debugRender(debugRenderer, world, cam, pixelsPerMeter);
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        world.dispose();
        debugRenderer.dispose();
    }
}
