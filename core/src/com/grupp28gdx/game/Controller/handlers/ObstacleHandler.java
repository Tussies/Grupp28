package com.grupp28gdx.game.Controller.handlers;

import com.badlogic.gdx.utils.Array;
import com.grupp28gdx.game.Model.Factories.ModeFactory;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;


public class ObstacleHandler extends SpawnHandler{


    /**
     *
     * This class is used to generate obstacles and handles all the position and deletion of all obstacles.
     *
     *
     *  obstacleArray = An array of obstacle objects
     *  modeFactory = global modeFactory for ObstacleHandler
     *  id = Id that will be given to an obstacle
     * */

    private Array<Obstacle> obstacleArray = new Array<>();
    private final ModeFactory modeFactory;
    private int id = 0;

    /**
     * Constructs the ObstacleHandler
     * @param modeFactory, takes the given ModeFactory so all obstacles will spawn with the same difficulty
     */
    public ObstacleHandler(ModeFactory modeFactory){
        this.modeFactory = modeFactory;
    }

    /**
     * Method to getting obstacles.
     * @return obstacleArray, an Array of all obstacles.
     */
    public Array<Obstacle> getObstacles(){
        return obstacleArray;

    }

    /**
     * Method used to generate the gems, adds them to obstacleArray.
     * @param posX, given place to spawn obstacle on X position
     * @param posY, given place to spawn obstacle on Y position
     */
    @Override
    protected void generate(float posX,float posY) {
        id += 1;
        obstacleArray.add(modeFactory.createObstacle(posX,posY,id));
    }


    /**
     * Method that updates the obstacle spawning.
     * Calls on generate method when obstacleArray is empty, and destroys obstacle object when it has passed -7 behind posX.
     * @param posX, given place to determine where to add and remove obstacles based on x
     * @param posY, given place to determine where to add and remove obstacles based on y
     */
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

    /**
     * When a collision is detected this class will react with the specified object with matching id.
     * @param id, used to locate a specific obstacle
     */
    public void react(int id){
        for (int i=0; i < obstacleArray.size ; i++){
            if (obstacleArray.get(i).getId() == id){
                obstacleArray.removeIndex(i);
            }
        }
    }
}


