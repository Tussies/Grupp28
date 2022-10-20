package com.grupp28gdx.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.grupp28gdx.game.Model.CollisionDetector;
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.Guns.Bullet;
import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.OrangePlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.PlayerGroup.PurplePlayer;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.Model.*;
import com.grupp28gdx.game.handlers.GemstoneHandler;
import com.grupp28gdx.game.handlers.ObstacleHandler;
import com.grupp28gdx.game.input.PlayInputHandler;
import com.grupp28gdx.game.render.Hud;

import java.util.ArrayList;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

/**
 * This class is the play state, which is used for showing the play-state of the game in the view.
 * The play-state shows the actual game that the user plays.
 */
public class PlayState extends State {

    Box2DDebugRenderer debugRenderer;
    private World world;

    private Player player;
    private PlayInputHandler playInput;

    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private float frame;
    private int x;

    private final AssetManager assetManager = new AssetManager();
    private ArrayList<Obstacle> obstacles = new ArrayList<>();

    private Vector2 backgroundPosition1, backgroundPosition2;
    private ObstacleHandler obstacleHandler;
    private GemstoneHandler gemstoneHandler;
    private ModeFactory modeFactory;
    private OrthographicCamera cam;
    private Hud hud;

    private CollisionDetector collisionDetector;
    private ArrayList<Obstacle> obstacleList = new ArrayList<>();

    public PlayState(GameStateManager gsm, int x) {
        super(gsm);
        cam = new OrthographicCamera();
        backgroundPosition1 = new Vector2(cam.position.x - cam.viewportWidth/2 - 500, -300);
        backgroundPosition2 = new Vector2((cam.position.x - cam.viewportWidth/2) - 500 + 4096, -300);
        world = new World(new Vector2(0, 0), true);
        this.x = x;

        debugRenderer = new Box2DDebugRenderer();
        rv.renderMusic();

        cam.setToOrtho(false, w/2, h/2);

        hud = new Hud();
        modeFactory = setFactories(this.x);
        obstacleHandler = new ObstacleHandler(world, rv,setFactories(this.x));
        gemstoneHandler = new GemstoneHandler(world, rv,setFactories(this.x));
        player = modeFactory.createPlayer();
        frame = 0;
        this.playInput = new PlayInputHandler(player);
        setInputProcessor(playInput);
        collisionDetector = new CollisionDetector(obstacleHandler,gemstoneHandler,player.getGun(),hud,player);

    }


    private void updateBackground() {
        if(cam.position.x - (cam.viewportWidth / 2) > backgroundPosition1.x + 4096)
            backgroundPosition1.add(4096/2f, 0);
        if(cam.position.x - (cam.viewportWidth / 2) > backgroundPosition2.x + 2048)
            backgroundPosition2.add(4096, 0);
    }


    private ModeFactory setFactories(int x){
        switch (x) {
            case 1:
                return new DefaultModeFactory();
            case 2:
                return new EasyModeFactory();
            case 3:
                return new HardModeFactory();
        }
        return null;
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float delta) {
        world.step(1/60f, 6,2);
        updateBackground();

        player.playerUpdate(delta);

        obstacleHandler.update(Math.round(player.getBody().getXPosition()),0.5f);
        gemstoneHandler.update(Math.round(player.getBody().getXPosition()),0.5f);


        if(Gdx.input.isKeyPressed(41)) {
            gsm.set(new MenuState(gsm));
            rv.musicStop();
        }

        collisionDetector.update();

    }

    private void cameraUpdate() {
        Vector3 position = cam.position;
        position.x = player.getBody().getXPosition()*pixelsPerMeter*2;
        position.y = player.getBody().getYPosition()*pixelsPerMeter*2;

        rv.updateCamera(cam,position);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cameraUpdate();

        update(Gdx.graphics.getDeltaTime());
        rv.setProjectionMatrix(cam.combined);
        rv.render(assetManager.getBackground(), backgroundPosition1.x, backgroundPosition1.y, 4096, 4096);
        rv.render(assetManager.getGroundTexture(), backgroundPosition1.x, backgroundPosition1.y-300, 4096, 2000/3+10);
        rv.render(assetManager.getBackground(), backgroundPosition2.x, backgroundPosition2.y, 4096, 4096);
        rv.render(assetManager.getGroundTexture(), backgroundPosition2.x, backgroundPosition2.y-300, 4096, 2000/3+10);

        for (Obstacle obstacle : obstacleHandler.getObstacles()){
            if (obstacle instanceof PermanentObstacle)
                rv.render(assetManager.getWallTexture(),obstacle.getBody().x*pixelsPerMeter*2,obstacle.getBody().y*pixelsPerMeter*2-32,32,32*3);
            if (obstacle instanceof DestroyableObstacle)
                rv.render(assetManager.getDestroyableTexture(),obstacle.getBody().x*pixelsPerMeter*2,obstacle.getBody().y*pixelsPerMeter*2-32,32,32*3);
            if (obstacle instanceof SpikeObstacle)
                rv.render(assetManager.getSpikeTexture(),obstacle.getBody().x*pixelsPerMeter*2,obstacle.getBody().y*pixelsPerMeter*2+32,64,32);
        }

        for (Gemstone gemstone : gemstoneHandler.getGem()){
            if (gemstone instanceof BigGemstone){
                rv.render(assetManager.getBigGemstoneTexture(),(gemstone).getPosition().x*pixelsPerMeter*2,(gemstone).getPosition().y*pixelsPerMeter*2,pixelsPerMeter*0.75f,pixelsPerMeter*0.75f);}
            else if (gemstone instanceof MediumGemstone){
                rv.render(assetManager.getMediumGemstoneTexture(),(gemstone).getPosition().x*pixelsPerMeter*2,(gemstone).getPosition().y*pixelsPerMeter*2,pixelsPerMeter*0.45f,pixelsPerMeter*0.45f);}
            else{
                rv.render(assetManager.getSmallGemstoneTexture(), gemstone.getPosition().x*pixelsPerMeter*2,(gemstone).getPosition().y*pixelsPerMeter*2,pixelsPerMeter*0.18f,pixelsPerMeter*0.18f);}
        }
        hud.updateScore(Math.round(player.getBody().getXPosition()) + player.getGemScore() );
        hud.updateGemScore(player.getGemScore());
        rv.debugRender(debugRenderer,world,cam,pixelsPerMeter);
        updateBulletTexture(player.getGun().getBulletsFired());
        updatePlayerTexture();
        rv.render(hud);



    }

    private void updateBulletTexture(ArrayList<Bullet> bullets){
        for (int j = 0 ; j <bullets.size(); j++){
           rv.render(assetManager.getBulletTexture(),  bullets.get(j).getXPosition()*pixelsPerMeter*2,  bullets.get(j).getYPosition()*pixelsPerMeter*2 , 40, 40 );
        }
    }

    private void updatePlayerTexture() {
        int animationFrame = Math.round(frame);
        switch (player.getStateOfPlayer().toString()) {
            case "walking":
                frame += 0.1;
                frame = frame % 60;
                animationFrame = animationFrame % 5;

                if(player instanceof OrangePlayer) {
                    rv.render(assetManager.getPlayerWalkingAnimationOrangePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerWalkingAnimationOrangePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rv.render(assetManager.getPlayerWalkingAnimationGreenPlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerWalkingAnimationGreenPlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }
                break;
            case "dead":
                if(player instanceof OrangePlayer) {
                    rv.render(assetManager.getOrangeDeadTexture(), player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getOrangeDeadTexture().getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rv.render(assetManager.getGreenDeadTexture(), player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getGreenDeadTexture().getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }

                if(player instanceof PurplePlayer) {
                    rv.render(assetManager.getPurpleDeadTexture(), player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPurpleDeadTexture().getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }
                break;
            case "jumping":
                frame += 0.1;
                frame = frame % 60;

                if(player.getBody().speedY > 0.1){ frame = 0; animationFrame=0;}
                animationFrame = animationFrame % 4;

                if(player instanceof OrangePlayer) {
                    rv.render(assetManager.getPlayerJumpingAnimationOrangePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerJumpingAnimationOrangePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 250/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rv.render(assetManager.getPlayerJumpingAnimationGreenPlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerJumpingAnimationGreenPlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 250/4f, 422/4f);
                }

                if(player instanceof PurplePlayer) {
                    rv.render(assetManager.getPlayerJumpingAnimationPurplePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerJumpingAnimationPurplePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 250/4f, 422/4f);
                }

                break;
            case "running":
                frame += 0.1;
                frame = frame % 60;
                animationFrame = animationFrame % 5;
                rv.render(assetManager.getPlayerRunningAnimationPurplePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerRunningAnimationPurplePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                break;
        }
    }

    @Override
    public void dispose() {
        assetManager.getBackground().dispose();
        world.dispose();
        debugRenderer.dispose();
        for (Texture texture : assetManager.getPlayerWalkingAnimationOrangePlayer()){
            texture.dispose();
        }
        for (Texture texture : assetManager.getPlayerWalkingAnimationGreenPlayer()){
            texture.dispose();
        }
        for (Texture texture : assetManager.getPlayerJumpingAnimationOrangePlayer()){
            texture.dispose();
        }
        for (Texture texture : assetManager.getPlayerJumpingAnimationGreenPlayer()){
            texture.dispose();
        }
        for (Texture texture : assetManager.getPlayerJumpingAnimationPurplePlayer()){
            texture.dispose();
        }
        for (Texture texture : assetManager.getPlayerRunningAnimationPurplePlayer()){
            texture.dispose();
        }
    }
}
