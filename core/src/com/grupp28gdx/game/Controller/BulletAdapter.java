package com.grupp28gdx.game.Controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.Model.Guns.Bullet;
import com.grupp28gdx.game.Model.ModeFactory;
import com.grupp28gdx.game.render.RenderController;

public class BulletAdapter {
    private World world;
    private Bullet bulletData;
    private Body bulletBody;

    public BulletAdapter(World world, ModeFactory factory, float spawnPosX, float spawnPosY, RenderController rc) { // fix param
        this.world = world;
        bulletBody = world.createBody(generateBodyDef(spawnPosX - 1, spawnPosY));
        PolygonShape bodyShape = new PolygonShape();
        bodyShape.set(getVectors());
        rc.createFixture(bulletBody, bodyShape);
        bulletBody.createFixture(bodyShape, 4.0f);

    }

    private Vector2[] getVectors() {
        if (bulletData.getVectorListX().size() == 4) {
            return new Vector2[]{
                    new Vector2(bulletData.getVectorListX().get(0), bulletData.getVectorListY().get(0)),
                    new Vector2(bulletData.getVectorListX().get(1), bulletData.getVectorListY().get(1)),
                    new Vector2(bulletData.getVectorListX().get(2), bulletData.getVectorListY().get(2)),
                    new Vector2(bulletData.getVectorListX().get(3), bulletData.getVectorListY().get(3)),
            };
        } else if (bulletData.getVectorListX().size() == 3) {
            return new Vector2[]{
                    new Vector2(bulletData.getVectorListX().get(0), bulletData.getVectorListY().get(0)),
                    new Vector2(bulletData.getVectorListX().get(1), bulletData.getVectorListY().get(1)),
                    new Vector2(bulletData.getVectorListX().get(2), bulletData.getVectorListY().get(2)),
            };
        } else return null;
    }

    private BodyDef generateBodyDef(float spawnX, float spawnY) {
        BodyDef bodyDef;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(spawnX,spawnY);
        bodyDef.fixedRotation = true;
        return bodyDef;
    }
}
