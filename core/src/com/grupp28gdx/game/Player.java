package com.grupp28gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.input.PlayInputHandler;
import com.grupp28gdx.game.states.PlayState;

import java.awt.event.ActionEvent;
import java.util.Scanner;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

public class Player extends Sprite {
    private Body player;
    private BodyDef bodyDef;
    private PolygonShape bodyShape;
    private int movementSpeed;
    private int forceX=0;
    private int forceY=0;
    private boolean hasJumped;
    private float x_position;
    private float y_position;
    private TextureRegion alienStand;
    //private Sprite alienSprite;
    private Texture texture;

    public Player(World world, PlayState state){
        //super(state.getAtlas().findRegion("armor"));
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,1);
        bodyDef.fixedRotation = true;
        player = world.createBody(bodyDef);
        movementSpeed = 0;
        bodyShape = new PolygonShape();
        bodyShape.setAsBox(30/pixelsPerMeter, 30/pixelsPerMeter);
        player.createFixture(bodyShape, 1.0f);

        texture = new Texture("alien00.png");

        //alienStand = new TextureRegion(getTexture(), 1033,372,32,32);
        //setBounds(0,0,32/pixelsPerMeter, 32/pixelsPerMeter);
        //setRegion(alienStand);

        //alienSprite = new Sprite(new Texture("armor__0000_idle_1.png"));
        //player.setUserData(alienSprite);

        //alienSprite.getTexture().dispose();
        bodyShape.dispose();
    }

    public Texture getTexture() {
        return texture;
    }

    public void  setPosition(Vector2 v2){
        x_position = v2.x;
        y_position = v2.y;
    }

    public void inputActionDown(int key) {
        if(player.getLinearVelocity().y==0) {hasJumped = false;}
        switch (key){
            case 19: if(player.getLinearVelocity().y==0){ this.forceY = 220;System.out.println("jump");}break;
            case 22: forceX += 1; break;
            case 20: forceY = -60; break;
        }
    }
    public void inputActionUp(int key) {
        switch (key){
            case 19:this.forceY=0; break;
            case 22: forceX -= 1; break;
            case 20: forceY = 0; break;
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
        this.setPosition(player.getPosition());
    }
}