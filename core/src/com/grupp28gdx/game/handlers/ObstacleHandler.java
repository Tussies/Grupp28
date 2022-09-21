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
            case 1:System.out.println("Test"); itemArray.add(new Spike(posX+10,0));
        }
    }

    @Override
    public void update(float posX,float posY) {
        if (itemArray.isEmpty())generate(posX,posY);
        else if (!(itemArray.get(itemArray.size - 1).getX_position() == posX)){
            generate(posX,posY);
        }
        for (Obstacle obstacle : itemArray){
            obstacle.setBody(world.createBody(obstacle.getBodyDef()));
            obstacle.getBody().createFixture(obstacle.getBodyShape(),1.0f);
        }
    }
}


