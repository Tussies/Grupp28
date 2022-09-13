package com.grupp28gdx.game.obstacles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Spike extends Obstacle {
    Vector2[] spikeBodyVectors = {
            new Vector2(this.getX_position(),this.getY_position()+1),
            new Vector2(this.getX_position()+2,this.getY_position()+1),
            new Vector2(this.getX_position()+1,this.getY_position()+2)};
    PolygonShape spike;
    public Spike(int posX, int posY) {
        spike = new PolygonShape();
        spike.set(spikeBodyVectors);
    }
    @Override
    public PolygonShape getBody(){
        return spike;
    }
}
