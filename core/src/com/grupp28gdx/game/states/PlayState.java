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
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.Guns.Bullet;
import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.OrangePlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.PlayerGroup.PurplePlayer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.Controller.GemstoneAdapter;
import com.grupp28gdx.game.Controller.ObstacleAdapter;
import com.grupp28gdx.game.Model.*;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
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
    private Body playerHitbox;
    private PlayInputHandler playInput;

    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();
    private float frame;

    private final AssetManager assetManager = new AssetManager();
    private ArrayList<Obstacle> obstacles = new ArrayList<>();

    private Vector2 backgroundPosition1, backgroundPosition2;
    private ObstacleHandler obstacleHandler;
    private GemstoneHandler gemstoneHandler;

    private OrthographicCamera cam;
    private Hud hud;

    private CollisionDetector collisionDetector;
    private ArrayList<Obstacle> obstacleList = new ArrayList<>();

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam = new OrthographicCamera();
        backgroundPosition1 = new Vector2(cam.position.x - cam.viewportWidth/2 - 500, -300);
        backgroundPosition2 = new Vector2((cam.position.x - cam.viewportWidth/2) - 500 + w, -300);
        world = new World(new Vector2(0, 0), true);
        collisionDetector = new CollisionDetector();
        player = new OrangePlayer();
        this.playInput = new PlayInputHandler(player);
        debugRenderer = new Box2DDebugRenderer();
        rc.renderBirdMusic();

        cam.setToOrtho(false, w/2, h/2);

        setInputProcessor(playInput);
        hud = new Hud();
        obstacleHandler = new ObstacleHandler(world,rc,new EasyModeFactory());
        gemstoneHandler = new GemstoneHandler(world,rc,new EasyModeFactory());

        frame = 0;

        playerHitbox = createHitBox();
    }


    private void updateBackground() {
        if(cam.position.x - (4096 / 2f) > backgroundPosition1.x + 4096)
            backgroundPosition1.add(4096, 0);
        if(cam.position.x - (4096 / 2f) > backgroundPosition2.x + 4096)
            backgroundPosition2.add(4096/2f, 0);
    }


    public Body createHitBox() {
        BodyDef hitboxdef = new BodyDef();
        hitboxdef.type = BodyDef.BodyType.StaticBody;
        hitboxdef.position.set(0,0);
        hitboxdef.fixedRotation = true;
        playerHitbox = world.createBody(hitboxdef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(0.1f, 0.1f);

        playerHitbox.createFixture(shape, 1.0f);
        shape.dispose();

        return playerHitbox;
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float delta) {
        world.step(1/60f, 6,2);
        updateBackground();

        obstacleList = obstacleHandler.obstacleData2ObstaclesObstacle();
        player.playerUpdate(delta, obstacleList);

        obstacleHandler.update(Math.round(player.getBody().getXPosition()),0.5f);
        gemstoneHandler.update(Math.round(player.getBody().getXPosition()),0.5f);
        hud.updateScore(Math.round(player.getBody().getXPosition()));


        if(collisionDetector.hasCollided(player,1f)){
            player.collisionGroundBegin();
        }else player.collisionGroundEnd();

        for(ObstacleAdapter obstacle : obstacleHandler.getObstacles()){
            if (collisionDetector.hasCollided(player, obstacle.getObstacleData())) hud.gameOver(true);
        }
        for(GemstoneAdapter gemstone : gemstoneHandler.getGem()){
            if(collisionDetector.hasCollided(player,gemstone.getGemstoneData()))
                hud.updateCoins(+10);
        }

        playerHitbox.setTransform(player.getBody().x*2,player.getBody().y*2,0);
    }

    public void cameraUpdate() {
        Vector3 position = cam.position;
        position.x = player.getBody().getXPosition()*pixelsPerMeter*2;
        position.y = player.getBody().getYPosition()*pixelsPerMeter*2;

        rc.updateCamera(cam,position);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cameraUpdate();

        update(Gdx.graphics.getDeltaTime());
        rc.setProjectionMatrix(cam.combined);
        rc.render(assetManager.getBackground(), backgroundPosition1.x, backgroundPosition1.y, 4096, 4096);
        rc.render(assetManager.getGroundTexture(), backgroundPosition1.x, backgroundPosition1.y-310, 4096, 2000/3+10);
        rc.render(assetManager.getBackground(), backgroundPosition2.x, backgroundPosition2.y, 4096, 4096);
        rc.render(assetManager.getGroundTexture(), backgroundPosition2.x, backgroundPosition2.y-310, 4096, 2000/3+10);
        
        for (ObstacleAdapter obstacle : obstacleHandler.getObstacles()){
            if (obstacle.getObstacleData() instanceof PermanentObstacle)
                rc.render(assetManager.getWallTexture(),obstacle.getObstacleData().getPosition().x*pixelsPerMeter*2,obstacle.getObstacleData().getPosition().y*pixelsPerMeter*2-32,32,32*3);
            if (obstacle.getObstacleData() instanceof DestroyableObstacle)
                rc.render(assetManager.getDestroyableTexture(),obstacle.getObstacleData().getPosition().x*pixelsPerMeter*2,obstacle.getObstacleData().getPosition().y*pixelsPerMeter*2-32,32,32*3);
            if (obstacle.getObstacleData() instanceof SpikeObstacle)
                rc.render(assetManager.getSpikeTexture(),obstacle.getObstacleData().getPosition().x*pixelsPerMeter*2,obstacle.getObstacleData().getPosition().y*pixelsPerMeter*2+32,64,32);
        }

        for (GemstoneAdapter gemstone : gemstoneHandler.getGem()){
            if (gemstone.getGemstoneData() instanceof BigGemstone){rc.render(assetManager.getBigGemstoneTexture(),((BigGemstone) gemstone.getGemstoneData()).body.x*pixelsPerMeter*2,((BigGemstone) gemstone.getGemstoneData()).body.y*pixelsPerMeter*2,pixelsPerMeter*0.75f,pixelsPerMeter*0.75f);}
            else if (gemstone.getGemstoneData() instanceof MediumGemstone){rc.render(assetManager.getMediumGemstoneTexture(),((BigGemstone) gemstone.getGemstoneData()).body.x*pixelsPerMeter*2,((BigGemstone) gemstone.getGemstoneData()).body.y*pixelsPerMeter*2,pixelsPerMeter*0.45f,pixelsPerMeter*0.45f);}
            else{rc.render(assetManager.getSmallGemstoneTexture(),((BigGemstone) gemstone.getGemstoneData()).body.x*pixelsPerMeter*2,((BigGemstone) gemstone.getGemstoneData()).body.y*pixelsPerMeter*2,pixelsPerMeter*0.18f,pixelsPerMeter*0.18f);}
        }
        updateBulletTexture(player.getGun().getBulletsFired());
        updatePlayerTexture();
        rc.render(hud);

    }

    private void updateBulletTexture(ArrayList<Bullet> bullets){
        for (int j = 0 ; j <bullets.size(); j++){
           rc.render(assetManager.getBulletTexture(),  bullets.get(j).getXPosition()*pixelsPerMeter*2,  bullets.get(j).getYPosition()*pixelsPerMeter*2 , 40, 40 );
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
                    rc.render(assetManager.getPlayerWalkingAnimationOrangePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerWalkingAnimationOrangePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rc.render(assetManager.getPlayerWalkingAnimationGreenPlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerWalkingAnimationGreenPlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }
                break;
            case "jumping":
                frame += 0.1;
                frame = frame % 60;

                if(player.getBody().speedY > 0.1){ frame = 0; animationFrame=0;}
                animationFrame = animationFrame % 4;

                if(player instanceof OrangePlayer) {
                    rc.render(assetManager.getPlayerJumpingAnimationOrangePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerJumpingAnimationOrangePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 250/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rc.render(assetManager.getPlayerJumpingAnimationGreenPlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerJumpingAnimationGreenPlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 250/4f, 422/4f);
                }

                if(player instanceof PurplePlayer) {
                    rc.render(assetManager.getPlayerJumpingAnimationPurplePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerJumpingAnimationPurplePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 250/4f, 422/4f);
                }

                break;
            case "running":
                frame += 0.1;
                frame = frame % 60;
                animationFrame = animationFrame % 5;
                rc.render(assetManager.getPlayerRunningAnimationPurplePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerRunningAnimationPurplePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
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
