package com.grupp28gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.states.GameStateManager;
import com.grupp28gdx.game.states.MenuState;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

public class Player implements Spawnable {
    private Body player;
    private BodyDef bodyDef;
    private PolygonShape bodyShape;
    private int movementSpeed;
    private int forceX=0;
    private int forceY=0;
    private float x_position;
    private float y_position;
    private GameStateManager gsm;
    private int jumps = 0;
    private long lastTap = 0;
    private String playerState;

    public Player(World world){
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,1);
        bodyDef.fixedRotation = true;
        player = world.createBody(bodyDef);
        movementSpeed = 700;
        bodyShape = new PolygonShape();
        bodyShape.setAsBox(30/pixelsPerMeter, 30/pixelsPerMeter);
        player.createFixture(bodyShape, 1.0f);
        gsm = new GameStateManager();

        playerState = "walking";
    }

    public void  setPosition(Vector2 v2){
        x_position = v2.x;
        y_position = v2.y;
    }

    public float getX_position(){return this.x_position;}
    public float getY_position(){return this.y_position;}

    public void inputActionDown(int key) {
        switch (key){
            case 19: if(player.getLinearVelocity().y==0 || jumps < 2){
                jumps ++;
                this.forceY = 200;System.out.println("jump");
                if(player.getLinearVelocity().y == 0) {
                    jumps = 0;
                }
            }
            playerState = "jumping";
            break;
            case 22: forceX += 1; break;
            case 20: forceY = -60; break;
        }
    }
    public void inputActionUp(int key) {
        switch (key){
            case 19:this.forceY=0; break;
            case 22: forceX -= 3; break;
            case 20: forceY = 0; break;
            case 111: gsm.set(new MenuState(gsm));
        }
    }

    public Body getPlayerBody(){
        return player;
    }

    public PolygonShape getBodyShape(){
        return bodyShape;
    }

    public void playerMovementUpdate(float delta) {
        player.applyForceToCenter(movementSpeed, forceY, false);
        player.setLinearVelocity(forceX * 5, player.getLinearVelocity().y);
        if(forceY>0) {forceY +=-10;}
        if(player.getLinearVelocity().y<=-2){playerState="walking";}
        this.setPosition(player.getPosition());
    }

    public String getPlayerState() {
        return playerState;
    }

    public int getForceY() {
        return forceY;
    }
}