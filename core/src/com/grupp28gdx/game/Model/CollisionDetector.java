package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.Guns.Bullet;
import com.grupp28gdx.game.Model.Guns.Gun;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.handlers.GemstoneHandler;
import com.grupp28gdx.game.handlers.ObstacleHandler;
import com.grupp28gdx.game.render.Hud;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetector {

    private List<Object> collisionsList = new ArrayList<Object>();
    private Hud hud;
    private Player player;

    public CollisionDetector(ObstacleHandler obstacleHandler, GemstoneHandler gemstoneHandler, Gun gun, Hud hud,Player player){
        collisionsList.add(obstacleHandler);
        collisionsList.add(gemstoneHandler);
        collisionsList.add(gun);
        this.hud = hud;
        this.player = player;
    }

    public void update(){
        for (Object subscriber : collisionsList){
            if(subscriber instanceof ObstacleHandler){
                for(Obstacle obstacle : ((ObstacleHandler) subscriber).getObstacles()){
                    if (checkCollision(player, obstacle)) {
                        hud.gameOver(true);
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
        if (hasCollided(player,1)){
            player.collisionGroundBegin();
        }
    }

    private ObstacleHandler getObstacleFromCollisionList() {
        for (Object x : collisionsList){
            if(x instanceof ObstacleHandler) return (ObstacleHandler) x;
        }
        return null;
    }

    public boolean checkCollision(Player player,Gemstone gemstone){
        return hasCollided(player.getBody(),gemstone.getPosition(), player.getHeight(), player.getWidth(), gemstone.getHeight(), gemstone.getWidth());
    }

    public boolean checkCollision(Player player,Obstacle obstacle){
        return hasCollided(player.getBody(),obstacle.getBody(), player.getHeight(),player.getWidth(),obstacle.getHeight(), obstacle.getWidth());
    }

    public boolean checkCollision(Bullet bullet,Obstacle obstacle){
        return hasCollided(bullet.getBody(),obstacle.getBody(), bullet.getHeight(),bullet.getWidth(),obstacle.getHeight(), obstacle.getWidth());
    }

    public boolean hasCollided(Body o1, Body o2,float o1Height,float o1Width,float o2Height,float o2Width) {
        float o1BodyX = o1.getXPosition() * 2;
        float o1BodyY = o1.getYPosition() * 2;

        float o2BodyX = o2.getXPosition() * 2;
        float o2BodyY = o2.getYPosition() * 2;

        float o1OffsetX = o1Width;
        float o1OffsetY = o1Height;

        float o2OffsetX = o2Width;
        float o2OffsetY = o2Height;

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

    public boolean hasCollided(Player player, float yPosition){

        Body playerBody = player.getBody();

        if (playerBody.y < yPosition) {
            return true;
        }
        return false;
    }
}
