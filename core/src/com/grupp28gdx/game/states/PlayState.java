package com.grupp28gdx.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.grupp28gdx.game.Model.CollisionDetector;
import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.OrangePlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.PlayerGroup.PurplePlayer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.Controller.ObstacleAdapter;
import com.grupp28gdx.game.Model.*;
import com.grupp28gdx.game.handlers.GemstoneHandler;
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
    private PlayInputHandler playInput;

    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private float frame;
    private int x;

    private Texture background;
    private Texture alien;
    private Texture[] playerWalkingAnimationOrangePlayer = {
            new Texture("red__0006_walk_1.png"),
            new Texture("red__0007_walk_2.png"),
            new Texture("red__0008_walk_3.png"),
            new Texture("red__0009_walk_4.png"),
            new Texture("red__0010_walk_5.png"),
            new Texture("red__0011_walk_6.png")};
    private Texture[] playerJumpingAnimationOrangePlayer = {
            new Texture("red__0027_jump_1.png"),
            new Texture("red__0028_jump_2.png"),
            new Texture("red__0029_jump_3.png"),
            new Texture("red__0030_jump_4.png")};
    private Texture[] playerWalkingAnimationGreenPlayer = {
            new Texture("alien_walking_1.png"),
            new Texture("armor__0007_walk_2.png"),
            new Texture("armor__0008_walk_3.png"),
            new Texture("armor__0009_walk_4.png"),
            new Texture("armor__0010_walk_5.png"),
            new Texture("armor__0011_walk_6.png")};
    private Texture[] playerJumpingAnimationGreenPlayer = {
            new Texture("armor__0027_jump_1.png"),
            new Texture("armor__0028_jump_2.png"),
            new Texture("armor__0028_jump_3.png"),
            new Texture("armor__0030_jump_4.png")};
    private Texture[] playerRunningAnimationGreenPlayer = {
            new Texture("armor__0031_run_1.png"),
            new Texture("armor__0032_run_2.png"),
            new Texture("armor__0033_run_3.png"),
            new Texture("armor__0034_run_4.png"),
            new Texture("armor__0035_run_5.png"),
            new Texture("armor__0036_run_6.png")};
    private Texture[] playerRunningAnimationPurplePlayer = {
            new Texture("blue__0012_run_1.png"),
            new Texture("blue__0013_run_2.png"),
            new Texture("blue__0014_run_3.png"),
            new Texture("blue__0015_run_4.png"),
            new Texture("blue__0016_run_5.png"),
            new Texture("blue__0017_run_6.png")};
    private Texture[] playerJumpingAnimationPurplePlayer = {
            new Texture("blue__0027_jump_1.png"),
            new Texture("blue__0028_jump_2.png"),
            new Texture("blue__0029_jump_3.png"),
            new Texture("blue__0030_jump_4.png")};
    private final AssetManager assetManager = new AssetManager();

    private Vector2 backgroundPosition1, backgroundPosition2;
    private ObstacleHandler obstacleHandler;
    private GemstoneHandler gemstoneHandler;

    private OrthographicCamera cam;
    private Hud hud;

    private CollisionDetector collisionDetector;


    public PlayState(GameStateManager gsm, int x) {
        super(gsm);
        cam = new OrthographicCamera();
        backgroundPosition1 = new Vector2(cam.position.x - cam.viewportWidth/2 - 500, -300);
        backgroundPosition2 = new Vector2((cam.position.x - cam.viewportWidth/2) - 500 + w, -300);
        world = new World(new Vector2(0, 0), true);
        collisionDetector = new CollisionDetector();
        player = new GreenPlayer();
        this.playInput = new PlayInputHandler(player);
        this.x = x;
        ground = createGround();
        debugRenderer = new Box2DDebugRenderer();
        rc.renderBirdMusic();

        cam.setToOrtho(false, w/2, h/2);

        setInputProcessor(playInput);
        hud = new Hud();
        obstacleHandler = new ObstacleHandler(world,rc,new EasyModeFactory());
        gemstoneHandler = new GemstoneHandler(world,rc,new EasyModeFactory());
        setFactories(this.x);
        frame = 0;
    }


    private void updateBackground() {
        if(cam.position.x - (cam.viewportWidth / 2) > backgroundPosition1.x + w)
            backgroundPosition1.add(w * 2, 0);
        if(cam.position.x - (cam.viewportWidth / 2) > backgroundPosition2.x + w)
            backgroundPosition2.add(w * 2, 0);
    }

    public void setFactories(int x){
        switch (x) {
            case 1:
                new DefaultModeFactory();
                break;
            case 2:
                new EasyModeFactory();
                break;
            case 3:
                new HardModeFactory();
                break;
        }
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
        gemstoneHandler.update(Math.round(player.getBody().getXPosition()),0.5f);
        hud.updateScore(Math.round(player.getBody().getXPosition()));

        if(Gdx.input.isKeyPressed(Input.Keys.UP)) player.jump();

        if(collisionDetector.hasCollided(player,1f)){
            player.collisionGroundBegin();
        }else player.collisionGroundEnd();

        for(ObstacleAdapter obstacle : obstacleHandler.getObstacles()){
            hud.gameOver(collisionDetector.hasCollided(player,obstacle));
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

                if(player instanceof OrangePlayer) {
                    rc.render(playerWalkingAnimationOrangePlayer[animationFrame], player.getBody().getXPosition() * pixelsPerMeter - (playerWalkingAnimationOrangePlayer[1].getWidth()/8f), player.getBody().getYPosition() * pixelsPerMeter - 30, 200/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rc.render(playerWalkingAnimationGreenPlayer[animationFrame], player.getBody().getXPosition() * pixelsPerMeter - (playerWalkingAnimationGreenPlayer[1].getWidth()/8f), player.getBody().getYPosition() * pixelsPerMeter - 30, 200/4f, 422/4f);
                }
                break;
            case "jumping":
                frame += 0.1;
                frame = frame % 60;

                if(player.getBody().speedY > 0.1){ frame = 0; animationFrame=0;}
                animationFrame = animationFrame % 4;

                if(player instanceof OrangePlayer) {
                    rc.render(playerJumpingAnimationOrangePlayer[animationFrame], player.getBody().getXPosition() * pixelsPerMeter - (playerJumpingAnimationOrangePlayer[1].getWidth()/8f), player.getBody().getYPosition() * pixelsPerMeter - 30, 250/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rc.render(playerJumpingAnimationGreenPlayer[animationFrame], player.getBody().getXPosition() * pixelsPerMeter - (playerJumpingAnimationGreenPlayer[1].getWidth()/8f), player.getBody().getYPosition() * pixelsPerMeter - 30, 250/4f, 422/4f);
                }

                if(player instanceof PurplePlayer) {
                    rc.render(playerJumpingAnimationPurplePlayer[animationFrame], player.getBody().getXPosition() * pixelsPerMeter - (playerJumpingAnimationPurplePlayer[1].getWidth()/8f), player.getBody().getYPosition() * pixelsPerMeter - 30, 250/4f, 422/4f);
                }

                break;
            case "running":
                frame += 0.1;
                frame = frame % 60;
                animationFrame = animationFrame % 5;
                rc.render(playerRunningAnimationPurplePlayer[animationFrame], player.getBody().getXPosition() * pixelsPerMeter - (playerWalkingAnimationGreenPlayer[1].getWidth()/8f), player.getBody().getYPosition() * pixelsPerMeter - 30, 200/4f, 422/4f);
                break;
        }
    }

    @Override
    public void dispose() {
        assetManager.getBackground().dispose();
        world.dispose();
        debugRenderer.dispose();
        for (Texture texture : playerWalkingAnimationGreenPlayer){
            texture.dispose();
        }
        for (Texture texture : playerJumpingAnimationGreenPlayer){
            texture.dispose();
        }
        for (Texture texture : playerRunningAnimationGreenPlayer){
            texture.dispose();
        }
        for (Texture texture : playerRunningAnimationPurplePlayer){
            texture.dispose();
        }
        for (Texture texture : playerJumpingAnimationGreenPlayer){
            texture.dispose();
        }
    }
}
