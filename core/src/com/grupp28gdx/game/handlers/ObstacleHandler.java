package com.grupp28gdx.game.handlers;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.obstacles.*;

import static com.grupp28gdx.game.utils.Constants.pixelsPerMeter;

public class ObstacleHandler extends SpawnHandler{
    protected Array<Obstacle> itemArray = new Array<>();
    protected World world;
    public ObstacleHandler(World world){
        this.world = world;
    }

    public Array<Obstacle> getObstacles(){
        return itemArray;
    }

    @Override
    protected void generate(float posX,float posY) {
        int n = 1-numberOfSpawnableItems+1;
        int i = rand.nextInt() % n;
        int randomNum = 1 + i;
        switch (randomNum){
            case 1: itemArray.add(new Spike(posX+20,posY));
        }
    }

    @Override
    public void update(float posX,float posY) {
        if (posX % 10 == 0) {
            if (itemArray.isEmpty()) {
                createObstacle(posX, -0.1f);
            } else if (!(itemArray.get(itemArray.size - 1).getX_position() == posX+20)) {
                createObstacle(posX, -0.1f);
            }
            while (itemArray.get(0).getX_position() - posX <= -10) {
                world.destroyBody(itemArray.get(0).getBody());
                itemArray.removeIndex(0);
            }
        }
    }

    private void createObstacle(float posX, float posY) {
        generate(posX,posY);
        itemArray.get(itemArray.size - 1).setBody(world.createBody(itemArray.get(itemArray.size - 1).getBodyDef()));
        itemArray.get(itemArray.size - 1).getBody().createFixture(itemArray.get(itemArray.size - 1).getBodyShape(),1.0f);
        itemArray.get(itemArray.size - 1).getBodyShape().dispose();
    }
}


