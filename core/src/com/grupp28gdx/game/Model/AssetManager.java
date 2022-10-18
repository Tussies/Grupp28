package com.grupp28gdx.game.Model;

import com.badlogic.gdx.graphics.Texture;

public class AssetManager {

    private final Texture background = new Texture("nebulaset1.png");
    private final Texture groundTexture = new Texture("groundTexture.png");

    private final Texture bullet = new Texture("Bomb_B_01.png");

    private final Texture spikeTexture = new Texture("spikeTexture.png");
    private final Texture destroyableTexture = new Texture("destroyableTexture.png");
    private final Texture wallTexture = new Texture("wallTexture.png");

    private Texture smallGemstoneTexture = new Texture("smallGemstone.png");
    private Texture mediumGemstoneTexture = new Texture("mediumGemstone.png");
    private Texture bigGemstoneTexture = new Texture("bigGemstone.png");

    private Texture[] playerWalkingAnimation = {
            new Texture("alien_walking_1.png"),
            new Texture("armor__0007_walk_2.png"),
            new Texture("armor__0008_walk_3.png"),
            new Texture("armor__0009_walk_4.png"),
            new Texture("armor__0010_walk_5.png"),
            new Texture("armor__0011_walk_6.png")};

    private Texture[] playerJumpingAnimation = {
            new Texture("armor__0027_jump_1.png"),
            new Texture("armor__0028_jump_2.png"),
            new Texture("armor__0028_jump_3.png"),
            new Texture("armor__0030_jump_4.png")};

    public Texture getBackground(){
        return background;
    }

    public Texture getBulletTexture(){return bullet;}

    public Texture getSpikeTexture(){return spikeTexture;}
    public Texture getDestroyableTexture(){return destroyableTexture;}
    public Texture getWallTexture(){return wallTexture;}

    public Texture getSmallGemstoneTexture(){return smallGemstoneTexture;}
    public Texture getMediumGemstoneTexture(){return mediumGemstoneTexture;}
    public Texture getBigGemstoneTexture(){return bigGemstoneTexture;}

    public Texture[] getGreenAlienWalkingAnimation(){
        return playerWalkingAnimation;
    }

    public Texture[] getGreenAlienJumpingAnimation(){
        return playerJumpingAnimation;
    }

    public Texture getGroundTexture() { return groundTexture;
    }
}
