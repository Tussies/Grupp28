package com.grupp28gdx.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.grupp28gdx.game.BodyContactListener;
import com.grupp28gdx.game.Player;
import com.grupp28gdx.game.handlers.ObstacleHandler;
import com.grupp28gdx.game.input.PlayInputHandler;
import com.grupp28gdx.game.render.Hud;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

public class PlayState extends State {

    Box2DDebugRenderer debugRenderer;
    private World world;
    private Body ground;

    private Player player;
    private Body playerBody;
    private PlayInputHandler playInput;

    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private float frame;

    private Texture background;
    private Texture alien;
    private Texture[] playerWalkingAnimation = {
            new Texture("alien_walking_1.png"),
            new Texture("armor__0007_walk_2.png"),
            new Texture("armor__0008_walk_3.png"),
            new Texture("armor__0009_walk_4.png"),
            new Texture("armor__0010_walk_5.png"),
            new Texture("armor__0011_walk_6.png")};
    private Texture[] playerJumpingAnimation = {
            new Texture("armor__0027_jump_1.png"),
            new Texture("armor__0028_jump_2.png"),
            new Texture("armor__0028_jump_3.png"),
            new Texture("armor__0030_jump_4.png")};

    private Vector2 backgroundPosition1, backgroundPosition2;
    private ObstacleHandler obstacleHandler;

    private OrthographicCamera cam;
    private Hud hud;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("nebulaset1.png");
        cam = new OrthographicCamera();
        backgroundPosition1 = new Vector2(cam.position.x - cam.viewportWidth/2 - 500, -300);
        backgroundPosition2 = new Vector2((cam.position.x - cam.viewportWidth/2) - 500 + w, -300);
        world = new World(new Vector2(0, -9.8f), true);
        world.setContactListener(new BodyContactListener(this));
        player = new Player();
        this.playInput = new PlayInputHandler(player);
        playerBody = player.getPlayerBody();
        ground = createGround();
        debugRenderer = new Box2DDebugRenderer();
        rc.renderBirdMusic();

        cam.setToOrtho(false, w/2, h/2);

        setInputProcessor(playInput);
        hud = new Hud();
        obstacleHandler = new ObstacleHandler(world);

        frame = 0;
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
        shape.setAsBox(100/pixelsPerMeter, 20/pixelsPerMeter);

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
        ground.setTransform(player.getX_position(),0, 0);
        obstacleHandler.update(Math.round(player.getX_position()),0);
        hud.updateScore(Math.round(player.getX_position()));
    }

    public void cameraUpdate(float delta) {
        Vector3 position = cam.position;
        position.x = playerBody.getPosition().x * pixelsPerMeter;
        position.y = playerBody.getPosition().y * pixelsPerMeter;

        rc.updateCamera(cam,position);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        update(Gdx.graphics.getDeltaTime());
        rc.setProjectionMatrix(cam.combined);
        rc.render(background, backgroundPosition1.x, backgroundPosition1.y, w, h);
        rc.render(background, backgroundPosition1.x, backgroundPosition1.y, w, h);
        rc.render(background, backgroundPosition2.x, backgroundPosition2.y, w, h);
        rc.debugRender(debugRenderer,world,cam,pixelsPerMeter);
        updatePlayerTexture();
        rc.render(hud);

    }

    private void updatePlayerTexture() {
        int animationFrame = Math.round(frame);
        switch (player.getPlayerState()){
            case "walking":
                frame += 0.1;
                frame = frame % 60;
                animationFrame = animationFrame % 5;
                rc.render(playerWalkingAnimation[animationFrame], playerBody.getPosition().x * pixelsPerMeter - (playerWalkingAnimation[1].getWidth()/8f), playerBody.getPosition().y * pixelsPerMeter - 30, 200/4f, 422/4f);
                break;
            case "jumping":
                frame += 0.1;
                frame = frame % 60;
                System.out.println(player.getForceY());
                if(player.getForceY() == 180){ frame = 0; animationFrame=0;}
                animationFrame = animationFrame % 4;
                System.out.println(animationFrame);
                rc.render(playerJumpingAnimation[animationFrame], playerBody.getPosition().x * pixelsPerMeter - (playerJumpingAnimation[1].getWidth()/8f), playerBody.getPosition().y * pixelsPerMeter - 30, 250/4f, 422/4f);
                break;
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        world.dispose();
        debugRenderer.dispose();
        for (Texture texture : playerWalkingAnimation){
            texture.dispose();
        }
        for (Texture texture : playerJumpingAnimation){
            texture.dispose();
        }
    }
}
