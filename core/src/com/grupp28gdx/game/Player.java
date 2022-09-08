package com.grupp28gdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Player {
    private Body player = createPlayer();
    public World tempworld = new World(new Vector2(0,-9.8f), false);

    public Body createPlayer() {
        Body pBody;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(0,0);
        def.fixedRotation = true;
        pBody = tempworld.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(16,16);

        pBody.createFixture(shape, 1.0f);
        shape.dispose();

        return pBody;
    }


}