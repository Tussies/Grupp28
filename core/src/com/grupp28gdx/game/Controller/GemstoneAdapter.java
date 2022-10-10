package com.grupp28gdx.game.Controller;

import com.grupp28gdx.game.Model.BigGemstone;
import com.grupp28gdx.game.Model.MediumGemstone;
import com.grupp28gdx.game.Model.SmallGemstone;
import com.grupp28gdx.game.Model.Position;
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

    public float getBigRadius(float radius){ return bigGemstoneModel.getRadius(); }

    public float getMediumRadius(float radius){
        return mediumGemstoneModel.getRadius();
    }

    public float getSmallRadius(float radius){
        return smallGemstoneModel.getRadius();
    }

    public int getBigPoints(int points) { return bigGemstoneModel.getPoints(); }

    public int getMediumPoints(int points){ return mediumGemstoneModel.getPoints(); }

    public int getSmallPoints(int points){
        return smallGemstoneModel.getPoints();
    }

    public Position getBigPosition(Position position) {
        return bigGemstoneModel.position;
    }

    public Position getMediumPosition(Position position) {
        return mediumGemstoneModel.position;
    }
    public Position getSmallPosition(Position position) {
        return smallGemstoneModel.position;
    }

    public void removeGemstone(BigGemstone bg, MediumGemstone mg, SmallGemstone sg){
    }
}
