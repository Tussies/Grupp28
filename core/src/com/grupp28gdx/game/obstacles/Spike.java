package com.grupp28gdx.game.obstacles;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.grupp28gdx.game.Model.Body;


public class Spike extends Obstacle {
    Body[] spikeBodyVectors = {
            new Body(this.getX_position(),this.getY_position()+1),
            new Body(this.getX_position()+2,this.getY_position()+1),
            new Body(this.getX_position()+1,this.getY_position()+2)};
    PolygonShape spike;
    BodyDef definition;
    public Spike(float posX, float posY) {
        definition = new BodyDef();
        definition.type = BodyDef.BodyType.StaticBody;
        definition.position.set(posX, (float) (Math.random()%5));
        definition.fixedRotation = true;
        

        this.setPosition(posX, posY);
        spike = new PolygonShape();
        //@TODO fix the fucking shapes
        //spike.set(spikeBodyVectors);
    }
    @Override
    public PolygonShape getBodyShape(){
        return spike;
    }
    @Override
    public BodyDef getBodyDef(){
        return definition;
    }
    @Override
    public com.badlogic.gdx.physics.box2d.Body getBody(){return body;}
    @Override
    public void setBody(com.badlogic.gdx.physics.box2d.Body setBody){
        body = setBody;
    }
}
