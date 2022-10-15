package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Controller.ObstacleAdapter;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;

public class CollisionDetector {


    public boolean hasCollided(Player player, Gemstone gemstone ){
        Body playerBody = player.getBody();
        Body gemstoneBody = gemstone.getBody();
        float playerOffsetX = 1f;
        float playerOffsetY = 1f;

        float gemstoneOffsetX = 0.5f;
        float gemstoneOffsetY = 0.5f;

        if((
                (playerBody.x<=gemstoneBody.x+gemstoneOffsetX && playerBody.x>=gemstoneBody.x) &&
                        (playerBody.y<=gemstoneBody.y+gemstoneOffsetY && playerBody.y>=gemstoneBody.y))||
                ((playerBody.x+playerOffsetX>=gemstoneBody.x && playerBody.x<=gemstoneBody.x) &&
                        (playerBody.y+playerOffsetY>=gemstoneBody.y && playerBody.y<=gemstoneBody.y)))
        {
            System.out.println("Collision");
            return true;
        }

        return false;
    }

    public boolean hasCollided(Player player, ObstacleAdapter spike){
        Body playerBody = player.getBody();
        Body spikeBody = spike.getObstacleData().getPosition();
        float playerOffsetX = 1f;
        float playerOffsetY = 1f;

        float spikeOffsetX = 0.5f;
        float spikeOffsetY = 0.5f;

        if((
                (playerBody.x<=spikeBody.x+spikeOffsetX && playerBody.x>=spikeBody.x) &&
                        (playerBody.y<=spikeBody.y+spikeOffsetY && playerBody.y>=spikeBody.y))||
                ((playerBody.x+playerOffsetX>=spikeBody.x && playerBody.x<=spikeBody.x) &&
                        (playerBody.y+playerOffsetY>=spikeBody.y && playerBody.y<=spikeBody.y)))
        {
            System.out.println("Collision");
            return true;
        }

        return false;
    }

    public boolean hasCollided(Player player, float yPosition){
        Body playerBody = player.getBody();

        if(playerBody.y < yPosition)
        {
            return true;
        }
        return false;
    }
}
