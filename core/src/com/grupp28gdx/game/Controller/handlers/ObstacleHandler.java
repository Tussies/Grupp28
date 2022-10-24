package com.grupp28gdx.game.Controller.handlers;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import com.grupp28gdx.game.Model.ModeFactory;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.View.render.RenderView;


public class ObstacleHandler extends SpawnHandler{
    private Array<Obstacle> obstacleArray = new Array<>();
    private World world;
    private RenderView rc;
    private final ModeFactory modeFactory;
    private int id = 0;
    public ObstacleHandler(World world, RenderView rc, ModeFactory modeFactory){
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
            } else if (!((obstacleArray.get(obstacleArray.size - 1).getBody().getXPosition() >= posX+8) && (obstacleArray.get(obstacleArray.size - 1).getBody().getXPosition() <= posX+12))) {
                generate(posX+10+rand.nextInt()%2- rand.nextInt()%2, posY);
            }
            if(obstacleArray.size != 1){
                while (obstacleArray.get(0).getBody().getXPosition() - posX <= -5) {
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


