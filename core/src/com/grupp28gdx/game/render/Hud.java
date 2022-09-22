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

    private int worldTimer;
    private float timeCount;
    private int score;

    Label scoreCounterLabel;
    Label scoreLabel;
    Label timeLabel;

    public Hud(){
        worldTimer = 0;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport);

        Table table = new Table();
        table.setFillParent(true);
        table.padBottom(Gdx.graphics.getHeight()/2);

        scoreCounterLabel = new Label(String.format("%06d",score), new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));
        scoreLabel= new Label(String.format("%06d",score), new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));
        timeLabel= new Label(("Score:"), new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));

        table.add(timeLabel).expandX().padTop(2);
        table.row();
        table.add(scoreCounterLabel).expandX();
        //table.add(scoreLabel).expandX();

        stage.addActor(table);
    }

    public void updateScore(int newScore){
        scoreCounterLabel.setText(String.format("%06d",newScore));
    }
}
