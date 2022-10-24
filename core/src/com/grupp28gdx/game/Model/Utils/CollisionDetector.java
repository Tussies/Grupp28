package com.grupp28gdx.game.Model.Utils;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.Guns.Bullet;
import com.grupp28gdx.game.Model.Guns.Gun;
import com.grupp28gdx.game.Model.ObstacleGroup.DestroyableObstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.handlers.GemstoneHandler;
import com.grupp28gdx.game.Model.handlers.ObstacleHandler;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetector {

    private List<Object> collisionsList = new ArrayList<>();
    private Player player;

    public CollisionDetector(ObstacleHandler obstacleHandler, GemstoneHandler gemstoneHandler, Gun gun,Player player){
        collisionsList.add(obstacleHandler);
        collisionsList.add(gemstoneHandler);
        collisionsList.add(gun);
        this.player = player;
    }

    /**
     *  A method that looks through the subscribers to find collisions between objects.
     *  Collision detector requires a player and a hud to function.
     *  Requires subscribers to be one of the following objects.
     * @Object ObstacleHandler
     * @Object GemstoneHandler
     * @Object Gun
     */

    public void update(){
        for (Object subscriber : collisionsList){
            if(subscriber instanceof ObstacleHandler){
                for(Obstacle obstacle : ((ObstacleHandler) subscriber).getObstacles()){
                    if (checkCollision(player, obstacle)) {
                        player.react();
                    }
                }
            }else if(subscriber instanceof GemstoneHandler){
                for(int x = 0;x < ((GemstoneHandler) subscriber).getGem().size();x++){
                    if (checkCollision(player,((GemstoneHandler) subscriber).getGem().get(x))) {
                        ((GemstoneHandler) subscriber).react(((GemstoneHandler) subscriber).getGem().get(x).getId());
                        player.addCollectedGem(((GemstoneHandler) subscriber).getGem().get(x).getValue());
                    }
                }

            }else if(subscriber instanceof Gun){
                for(int y = 0; y <= getObstacleFromCollisionList().getObstacles().size()-1; y++) {
                    for (int i = 0; i < ((Gun) subscriber).getBulletsFired().size(); i++) {
                        if (checkCollision((((Gun) subscriber).getBulletsFired().get(i)), getObstacleFromCollisionList().getObstacles().get(y))) {
                            ((Gun) subscriber).destroyBullet(i);
                            if (getObstacleFromCollisionList().getObstacles().get(y) instanceof DestroyableObstacle) {
                                getObstacleFromCollisionList().react(getObstacleFromCollisionList().getObstacles().get(y).getId());
                                break;
                            }
                        }
                    }
                }
            }else System.out.println("Exception");
        }
        float y = 1;
        if (hasCollided(player,y)){
            player.collisionGroundBegin(y);
        }
    }

    private ObstacleHandler getObstacleFromCollisionList() {
        for (Object x : collisionsList){
            if(x instanceof ObstacleHandler) return (ObstacleHandler) x;
        }
        return null;
    }


    public boolean checkCollision(Player player,Gemstone gemstone){
        return hasCollided(player.getBody(),gemstone.getBody());
    }

    public boolean checkCollision(Player player,Obstacle obstacle){
        return hasCollided(player.getBody(),obstacle.getBody());
    }

    public boolean checkCollision(Bullet bullet,Obstacle obstacle){
        return hasCollided(bullet.getBody(),obstacle.getBody());
    }

    private boolean hasCollided(Body o1, Body o2) {
        float o1BodyX = o1.getXPosition() * 2;
        float o1BodyY = o1.getYPosition() * 2;

        float o2BodyX = o2.getXPosition() * 2;
        float o2BodyY = o2.getYPosition() * 2;

        float o1OffsetX = o1.getWidth();
        float o1OffsetY = o1.getHeight();

        float o2OffsetX = o2.getWidth();
        float o2OffsetY = o2.getHeight();

        return ((o2BodyX <= o1BodyX + o1OffsetX &&
                o2BodyX >= o1BodyX) &&
                (o2BodyY <= o1BodyY + o1OffsetY &&
                        o2BodyY >= o1BodyY))

                ||

                ((o1BodyX <= o2BodyX + o2OffsetX &&
                        o1BodyX >= o2BodyX) &&
                        (o1BodyY <= o2BodyY + o2OffsetY &&
                                o1BodyY >= o2BodyY));
    }

    private boolean hasCollided(Player player, float yPosition){

        Body playerBody = player.getBody();

        return playerBody.getYPosition() < yPosition;
    }
}
