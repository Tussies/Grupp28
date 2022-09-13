package com.grupp28gdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Player {

    //remove tempworld since it's only temporary for the player to be created
    //public World tempworld;


    public static Body createPlayer(World world) {
        Body pBody;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(0,0);
        def.fixedRotation = true;
        pBody = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1,1);

        pBody.createFixture(shape, 0f);
        shape.dispose();
        //System.out.println("Player has been created");


        return pBody;


    }
    /*public void update(float delta){
    tempworld.step(1/60f, 6 , 2);
    }*/
    public void playerTalk(){
        Scanner keyboard = new Scanner(System.in);
        int myInt = keyboard.nextInt();
        System.out.println(myInt);


    }
    public void jumpPerformed(ActionEvent e){

        //Call method that lets player jump
    }


}