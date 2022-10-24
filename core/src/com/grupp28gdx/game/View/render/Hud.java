package com.grupp28gdx.game.View.render;

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
    private Stage gameOverStage;

    private Label scoreCounterLabel;
    private Label finalScoreCounterLabel;
    private Label coinCountLabel;
    private Label scoreTextLabel;
    private Label coinTextLabel;

    private Label gameOverLabel;
    private Label goBackToMenu;

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

        createGameOverStage();
    }

    private void createGameOverStage(){
        gameOverStage = new Stage(viewport);
        Table table = new Table();
        table.setFillParent(true);
        table.padBottom(Gdx.graphics.getHeight()/2);
        gameOverLabel = new Label("Game Over",new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));
        gameOverLabel.setFontScale(2);
        finalScoreCounterLabel=new Label(String.format("%06d",0),new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));
        scoreTextLabel = new Label(("Final score:"), new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));
        goBackToMenu = new Label(("To return to menu press 'M'"), new Label.LabelStyle(new BitmapFont(Gdx.files.internal("Bullpen3DBitmap.fnt")), Color.WHITE));

        table.add(gameOverLabel).expandX();
        table.row();

        table.add(scoreTextLabel).expandX();
        table.row();
        table.add(finalScoreCounterLabel).expandX();
        gameOverStage.addActor(table);
        table.row();
        table.row();
        table.add(goBackToMenu).expandX();

    }


    /**
     * If gameOver is true the viewport will display the game over screen overlay
     * @param gameOver
     */
    public void gameOver(boolean gameOver) {
        if (gameOver){
            stage = gameOverStage;
    }
}

    /**
     * Sets the text to the score of the player, requires int to be displayed.
     * @param newScore
     */
    public void updateScore(int newScore){
        scoreCounterLabel.setText(String.format("%06d",newScore));
        finalScoreCounterLabel.setText(String.format("%06d",newScore));
    }

    /**
     * Sets the text to the label that displays collected gems value.
     * @param gems
     */
    public void updateGemScore(int gems){coinCountLabel.setText(String.format("%02d",gems));}
}
