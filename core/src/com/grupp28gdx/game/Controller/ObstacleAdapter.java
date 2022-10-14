package com.grupp28gdx.game.Controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.grupp28gdx.game.Model.ModeFactory;
import com.grupp28gdx.game.Model.Obstacle;
import com.grupp28gdx.game.render.RenderController;

public class ObstacleAdapter {
    private World world;
    private Obstacle obstacleData;
    private Body obstacleBody;

    public ObstacleAdapter(World world, ModeFactory factory, float spawnPosX, float spawnPosY, RenderController rc){
        this.world = world;
        this.obstacleData = factory.createObstacle(spawnPosX,spawnPosY);
        obstacleBody = world.createBody(generateBodyDef(spawnPosX,spawnPosY));
        PolygonShape bodyShape = new PolygonShape();
        bodyShape.set(getVectors());
        rc.createFixture(obstacleBody,bodyShape);
        obstacleBody.createFixture(bodyShape,4.0f);

        }

    private Vector2[] getVectors() {
        if (obstacleData.getVectorListX().length == 4){
            return new Vector2[]{
                    new Vector2(obstacleData.getVectorListX()[0],obstacleData.getVectorListY()[0]),
                    new Vector2(obstacleData.getVectorListX()[1],obstacleData.getVectorListY()[1]),
                    new Vector2(obstacleData.getVectorListX()[2],obstacleData.getVectorListY()[2]),
                    new Vector2(obstacleData.getVectorListX()[3],obstacleData.getVectorListY()[3]),
            };
        }else if (obstacleData.getVectorListX().length == 3){
            return new Vector2[]{
                    new Vector2(obstacleData.getVectorListX()[0],obstacleData.getVectorListY()[0]),
                    new Vector2(obstacleData.getVectorListX()[1],obstacleData.getVectorListY()[1]),
                    new Vector2(obstacleData.getVectorListX()[2],obstacleData.getVectorListY()[2]),
            };
        }else return null;
    }

    private BodyDef generateBodyDef(float spawnX,float spawnY) {
        BodyDef bodyDef;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(spawnX,spawnY);
        bodyDef.fixedRotation = true;
        return bodyDef;
    }


    }
