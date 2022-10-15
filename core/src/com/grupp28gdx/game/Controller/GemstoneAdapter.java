package com.grupp28gdx.game.Controller;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.MediumGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.SmallGemstone;
import com.grupp28gdx.game.View.CoinView;

/**
 * Adapter class for gemstones, this class connects the logic of the model class with the view class of all gemstones.
 * The adapter consists of multiple getters and setters from and for small, medium and Gemstones.
 */
public class GemstoneAdapter {
    private CoinView coinView;
    private BigGemstone bigGemstoneModel;
    private MediumGemstone mediumGemstoneModel;
    private SmallGemstone smallGemstoneModel;
    
    public GemstoneAdapter(BigGemstone bigGemstoneModel, MediumGemstone mediumGemstoneModel, SmallGemstone smallGemstoneModel, CoinView coinView){
        this.bigGemstoneModel = bigGemstoneModel;
        this.mediumGemstoneModel = mediumGemstoneModel;
        this.smallGemstoneModel = smallGemstoneModel;
        this.coinView = coinView;
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
     * Returns position of a gemstone of type big.
     * @param body
     * @return body
     */
    public Body getBigPosition(Body body) {
        return bigGemstoneModel.body;
    }

    /**
     * Returns position of a gemstone of type medium.
     * @param body
     * @return body
     */
    public Body getMediumPosition(Body body) {
        return mediumGemstoneModel.body;
    }

    /**
     * Returns position of a gemstone of type small.
     * @param body
     * @return body
     */
    public Body getSmallPosition(Body body) {
        return smallGemstoneModel.body;
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
