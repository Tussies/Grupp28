package com.grupp28gdx.game.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;



public class Hud {
    public Stage stage;
    private Viewport viewport;

    Label scoreCounterLabel;
    Label coinCountLabel;
    Label scoreTextLabel;
    Label coinTextLabel;

    public Hud(){

        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport);

        Table table = new Table();
        table.setFillParent(true);
        table.padBottom(Gdx.graphics.getHeight()/2);

        scoreCounterLabel = new Label(String.format("%06d",0), new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));
        coinCountLabel = new Label(String.format("%02d",0), new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));
        scoreTextLabel = new Label(("Score:"), new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));
        coinTextLabel = new Label(("Coins:"), new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));

        table.add(coinTextLabel).expandX().padTop(2);
        table.add(scoreTextLabel).expandX().padTop(2);
        table.row();
        table.add(coinCountLabel).expandX();
        table.add(scoreCounterLabel).expandX();

        stage.addActor(table);
    }

    public void updateScore(int newScore){
        scoreCounterLabel.setText(String.format("%06d",newScore));
    }
    public void updateCoins(int coins){coinCountLabel.setText(String.format("%02d",coins));}
}
