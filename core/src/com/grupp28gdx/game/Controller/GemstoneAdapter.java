package com.grupp28gdx.game.Controller;

import com.grupp28gdx.game.Model.BigGemstone;
import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.MediumGemstone;
import com.grupp28gdx.game.Model.SmallGemstone;
import com.grupp28gdx.game.View.CoinView;

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

    public float getBigSideLength(float sideLength){ return bigGemstoneModel.getSideLength(); }

    public float getMediumSideLength(float sideLength){
        return mediumGemstoneModel.getSideLength();
    }

    public float getSmallSideLength(float radius){
        return smallGemstoneModel.getSideLength();
    }

    public int getBigPoints(int points) { return bigGemstoneModel.getPoints(); }

    public int getMediumPoints(int points){ return mediumGemstoneModel.getPoints(); }

    public int getSmallPoints(int points){
        return smallGemstoneModel.getPoints();
    }

    public Body getBigPosition(Body body) {
        return bigGemstoneModel.body;
    }

    public Body getMediumPosition(Body body) {
        return mediumGemstoneModel.body;
    }

    public Body getSmallPosition(Body body) {
        return smallGemstoneModel.body;
    }

    public void removeGemstone(BigGemstone bg, MediumGemstone mg, SmallGemstone sg){
    }
}
