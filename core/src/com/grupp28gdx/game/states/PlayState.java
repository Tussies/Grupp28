package com.grupp28gdx.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.Controller.ObstacleAdapter;
import com.grupp28gdx.game.Model.*;
import com.grupp28gdx.game.handlers.ObstacleHandler;
import com.grupp28gdx.game.input.PlayInputHandler;
import com.grupp28gdx.game.render.Hud;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

/**
 * This class is the play state, which is used for showing the play-state of the game in the view.
 * The play-state shows the actual game that the user plays.
 */
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

    private final AssetManager assetManager = new AssetManager();

    private Vector2 backgroundPosition1, backgroundPosition2;
    private ObstacleHandler obstacleHandler;

    private OrthographicCamera cam;
    private Hud hud;

    private CollisionDetector collisionDetector;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam = new OrthographicCamera();
        backgroundPosition1 = new Vector2(cam.position.x - cam.viewportWidth/2 - 500, -300);
        backgroundPosition2 = new Vector2((cam.position.x - cam.viewportWidth/2) - 500 + w, -300);
        world = new World(new Vector2(0, 0), true);
        collisionDetector = new CollisionDetector();
        player = new GreenPlayer();
        this.playInput = new PlayInputHandler(player);
        ground = createGround();
        debugRenderer = new Box2DDebugRenderer();
        rc.renderBirdMusic();

        cam.setToOrtho(false, w/2, h/2);

        setInputProcessor(playInput);
        hud = new Hud();
        obstacleHandler = new ObstacleHandler(world,rc,new EasyModeFactory());

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
        shape.setAsBox(1000/pixelsPerMeter, 30/pixelsPerMeter);

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
        player.playerUpdate(delta);

        ground.setTransform(player.getBody().getXPosition()*2,1, 0);
        obstacleHandler.update(Math.round(player.getBody().getXPosition()),0.5f);
        hud.updateScore(Math.round(player.getBody().getXPosition()));

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) player.jump();

        if(collisionDetector.hasCollided(player,1f)){
            player.collisionGroundBegin();
        }else player.collisionGroundEnd();

        for(ObstacleAdapter obstacle : obstacleHandler.getObstacles()){
            if(collisionDetector.hasCollided(player,obstacle)) System.out.println("Collision");
        }
    }

    public void cameraUpdate() {
        Vector3 position = cam.position;
        position.x = player.getBody().getXPosition()*64;
        position.y = player.getBody().getYPosition()*64;

        rc.updateCamera(cam,position);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cameraUpdate();

        update(Gdx.graphics.getDeltaTime());
        rc.setProjectionMatrix(cam.combined);
        rc.render(assetManager.getBackground(), backgroundPosition1.x, backgroundPosition1.y, w, h);
        rc.render(assetManager.getBackground(), backgroundPosition1.x, backgroundPosition1.y, w, h);
        rc.render(assetManager.getBackground(), backgroundPosition2.x, backgroundPosition2.y, w, h);
        rc.debugRender(debugRenderer,world,cam,pixelsPerMeter);
        updatePlayerTexture();
        rc.render(hud);

    }

    private void updatePlayerTexture() {
        int animationFrame = Math.round(frame);
        switch (player.getStateOfPlayer().toString()) {
            case "walking":
                frame += 0.1;
                frame = frame % 60;
                animationFrame = animationFrame % 5;
                rc.render(assetManager.getGreenAlienWalkingAnimation()[animationFrame],
                        player.getBody().getXPosition() * 64 - (assetManager.getGreenAlienWalkingAnimation()[1].getWidth()/8f),
                        player.getBody().getYPosition() * 64, 200/4f, 422/4f);
                break;
            case "jumping":
                frame += 0.1;
                frame = frame % 60;

                if(player.getBody().getForceY() == 180){ frame = 0; animationFrame=0;}
                animationFrame = animationFrame % 4;

                rc.render(assetManager.getGreenAlienJumpingAnimation()[animationFrame],
                        player.getBody().getXPosition() * pixelsPerMeter - (assetManager.getGreenAlienJumpingAnimation()[1].getWidth()/8f),
                        player.getBody().getYPosition() * pixelsPerMeter - 30, 250/4f, 422/4f);
                break;
        }
    }

    @Override
    public void dispose() {
        assetManager.getBackground().dispose();
        world.dispose();
        debugRenderer.dispose();
        for (Texture texture : assetManager.getGreenAlienWalkingAnimation()){
            texture.dispose();
        }
        for (Texture texture : assetManager.getGreenAlienJumpingAnimation()){
            texture.dispose();
        }
    }
}
