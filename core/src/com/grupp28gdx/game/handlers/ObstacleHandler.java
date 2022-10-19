package com.grupp28gdx.game.handlers;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import com.grupp28gdx.game.Model.ModeFactory;
import com.grupp28gdx.game.Model.Obstacle;
import com.grupp28gdx.game.render.RenderController;


public class ObstacleHandler extends SpawnHandler{
    protected Array<Obstacle> obstacleArray = new Array<>();
    protected World world;
    protected  RenderController rc;
    protected ModeFactory modeFactory;
    protected int id = 0;
    public ObstacleHandler(World world, RenderController rc, ModeFactory modeFactory){
        this.world = world;
        this.rc = rc;
        this.modeFactory = modeFactory;
    }

    public Array<Obstacle> getObstacles(){
        return obstacleArray;
    }

    @Override
    protected void generate(float posX,float posY) {
        id += 1;
        obstacleArray.add(modeFactory.createObstacle(posX,posY,id));
    }

    @Override
    public void update(float posX,float posY) {
        if (posX % 8 == 0 && posX > 15) {
            if (obstacleArray.isEmpty()) {
                generate(posX+10+rand.nextInt()%2- rand.nextInt()%2, posY);
            } else if (!((obstacleArray.get(obstacleArray.size - 1).getPosition().getXPosition() >= posX+5) && (obstacleArray.get(obstacleArray.size - 1).getPosition().getXPosition() <= posX+10))) {
                generate(posX+10+rand.nextInt()%2- rand.nextInt()%2, posY);
            }
            if(obstacleArray.size != 1){
                while (obstacleArray.get(0).getPosition().getXPosition() - posX <= -5) {
                    obstacleArray.removeIndex(0);
                }
            }

        }
    }


    public void react(int id){
        for (int i=0; i < obstacleArray.size-1 ; i++){
            if (obstacleArray.get(i).getId() == id){
                obstacleArray.removeIndex(i);
            }
        }
    }
}


