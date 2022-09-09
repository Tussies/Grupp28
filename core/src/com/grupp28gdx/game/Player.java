package com.grupp28gdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Player {
    private Body player = createPlayer();
    //remove tempworld since it's only temporary for the player to be created
    public World tempworld;


    public Body createPlayer() {
        Body pBody;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(0,0);
        def.fixedRotation = true;
        this.tempworld = new World(new Vector2(0,-9.8f), false);
        pBody = tempworld.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(16,16);

        pBody.createFixture(shape, 1.0f);
        shape.dispose();
        System.out.println("Player has been created");


        return pBody;


    }
    public void update(float delta){
    tempworld.step(1/60f, 6 , 2);


    }
    public void playerTalk(){
        Scanner keyboard = new Scanner(System.in);
        int myInt = keyboard.nextInt();
        System.out.println(myInt);


    }
    public void jumpPerformed(ActionEvent e){

        //Call method that lets player jump
    }


}