package com.grupp28gdx.game.obstacles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Spike extends Obstacle {
    Vector2[] spikeBodyVectors = {
            new Vector2(this.getX_position(),this.getY_position()+1),
            new Vector2(this.getX_position()+2,this.getY_position()+1),
            new Vector2(this.getX_position()+1,this.getY_position()+2)};
    PolygonShape spike;
    BodyDef definition;
    public Spike(float posX, float posY) {
        definition = new BodyDef();
        definition.type = BodyDef.BodyType.StaticBody;
        definition.position.set(posX,posY);
        definition.fixedRotation = true;
        Vector2 v2 = new Vector2();
        v2.x = posX;
        v2.y = posY;
        this.setPosition(v2);
        spike = new PolygonShape();
        spike.set(spikeBodyVectors);
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
    public Body getBody(){return body;}
    @Override
    public void setBody(Body setBody){
        body = setBody;
    }
}
