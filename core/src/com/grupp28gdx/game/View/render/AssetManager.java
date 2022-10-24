package com.grupp28gdx.game.View.render;

import com.badlogic.gdx.graphics.Texture;

public class AssetManager {

    private final Texture background = new Texture("nebulaset1.png");
    private final Texture groundTexture = new Texture("groundTexture.png");

    private final Texture bullet = new Texture("Bomb_B_01.png");

    private final Texture spikeTexture = new Texture("spikeTexture.png");
    private final Texture destroyableTexture = new Texture("destroyableTexture.png");
    private final Texture wallTexture = new Texture("wallTexture.png");

    private final Texture smallGemstoneTexture = new Texture("smallGemstone.png");
    private final Texture mediumGemstoneTexture = new Texture("mediumGemstone.png");
    private final Texture bigGemstoneTexture = new Texture("bigGemstone.png");

    private final Texture orangeDeadTexture = new Texture("orangeDead.png");
    private final Texture greenDeadTexture = new Texture("greenDead.png");
    private final Texture purpleDeadTexture = new Texture("purpleDead.png");

    private final Texture[] playerWalkingAnimationOrangePlayer = {
            new Texture("red__0006_walk_1.png"),
            new Texture("red__0007_walk_2.png"),
            new Texture("red__0008_walk_3.png"),
            new Texture("red__0009_walk_4.png"),
            new Texture("red__0010_walk_5.png"),
            new Texture("red__0011_walk_6.png")};
    private final Texture[] playerJumpingAnimationOrangePlayer = {
            new Texture("red__0027_jump_1.png"),
            new Texture("red__0028_jump_2.png"),
            new Texture("red__0029_jump_3.png"),
            new Texture("red__0030_jump_4.png")};
    private final Texture[] playerWalkingAnimationGreenPlayer = {
            new Texture("alien_walking_1.png"),
            new Texture("armor__0007_walk_2.png"),
            new Texture("armor__0008_walk_3.png"),
            new Texture("armor__0009_walk_4.png"),
            new Texture("armor__0010_walk_5.png"),
            new Texture("armor__0011_walk_6.png")};
    private final Texture[] playerJumpingAnimationGreenPlayer = {
            new Texture("armor__0027_jump_1.png"),
            new Texture("armor__0028_jump_2.png"),
            new Texture("armor__0028_jump_3.png"),
            new Texture("armor__0030_jump_4.png")};
    private final Texture[] playerRunningAnimationPurplePlayer = {
            new Texture("blue__0012_run_1.png"),
            new Texture("blue__0013_run_2.png"),
            new Texture("blue__0014_run_3.png"),
            new Texture("blue__0015_run_4.png"),
            new Texture("blue__0016_run_5.png"),
            new Texture("blue__0017_run_6.png")};
    private final Texture[] playerJumpingAnimationPurplePlayer = {
            new Texture("blue__0027_jump_1.png"),
            new Texture("blue__0028_jump_2.png"),
            new Texture("blue__0029_jump_3.png"),
            new Texture("blue__0030_jump_4.png")};

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

    public Texture[] getPlayerWalkingAnimationOrangePlayer(){return playerWalkingAnimationOrangePlayer;}

    public Texture[] getPlayerJumpingAnimationOrangePlayer() {
        return playerJumpingAnimationOrangePlayer;
    }

    public Texture[] getPlayerWalkingAnimationGreenPlayer() {
        return playerWalkingAnimationGreenPlayer;
    }

    public Texture[] getPlayerJumpingAnimationGreenPlayer() {
        return playerJumpingAnimationGreenPlayer;
    }

    public Texture[] getPlayerRunningAnimationPurplePlayer() {
        return playerRunningAnimationPurplePlayer;
    }

    public Texture[] getPlayerJumpingAnimationPurplePlayer() {
        return playerJumpingAnimationPurplePlayer;
    }

    public Texture getGroundTexture() { return groundTexture;}

    public Texture getOrangeDeadTexture() {
        return orangeDeadTexture;
    }

    public Texture getGreenDeadTexture() {
        return greenDeadTexture;
    }

    public Texture getPurpleDeadTexture() {
        return purpleDeadTexture;
    }

    public void dispose() {
        background.dispose();
        groundTexture.dispose();
        bullet.dispose();
        spikeTexture.dispose();
        destroyableTexture.dispose();
        wallTexture.dispose();
        smallGemstoneTexture.dispose();
        mediumGemstoneTexture.dispose();
        bigGemstoneTexture.dispose();
        orangeDeadTexture.dispose();
        greenDeadTexture.dispose();
        purpleDeadTexture.dispose();
        for (Texture texture : playerJumpingAnimationOrangePlayer){
            texture.dispose();
        }
        for (Texture texture : playerJumpingAnimationOrangePlayer){
            texture.dispose();
        }
        for (Texture texture : playerWalkingAnimationGreenPlayer){
            texture.dispose();
        }
        for (Texture texture : playerJumpingAnimationGreenPlayer){
            texture.dispose();
        }
        for (Texture texture : playerRunningAnimationPurplePlayer){
            texture.dispose();
        }
        for (Texture texture : playerJumpingAnimationPurplePlayer){
            texture.dispose();
        }
    }
}
