package com.grupp28gdx.game.Controller;

import com.grupp28gdx.game.Model.handlers.GemstoneHandler;
import com.grupp28gdx.game.Model.handlers.ObstacleHandler;
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.Guns.Bullet;
import com.grupp28gdx.game.Model.ObstacleGroup.DestroyableObstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.Obstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.PermanentObstacle;
import com.grupp28gdx.game.Model.ObstacleGroup.SpikeObstacle;
import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.PlayerGroup.OrangePlayer;
import com.grupp28gdx.game.Model.PlayerGroup.Player;
import com.grupp28gdx.game.Model.PlayerGroup.PurplePlayer;
import com.grupp28gdx.game.View.render.AssetManager;
import com.grupp28gdx.game.View.render.RenderView;

import java.util.ArrayList;

import static com.grupp28gdx.game.Model.PlayerGroup.Constants.pixelsPerMeter;

public class RenderController {
    private final AssetManager assetManager = new AssetManager();
    private int frame;

    private RenderView rv;

    private float ambientPosition1;
    private float ambientPosition2;

    public RenderController(RenderView rv){
        this.frame = 0;
        ambientPosition1 = -1000;
        ambientPosition2 = -1000+4096;
        this.rv = rv;
    }

    public void update(Player player, ObstacleHandler obstacleHandler, GemstoneHandler gemstoneHandler){
        updateAmbientTextures(player);
        updateObstacles(obstacleHandler);
        updateGemstones(gemstoneHandler);
        updateBulletTexture(player.getGun().getBulletsFired());
        updatePlayerTexture(player);
    }

    public void dispose(){
        assetManager.dispose();
    }

    private void updateAmbientTextures(Player player) {
        updateBackgroundPosition(player);

        rv.render(assetManager.getBackground(), ambientPosition1, 0, 4096, 4096);
        rv.render(assetManager.getGroundTexture(), ambientPosition1, -600, 4096, 2000/3+10);
        rv.render(assetManager.getBackground(), ambientPosition2, 0, 4096, 4096);
        rv.render(assetManager.getGroundTexture(), ambientPosition2, -600, 4096, 2000/3+10);
    }

    private void updateBackgroundPosition(Player player) {
        if(player.getBody().x * pixelsPerMeter * 2 > ambientPosition1 + 4096)
            ambientPosition1+= 4096/2f;
        if(player.getBody().x * pixelsPerMeter * 2 > ambientPosition2 + 2048)
            ambientPosition2+=4096;
    }

    private void updateGemstones(GemstoneHandler gemstoneHandler) {
        for (Gemstone gemstone : gemstoneHandler.getGem()){
            if (gemstone instanceof BigGemstone){
                rv.render(assetManager.getBigGemstoneTexture(),(gemstone).getBody().x*pixelsPerMeter*2,(gemstone).getBody().y*pixelsPerMeter*2,pixelsPerMeter*0.75f,pixelsPerMeter*0.75f);}
            else if (gemstone instanceof MediumGemstone){
                rv.render(assetManager.getMediumGemstoneTexture(),(gemstone).getBody().x*pixelsPerMeter*2,(gemstone).getBody().y*pixelsPerMeter*2,pixelsPerMeter*0.45f,pixelsPerMeter*0.45f);}
            else{
                rv.render(assetManager.getSmallGemstoneTexture(), gemstone.getBody().x*pixelsPerMeter*2,(gemstone).getBody().y*pixelsPerMeter*2,pixelsPerMeter*0.18f,pixelsPerMeter*0.18f);}
        }
    }

    private void updateObstacles(ObstacleHandler obstacleHandler) {
        for (Obstacle obstacle : obstacleHandler.getObstacles()){
            if (obstacle instanceof PermanentObstacle)
                rv.render(assetManager.getWallTexture(),obstacle.getBody().x*pixelsPerMeter*2,obstacle.getBody().y*pixelsPerMeter*2-32,32,32*3);
            if (obstacle instanceof DestroyableObstacle)
                rv.render(assetManager.getDestroyableTexture(),obstacle.getBody().x*pixelsPerMeter*2,obstacle.getBody().y*pixelsPerMeter*2-32,32,32*3);
            if (obstacle instanceof SpikeObstacle)
                rv.render(assetManager.getSpikeTexture(),obstacle.getBody().x*pixelsPerMeter*2,obstacle.getBody().y*pixelsPerMeter*2+32,64,32);
        }
    }

    private void updateBulletTexture(ArrayList<Bullet> bullets){
        for (int j = 0 ; j <bullets.size(); j++){
            rv.render(assetManager.getBulletTexture(),  bullets.get(j).getXPosition()*pixelsPerMeter*2,  bullets.get(j).getYPosition()*pixelsPerMeter*2 , 40, 40 );
        }
    }

    private void updatePlayerTexture(Player player) {
        int animationFrame = Math.round(frame)/9;
        switch (player.getStateOfPlayer().toString()) {
            case "walking":
                frame += 1f;
                frame = frame % 60;
                animationFrame = animationFrame % 5;

                if(player instanceof OrangePlayer) {
                    rv.render(assetManager.getPlayerWalkingAnimationOrangePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerWalkingAnimationOrangePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rv.render(assetManager.getPlayerWalkingAnimationGreenPlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerWalkingAnimationGreenPlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }
                break;
            case "dead":
                if(player instanceof OrangePlayer) {
                    rv.render(assetManager.getOrangeDeadTexture(), player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getOrangeDeadTexture().getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rv.render(assetManager.getGreenDeadTexture(), player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getGreenDeadTexture().getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }

                if(player instanceof PurplePlayer) {
                    rv.render(assetManager.getPurpleDeadTexture(), player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPurpleDeadTexture().getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 200/4f, 422/4f);
                }
                break;
            case "jumping":
                frame += 1f;
                frame = frame % 60;

                if(player.getBody().speedY > 0.1){ frame = 0; animationFrame=0;}
                animationFrame = animationFrame % 4;

                if(player instanceof OrangePlayer) {
                    rv.render(assetManager.getPlayerJumpingAnimationOrangePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerJumpingAnimationOrangePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 250/4f, 422/4f);
                }

                if(player instanceof GreenPlayer) {
                    rv.render(assetManager.getPlayerJumpingAnimationGreenPlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerJumpingAnimationGreenPlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 250/4f, 422/4f);
                }

                if(player instanceof PurplePlayer) {
                    rv.render(assetManager.getPlayerJumpingAnimationPurplePlayer()[animationFrame], player.getBody().getXPosition() * pixelsPerMeter*2 - (assetManager.getPlayerJumpingAnimationPurplePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().getYPosition() * pixelsPerMeter*2-5, 250/4f, 422/4f);
                }

                break;
            case "running":
                frame += 1f;
                frame = frame % 60;
                animationFrame = animationFrame % 5;
                rv.render(assetManager.getPlayerRunningAnimationPurplePlayer()[animationFrame], player.getBody().x * pixelsPerMeter*2 - (assetManager.getPlayerRunningAnimationPurplePlayer()[1].getWidth()/8f) + pixelsPerMeter-12, player.getBody().y * pixelsPerMeter*2-5, 200/4f, 422/4f);
                break;
        }
    }
}
