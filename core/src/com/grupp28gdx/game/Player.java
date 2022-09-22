package com.grupp28gdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

public class Player extends Actor {
    private Body player;
    private BodyDef bodyDef;
    private PolygonShape bodyShape;
    private int movementSpeed;
    private int forceX=0;
    private int forceY=0;

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
    }

    public void inputActionDown(int key) {
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