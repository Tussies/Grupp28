package com.grupp28gdx.game.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class RenderView {
    private SpriteBatch sb;
    public RenderView(){
        sb = new SpriteBatch();
    }

    private Music music;

    public void render(Texture texture, int x, int y){
        sb.begin();
        sb.draw(texture,x,y);
        sb.end();
    }

    public void render(Texture texture,float x,float y,float screenWith,float screenHeight){
        sb.begin();
        sb.draw(texture,x,y,screenWith,screenHeight);
        sb.end();
    }

    public void updateCamera(Camera cam, Vector3 position){
        cam.position.set(position);
        cam.update();
    }

    public void setProjectionMatrix(Matrix4 combined) {
        sb.setProjectionMatrix(combined);
    }

    public void updateScore(int score){
        sb.begin();
        sb.end();
    }

    public void render(Hud hud) {
        sb.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    public void renderMusic(){
        music = Gdx.audio.newMusic(Gdx.files.internal("newsong.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();

    }
    public void musicStop(){
        music.stop();
    }
}
