package com.grupp28gdx.game.Controller;
import java.awt.*;
import java.awt.event.*;

import com.grupp28gdx.game.Model.BigCoin;

import com.grupp28gdx.game.Model.MediumCoin;
import com.grupp28gdx.game.Model.SmallCoin;
import com.grupp28gdx.game.View.CoinView;

public class CoinAdapter {
    private CoinView coinView;
    private BigCoin bigCoinModel;
    private MediumCoin mediumCoinModel;
    private SmallCoin smallCoinModel;

    public CoinAdapter(BigCoin bigCoinModel, MediumCoin mediumCoinModel, SmallCoin smallCoinModel, CoinView coinView){
        this.bigCoinModel = bigCoinModel;
        this.mediumCoinModel = mediumCoinModel;
        this.smallCoinModel = smallCoinModel;
        this.coinView = coinView;
    }

    public float getBigRadius(float radius){
        return bigCoinModel.getRadius();
    }

    public float getMediumRadius(float radius){
        return mediumCoinModel.getRadius();
    }

    public float getSmallRadius(float radius){
        return smallCoinModel.getRadius();
    }

    public int getBigPoints(int points){
        return bigCoinModel.getPoints();
    }

    public int getMediumPoints(int points){
        return mediumCoinModel.getPoints();
    }

    public int getSmallPoints(int points){
        return smallCoinModel.getPoints();
    }

    public void removeCoin(BigCoin bc, MediumCoin mc, SmallCoin sc){
        //remove(bc or mc or sc);
    }
}
