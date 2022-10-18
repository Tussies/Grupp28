package com.grupp28gdx.game.Model;

import com.grupp28gdx.game.Controller.ObstacleAdapter;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.PlayerGroup.Player;

public class CollisionDetector {


    public boolean hasCollided(Player player, Gemstone gemstone ){
        Body playerBody = player.getBody();
        Body gemstoneBody = gemstone.getPosition();

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

            return true;
        }

        return false;
    }

    public boolean hasCollided(Player player, PermanentObstacle Wall){
        Body playerBody = player.getBody();
        Body wallBody = Wall.getPosition();

        float playerPositionX = playerBody.x*2;
        float playerPositionY = playerBody.y*2;

        float wallBodyX = wallBody.x*2;
        float wallBodyY = wallBody.y*2;

        float playerOffsetX = 1.40f;
        float playerOffsetY = 2.75f;

        float wallOffsetX = 1f;
        float wallOffsetY = 2f;

        if(
                ((wallBodyX<=playerPositionX+playerOffsetX &&
                 wallBodyX>=playerPositionX) &&
                (wallBodyY <= playerPositionY+playerOffsetY &&
                 wallBodyY >= playerPositionY))

                        ||

                ((playerPositionX<=wallBodyX+wallOffsetX &&
                 playerPositionX>=wallBodyX) &&
                (playerPositionY <= wallBodyY+wallOffsetY &&
                 playerPositionY >= wallBodyY))
                )
        {
            return true;
        }

        return false;
    }

    public boolean hasCollided(Player player, DestroyableObstacle Wall){
        Body playerBody = player.getBody();
        Body wallBody = Wall.getPosition();

        float playerPositionX = playerBody.x*2;
        float playerPositionY = playerBody.y*2;

        float wallBodyX = wallBody.x*2;
        float wallBodyY = wallBody.y*2;

        float playerOffsetX = 1.40f;
        float playerOffsetY = 2.75f;

        float wallOffsetX = 1f;
        float wallOffsetY = 2f;

        if(
                ((wallBodyX<=playerPositionX+playerOffsetX &&
                        wallBodyX>=playerPositionX) &&
                        (wallBodyY <= playerPositionY+playerOffsetY &&
                                wallBodyY >= playerPositionY))

                        ||

                        ((playerPositionX<=wallBodyX+wallOffsetX &&
                                playerPositionX>=wallBodyX) &&
                                (playerPositionY <= wallBodyY+wallOffsetY &&
                                        playerPositionY >= wallBodyY))
        )
        {
            System.out.println("Collision");
            return true;
        }

        return false;
    }


    public boolean hasCollided(Player player, SpikeObstacle spike){
        Body playerBody = player.getBody();
        Body spikeBody = spike.getPosition();

        float playerPositionX = playerBody.x*2;
        float playerPositionY = playerBody.y*2;

        float spikeBodyX1 = spikeBody.x*2+0.25f;
        float spikeBodyY1 = spikeBody.y*2+1;

        float spikeBodyX2 = spikeBodyX1 + 0.25f;
        float spikeBodyY2 = spikeBodyY1 + 0.5f;

        float playerOffsetX = 1f;
        float playerOffsetY = 2.75f;

        float spikeOffsetX = 2.25f;
        float spikeOffsetY = 0.5f;

        float spikeOffsetX2 = 1f;
        float spikeOffsetY2 = 0.5f;

        if(
                ((spikeBodyX1<=playerPositionX+playerOffsetX &&
                        spikeBodyX1>=playerPositionX) &&
                        (spikeBodyY1 <= playerPositionY+playerOffsetY &&
                                spikeBodyY1 >= playerPositionY))

                        ||

                        ((playerPositionX<=spikeBodyX1+spikeOffsetX &&
                                playerPositionX>=spikeBodyX1) &&
                                (playerPositionY <= spikeBodyY1+spikeOffsetY &&
                                        playerPositionY >= spikeBodyY1))

                        ||

                        ((spikeBodyX2<=playerPositionX+playerOffsetX &&
                                spikeBodyX2>=playerPositionX) &&
                                (spikeBodyY2 <= playerPositionY+playerOffsetY &&
                                        spikeBodyY2 >= playerPositionY))

                        ||

                        ((playerPositionX<=spikeBodyX2+spikeOffsetX2 &&
                                playerPositionX>=spikeBodyX2) &&
                                (playerPositionY <= spikeBodyY2+spikeOffsetY2 &&
                                        playerPositionY >= spikeBodyY2))

        )
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
