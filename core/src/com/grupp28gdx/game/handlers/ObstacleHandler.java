package com.grupp28gdx.game.handlers;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Controller.ObstacleAdapter;
import com.grupp28gdx.game.Model.ModeFactory;
import com.grupp28gdx.game.render.RenderController;


public class ObstacleHandler extends SpawnHandler{
    protected Array<ObstacleAdapter> itemArray = new Array<>();
    protected World world;
    protected  RenderController rc;
    protected ModeFactory modeFactory;
    public ObstacleHandler(World world, RenderController rc, ModeFactory modeFactory){
        this.world = world;
        this.rc = rc;
        this.modeFactory = modeFactory;
    }

    public Array<ObstacleAdapter> getObstacles(){
        return itemArray;
    }

    @Override
    protected void generate(float posX,float posY) {
        int n = 1-numberOfSpawnableItems+1;
        int i = rand.nextInt() % n;
        int randomNum = 1 + i;
        switch (randomNum){
            case 1: itemArray.add(new ObstacleAdapter(world,modeFactory,posX,posY,rc));
        }
    }

    @Override
    public void update(float posX,float posY) {
        if (posX % 5 == 0) {
            if (itemArray.isEmpty()) {
                generate(posX+5, posY);
            } else if (!(itemArray.get(itemArray.size - 1).getObstacleData().getPosition().getXPosition() == posX+5)) {
                generate(posX+5, posY);
            }
            while (itemArray.get(0).getObstacleData().getPosition().getXPosition() - posX <= -5) {
                itemArray.get(0).destroyBody();
                itemArray.removeIndex(0);
            }
        }
    }
}


