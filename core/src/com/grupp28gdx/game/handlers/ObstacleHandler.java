package com.grupp28gdx.game.handlers;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Controller.ObstacleAdapter;
import com.grupp28gdx.game.Model.ModeFactory;
import com.grupp28gdx.game.Model.Obstacle;
import com.grupp28gdx.game.Model.Random;
import com.grupp28gdx.game.render.RenderController;


public class ObstacleHandler extends SpawnHandler{
    protected Array<Obstacle> itemArray = new Array<>();
    protected World world;
    protected  RenderController rc;
    protected ModeFactory modeFactory;
    public ObstacleHandler(World world, RenderController rc, ModeFactory modeFactory){
        this.world = world;
        this.rc = rc;
        this.modeFactory = modeFactory;
    }

    public Array<Obstacle> getObstacles(){
        return itemArray;
    }

    @Override
    protected void generate(float posX,float posY) {
        itemArray.add(modeFactory.createObstacle(posX,posY));
    }

    @Override
    public void update(float posX,float posY) {
        if (posX % 8 == 0 && posX > 15) {
            if (itemArray.isEmpty()) {
                generate(posX+10+rand.nextInt()%2- rand.nextInt()%2, posY);
            } else if (!((itemArray.get(itemArray.size - 1).getPosition().getXPosition() >= posX+5) && (itemArray.get(itemArray.size - 1).getPosition().getXPosition() <= posX+10))) {
                generate(posX+10+rand.nextInt()%2- rand.nextInt()%2, posY);
            }
            if(itemArray.size != 1){
                while (itemArray.get(0).getPosition().getXPosition() - posX <= -5) {
                    itemArray.removeIndex(0);
                }
            }

        }
    }
}


