package com.grupp28gdx.game.Model.Utils;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.Guns.Bullet;
import com.grupp28gdx.game.Model.Guns.Gun;
import com.grupp28gdx.game.Model.ObstacleGroup.DestroyableObstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Controller.handlers.GemstoneHandler;
import com.grupp28gdx.game.Controller.handlers.ObstacleHandler;
import com.grupp28gdx.game.View.render.Hud;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetector {

    private List<Object> collisionsList = new ArrayList<Object>();
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
                for(Gemstone gemstone : ((GemstoneHandler) subscriber).getGem()){
                    if (checkCollision(player,gemstone)) {
                        ((GemstoneHandler) subscriber).react(gemstone.getId());
                        player.addCollectedGem(gemstone.getValue());
                    }
                }

            }else if(subscriber instanceof Gun){
                for (Obstacle obstacles : getObstacleFromCollisionList().getObstacles()){
                    for(int i = 0; i < ((Gun) subscriber).bulletsFired.size(); i++){
                       if(checkCollision((((Gun) subscriber).getBulletsFired().get(i)), obstacles)) {
                           ((Gun) subscriber).destroyBullet(i);
                           if(obstacles instanceof DestroyableObstacle){
                               getObstacleFromCollisionList().react(obstacles.getId());
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
        return hasCollided(player.getBody(),gemstone.getPosition());
    }

    public boolean checkCollision(Player player,Obstacle obstacle){
        return hasCollided(player.getBody(),obstacle.getBody());
    }

    public boolean checkCollision(Bullet bullet,Obstacle obstacle){
        return hasCollided(bullet.getBody(),obstacle.getBody());
    }

    public boolean hasCollided(Body o1, Body o2) {
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

        return playerBody.y < yPosition;
    }
}