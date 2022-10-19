package com.grupp28gdx.game.Controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.Body;
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;
import com.grupp28gdx.game.Model.ModeFactory;
import com.grupp28gdx.game.render.RenderController;

/**
 * Adapter class for gemstones, this class connects the logic of the model class with the view class of all gemstones.
 * The adapter consists of multiple getters and setters from and for small, medium and Gemstones.
 */
public class GemstoneAdapter {
    private World world;
    private Gemstone gemstoneData;
    private Body gemstoneBody;
    private BigGemstone bigGemstoneModel;
    private MediumGemstone mediumGemstoneModel;
    private SmallGemstone smallGemstoneModel;
    
    public GemstoneAdapter(World world, ModeFactory factory, float spawnPosX, float spawnPosY, RenderController rc,int id){
        this.world = world;
        this.gemstoneData = factory.createGemstone(spawnPosX,spawnPosY,id);
        gemstoneBody = world.createBody(generateBodyDef(spawnPosX,spawnPosY));
        PolygonShape bodyShape = new PolygonShape();
        bodyShape.set(getVectors());
        rc.createFixture(gemstoneBody,bodyShape);
        gemstoneBody.createFixture(bodyShape,4.0f);

    }

    private Vector2[] getVectors() {
        if (gemstoneData.getVectorListX().size() == 8) {
            return new Vector2[]{
                    new Vector2(gemstoneData.getVectorListX().get(0),gemstoneData.getVectorListY().get(0)),
                    new Vector2(gemstoneData.getVectorListX().get(1),gemstoneData.getVectorListY().get(1)),
                    new Vector2(gemstoneData.getVectorListX().get(2),gemstoneData.getVectorListY().get(2)),
                    new Vector2(gemstoneData.getVectorListX().get(3),gemstoneData.getVectorListY().get(3)),
                    new Vector2(gemstoneData.getVectorListX().get(4),gemstoneData.getVectorListY().get(4)),
                    new Vector2(gemstoneData.getVectorListX().get(5),gemstoneData.getVectorListY().get(5)),
                    new Vector2(gemstoneData.getVectorListX().get(6),gemstoneData.getVectorListY().get(6)),
                    new Vector2(gemstoneData.getVectorListX().get(7),gemstoneData.getVectorListY().get(7)),

            };
        }else return null;
    }

    private BodyDef generateBodyDef(float spawnX, float spawnY) {
        BodyDef bodyDef;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(spawnX,spawnY);
        bodyDef.fixedRotation = true;
        return bodyDef;
    }

    public Body getGemstoneBody(){
        return gemstoneBody;
    }

    public void destroyBody(){
        world.destroyBody(gemstoneBody);
    }

    public Gemstone getGemstoneData(){
        return gemstoneData;
    }

    /**
     * Returns sideLength of a big gemstone object.
     * @param sideLength
     * @return sideLength
     */
    public float getBigSideLength(float sideLength){ return bigGemstoneModel.getSideLength(); }

    /**
     * Returns sideLength of a medium gemstone object.
     * @param sideLength
     * @return sideLength
     */
    public float getMediumSideLength(float sideLength){
        return mediumGemstoneModel.getSideLength();
    }

    /**
     * Returns sideLength of a small gemstone object.
     * @param sideLength
     * @return sideLength
     */
    public float getSmallSideLength(float sideLength){
        return smallGemstoneModel.getSideLength();
    }

    /**
     * Returns points according to the big gemstone model, returns the least points.
     * @param points
     * @return points
     */
    public int getBigPoints(int points) { return bigGemstoneModel.getPoints(); }

    /**
     * Returns points according to the medium gemstone model.
     * @param points
     * @return points
     */
    public int getMediumPoints(int points){ return mediumGemstoneModel.getPoints(); }

    /**
     * Returns points according to the small gemstone model, returns the most points.
     * @param points
     * @return points
     */
    public int getSmallPoints(int points){
        return smallGemstoneModel.getPoints();
    }

    /**
     * Removes gemstone from game, is called on when player acquires the coin.
     * @param bg
     * @param mg
     * @param sg
     */
    public void removeGemstone(BigGemstone bg, MediumGemstone mg, SmallGemstone sg){
    }
}
