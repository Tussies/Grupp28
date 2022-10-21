package com.grupp28gdx.game.Model.Obstacles;

import com.grupp28gdx.game.Model.Body;

/**
 * This obstacle is permanent, which means that it will not disappear if the player shoots it with a gun.
 */
public class PermanentObstacle implements Obstacle {
    private int id;

    private final Body body;

    public PermanentObstacle(float spawnPosX, float spawnPosY,int id){
        body = new Body(spawnPosX,spawnPosY);
        body.setHeight(1.9f);
        body.setWidth(1);
        this.id = id;
    }

    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public Body getBody(){
        return body;
    }

    @Override
    public Obstacle createObstacle(float spawnX, float spawnY,int id) {
        return new PermanentObstacle(spawnX,spawnY,id);
    }

}
